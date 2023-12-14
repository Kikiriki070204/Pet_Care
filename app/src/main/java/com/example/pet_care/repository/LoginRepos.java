package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.pet_care.models.LoginModel;
import com.example.pet_care.models.pruebamodel;
import com.example.pet_care.request.LoginRequest;
import com.example.pet_care.retrofit.request_1;

public class LoginRepos {
    public Retrofit retrofit;
    void setRetrofit(){retrofit=request_1.getRetrofit();}

    public MutableLiveData<LoginModel> Login(String email, String password)
    {
        setRetrofit();
        LoginRequest loginRequest=retrofit.create(LoginRequest.class);
        Call<LoginModel> loginCall= loginRequest.Login(email, password);
        MutableLiveData<LoginModel> mutable=new MutableLiveData<>();
        Log.d("KIARA", "aaa");

        loginCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                Log.d("KIARA", "abba");
                LoginModel loginModel;

                switch(response.code()) {
                    case 500:
                    case 400:
                    case 401:
                        loginModel= new LoginModel();
                        loginModel.code=String.valueOf(response.code());
                        mutable.setValue(loginModel);
                       break;
                    case 201:
                        loginModel=response.body();

                        if(loginModel != null)
                        {
                            loginModel.setId(response.body().getId());
                            loginModel.setNombre(response.body().getNombre());
                            loginModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(loginModel);
                        break;
                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });
    return mutable;
    }
}
