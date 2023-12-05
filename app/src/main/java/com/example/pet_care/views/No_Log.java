package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.pet_care.R;
import com.example.pet_care.adapters.SlidePagerAdapter;

public class No_Log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_log);
        ViewPager2 viewPager = findViewById(R.id.vpStart);

// Configura el adaptador del ViewPager2
        viewPager.setAdapter(new SlidePagerAdapter());

// Configura la animación del deslizamiento
        viewPager.setCurrentItem(1);
    }
}