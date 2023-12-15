package com.example.pet_care.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.SwitchModel;
import com.example.pet_care.request.SwitchRequest;
import com.example.pet_care.retrofit.request_1;
import com.example.pet_care.views.Switch_buzzer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SwitchRepos {
    public Retrofit retrofit;

    void setRetrofit(){retrofit= request_1.getRetrofit();}
    public MutableLiveData<SwitchModel> Switchchange(String Switch)
    {
        setRetrofit();
        SwitchRequest switch_buzzer=retrofit.create(SwitchRequest.class);
        Call<SwitchModel> SwitchModelCall= switch_buzzer.Switchchange(Switch);
        MutableLiveData<SwitchModel> mutable=new MutableLiveData<>();
        SwitchModelCall.enqueue(new Callback<SwitchModel>() {
            @Override
            public void onResponse(Call<SwitchModel> call, Response<SwitchModel> response) {
                SwitchModel switchModel;
                switch(response.code()) {
                    case 422:
                    case 404:
                    case 400:
                        switchModel= new SwitchModel();
                        switchModel.code=String.valueOf(response.code());
                        mutable.setValue(switchModel);
                        break;
                    case 200:
                        switchModel=response.body();

                        if(switchModel != null)
                        {
                            switchModel.setSwitch(response.body().getSwitch());
                            switchModel.code=String.valueOf(response.code());
                        }
                        mutable.setValue(switchModel);
                        break;
                }

            }

            @Override
            public void onFailure(Call<SwitchModel> call, Throwable t) {

            }
        });

        return mutable;
    }

}
