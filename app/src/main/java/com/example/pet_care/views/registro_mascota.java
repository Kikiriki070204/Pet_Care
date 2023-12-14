package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.PetModel;
import com.example.pet_care.view_models.pet_viewmodel;

public class registro_mascota extends AppCompatActivity {

    TextView pet_name, peso, pet_collar;
    Button start_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        Intent a=getIntent();
        int id= a.getIntExtra("id_user",-1);
        String id_user=String.valueOf(id);

        pet_name=findViewById(R.id.pet_name);
        peso=findViewById(R.id.peso);
        pet_collar=findViewById(R.id.pet_collar);
        start_up=findViewById(R.id.start_up);

        start_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewModelProvider provider= new ViewModelProvider(registro_mascota.this);
                pet_viewmodel petViewmodel=provider.get(pet_viewmodel.class);
                petViewmodel.newPet(pet_name.getText().toString(), peso.getText().toString(),pet_collar.getText().toString(),id_user).observe(registro_mascota.this, new Observer<PetModel>() {
                    @Override
                    public void onChanged(PetModel petModel) {
                        switch (petModel.code)
                        {
                            case "404":
                                Toast.makeText(registro_mascota.this, "¡Error! La clave del collar no existe o es errónea ", Toast.LENGTH_SHORT).show();
                                break;
                            case "422":
                                Toast.makeText(registro_mascota.this, "¡Error! Verifica tus datos", Toast.LENGTH_SHORT).show();
                                break;
                            case "201":
                                Toast.makeText(registro_mascota.this, "¡Macota registrada con éxito! ", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        });
    }
}