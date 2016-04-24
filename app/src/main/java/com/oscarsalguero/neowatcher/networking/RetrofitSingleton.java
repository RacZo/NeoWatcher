package com.oscarsalguero.neowatcher.networking;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetroFit singleton class.
 * <p/>
 * Used to configure the way the app connects to our backend API.
 * Request/response deserialization and authentication can be handled/configured here.
 * <p/>
 * Created by RacZo on 4/24/16.
 */
public class RetroFitSingleton {

    private static final String LOG_TAG = RetroFitSingleton.class.getName();
    private static RetroFitSingleton instance;
    private WebService jsonWebService;
    private Context mContext;

    public static RetroFitSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new RetroFitSingleton(context);
        }
        return instance;
    }

    private RetroFitSingleton(final Context context) {

        try {

            mContext = context;

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

            String url = WebService.BASE_URL;

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                    .setDateFormat(WebService.API_DATE_FORMAT)
                    .create();

            Retrofit retrofitJSON = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

            jsonWebService = retrofitJSON.create(WebService.class);

        } catch (Exception e) {
            Log.e(LOG_TAG, "An error occurred initializing RetroFit singleton class", e);
        }
    }

    public WebService getJsonWebService() {
        return this.jsonWebService;
    }

}
