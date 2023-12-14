package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.EditProfileModel;
import com.example.pet_care.view_models.editProfile_viewmodel;

public class Editar_password extends AppCompatActivity {

    EditText passwordnew, passwordConf;
    Button btnEdit, btnBack;
    public int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_password);
        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        passwordnew=findViewById(R.id.etpasswordnew);
        passwordConf=findViewById(R.id.etpasswordconf);
        btnEdit=findViewById(R.id.edit);
        btnBack=findViewById(R.id.return_home);
        Intent a=getIntent();
        userId=a.getIntExtra("id",-1);
        String id=String.valueOf(userId);

        btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick (View v){
            ViewModelProvider viewModelProvider= new ViewModelProvider(Editar_password.this);
            editProfile_viewmodel editProfileviewmodel=viewModelProvider.get(editProfile_viewmodel.class);
            editProfileviewmodel.editProfile(id,passwordnew.getText().toString(),passwordConf.getText().toString()).observe(Editar_password.this, new Observer<EditProfileModel>() {
                @Override
                public void onChanged(EditProfileModel editProfileModel) {
                    if(editProfileModel != null && editProfileModel.code !=null)
                    {
                        switch (editProfileModel.code)
                        {
                            case "500":
                            case "422":
                            case "404":
                                Toast.makeText(Editar_password.this, "¡Error! Contraseña o correo no son correctos", Toast.LENGTH_SHORT).show();
                                break;
                            case "200":
                                Toast.makeText(Editar_password.this, "¡Error! Contraseña o correo no son correctos", Toast.LENGTH_SHORT).show();

                                Intent i=new Intent(getApplicationContext(), Home.class);
                               i.putExtra("id",editProfileModel.id);
                                startActivity(i);

                                break;
                        }
                    }

                }
                });
                }
                });

        }
}