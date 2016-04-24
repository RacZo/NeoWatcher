package com.oscarsalguero.neowatcher;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.oscarsalguero.neowatcher.adapter.NEOAdapter;
import com.oscarsalguero.neowatcher.bean.PotentiallyHazardousAsteroid;
import com.oscarsalguero.neowatcher.networking.RetroFitSingleton;
import com.oscarsalguero.neowatcher.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Main Activity which presents a list of NEOs
 * <p/>
 * Created by RacZo on 4/23/16.
 */
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String LOG_TAG = MainActivity.class.getName();

    private CoordinatorLayout mCoordinatorLayout;

    private RecyclerView mRecyclerView;
    private NEOAdapter mAdapter;
    private ProgressBar mProgressBar;
    private TextView mTextViewEmpty;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLinearLayoutManager;
    private List<PotentiallyHazardousAsteroid> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.mipmap.ic_launcher);
        }

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setVisibility(View.GONE);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);

        mTextViewEmpty = (TextView) findViewById(android.R.id.empty);
        mTextViewEmpty.setVisibility(View.GONE);

        getNeos();
    }

    @Override
    public void onRefresh() {
        getNeos();
    }

    /**
     * Attempts to get NEOs
     */
    private void getNeos() {

        mRecyclerView.setVisibility(View.GONE);
        mTextViewEmpty.setText(getString(R.string.loading_neos));
        mTextViewEmpty.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);

        final Call<List<PotentiallyHazardousAsteroid>> call = RetroFitSingleton.getInstance(getApplicationContext()).getJsonWebService()
                .getPotentialHazardousAsteroids();
        call.enqueue(new retrofit2.Callback<List<PotentiallyHazardousAsteroid>>() {

            @Override
            public void onResponse(Call<List<PotentiallyHazardousAsteroid>> call, Response<List<PotentiallyHazardousAsteroid>> response) {
                mProgressBar.setVisibility(View.GONE);
                stopRefreshing();
                if (response.isSuccessful()) {
                    List<PotentiallyHazardousAsteroid> neos = response.body();
                    if (neos != null && neos.size() > 0) {
                        mList = neos;
                        mAdapter = new NEOAdapter(MainActivity.this, mList);
                        mRecyclerView.setAdapter(mAdapter);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mTextViewEmpty.setVisibility(View.GONE);
                    } else {
                        mRecyclerView.setVisibility(View.GONE);
                        mTextViewEmpty.setText(getString(R.string.empty_pha));
                        mTextViewEmpty.setVisibility(View.VISIBLE);
                    }
                } else {
                    mRecyclerView.setVisibility(View.GONE);
                    mTextViewEmpty.setText(getString(R.string.empty_pha));
                    mTextViewEmpty.setVisibility(View.VISIBLE);
                    Utils.showSnackBarWithError(mCoordinatorLayout, getString(R.string.error_network));
                }
            }

            @Override
            public void onFailure(Call<List<PotentiallyHazardousAsteroid>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                stopRefreshing();
                Log.e(LOG_TAG, "Error getting report monitors", t);
            }

        });

    }

    /**
     * Tells the swipe refresh layout to stop refreshing
     */
    private void stopRefreshing() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
