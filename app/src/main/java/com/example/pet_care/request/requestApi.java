package com.example.pet_care.request;

import com.example.pet_care.models.pruebamodel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface requestApi {
    @FormUrlEncoded
    @POST("register")
    Call<pruebamodel> postModel(@Field("nombre") String nombre,
                                @Field("apellidos") String apellidos,
                                @Field("email") String email,
                                @Field("password") String password,
                                @Field("password_confirmation") String password_confirmation);
}
