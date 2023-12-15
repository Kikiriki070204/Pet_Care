package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.CollarModel;
import com.example.pet_care.repository.CollarRepos;
import com.example.pet_care.request.CollarRequest;

public class collar_viewmodel extends ViewModel {
    private MutableLiveData<CollarModel> model;
    private CollarRepos collarRepos;

    public LiveData<CollarModel> getData()
    {
        if(model==null)
        {
            model=new MutableLiveData<>();
            Data();
        }
        return model;
    }

    private void Data()
    {
        if(collarRepos == null){
            collarRepos=new CollarRepos();
        }
        model=collarRepos.getData();
    }
}
