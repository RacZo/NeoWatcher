package com.oscarsalguero.neowatcher.networking;

import com.oscarsalguero.neowatcher.bean.PotentiallyHazardousAsteroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Web Service Client
 * <p/>
 * Created by RacZo on 4/24/16.
 */
public interface WebService {

    String API_DATE_FORMAT = "yyyy-MM-dd";
    String BASE_URL = "http://neowatcher.mybluemix.net/";

    /**
     * Gets Potentially Hazardous Asteroids data in JSON format
     */
    @GET("pha_extended.json")
    Call<List<PotentiallyHazardousAsteroid>> getPotentialHazardousAsteroids();

}
