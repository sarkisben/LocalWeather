package com.example.michael.localweather.WeatherData;

/**
 * Created by bgsar on 10/10/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("precipProbability")
    @Expose
    private double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;
    @SerializedName("temperatureHigh")
    @Expose
    private double temperatureHigh;
    @SerializedName("temperatureLow")
    @Expose
    private double temperatureLow;

    public int getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public double getTemperatureHigh() {
        return temperatureHigh;
    }

    public double getTemperatureLow() {
        return temperatureLow;
    }
}


