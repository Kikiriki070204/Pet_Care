package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.BuzzerModel;
import com.example.pet_care.repository.BuzzerRepos;

public class Buzzer_viewmodel extends ViewModel {
    private MutableLiveData<BuzzerModel> buzzerModel;
    private BuzzerRepos buzzerRepos;

    public LiveData<BuzzerModel> Buzzer(String value)
    {
        if(buzzerModel==null)
        {
            buzzerModel=new MutableLiveData<>();
            MyBuzzer(value);
        }
        return buzzerModel;
    }

    private void MyBuzzer(String value)
    {
        if(buzzerRepos==null)
        {
            buzzerRepos=new BuzzerRepos();
        }
        buzzerModel=buzzerRepos.Buzzer(value);
    }

}
