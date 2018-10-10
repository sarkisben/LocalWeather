package com.example.michael.localweather;

import android.app.Activity;
import android.location.Geocoder;

public class LocalWeatherPresenter implements LocalWeatherContract.Presenter {
    private LocalWeatherContract.View fragment;
    private LocalWeatherContract.Interactor interactor;

    public LocalWeatherPresenter(LocalWeatherContract.View fragment){
        this.fragment = fragment;
        interactor = new LocalWeatherInteractor(this);
    }

    @Override
    public String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude) {
        return interactor.getGeocodedLocation(geocoder, latitude, longitude);
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
}
