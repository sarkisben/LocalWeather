package com.example.michael.localweather.Settings;

import android.support.v4.app.FragmentManager;

public interface SettingsContract {
    interface View{

    }
    interface Presenter{
        void goBack(FragmentManager manager);

    }
    interface Interactor{
        void goBack(FragmentManager manager);

    }
    interface Router{
        void goBack(FragmentManager manager);
    }
}
