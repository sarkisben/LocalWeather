package com.example.michael.localweather.Settings;

import android.support.v4.app.FragmentManager;

public class SettingsPresenter implements SettingsContract.Presenter {
    private SettingsContract.View fragment;
    private SettingsContract.Interactor interactor;

    public SettingsPresenter(SettingsContract.View fragment){
        this.fragment = fragment;
        interactor = new SettingsInteractor(this);
    }

    @Override
    public void goBack(FragmentManager manager) {
        interactor.goBack(manager);
    }
}
