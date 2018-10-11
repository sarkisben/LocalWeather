package com.example.michael.localweather.Settings;

public class SettingsInteractor implements SettingsContract.Interactor{

    private SettingsContract.Presenter presenter;
    private SettingsContract.Router router;

    public SettingsInteractor(SettingsContract.Presenter presenter){
        this.presenter = presenter;
        SettingsRouter router = new SettingsRouter(this);
    }


    @Override
    public void goBack(String location) {
        router.goBack(location);
    }
}
