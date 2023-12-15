package com.example.pet_care.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.pet_care.R;
import com.example.pet_care.view_models.map_viewmodel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private map_viewmodel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragmentmap, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(map_viewmodel.class);
        observeLatitudeAndLongitude();
    }

    private void observeLatitudeAndLongitude() {
        viewModel.getLatitudeData().observe(getViewLifecycleOwner(), latitude -> {
            // Actualizar el marcador con la nueva latitud
            updateMapMarker(latitude, viewModel.getLongitudeData().getValue());
        });

        viewModel.getLongitudeData().observe(getViewLifecycleOwner(), longitude -> {
            // Actualizar el marcador con la nueva longitud
            updateMapMarker(viewModel.getLatitudeData().getValue(), longitude);
        });
    }

    private void updateMapMarker(Double latitude, Double longitude) {
        if (googleMap != null) {
            // Limpiar el mapa antes de agregar el nuevo marcador
            googleMap.clear();

            // Crear un objeto LatLng con las nuevas coordenadas
            LatLng newLatLng = new LatLng(latitude, longitude);

            // Agregar un marcador al mapa con las nuevas coordenadas
            googleMap.addMarker(new MarkerOptions().position(newLatLng).title("Nuevo Marcador"));

            // Mover la cámara a las nuevas coordenadas
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(newLatLng));
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        // Configurar el mapa aquí si es necesario
    }
}
