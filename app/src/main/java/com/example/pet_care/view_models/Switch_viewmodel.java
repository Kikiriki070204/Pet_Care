package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.SwitchModel;
import com.example.pet_care.repository.SwitchRepos;

public class Switch_viewmodel {
    private MutableLiveData<SwitchModel> switchModel;
    private SwitchRepos switchRepos;
    public LiveData<SwitchModel> switchchange(String Switch){
        if(switchModel==null){
            switchModel=new MutableLiveData<>();
            Switchchange(Switch);
        }
        return switchModel;
    }
    private void Switchchange(String Switch){
        if(switchRepos==null){
            switchRepos=new SwitchRepos();
        }
        switchModel=switchRepos.Switchchange(Switch);
    }
}
