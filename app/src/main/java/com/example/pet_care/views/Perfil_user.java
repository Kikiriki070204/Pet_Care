package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.pet_care.R;

public class Perfil_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Intent a=getIntent();
        int userId=a.getIntExtra("id",-1);
        String id=String.valueOf(userId);
    }
}