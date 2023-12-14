package com.example.pet_care.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollarModel {

    public String code;

    @SerializedName("sensor_data")
    public List<DataModel> sensor_data;

    public List<DataModel> getSensor_data() {
        return sensor_data;
    }

    public void setSensor_data(List<DataModel> sensor_data) {
        this.sensor_data = sensor_data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
