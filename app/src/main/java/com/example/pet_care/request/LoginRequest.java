package com.example.pet_care.request;

import com.example.pet_care.models.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginRequest {
    @FormUrlEncoded
    @POST("auth/login")
    Call <LoginModel> Login(@Field("email")String email,
                            @Field("password") String password);
}
