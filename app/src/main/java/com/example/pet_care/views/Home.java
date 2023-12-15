package com.example.pet_care.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pet_care.R;
import com.example.pet_care.adapters.MyPetsAdapter;
import com.example.pet_care.listeners.PetListener;
import com.example.pet_care.models.HomeModel;
import com.example.pet_care.models.Pet;
import com.example.pet_care.view_models.home_viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements PetListener {
TextView nombre_user,hey;
ImageView add;
RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombre_user=findViewById(R.id.Nombre);
        hey=findViewById(R.id.hey);
        recycler=findViewById(R.id.recyclerView);
        add=findViewById(R.id.add_btn);
        Intent a=getIntent();
        String nombre_us=a.getStringExtra("nombre");
        int userId=a.getIntExtra("id",-1);
        String id_usuario=String.valueOf(userId);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(Home.this,registro_mascota.class);
                o.putExtra("id_user",userId);
                o.putExtra("nombre",nombre_us);

                startActivity(o);
            }
        });

        nombre_user.setText(nombre_us);

        List<Pet> petList=new ArrayList<>();

        ViewModelProvider viewModel=new ViewModelProvider(this);
        home_viewmodel homeViewModel=viewModel.get(home_viewmodel.class);
        homeViewModel.getHome(id_usuario).observe(this, new Observer<HomeModel>() {
            @Override
            public void onChanged(HomeModel homeModel) {
                if(homeModel != null && homeModel.code !=null)
                {
                    switch (homeModel.code)
                    {
                        case "401":
                            hey.setText("¡Aún no tienes mascotas registradas!");

                            break;
                        case "200":
                            if(homeModel.pets!=null) {

                                recycler.setAdapter(new MyPetsAdapter(homeModel.pets,Home.this));
                                recycler.setLayoutManager(new LinearLayoutManager(Home.this));
                                recycler.setHasFixedSize(true);
                            }
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
            startActivity(new Intent(Home.this, Perfil_user.class));
        }
        else if(id==R.id.log_out)
        {
            startActivity(new Intent(Home.this, Reg.class));
        }
        return true;
    }

    @Override
    public void onClick(Pet pet) {
        Intent x=new Intent(Home.this,Profile_Dog.class);
        x.putExtra("pet_name",pet.nombre);
        x.putExtra("id_masc",pet.id_mascota);
        startActivity(x);
    }
}