package com.example.michael.localweather;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.michael.localweather.Retrofit.DarkSkyEndpoints;
import com.example.michael.localweather.Retrofit.RetrofitClient;
import com.example.michael.localweather.WeatherData.Currently;
import com.example.michael.localweather.WeatherData.Report;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.michael.localweather.LocalWeatherContract.PERMISSIONS_REQUEST_READ_CONTACTS;

public class LocalWeatherRepository implements LocalWeatherContract.Repository {

    private final double nullIslandLongitude = 5.633333;
    private final double nullIsalndLatitude = -1.416667;
    LocalWeatherContract.Interactor interactor;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private DarkSkyEndpoints endpoints;

    public LocalWeatherRepository(LocalWeatherContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void initializeLocationServices(Activity context) {
        endpoints = RetrofitClient.getClient();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        //Check permission to see if we can use location
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //Not granted
            //Show explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                interactor.createPermissionNotGrantedMessage(context.getResources().getString(R.string.location_permission_denied));
            } else {
                //Request the permission
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            //Permission Granted
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(context, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double longitude = location.getLongitude();
                                double latitude = location.getLatitude();
                                callForecast(latitude, longitude);
                            } else {
                                callForecast(nullIsalndLatitude, nullIslandLongitude);
                            }
                        }
                    });
        }
    }

    public void callForecast(final double latitude, final double longitude) {
        Call<Report> call = endpoints.weatherReport(longitude, latitude);
        call.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                interactor.passLatLong(latitude, longitude);
                Report report = response.body();
                String timezone = report.getTimezone();
                Currently currentReport = report.getCurrently();
                interactor.passTemperature(currentReport.getTemperature());
                interactor.passSummary(currentReport.getSummary());
                interactor.passForecast(report.getDaily().getData(), timezone
                );
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                interactor.createPermissionNotGrantedMessage(t.getMessage());
            }
        });
    }



}
