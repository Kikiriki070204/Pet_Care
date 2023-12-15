package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.HomeModel;
import com.example.pet_care.request.HomeRequest;
import com.example.pet_care.retrofit.request_1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeRepos {
    public Retrofit retrofit;
    void setRetrofit(){retrofit= request_1.getRetrofit();}

    public MutableLiveData<HomeModel> getHome(String id)
    {
        setRetrofit();
        HomeRequest homeRequest=retrofit.create(HomeRequest.class);
        Call<HomeModel> homeCall= homeRequest.getHome(id);
        MutableLiveData<HomeModel> mutable=new MutableLiveData<>();
        Log.d("HOME","homeee");

        homeCall.enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {
                Log.d("HOME","wcm");
                HomeModel homeModel;

                switch (response.code())
                {
                    case 404:
                        homeModel=new HomeModel();
                        homeModel.code=String.valueOf(response.code());
                        mutable.setValue(homeModel);
                        break;
                    case 200:
                        homeModel=response.body();
                        if(homeModel != null)
                        {
                            homeModel.pets=response.body().getPets();
                            homeModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(homeModel);
                        break;
                }

            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {

            }
        });
        return mutable;
    }
}
