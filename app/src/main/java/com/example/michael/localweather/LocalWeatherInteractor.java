package com.example.michael.localweather;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;

public class LocalWeatherInteractor implements LocalWeatherContract.Interactor{
    private LocalWeatherContract.Presenter presenter;
    private LocalWeatherContract.Repository repository;
    private LocalWeatherContract.Router router;

    public LocalWeatherInteractor(LocalWeatherContract.Presenter presenter){
        this.presenter = presenter;
        repository = new LocalWeatherRepository(this);
        router = new LocalWeatherRouter(this);
    }

    @Override
    public String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude) {
        try {
            List<Address> listAddresses = geocoder.getFromLocation(latitude, longitude, 1);
            if(listAddresses!= null && listAddresses.size() > 0){
                return listAddresses.get(0).getAddressLine(0);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "Sample text";
    }

    @Override
    public void startLocationServices(Activity context) {
        repository.initializeLocationServices(context);
    }

    @Override
    public void createPermissionNotGrantedMessage(String text) {
        presenter.showPermissionNotGrantedMessage(text);
    }

    @Override
    public void passLatLong(double latitude, double longitude) {
        presenter.passLatLong(latitude, longitude);
    }
}
