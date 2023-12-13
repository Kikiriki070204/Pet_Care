package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pet_care.R;

public class registro_mascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        Intent a=getIntent();
        int id= a.getIntExtra("id_user",-1);
        String id_user=String.valueOf(id);


    }
}