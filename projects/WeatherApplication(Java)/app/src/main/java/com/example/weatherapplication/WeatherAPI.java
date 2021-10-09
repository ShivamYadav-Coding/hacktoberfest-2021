package com.example.weatherapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather?appid=dc5cad5a38fab2458f93f2afb004b9c1&units=metric")
    Call<OpenWeatherMap> getWeatherWithLocation(@Query("lat") double lat, @Query("lon") double lon);

    @GET("weather?appid=dc5cad5a38fab2458f93f2afb004b9c1&units=metric")
    Call<OpenWeatherMap> getWeatherWithCityName(@Query("q")String cityName);

}
