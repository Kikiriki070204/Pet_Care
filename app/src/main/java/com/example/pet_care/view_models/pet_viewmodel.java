package com.example.pet_care.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pet_care.models.PetModel;
import com.example.pet_care.repository.PetRepos;

public class pet_viewmodel extends ViewModel {
    private MutableLiveData<PetModel> model;
    private PetRepos petRepos;

    public LiveData<PetModel> newPet(String nombre, String apellido, String id_collar, String id_usuario)
    {
        if(model==null)
        {
            model=new MutableLiveData<>();
            createPet(nombre, apellido, id_collar, id_usuario);
        }
        return model;
    }

    private void createPet(String nombre, String apellido,String id_collar, String id_usuario)
    {
        if(petRepos==null)
        {
            petRepos=new PetRepos();
        }
        model=petRepos.newPet(nombre, apellido,id_collar, id_usuario);
    }
}
