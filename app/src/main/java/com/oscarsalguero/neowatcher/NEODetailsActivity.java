package com.oscarsalguero.neowatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oscarsalguero.neowatcher.bean.PotentiallyHazardousAsteroid;

/**
 * NEO Details
 * <p/>
 * Created by RacZo on 4/24/16.
 */
public class NEODetailsActivity extends AppCompatActivity {

    private static final String LOG_TAG = NEODetailsActivity.class.getName();

    private CoordinatorLayout mCoordinatorLayout;

    private PotentiallyHazardousAsteroid mPHA;

    public final static String PARAM_NEO = "PARAM_NEO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neo_details);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.mipmap.ic_launcher);
        }

        Button buttonVisualize3D = (Button) findViewById(R.id.button_visualize);

        TextView textViewName = (TextView) findViewById(R.id.text_view_name);
        TextView textViewLastObserved = (TextView) findViewById(R.id.text_view_last_observed);
        TextView textViewOrbitalPeriod = (TextView) findViewById(R.id.text_view_orbital_period);
        TextView textViewPerihelionDistance = (TextView) findViewById(R.id.text_view_perihelion_distance);
        TextView textViewArcYears = (TextView) findViewById(R.id.text_view_arc_years);
        TextView textViewNumberOfObservations = (TextView) findViewById(R.id.text_view_numbers_of_observations);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mPHA = (PotentiallyHazardousAsteroid) bundle.getSerializable(PARAM_NEO);
        }

        if (mPHA != null) {
            String name = mPHA.getName();
            if (TextUtils.isEmpty(name)) {
                name = mPHA.getPrincipalDesignation();
            }
            textViewName.setText(name);
            setTitle(name + " Details");
            textViewLastObserved.setText(String.valueOf(mPHA.getDateOfLastObservation()));
            textViewOrbitalPeriod.setText(String.valueOf(mPHA.getOrbitalPeriod()));
            textViewPerihelionDistance.setText(String.valueOf(mPHA.getPerihelionDistance()));
            textViewArcYears.setText(mPHA.getArcYears());
            textViewNumberOfObservations.setText(String.valueOf(mPHA.getNumberOfObservations()));

            if (buttonVisualize3D != null) {
                buttonVisualize3D.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(LOG_TAG, "Will show " + VisualizeMin3DActivity.class.getName());
                        Intent intent = new Intent(NEODetailsActivity.this, VisualizeMin3DActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(NEODetailsActivity.PARAM_NEO, mPHA);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        }

    }
}
