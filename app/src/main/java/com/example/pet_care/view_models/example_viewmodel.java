package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.pruebamodel;
import com.example.pet_care.repository.prueba_repos;

public class example_viewmodel extends ViewModel {
    private MutableLiveData<pruebamodel> model;
    private prueba_repos modelRepos;

    public LiveData<pruebamodel> postModel(String nombre, String apellidos, String email, String password){
        if(model==null)
        {
            model= new MutableLiveData<>();
            createModel(nombre, apellidos, email, password);
        }
        return model;
    }
    private void createModel(String nombre, String apellidos, String email, String password){
        if (modelRepos==null){
            modelRepos=new prueba_repos();
        }
        model=modelRepos.postModel(nombre, apellidos, email, password);
    }
}
