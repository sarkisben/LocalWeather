package com.example.michael.localweather.WeatherData;

/**
 * Created by bgsar on 10/10/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getSummary() {
        return summary;
    }

    public List<Datum> getData() {
        return data;
    }


}
