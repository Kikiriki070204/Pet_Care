package com.example.pet_care.view_models;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pet_care.models.MapModel;
import com.example.pet_care.repository.MapRepos;
import com.example.pet_care.request.MapRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class map_viewmodel extends ViewModel {
    private MutableLiveData<Double> latitudeData = new MutableLiveData<>();
    private MutableLiveData<Double> longitudeData = new MutableLiveData<>();
    private MapRequest apiService;

    public map_viewmodel() {
        apiService = MapRepos.getRetrofitInstance().create(MapRequest.class);
        fetchLatitudeAndLongitude();
    }

    private void fetchLatitudeAndLongitude() {
        Call<Double> latitudeCall = apiService.getLatitude();
        latitudeCall.enqueue(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                if (response.isSuccessful() && response.body() != null) {
                    latitudeData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {
            }
        });

        Call<Double> longitudeCall = apiService.getLongitude();
        longitudeCall.enqueue(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                if (response.isSuccessful() && response.body() != null) {
                    longitudeData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {

            }
        });
    }

    public LiveData<Double> getLatitudeData() {
        return latitudeData;
    }

    public LiveData<Double> getLongitudeData() {
        return longitudeData;
    }
}

