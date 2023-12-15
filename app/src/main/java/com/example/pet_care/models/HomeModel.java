package com.example.pet_care.models;

import java.util.List;

public class HomeModel {
    public String code;
    public List<Pet> pets;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
