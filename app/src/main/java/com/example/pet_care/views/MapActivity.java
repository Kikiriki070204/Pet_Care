package com.example.pet_care.views;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.pet_care.R;
import com.example.pet_care.view_models.map_viewmodel;
import com.example.pet_care.views.fragments.MapFragment;

public class MapActivity extends AppCompatActivity {

    private map_viewmodel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_map);

        viewModel = new ViewModelProvider(this).get(map_viewmodel.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new MapFragment())
                    .commit();
        }
    }
}
