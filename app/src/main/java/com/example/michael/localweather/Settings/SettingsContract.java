package com.example.michael.localweather.Settings;

public interface SettingsContract {
    interface View{

    }
    interface Presenter{
        void goBack(String location);

    }
    interface Interactor{
        void goBack(String location);

    }
    interface Router{
        void goBack(String location);
    }
}
