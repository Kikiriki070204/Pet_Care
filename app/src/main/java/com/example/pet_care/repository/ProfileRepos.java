package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.pet_care.models.ProfileModel;
import com.example.pet_care.request.ProfileRequest;
import  com.example.pet_care.retrofit.request_1;
public class ProfileRepos {
    public Retrofit retrofit;
    void setRetrofit(){
        retrofit= request_1.getRetrofit();
    }
    public MutableLiveData<ProfileModel> getProfile(String id)
    {
        setRetrofit();
        ProfileRequest profileRequest=retrofit.create(ProfileRequest.class);
        Call<ProfileModel> profileModelCall = profileRequest.getProfile(id);

        MutableLiveData<ProfileModel> mutable=new MutableLiveData<>();
        Log.d("Profile","ProfileHome");
        profileModelCall.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                ProfileModel profileModel;
                switch (response.code())
                {
                    case 404:
                        profileModel=new ProfileModel();
                        profileModel.code=String.valueOf(response.code());
                        mutable.setValue(profileModel);
                        break;
                    case 200:
                        profileModel=response.body();
                        if(profileModel != null)
                        {
                            profileModel.setName(response.body().getName());
                            profileModel.setSurname(response.body().getSurname());
                            profileModel.setEmail(response.body().getEmail());
                            profileModel.setPassword(response.body().getPassword());
                            profileModel.setPasswordConf(response.body().getPasswordConf());
                            profileModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(profileModel);
                        break;
                }
            }
            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
            }
        });

        return mutable;
    }
}
