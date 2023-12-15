package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.adapters.CollarAdapter;
import com.example.pet_care.models.CollarModel;
import com.example.pet_care.models.DataModel;
import com.example.pet_care.view_models.collar_viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Profile_Dog extends AppCompatActivity {
    TextView pet_nom;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dog);

        pet_nom=findViewById(R.id.pet_nom);
        recycler=findViewById(R.id.recyclerView);

        Intent b=getIntent();
        String pet_name=b.getStringExtra("pet_name");

        pet_nom.setText(pet_name);

        List<DataModel> dataList=new ArrayList<>();

        ViewModelProvider provider=new ViewModelProvider(Profile_Dog.this);
        collar_viewmodel viewmodel=provider.get(collar_viewmodel.class);

        viewmodel.getData().observe(Profile_Dog.this, new Observer<CollarModel>() {
            @Override
            public void onChanged(CollarModel collarModel) {
                if(collarModel != null)
                {
                    switch (collarModel.code)
                    {
                        case "401":
                            Toast.makeText(Profile_Dog.this,"¡Error! No hay datos por mostrar",Toast.LENGTH_SHORT).show();
                            break;
                        case "200":
                            recycler.setAdapter(new CollarAdapter(collarModel.sensor_data));
                            recycler.setLayoutManager(new LinearLayoutManager(Profile_Dog.this));
                            recycler.setHasFixedSize(true);
                            break;
                    }
                }
            }
        });
    }
}