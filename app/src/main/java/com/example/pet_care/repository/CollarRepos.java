package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.pet_care.models.CollarModel;
import com.example.pet_care.request.CollarRequest;
import com.example.pet_care.retrofit.request_1;

import java.util.List;

public class CollarRepos {
    public Retrofit retrofit;
    void setRetrofit(){retrofit=request_1.getRetrofit();}

    public MutableLiveData<CollarModel> getData()
    {
        setRetrofit();
        CollarRequest collarRequest=retrofit.create(CollarRequest.class);
        Call<CollarModel> collarCall= collarRequest.getData();
        MutableLiveData<CollarModel> mutable= new MutableLiveData<>();
        Log.d("COLLAR","hey");

        collarCall.enqueue(new Callback<CollarModel>() {
            @Override
            public void onResponse(Call<CollarModel> call, Response<CollarModel> response) {
                CollarModel collarModel;
                Log.d("COLLAR","heeeey");

                switch (response.code())
                {
                    case 401:
                        collarModel= new CollarModel();
                        collarModel.code=String.valueOf(response.code());
                        mutable.setValue(collarModel);
                        break;
                    case 200:
                        collarModel= response.body();
                        if(collarModel !=null)
                        {
                            collarModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(collarModel);
                        break;
                }

            }

            @Override
            public void onFailure(Call<CollarModel> call, Throwable t) {

            }
        });
        return mutable;
    }
}
