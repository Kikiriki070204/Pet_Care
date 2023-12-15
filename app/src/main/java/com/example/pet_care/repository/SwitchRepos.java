package com.example.pet_care.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.BuzzerModel;
import com.example.pet_care.request.SwitchRequest;
import com.example.pet_care.retrofit.request_1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SwitchRepos {
    public Retrofit retrofit;

    void setRetrofit(){retrofit= request_1.getRetrofit();}
    public MutableLiveData<BuzzerModel> Switchchange(String Switch)
    {
        setRetrofit();
        SwitchRequest switch_buzzer=retrofit.create(SwitchRequest.class);
        Call<BuzzerModel> SwitchModelCall= switch_buzzer.Switchchange(Switch);
        MutableLiveData<BuzzerModel> mutable=new MutableLiveData<>();
        SwitchModelCall.enqueue(new Callback<BuzzerModel>() {
            @Override
            public void onResponse(Call<BuzzerModel> call, Response<BuzzerModel> response) {
                BuzzerModel switchModel;
                switch(response.code()) {
                    case 422:
                    case 404:
                    case 400:
                        switchModel= new BuzzerModel();
                        switchModel.code=String.valueOf(response.code());
                        mutable.setValue(switchModel);
                        break;
                    case 200:
                        switchModel=response.body();

                        if(switchModel != null)
                        {
                            switchModel.setValue(response.body().getValue());
                            switchModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(switchModel);
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
