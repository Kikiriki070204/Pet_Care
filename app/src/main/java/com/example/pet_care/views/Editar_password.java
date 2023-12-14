package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pet_care.R;

public class Editar_password extends AppCompatActivity {

    EditText passwordnew, passwordConf;
    Button btnEdit, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_password);

    }
}