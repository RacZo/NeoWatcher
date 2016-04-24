package com.oscarsalguero.neowatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

/**
 * Startup Splash screen that shows the logo
 * <p/>
 * Created by RacZo on 4/23/16.
 */
public class SplashScreenActivity extends AppCompatActivity {

    private static final String LOG_TAG = SplashScreenActivity.class.getName();

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mImageView = (ImageView) findViewById(R.id.image_view_logo);

        YoYo.with(Techniques.Bounce).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(LOG_TAG, "Logo animation started");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(LOG_TAG, "Logo animation ended");
                showMainActivity();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(LOG_TAG, "Logo animation cancelled");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(LOG_TAG, "Logo animation repeat");
            }
        }).duration(2500).delay(500).playOn(mImageView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void showMainActivity() {
        Log.d(LOG_TAG, "Will show " + MainActivity.class.getName());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
