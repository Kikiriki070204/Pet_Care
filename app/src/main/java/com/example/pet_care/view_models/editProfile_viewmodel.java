package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.EditProfileModel;
import com.example.pet_care.repository.EditProfileRepos;

public class editProfile_viewmodel extends ViewModel {
    private MutableLiveData<EditProfileModel> editProfileModel;
    private EditProfileRepos editProfileRepos;
    public LiveData<EditProfileModel> editProfile(String id,String passwordnew, String passwordConf){
        if(editProfileModel==null){
            editProfileModel=new MutableLiveData<>();
            EditProfile(id, passwordnew, passwordConf);
        }
        return editProfileModel;
    }
    private void EditProfile( String id, String passwordnew, String passwordConf){
        if(editProfileRepos==null){
            editProfileRepos=new EditProfileRepos();
        }
        editProfileModel=editProfileRepos.EditProfile(id,passwordnew, passwordConf);
    }
}
