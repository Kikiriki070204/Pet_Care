package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.SwitchModel;
import com.example.pet_care.view_models.Switch_viewmodel;

public class Switch_buzzer extends AppCompatActivity {

    Switch switch1;
    public int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_buzzer);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent a = getIntent();
        userId = a.getIntExtra("id", -1);
        String id = String.valueOf(userId);
        switch1 = findViewById(R.id.switch_buzzer);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                   ViewModelProvider viewModelProvider = new ViewModelProvider(Switch_buzzer.this);
                                                   Switch_viewmodel switch_viewmodel = viewModelProvider.get(Switch_viewmodel.class);
                                                   switch_viewmodel.switchchange(id).observe(Switch_buzzer.this, new Observer<SwitchModel>() {
                                                       @Override
                                                       public void onChanged(SwitchModel switchModel) {
                                                           if (switchModel != null && switchModel.code != null) {
                                                               switch (switchModel.code) {
                                                                   case "500":
                                                                   case "422":
                                                                   case "404":
                                                                       Toast.makeText(Switch_buzzer.this, "¡Error! Buzzer no recorido", Toast.LENGTH_SHORT).show();
                                                                       break;
                                                                   case "200":
                                                                       Toast.makeText(Switch_buzzer.this, "yea! works", Toast.LENGTH_SHORT).show();

                                                                       Intent i = new Intent(getApplicationContext(), Home.class);
                                                                       i.putExtra("id", userId);
                                                                       startActivity(i);
                                                                       break;
                                                               }
                                                           }
                                                       }
                                                   });
                                               }
                                           }
        );

    }
}