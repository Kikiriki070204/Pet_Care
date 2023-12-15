package com.example.pet_care.request;

import com.example.pet_care.models.SwitchModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SwitchRequest {
    @POST("guzzle/buzzer")
    Call<SwitchModel> Switchchange(@Field("value") String Switch );

}
