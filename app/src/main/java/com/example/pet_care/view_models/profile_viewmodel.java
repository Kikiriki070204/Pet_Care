package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.ProfileModel;
import com.example.pet_care.repository.ProfileRepos;

public class profile_viewmodel extends ViewModel {
    private MutableLiveData<ProfileModel> profileModel;

    private ProfileRepos profileRepos;

    public LiveData<ProfileModel> getProfile(String id) {
        if (profileModel == null) {
        profileModel=new MutableLiveData<>();
        myProfile(id);
        }
        return profileModel;
    }
    private void myProfile(String id)
    {
        if(profileRepos==null){
            profileRepos= new ProfileRepos();
        }
        profileModel=profileRepos.getProfile(id);
    }
}
