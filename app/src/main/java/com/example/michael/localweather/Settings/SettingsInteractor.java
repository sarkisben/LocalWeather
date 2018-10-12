package com.example.michael.localweather.Settings;

import android.support.v4.app.FragmentManager;

public class SettingsInteractor implements SettingsContract.Interactor{

    private SettingsContract.Presenter presenter;
    private SettingsContract.Router router;

    public SettingsInteractor(SettingsContract.Presenter presenter){
        this.presenter = presenter;
        router = new SettingsRouter(this);
    }


    @Override
    public void goBack(FragmentManager manager) {
        router.goBack(manager);
    }
}
