package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pet_care.R;
import com.example.pet_care.models.BuzzerModel;
import com.example.pet_care.view_models.Buzzer_viewmodel;

public class Buzzer extends AppCompatActivity {

    Button btnOn, btnOff;
    public int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer);
        btnOn=findViewById(R.id.button);
        btnOff=findViewById(R.id.button2);

        btnOn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ViewModelProvider provider=new ViewModelProvider(Buzzer.this);
                Buzzer_viewmodel buzzer_viewmodel=provider.get(Buzzer_viewmodel.class);
                buzzer_viewmodel.Buzzer("1").observe(Buzzer.this, new Observer<BuzzerModel>() {
                    @Override
                    public void onChanged(BuzzerModel buzzerModel) {
                        switch (buzzerModel.getCode())
                        {
                            case "200":
                                Toast.makeText(Buzzer.this, "BUZZER ENCENDIDO ", Toast.LENGTH_SHORT).show();
                                break;
                            case "400":
                                Toast.makeText(Buzzer.this, "ERROR DE PETICION ", Toast.LENGTH_SHORT).show();
                                break;
                            case "401":
                                Toast.makeText(Buzzer.this, "ERROR DE AUTENTICACION ", Toast.LENGTH_SHORT).show();
                                break;
                            case "500":
                                Toast.makeText(Buzzer.this, "ERROR DEL SERVIDOR ", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        });
        btnOff.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ViewModelProvider provider=new ViewModelProvider(Buzzer.this);
                Buzzer_viewmodel buzzer_viewmodel=provider.get(Buzzer_viewmodel.class);
                buzzer_viewmodel.Buzzer("0").observe(Buzzer.this, new Observer<BuzzerModel>() {
                    @Override
                    public void onChanged(BuzzerModel buzzerModel) {
                        switch (buzzerModel.getCode())
                        {
                            case "200":
                                Toast.makeText(Buzzer.this, "BUZZER apagado ", Toast.LENGTH_SHORT).show();
                                break;
                            case "400":
                                Toast.makeText(Buzzer.this, "ERROR DE PETICION ", Toast.LENGTH_SHORT).show();
                                break;
                            case "401":
                                Toast.makeText(Buzzer.this, "ERROR DE AUTENTICACION ", Toast.LENGTH_SHORT).show();
                                break;
                            case "500":
                                Toast.makeText(Buzzer.this, "ERROR DEL SERVIDOR ", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        });
    }
}