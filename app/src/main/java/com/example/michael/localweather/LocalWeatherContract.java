package com.example.michael.localweather;

import android.app.Activity;
import android.location.Geocoder;

public interface LocalWeatherContract {

    public static final int PERMISSIONS_REQUEST_READ_CONTACTS = 3;

    interface View{
        void showToast(String text);
        void changeCoordToPlace(double latitude, double longitude);
    }

    interface Presenter {
        String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude);
        void startLocationServices(Activity context);
        void showPermissionNotGrantedMessage(String text);
        void passLatLong(double latitude, double longitude);
    }

    interface Interactor {
        String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude);
        void startLocationServices(Activity context);
        void createPermissionNotGrantedMessage(String text);
        void passLatLong(double latitude, double longitude);
    }

    interface Repository {
        void initializeLocationServices(Activity context);
        void initializeRetrofit();
    }

    interface Router {
        void openSettings();
    }
}
