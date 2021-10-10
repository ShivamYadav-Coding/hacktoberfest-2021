package com.example.convertor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitbuilder {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://api.exchangerate-api.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
