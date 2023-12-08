package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.pruebamodel;
import com.example.pet_care.view_models.example_viewmodel;

public class regist_page extends AppCompatActivity implements View.OnClickListener{
    EditText name,last_name, email,password;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_page);

        name=findViewById(R.id.name);
        last_name=findViewById(R.id.last_name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        registrar=findViewById(R.id.registrar);


       registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            ViewModelProvider provider=new ViewModelProvider(this);
            example_viewmodel viewmodel=provider.get(example_viewmodel.class);
            viewmodel.postModel(name.getText().toString(),last_name.getText().toString(),email.getText().toString(),password.getText().toString()).observe(this, new Observer<pruebamodel>() {
                @Override
                public void onChanged(pruebamodel pruebamodel) {

                }
            });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}