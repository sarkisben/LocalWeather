package com.example.michael.localweather.Settings;

public class SettingsRouter implements SettingsContract.Router {

    private SettingsContract.Interactor interactor;

    public SettingsRouter(SettingsContract.Interactor interactor){
        this.interactor = interactor;
    }

    @Override
    public void goBack(String location) {

    }
}
