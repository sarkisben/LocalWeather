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
    @SerializedName("sunriseTime")
    @Expose
    private int sunriseTime;
    @SerializedName("sunsetTime")
    @Expose
    private int sunsetTime;
    @SerializedName("moonPhase")
    @Expose
    private double moonPhase;
    @SerializedName("precipIntensity")
    @Expose
    private double precipIntensity;
    @SerializedName("precipIntensityMax")
    @Expose
    private double precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    @Expose
    private int precipIntensityMaxTime;
    @SerializedName("precipProbability")
    @Expose
    private double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;
    @SerializedName("temperatureHigh")
    @Expose
    private double temperatureHigh;
    @SerializedName("temperatureHighTime")
    @Expose
    private int temperatureHighTime;
    @SerializedName("temperatureLow")
    @Expose
    private double temperatureLow;
    @SerializedName("temperatureLowTime")
    @Expose
    private int temperatureLowTime;
    @SerializedName("apparentTemperatureHigh")
    @Expose
    private double apparentTemperatureHigh;
    @SerializedName("apparentTemperatureHighTime")
    @Expose
    private int apparentTemperatureHighTime;
    @SerializedName("apparentTemperatureLow")
    @Expose
    private double apparentTemperatureLow;
    @SerializedName("apparentTemperatureLowTime")
    @Expose
    private int apparentTemperatureLowTime;
    @SerializedName("dewPoint")
    @Expose
    private double dewPoint;
    @SerializedName("humidity")
    @Expose
    private double humidity;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("windSpeed")
    @Expose
    private double windSpeed;
    @SerializedName("windGust")
    @Expose
    private double windGust;
    @SerializedName("windGustTime")
    @Expose
    private int windGustTime;
    @SerializedName("windBearing")
    @Expose
    private int windBearing;
    @SerializedName("cloudCover")
    @Expose
    private double cloudCover;
    @SerializedName("uvIndex")
    @Expose
    private int uvIndex;
    @SerializedName("uvIndexTime")
    @Expose
    private int uvIndexTime;
    @SerializedName("visibility")
    @Expose
    private int visibility;
    @SerializedName("ozone")
    @Expose
    private double ozone;
    @SerializedName("temperatureMin")
    @Expose
    private double temperatureMin;
    @SerializedName("temperatureMinTime")
    @Expose
    private int temperatureMinTime;
    @SerializedName("temperatureMax")
    @Expose
    private double temperatureMax;
    @SerializedName("temperatureMaxTime")
    @Expose
    private int temperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    @Expose
    private double apparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    private int apparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    @Expose
    private double apparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    private int apparentTemperatureMaxTime;

    public int getTime() {
        return time;
    }
    public String getSummary() {
        return summary;
    }
    public int getSunriseTime() {
        return sunriseTime;
    }
    public int getSunsetTime() {
        return sunsetTime;
    }
    public double getMoonPhase() {
        return moonPhase;
    }
    public double getPrecipIntensity() {
        return precipIntensity;
    }
    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }
    public int getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
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
    public int getTemperatureHighTime() {
        return temperatureHighTime;
    }
    public double getTemperatureLow() {
        return temperatureLow;
    }
    public int getTemperatureLowTime() {
        return temperatureLowTime;
    }
    public double getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }
    public int getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }
    public double getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }
    public int getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }
    public double getDewPoint() {
        return dewPoint;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getPressure() {
        return pressure;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public double getWindGust() {
        return windGust;
    }
    public int getWindGustTime() {
        return windGustTime;
    }

    public int getWindBearing() {
        return windBearing;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public int getUvIndexTime() {
        return uvIndexTime;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getOzone() {
        return ozone;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public int getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }
    public int getTemperatureMaxTime() {
        return temperatureMaxTime;
    }
    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public int getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }
    public int getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }
}

