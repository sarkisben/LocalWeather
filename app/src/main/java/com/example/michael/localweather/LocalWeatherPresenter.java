package com.example.michael.localweather;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.michael.localweather.WeatherData.Datum;

import java.io.IOException;
import java.util.List;

public class LocalWeatherPresenter implements LocalWeatherContract.Presenter {
    private LocalWeatherContract.View fragment;
    private LocalWeatherContract.Interactor interactor;

    public LocalWeatherPresenter(LocalWeatherContract.View fragment) {
        this.fragment = fragment;
        interactor = new LocalWeatherInteractor(this);
    }

    @Override
    public String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude) {
        return interactor.getGeocodedLocation(geocoder, latitude, longitude);
    }

    @Override
    public String convertZipToLatLong(Geocoder geocoder, String zip) {
        try{
            List<Address> addresses = geocoder.getFromLocationName(zip, 1);
            if(addresses != null && !addresses.isEmpty()) {
                Address address = addresses.get(0);
                return interactor.getGeocodedLocation(geocoder, address.getLatitude(), address.getLongitude());
            }
            else{
                showPermissionNotGrantedMessage("Unable to get zipcode");
            }
        }
        catch (IOException e) {
            showPermissionNotGrantedMessage(e.getMessage());
        }
        return "Sample Text";
    }

    @Override
    public void startLocationServices(Activity context) {
        interactor.startLocationServices(context);
    }

    @Override
    public void showPermissionNotGrantedMessage(String text) {
        fragment.showToast(text);
    }

    @Override
    public void passLatLong(double latitude, double longitude) {
        fragment.changeCoordToPlace(latitude, longitude);
    }

    @Override
    public void passTemperature(double temp) {
        fragment.showTemp(temp);
    }

    @Override
    public void passSummary(String summ) {
        fragment.showSummary(summ);
    }

    @Override
    public void passForecast(List<Datum> days, String timezone) {
        fragment.showForecast(days, timezone);
    }

    @Override
    public void goToSettingsPage(FragmentManager fragmentManager, Fragment fragment) {
        interactor.goToSettingsPage(fragmentManager, fragment);
    }
}
