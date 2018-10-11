package com.example.michael.localweather;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.michael.localweather.Settings.SettingsFragment;

public class LocalWeatherRouter implements LocalWeatherContract.Router {

    private LocalWeatherContract.Interactor interactor;

    public LocalWeatherRouter(LocalWeatherContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void openSettings(FragmentManager fragmentManager) {
        SettingsFragment settings = new SettingsFragment();
        fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, settings)
                        .addToBackStack(null)
                        .commit();
    }
}
