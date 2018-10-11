package com.example.michael.localweather.Retrofit;

import com.example.michael.localweather.WeatherData.Report;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by bgsar on 10/10/2018.
 */

public interface DarkSkyEndpoints {

    @GET("/{longitude},{latitude}")
    Call<Report> weatherReport(@Path("longitude") double longitude, @Path("latitude") double latitude);


}
