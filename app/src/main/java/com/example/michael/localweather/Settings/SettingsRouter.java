package com.example.michael.localweather.Settings;

import android.support.v4.app.FragmentManager;

import com.example.michael.localweather.LocalWeatherFragment;
import com.example.michael.localweather.R;

public class SettingsRouter implements SettingsContract.Router {

    private SettingsContract.Interactor interactor;

    public SettingsRouter(SettingsContract.Interactor interactor){
        this.interactor = interactor;
    }

    @Override
    public void goBack(FragmentManager manager) {
        LocalWeatherFragment main = new LocalWeatherFragment();
        manager.beginTransaction()
                .replace(R.id.fragment_container, main)
                .addToBackStack(null)
                .commit();
    }
}
