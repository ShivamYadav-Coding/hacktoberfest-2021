package com.example.weatherapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeatherSearchCityActivity extends AppCompatActivity {

    private EditText editTextCityName;
    private ImageButton searchButton;
    private TextView textViewCityName;
    private TextView textViewTemperature;
    private TextView textViewWeather;
    private ImageView imageViewWeather;
    private TextView textViewHumidityValue;
    private TextView textViewMaxTempValue;
    private TextView textViewMinTempValue;
    private TextView textViewPressureValue;
    private TextView textViewWindValue;
    private TextView textViewDetails;
    private TextView textViewHumidity;
    private TextView textViewMaxTemp;
    private TextView textViewMinTemp;
    private TextView textViewPressure;
    private TextView textViewWind;
    LocationManager locationManager;
    LocationListener locationListener;
    double longitude;
    double latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_search_city);
        editTextCityName = findViewById(R.id.editTextSearchCityName);
        searchButton = findViewById(R.id.searchButton);
        textViewCityName = findViewById(R.id.textViewSearchCityName);
        textViewWeather = findViewById(R.id.textViewSearchWeather);
        textViewTemperature = findViewById(R.id.textViewSearchTemperature);
        imageViewWeather = findViewById(R.id.imageViewSearchWeather);
        textViewHumidityValue = findViewById(R.id.textViewSearchHumidityValue);
        textViewMaxTempValue = findViewById(R.id.textViewSearchMaxTempValue);
        textViewMinTempValue = findViewById(R.id.textViewSearchMinTempValue);
        textViewPressureValue = findViewById(R.id.textViewSearchPressureValue);
        textViewWindValue = findViewById(R.id.textViewSearchWindValue);
        textViewDetails = findViewById(R.id.textViewSearchDetails);
        textViewHumidity = findViewById(R.id.textViewSearchHumidity);
        textViewMaxTemp = findViewById(R.id.textViewSearchMaxTemp);
        textViewMinTemp = findViewById(R.id.textViewSearchMinTemp);
        textViewPressure = findViewById(R.id.textViewSearchPressure);
        textViewWind = findViewById(R.id.textViewSearchWind);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = editTextCityName.getText().toString();
                getWeatherByCityName(cityName);
                editTextCityName.setText(null);
            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                getWeatherData(latitude,longitude);
            }
        };
        if (ContextCompat.checkSelfPermission(WeatherSearchCityActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(WeatherSearchCityActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500,50,locationListener);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(WeatherSearchCityActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500,50,locationListener);
        }
    }

    public void getWeatherData(double lat,double lon) {
        Retrofit retrofit = WeatherRetrofit.getClient();
        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        Call<OpenWeatherMap> call = weatherAPI.getWeatherWithLocation(lat,lon);
        call.enqueue(new Callback<OpenWeatherMap>() {
            @Override
            public void onResponse(Call<OpenWeatherMap> call, Response<OpenWeatherMap> response) {
                OpenWeatherMap map = response.body();
                textViewCityName.setText(map.getName() + ", ");
                textViewTemperature.setText(map.getMain().getTemp() + "°C");
                textViewWeather.setText(map.getWeather().get(0).getDescription());
                textViewHumidityValue.setText(map.getMain().getHumidity() + "%");
                textViewMaxTempValue.setText(map.getMain().getTempMax() + "°C");
                textViewMinTempValue.setText(map.getMain().getTempMin() + "°C");
                textViewPressureValue.setText(map.getMain().getPressure() + "");
                textViewWindValue.setText(map.getWind().getSpeed() + "");
                textViewDetails.setText("Details");
                textViewWind.setText("Wind : ");
                textViewPressure.setText("Pressure : ");
                textViewMaxTemp.setText("Max Temp : ");
                textViewHumidity.setText("Humidity : ");
                textViewMinTemp.setText("Min Temp : ");
                String icon = map.getWeather().get(0).getIcon();
                Picasso.get().load("https://openweathermap.org/img/wn/" + icon + "@2x.png")
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(imageViewWeather);
            }

            @Override
            public void onFailure(Call<OpenWeatherMap> call, Throwable t) {
                Toast.makeText(WeatherSearchCityActivity.this,"There is an error",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getWeatherByCityName(String cityName) {
        Retrofit retrofit = WeatherRetrofit.getClient();
        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        Call<OpenWeatherMap> call = weatherAPI.getWeatherWithCityName(cityName);
        call.enqueue(new Callback<OpenWeatherMap>() {
            @Override
            public void onResponse(Call<OpenWeatherMap> call, Response<OpenWeatherMap> response) {
                if (response.isSuccessful()) {
                    OpenWeatherMap openWeatherMap = response.body();
                    textViewCityName.setText(openWeatherMap.getName() + ", " + openWeatherMap.getSys().getCountry());
                    textViewWeather.setText(openWeatherMap.getWeather().get(0).getDescription());
                    textViewTemperature.setText(openWeatherMap.getMain().getTemp() + "°C");
                    textViewHumidityValue.setText(openWeatherMap.getMain().getHumidity() + " %");
                    textViewMaxTempValue.setText(openWeatherMap.getMain().getTempMax() + "°C");
                    textViewMinTempValue.setText(openWeatherMap.getMain().getTempMin() + "°C");
                    textViewPressureValue.setText(openWeatherMap.getMain().getPressure() + "");
                    textViewWindValue.setText(openWeatherMap.getWind().getSpeed() + "");
                    textViewDetails.setText("Details");
                    textViewWind.setText("Wind : ");
                    textViewPressure.setText("Pressure : ");
                    textViewMaxTemp.setText("Max Temp : ");
                    textViewHumidity.setText("Humidity : ");
                    textViewMinTemp.setText("Min Temp : ");
                    String icon = openWeatherMap.getWeather().get(0).getIcon();
                    Picasso.get().load("https://openweathermap.org/img/wn/" + icon + "@2x.png")
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(imageViewWeather);
                }
            }

            @Override
            public void onFailure(Call<OpenWeatherMap> call, Throwable t) {
                Toast.makeText(WeatherSearchCityActivity.this,"City/State does not exist",Toast.LENGTH_LONG).show();
            }
        });
    }
}