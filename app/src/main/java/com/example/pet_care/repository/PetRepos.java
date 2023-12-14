package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.pet_care.models.PetModel;
import com.example.pet_care.request.PetRequest;
import com.example.pet_care.retrofit.request_1;

public class PetRepos {
    public Retrofit retrofit;
    void setRetrofit(){retrofit=request_1.getRetrofit();}

    public MutableLiveData<PetModel> newPet(String nombre, String peso,String id_collar, String id_usuario)
    {
     setRetrofit();
        PetRequest petRequest=retrofit.create(PetRequest.class);
        Call<PetModel> petModelCall=petRequest.newPet(nombre, peso, id_collar, id_usuario);
        MutableLiveData<PetModel> mutable=new MutableLiveData<>();
        Log.d("PET", "aaa");

        petModelCall.enqueue(new Callback<PetModel>() {
            @Override
            public void onResponse(Call<PetModel> call, Response<PetModel> response) {
                Log.d("PET", "pet");
                PetModel petModel;
                switch (response.code())
                {
                    case 404:
                    case 422:
                        petModel= new PetModel();
                        petModel.code=String.valueOf(response.code());
                        mutable.setValue(petModel);
                    break;
                    case 201:
                        petModel=response.body();
                        if(petModel != null)
                        {
                            petModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(petModel);
                        break;
                }
            }

            @Override
            public void onFailure(Call<PetModel> call, Throwable t) {

            }
        });
        return mutable;

    }
}
