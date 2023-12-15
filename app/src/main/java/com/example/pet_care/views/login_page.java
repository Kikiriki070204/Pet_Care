package com.example.pet_care.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.LoginModel;
import com.example.pet_care.view_models.login_viewmodel;

public class login_page extends AppCompatActivity {
EditText email, password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        email=findViewById(R.id.etMail);
        password=findViewById(R.id.etPassword);
        login=findViewById(R.id.log);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewModelProvider viewModelProvider= new ViewModelProvider(login_page.this);
                login_viewmodel loginviewmodel=viewModelProvider.get(login_viewmodel.class);
                loginviewmodel.Login(email.getText().toString(),password.getText().toString()).observe(login_page.this, new Observer<LoginModel>() {
                    @Override
                    public void onChanged(LoginModel loginModel) {
                        if(loginModel != null && loginModel.code !=null)
                        {
                            switch (loginModel.code)
                            {
                                case "500":
                                case "401":
                                case "400":
                                    Toast.makeText(login_page.this, "¡Error! Contraseña o correo no son correctos", Toast.LENGTH_SHORT).show();
                                    loginviewmodel.Login(email.getText().toString(),password.getText().toString()).observe(login_page.this, new Observer<LoginModel>() {
                                        @Override
                                        public void onChanged(LoginModel loginModel) {

                                        }
                                    });
                                    break;
                                case "201":
                                   Intent i=new Intent(getApplicationContext(), Home.class);
                                   i.putExtra("id",loginModel.id_usuario);
                                   i.putExtra("nombre",loginModel.nombre);
                                    startActivity(i);
                                    break;
                            }
                        }

                    }
                });
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
            startActivity(new Intent(login_page.this,Perfil_user.class));
        }
        else if(id==R.id.log_out)
        {
            startActivity(new Intent(login_page.this, Reg.class));
        }
        else if (id==R.id.home)
        {
            startActivity(new Intent(login_page.this, Home.class));
        }
        return true;
    }
}