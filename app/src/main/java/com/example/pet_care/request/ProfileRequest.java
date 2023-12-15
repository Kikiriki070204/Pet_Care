package com.example.pet_care.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.example.pet_care.models.ProfileModel;
public interface ProfileRequest {
    @GET("profile/{id}")
    Call<ProfileModel> getProfile(@Path("id") String id);
}
