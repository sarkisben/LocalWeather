package com.example.michael.localweather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String readableLocation;
    //Open the LocalWeatherFragment by default
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);


        if (fragment == null) {
            fragment = new LocalWeatherFragment();
            fm.beginTransaction()
              .replace(R.id.fragment_container, fragment)
              .addToBackStack(null)
              .commit();
        }
    }

    /**
     * Mutator for user entered location.
     * @return The city and zip code of the user location.
     */
    public String getReadableLocation(){
        return readableLocation;
    }

    /**
     * Accessor for the user entered location
     * @param newLoc Updated location.
     */
    public void setReadableLocation(String newLoc){
        readableLocation = newLoc;
    }
}
