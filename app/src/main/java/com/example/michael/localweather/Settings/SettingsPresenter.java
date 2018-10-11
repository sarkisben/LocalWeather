package com.example.michael.localweather.Settings;

public class SettingsPresenter implements SettingsContract.Presenter {
    private SettingsContract.View fragment;
    private SettingsContract.Interactor interactor;

    public SettingsPresenter(SettingsContract.View fragment){
        this.fragment = fragment;
        SettingsInteractor interactor = new SettingsInteractor(this);
    }

    @Override
    public void goBack(String location) {
        interactor.goBack(location);
    }
}
