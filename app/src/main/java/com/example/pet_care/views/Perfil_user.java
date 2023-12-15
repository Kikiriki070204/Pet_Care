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
import android.widget.EditText;
import android.widget.TextView;

import com.example.pet_care.R;
import com.example.pet_care.view_models.profile_viewmodel;

public class Perfil_user extends AppCompatActivity {
TextView name,surname,email;
EditText password;
String passcheck;
Button edit,return_home;
public  String nombre;
 public  int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Intent a=getIntent();
        userId=a.getIntExtra("id",-1);
        String id=String.valueOf(userId);
        nombre=a.getStringExtra("nombre");
        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        edit=findViewById(R.id.edit);
        return_home=findViewById(R.id.return_home);
        return_home.setOnClickListener(v -> {
            Intent o=new Intent(Perfil_user.this,Home.class);
            o.putExtra("id",userId);
            o.putExtra("nombre",nombre);
            startActivity(o);
        });



        ViewModelProvider viewModel=new ViewModelProvider(this);
        profile_viewmodel profileViewModel=viewModel.get(profile_viewmodel.class);
        profileViewModel.getProfile(id).observe(this, profileModel -> {
            if(profileModel != null && profileModel.code !=null)
            {
                switch (profileModel.code)
                {
                    case "200":
                        name.setText(profileModel.getNombre());
                        surname.setText(profileModel.getApellidos());
                        email.setText(profileModel.getEmail());
                        passcheck=profileModel.getPassword();
                        break;
                    case "404":
                        name.setText("No se encontro el usuario");
                        break;
                }
            }
        });

        edit.setOnClickListener(v -> {

            if(password.getText().toString().equals(passcheck))
            {
                Intent o=new Intent(Perfil_user.this,Editar_password.class);
                o.putExtra("id",userId);
                startActivity(o);
            }
            else
            {
                password.setError("Contraseña incorrecta");
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
            startActivity(new Intent(Perfil_user.this,Perfil_user.class));
        }
        else if(id==R.id.log_out)
        {
            startActivity(new Intent(Perfil_user.this, Reg.class));
        }
        else if (id==R.id.home)
        {
            startActivity(new Intent(Perfil_user.this, Home.class));
            Intent g=new Intent(Perfil_user.this,Home.class);
            g.putExtra("id",userId);
            g.putExtra("nombre",nombre);
            startActivity(g);
        }
        return true;
    }
}