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

import java.util.List;

public class DailyForecastAdapter extends RecyclerView.Adapter<DailyForecastAdapter.ViewHolder>{

    private List<Datum> forecast;


    public DailyForecastAdapter(List<Datum> forecast){
        this.forecast = forecast;
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

        String convertedDay = datum.getTime() + "";
        day.setText(convertedDay);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dayTextView;
        public TextView summaryTextView;
        public TextView tempHighTextView;
        public TextView tempLowTextView;

        public ViewHolder(View itemView){
            super(itemView);
            dayTextView = (TextView) itemView.findViewById(R.id.day);
            summaryTextView = (TextView) itemView.findViewById(R.id.daily_conditions);
            tempHighTextView = (TextView) itemView.findViewById(R.id.tempHigh);
            tempLowTextView = (TextView) itemView.findViewById(R.id.tempLow);
        }
    }

}
