package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.pet_care.R;
import com.example.pet_care.adapters.SlidePagerAdapter;

public class No_Log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_log);
        ViewPager2 pager = findViewById(R.id.vpStart);
        pager.setAdapter(new SlidePagerAdapter());

    }
}