package com.example.pet_care.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.BuzzerModel;
import com.example.pet_care.request.SwitchRequest;
import com.example.pet_care.retrofit.request_1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BuzzerRepos {
    public Retrofit retrofit;
    void setRetrofit(){retrofit = request_1.getRetrofit();}
    public MutableLiveData<BuzzerModel> Buzzer(String value)
    {
        setRetrofit();
        SwitchRequest switchRequest=retrofit.create(SwitchRequest.class);
        Call<BuzzerModel> buzzerCall= switchRequest.Switchchange(value);
        MutableLiveData<BuzzerModel> mutable=new MutableLiveData<>();
        Log.d("KIARA", "aaa");
        buzzerCall.enqueue(new Callback<BuzzerModel>() {
            @Override
            public void onResponse(Call<BuzzerModel> call, Response<BuzzerModel> response) {
                Log.d("KIARA", "abba");
                BuzzerModel buzzerModel;

                switch(response.code()) {
                    case 500:
                    case 400:
                    case 401:
                        buzzerModel= new BuzzerModel();
                        buzzerModel.code=String.valueOf(response.code());
                        mutable.setValue(buzzerModel);
                        break;
                    case 200:
                        buzzerModel=response.body();

                        if(buzzerModel != null)
                        {
                            buzzerModel.setCode(response.body().getCode());
                            buzzerModel.setValue(response.body().getValue());
                            buzzerModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(buzzerModel);
                        break;
                }
            }

            @Override
            public void onFailure(Call<BuzzerModel> call, Throwable t) {

            }
        });
        return mutable;
    }
}
