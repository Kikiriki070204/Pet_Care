package com.example.pet_care.request;

import com.example.pet_care.models.HomeModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeRequest {
    @GET("home/{id}")
    Call<HomeModel> getHome(@Path("id") String id);
}
