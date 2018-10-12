# LocalWeather

##Summary
This application was designed as an example for Cambridge Mobile Telematics.  
It is a basic weather application that displays the location, conditions, and temperature of the current location (by default).
It also describes a brief forecast of the given location for the next 8 days.
The user can open a settings fragment to change the location by entering a valid numerical zip code, or to keep using the current location.
This app only works for locations in the United States with a valid zip code.  It has been tested on Android versions 8 and above.

##Architecture
The app is desinged with two fragments, both with VIPER architecture.  Fragments are used in order to save location data over the course of using the app.  
VIPER architecture was used because I was most familiar with it when I worked at Wayfair and it encourages good practices such as unit testing and separating functionality.
Roughly, within each fragment, each part of the architecture does the following
View (or Fragment) --> Creates the fragment, changes display when appropriate, and adds listeners to elements when appropriate.
Presenter --> A "pass-throug" class between the Fragment and the Interactor
Interactor --> Decides whether a certain funtionality should be delegated to the Repository or the Router.
Repository --> This module was responsible for network calls and setting up location functionality.
Router --> Responsible for navigating to other apps.

There are three utility classes and four data classes. The utility classes are the following:
1. DailyForecastAdapter --> An adapter class for the RecyclerView that displays 8 days of forecast.
2. DarkSkyEndpoints --> An interface that codifies the enpoint(s) neede to access weather data online.
3. RetrofitClient --> A class that builds the retrofit client for use within the Repository of the LocalWeather fragment.

The data classes reflect the JSON returned by the DarkSkyEndpoint and converted to POJOs.  They are the following
1. Currently --> Displays the current weather conditions.
2. Daily --> Contains an array days of future forecasts.
3. Datum --> Represents on day of future forecast.
4. Report --> The root level of data returned by the endpoint.

##Third Party Libraries
Below are the thrid party libraries used as well as the reasoning for using them.
Retrofit2 - For use of the DarkSky endpoint
FusedLocationProviderClient - For location functionality
Geocoder - To decode from a user entered zip code to a Latitude and Longitude and vice versa.

##Current Issues
The main issue with the current code is that of multi threading.  Even thought the OkHttpClient is set up with a maximum requestnumber of 1, when entering a new location, the function that takes in the input, as well as the fusedLocationProviderClient success listener both trigger the same retrofit request at once. This results in only the current location being displayed.







