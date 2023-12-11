package com.example.pet_care.retrofit;

import android.widget.RelativeLayout;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class request_1 {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.117.37:8000/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
