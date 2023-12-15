package com.example.pet_care.request;

import com.example.pet_care.models.EditProfileModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EditProfileRequest {
    @FormUrlEncoded
    @POST("auth/users/{id}/update-password")
    Call<EditProfileModel> EditProfile(@Field("password")String password,
                                       @Path("id") String id,
                                       @Field("password_confirmation") String passwordConf);
}
