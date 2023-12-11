package com.example.pet_care.repository;

import android.content.Intent;
import android.util.Log;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.pruebamodel;
import com.example.pet_care.request.requestApi;
import com.example.pet_care.retrofit.request_1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class prueba_repos {
    public Retrofit retrofit;
    void setRetrofit(){
        retrofit= request_1.getRetrofit();
    }
    public MutableLiveData<pruebamodel> postModel(String nombre, String apellidos, String email,
                                                  String password, String password_confirmation){
        setRetrofit();
        requestApi requestModel=retrofit.create(requestApi.class);
        Call<pruebamodel> modelCall=requestModel.postModel(nombre, apellidos,email, password, password_confirmation);
        MutableLiveData<pruebamodel> mutable=new MutableLiveData<>();
        Log.d("KIARA", "aaa");
         modelCall.enqueue(new Callback<pruebamodel>() {
            @Override
            public void onResponse(Call<pruebamodel> call, Response<pruebamodel> response) {
                Log.d("KIARA", "abba");
                pruebamodel newModel;

                switch (response.code()){
                    case 422:
                        newModel=new pruebamodel();
                        newModel.code=String.valueOf(response.code());
                        mutable.setValue(newModel);
                        break;
                    case 201:
                        newModel= response.body();
                        if(newModel != null)
                        {
                            newModel.code= String.valueOf(response.code());
                        }
                        mutable.setValue(newModel);
                        break;
                }
            }

            @Override
            public void onFailure(Call<pruebamodel> call, Throwable t) {

            }
        });
        return mutable;
    }
}
