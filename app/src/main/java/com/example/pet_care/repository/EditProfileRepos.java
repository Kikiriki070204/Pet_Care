package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.EditProfileModel;
import com.example.pet_care.request.EditProfileRequest;
import com.example.pet_care.retrofit.request_1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class EditProfileRepos {
    public Retrofit retrofit;
    void setRetrofit(){ retrofit= request_1.getRetrofit();}
    public MutableLiveData<EditProfileModel> EditProfile(String id ,String password, String passwordConf)
    {
        setRetrofit();
        EditProfileRequest editProfileRequest=retrofit.create(EditProfileRequest.class);
        Call<EditProfileModel> editProfileCall= editProfileRequest.EditProfile( id ,password, passwordConf);
        MutableLiveData<EditProfileModel> mutable=new MutableLiveData<>();
        Log.d("Liara", "Conectando");

        editProfileCall.enqueue(new Callback<EditProfileModel>() {
            @Override
            public void onResponse(Call<EditProfileModel> call, retrofit2.Response<EditProfileModel> response) {
                Log.d("Liara", "Confirmando..");
                EditProfileModel editProfileModel;

                switch(response.code()) {
                    case 422:
                    case 404:
                    case 401:
                        editProfileModel= new EditProfileModel();
                        editProfileModel.code=String.valueOf(response.code());
                        mutable.setValue(editProfileModel);
                        break;
                    case 200:
                        editProfileModel=response.body();

                        if(editProfileModel != null)
                        {
                            editProfileModel.setId(response.body().getId());
                            editProfileModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(editProfileModel);
                        break;
                }

            }

            @Override
            public void onFailure(Call<EditProfileModel> call, Throwable t) {

            }
        });

        return mutable;
    }

}
