package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.HomeModel;
import com.example.pet_care.repository.HomeRepos;

public class home_viewmodel extends ViewModel {
    private MutableLiveData<HomeModel> homeModel;
    private HomeRepos homeRepos;

    public LiveData<HomeModel> getHome(String id) {
        if (homeModel == null) {
        homeModel=new MutableLiveData<>();
        myHome(id);
        }
        return homeModel;
    }

    private void myHome(String id)
    {
        if(homeRepos==null){
            homeRepos=new HomeRepos();
        }
        homeModel=homeRepos.getHome(id);
    }
}

