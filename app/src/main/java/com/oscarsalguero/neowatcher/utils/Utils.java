package com.oscarsalguero.neowatcher.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.oscarsalguero.neowatcher.Constants;
import com.oscarsalguero.neowatcher.R;

/**
 * Created by RacZo on 4/24/16.
 */
public abstract class Utils {

    /**
     * Shows a {@link Snackbar} with an error message
     *
     * @param view    the {@link View} the {@link Snackbar} will appear on
     * @param message a {@link String} with the error message we want to show
     */
    public static void showSnackBarWithError(View view, String message) {
        if (view != null) {
            Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.background_snackbar_error));
            TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        }
    }

    /**
     * Saves a flag when  {@link SplashScreenActivity} did show
     *
     * @param context the Android {@link Context} the method is being called from
     */
    public static void splashScreenDidShow(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = defaultSharedPreferences.edit();
        editor.putBoolean(Constants.PREFERENCE_SPLASH_SCREEN_DID_SHOW, false);
        editor.commit();
    }
}
