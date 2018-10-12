package com.example.michael.localweather.Retrofit;


import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bgsar on 10/10/2018.
 */

public class RetrofitClient {

    private static final int MAX_REQUESTS_NUMBER = 1;
    private static final String BASE_URL = "https://api.darksky.net/forecast/e15d7b66826921e95fbb65a190e81e68/";
    public static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit retrofit = null;

    public static DarkSkyEndpoints getClient() {
        if (retrofit == null) {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequests(MAX_REQUESTS_NUMBER);
            httpClient.dispatcher(dispatcher);
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        DarkSkyEndpoints endpoints = retrofit.create(DarkSkyEndpoints.class);
        return endpoints;
    }
}
