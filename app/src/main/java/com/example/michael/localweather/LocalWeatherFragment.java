package com.example.michael.localweather;

import android.app.Activity;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
}
