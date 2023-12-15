package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.pruebamodel;
import com.example.pet_care.repository.prueba_repos;
import com.example.pet_care.view_models.example_viewmodel;

public class regist_page extends AppCompatActivity {
    EditText name,last_name, email,password, password_conf;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_page);

        name=findViewById(R.id.name);
        last_name=findViewById(R.id.last_name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        password_conf=findViewById(R.id.password_conf);
        registrar=findViewById(R.id.registrar);

       registrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ViewModelProvider provider=new ViewModelProvider(regist_page.this);
               example_viewmodel viewmodel=provider.get(example_viewmodel.class);
               viewmodel.postModel(name.getText().toString(),last_name.getText().toString(),
                       email.getText().toString(),password.getText().toString(),password_conf.getText().toString()).observe(regist_page.this, new Observer<pruebamodel>() {
                   @Override
                   public void onChanged(pruebamodel pruebamodel) {
                       if (pruebamodel != null && pruebamodel.code != null) {
                           switch (pruebamodel.code) {
                               case "409":
                                   Toast.makeText(regist_page.this, "¡Error! Este correo ya está siendo utilizado ", Toast.LENGTH_SHORT).show();
                                   name.getText().clear();
                                   last_name.getText().clear();
                                   email.getText().clear();
                                   password.getText().clear();
                                   password_conf.getText().clear();
                                   break;
                               case "422":
                                   Toast.makeText(regist_page.this, "¡Error! Verifica tus datos", Toast.LENGTH_SHORT).show();
                                   name.getText().clear();
                                   last_name.getText().clear();
                                   email.getText().clear();
                                   password.getText().clear();
                                   password_conf.getText().clear();
                                   break;
                               case "201":
                                   startActivity(new Intent(regist_page.this, login_page.class));
                                   break;
                           }
                       }
                       else
                       {

                       }
                   }
               });
           }
       });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}