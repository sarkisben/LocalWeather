package com.example.michael.localweather;

import android.app.Activity;
import android.location.Geocoder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.michael.localweather.WeatherData.Datum;

import java.util.List;

public interface LocalWeatherContract {

    int PERMISSIONS_REQUEST_READ_CONTACTS = 3;

    interface View {
        void showToast(String text);

        void changeCoordToPlace(double latitude, double longitude);

        void showTemp(double temp);

        void showSummary(String summ);

        void showForecast(List<Datum> days, String timezone);
    }

    interface Presenter {
        String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude);

        void enterZip(Geocoder geocoder, String zip);

        void startLocationServices(Activity context);

        void showPermissionNotGrantedMessage(String text);

        void passLatLong(double latitude, double longitude);

        void passTemperature(double temp);

        void passSummary(String summ);

        void passForecast(List<Datum> days, String timezone);

        void goToSettingsPage(FragmentManager fragmentManager, Fragment fragment);
    }

    interface Interactor {
        String getGeocodedLocation(Geocoder geocoder, double latitude, double longitude);

        void startLocationServices(Activity context);

        void createPermissionNotGrantedMessage(String text);

        void convertZipToLatLong(Geocoder geocoder, String zip);

        void passLatLong(double latitude, double longitude);

        void passTemperature(double temp);

        void passSummary(String summ);

        void passForecast(List<Datum> days, String timezone);

        void goToSettingsPage(FragmentManager fragmentManager, Fragment fragment);

    }

    interface Repository {
        void initializeLocationServices(Activity context);

        void callForecast(final double latitude, final double longitude);
    }

    interface Router {
        void openSettings(FragmentManager fragmentManager, Fragment fragment);
    }
}
