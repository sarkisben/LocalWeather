package com.example.michael.localweather.Retrofit;

/**
 * Created by bgsar on 10/10/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://api.darksky.net/forecast/e15d7b66826921e95fbb65a190e81e68/";

    public static DarkSkyEndpoints getDarkSkyEndpoints(){
        return RetrofitClient.getClient(BASE_URL).create(DarkSkyEndpoints.class);
    }
}
