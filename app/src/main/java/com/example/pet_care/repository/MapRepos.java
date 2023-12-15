package com.example.pet_care.repository;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.ProfileModel;
import com.example.pet_care.request.ProfileRequest;
import com.example.pet_care.retrofit.request_1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapRepos {
    private static Retrofit retrofit;

    public static void setRetrofit() {
        retrofit = request_1.getRetrofit();
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            setRetrofit();
        }
        return retrofit;
    }
}


