package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.pruebamodel;
import com.example.pet_care.repository.prueba_repos;

public class example_viewmodel extends ViewModel {
    private MutableLiveData<pruebamodel> model;
    private prueba_repos modelRepos;

    public LiveData<pruebamodel> postModel(String nombre, String apellidos, String email,
                                           String password, String password_confirmation){
        if(model==null)
        {
            model= new MutableLiveData<>();
            createModel(nombre, apellidos, email, password, password_confirmation);
        }
        return model;
    }
    private void createModel(String nombre, String apellidos, String email, String password, String password_confirmation){
        if (modelRepos==null){
            modelRepos=new prueba_repos();
        }
        model=modelRepos.postModel(nombre, apellidos, email, password, password_confirmation);
    }
    public void clearError() {
        if (model != null && model.getValue() != null) {
            pruebamodel newModel=model.getValue();
            newModel.code = null;
            model.setValue(newModel);
        }
    }
}
