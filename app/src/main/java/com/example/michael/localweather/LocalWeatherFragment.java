package com.example.michael.localweather;

import android.app.Activity;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michael.localweather.RecyclerClasses.DailyForecastAdapter;
import com.example.michael.localweather.WeatherData.Datum;

import java.util.List;
import java.util.Locale;

public class LocalWeatherFragment extends Fragment implements LocalWeatherContract.View {

    private LocalWeatherContract.Presenter presenter;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.main_menu_fragment, container, false);
        return v;
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        activity = getActivity();
        presenter = new LocalWeatherPresenter(this);
        presenter.startLocationServices(getActivity());

    }

    @Override
    public void showToast(String text) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeCoordToPlace(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(activity.getApplicationContext(), Locale.getDefault());
        String location = presenter.getGeocodedLocation(geocoder, latitude, longitude);
        ((TextView)activity.findViewById(R.id.location_header)).setText(location);
    }

    @Override
    public void showTemp(double temp){
        String moddedString = String.format(getString(R.string.temperature), temp);
        ((TextView)activity.findViewById(R.id.temperatureDisplay)).setText(moddedString);
    }

    @Override
    public void showSummary(String summ) {
        String moddedString = String.format(getString(R.string.summary), summ);
        ((TextView)activity.findViewById(R.id.summaryDisplay)).setText(moddedString);
    }

    @Override
    public void showForecast(List<Datum> days) {
        RecyclerView forecast = activity.findViewById(R.id.forecast);
        DailyForecastAdapter adapter= new DailyForecastAdapter(days);
        forecast.setAdapter(adapter);
        forecast.setLayoutManager(new LinearLayoutManager(activity));
    }


}
