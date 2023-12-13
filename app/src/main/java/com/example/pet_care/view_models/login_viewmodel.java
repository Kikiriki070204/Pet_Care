package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.LoginModel;
import com.example.pet_care.repository.LoginRepos;

public class login_viewmodel extends ViewModel {
private MutableLiveData<LoginModel> loginModel;

private LoginRepos loginRepos;

public LiveData<LoginModel> Login(String email, String password)
{
    if(loginModel==null)
    {
        loginModel=new MutableLiveData<>();
        LogIn(email, password);
    }
    return loginModel;
}

private void LogIn(String email, String password)
{
    if(loginRepos==null)
    {
        loginRepos=new LoginRepos();
    }
    loginModel=loginRepos.Login(email, password);
}
}
