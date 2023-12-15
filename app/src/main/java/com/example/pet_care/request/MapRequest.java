package com.example.pet_care.request;
import com.example.pet_care.models.MapModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MapRequest {
    @GET("ruta/para/latitud")
    Call<Double> getLatitude();

    @GET("ruta/para/longitud")
    Call<Double> getLongitude();
}
