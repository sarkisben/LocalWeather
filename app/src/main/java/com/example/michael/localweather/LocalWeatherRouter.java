package com.example.michael.localweather;

public class LocalWeatherRouter implements LocalWeatherContract.Router {

    private LocalWeatherContract.Interactor interactor;

    public LocalWeatherRouter(LocalWeatherContract.Interactor interactor){
        this.interactor = interactor;
    }

    @Override
    public void openSettings() {

    }
}
