package com.example.pet_care.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.adapters.CollarAdapter;
import com.example.pet_care.models.CollarModel;
import com.example.pet_care.models.DataModel;
import com.example.pet_care.models.PetModel;
import com.example.pet_care.view_models.collar_viewmodel;

import java.util.ArrayList;
import java.util.List;

public class PerfilDog extends AppCompatActivity {

    TextView pet_nom;

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_dog);
        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pet_nom=findViewById(R.id.pet_nom);
        recycler=findViewById(R.id.recyclerView);

        List<DataModel> dataList=new ArrayList<>();

        ViewModelProvider provider= new ViewModelProvider(PerfilDog.this);
        collar_viewmodel viewmodel=provider.get(collar_viewmodel.class);
        viewmodel.getData().observe(PerfilDog.this, new Observer<CollarModel>() {
            @Override
            public void onChanged(CollarModel collarModel) {
                if(collarModel != null)
                {
                    switch (collarModel.code)
                    {
                        case "401":
                            Toast.makeText(PerfilDog.this,"¡Error! No hay datos por mostrar",Toast.LENGTH_SHORT).show();
                            break;
                        case "200":
                            recycler.setAdapter(new CollarAdapter(collarModel.sensor_data));
                            recycler.setLayoutManager(new LinearLayoutManager(PerfilDog.this));
                            recycler.setHasFixedSize(true);
                            break;
                    }
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.item1)
        {
            startActivity(new Intent(PerfilDog.this,Perfil_user.class));
        }
        else if(id==R.id.log_out)
        {
            startActivity(new Intent(PerfilDog.this, Reg.class));
        }
        else if (id==R.id.home)
        {
            startActivity(new Intent(PerfilDog.this, Home.class));
        }
        return true;
    }
    private void getRecycler()
    {

    }
}