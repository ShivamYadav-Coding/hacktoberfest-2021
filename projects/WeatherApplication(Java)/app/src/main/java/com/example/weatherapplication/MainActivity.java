package com.example.weatherapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;
    private TextView textViewCityName;
    private ImageView imageViewWeather;
    private TextView textViewTemperature;
    private TextView textViewWeather;
    private TextView textViewDetails;
    private TextView textViewHumidity;
    private TextView textViewMaxTemp;
    private TextView textViewMinTemp;
    private TextView textViewPressure;
    private TextView textViewWind;
    private TextView textViewHumidityValue;
    private TextView textViewMaxTempValue;
    private TextView textViewMinTempValue;
    private TextView textViewPressureValue;
    private TextView textViewWindValue;
    private FloatingActionButton floatingActionButton;
    private double lat;
    private double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCityName = findViewById(R.id.textViewCity);
        imageViewWeather = findViewById(R.id.imageViewWeather);
        textViewTemperature = findViewById(R.id.textViewTemperature);
        textViewWeather = findViewById(R.id.textViewWeather);
        textViewDetails = findViewById(R.id.textViewDetails);
        textViewHumidity = findViewById(R.id.textViewHumidity);
        textViewMaxTemp = findViewById(R.id.textViewMaxTemp);
        textViewMinTemp = findViewById(R.id.textViewMinTemp);
        textViewPressure = findViewById(R.id.textViewPressure);
        textViewWind = findViewById(R.id.textViewWind);
        textViewHumidityValue = findViewById(R.id.textViewHumidityValue);
        textViewMaxTempValue = findViewById(R.id.textViewMaxTempValue);
        textViewMinTempValue = findViewById(R.id.textViewMinTempValue);
        textViewPressureValue = findViewById(R.id.textViewPressureValue);
        textViewWindValue = findViewById(R.id.textViewWindValue);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WeatherSearchCityActivity.class);
                startActivity(intent);
            }
        });

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat = location.getLatitude();
                lon = location.getLongitude();
                Log.d("messageMe",lat + "");
                Log.d("messageMe",lon + "");
                getWeatherData(lon,lat);
            }
        };

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION},1);
        }else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500,50,locationListener);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 & grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500,50,locationListener);
        }
    }

    public void getWeatherData(double lon,double lat) {
        WeatherAPI weatherAPI = WeatherRetrofit.getClient().create(WeatherAPI.class);
        Call<OpenWeatherMap> call = weatherAPI.getWeatherWithLocation(lat,lon);
        call.enqueue(new Callback<OpenWeatherMap>() {
            @Override
            public void onResponse(Call<OpenWeatherMap> call, Response<OpenWeatherMap> response) {
                if (response.isSuccessful()) {
                    OpenWeatherMap map = response.body();
                    textViewCityName.setText(map.getName() + "," + map.getSys().getCountry());
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
            }

            @Override
            public void onFailure(Call<OpenWeatherMap> call, Throwable t) {
                t.printStackTrace();
                Log.d("messageMe","errorrorro");
                Toast.makeText(MainActivity.this,"There is an error",Toast.LENGTH_LONG).show();
            }
        });
    }
}