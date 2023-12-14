package com.example.pet_care.request;

import com.example.pet_care.models.CollarModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CollarRequest {
    @GET("guzzle/view")
    Call<CollarModel> getData();
}
