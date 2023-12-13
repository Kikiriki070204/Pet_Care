package com.example.pet_care.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.pet_care.R;
import com.example.pet_care.view_models.profile_viewmodel;

public class Perfil_user extends AppCompatActivity {
TextView name,surname,email,password;
Button edit,Safe;
String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Intent a=getIntent();
        int userId=a.getIntExtra("id",-1);
        String id=String.valueOf(userId);
        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        edit=findViewById(R.id.edit);
        Safe=findViewById(R.id.safe);


        ViewModelProvider viewModel=new ViewModelProvider(this);
        profile_viewmodel profileViewModel=viewModel.get(profile_viewmodel.class);
        profileViewModel.getProfile(id).observe(this, profileModel -> {
            if(profileModel != null && profileModel.code !=null)
            {
                switch (profileModel.code)
                {
                    case "200":
                        name.setText(profileModel.getName());
                        surname.setText(profileModel.getSurname());
                        email.setText(profileModel.getEmail());
                        password.setText(profileModel.getPassword());
                        break;
                    case "404":
                        name.setText("No se encontro el usuario");
                        break;
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
            Intent p=(new Intent(this, Perfil_user.class));
            p.putExtra("userid",userId);
            startActivity(p);
        }
        else if(id==R.id.log_out)
        {
            startActivity(new Intent(this, Reg.class));
        } else if (id == R.id.home) {
            Intent p=(new Intent(this, Home.class));
            p.putExtra("userid",userId);
            startActivity(p);

        }
        return true;
    }
}