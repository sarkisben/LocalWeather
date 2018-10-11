package com.example.michael.localweather.RecyclerClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michael.localweather.R;
import com.example.michael.localweather.WeatherData.Datum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DailyForecastAdapter extends RecyclerView.Adapter<DailyForecastAdapter.ViewHolder> {

    private List<Datum> forecast;
    private String timezone;


    public DailyForecastAdapter(List<Datum> forecast, String timezone) {
        this.forecast = forecast;
        this.timezone = timezone;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View forecastView = inflater.inflate(R.layout.day_forecast, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(forecastView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyForecastAdapter.ViewHolder viewHolder, int i) {

        Context localContext = viewHolder.itemView.getContext();
        Datum datum = forecast.get(i);

        TextView day = viewHolder.dayTextView;
        TextView summary = viewHolder.summaryTextView;
        TextView tempHigh = viewHolder.tempHighTextView;
        TextView tempLow = viewHolder.tempLowTextView;


        day.setText(convertToDate(datum.getTime()));
        summary.setText(datum.getSummary());
        String highTemp = String.format(localContext.getString(R.string.temperature_high), datum.getTemperatureHigh());
        tempHigh.setText(highTemp);
        String lowTemp = String.format(localContext.getString(R.string.temperature_high), datum.getTemperatureLow());
        tempLow.setText(lowTemp);
    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    /**
     * Covnerts unix time to a date.
     *
     * @param unixTime A long representing seconds from the last Epohc in unix.
     * @return String in this format: 	Wed, Jul 4, '01
     */
    private String convertToDate(long unixTime) {
        Date date = new java.util.Date(unixTime * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEE, MMM d");
        sdf.setTimeZone(TimeZone.getTimeZone(timezone));
        return sdf.format(date);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dayTextView;
        public TextView summaryTextView;
        public TextView tempHighTextView;
        public TextView tempLowTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            dayTextView = (TextView) itemView.findViewById(R.id.day);
            summaryTextView = (TextView) itemView.findViewById(R.id.daily_conditions);
            tempHighTextView = (TextView) itemView.findViewById(R.id.tempHigh);
            tempLowTextView = (TextView) itemView.findViewById(R.id.tempLow);
        }
    }

}
