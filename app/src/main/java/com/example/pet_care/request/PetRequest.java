package com.example.pet_care.request;

import com.example.pet_care.models.PetModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PetRequest {
    @FormUrlEncoded
    @POST("pets/add")
    Call<PetModel> newPet(@Field("nombre") String nombre,
                          @Field("peso") String peso,
                          @Field("id_collar") String id_collar,
                          @Field("id_usuario") String id_usuario);
}
