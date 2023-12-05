package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;

import com.example.pet_care.R;
import com.example.pet_care.adapters.SlidePagerAdapter;

public class No_Log extends AppCompatActivity {
    private ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_log);
        viewPager = findViewById(R.id.vpStart);

        // Create the adapter
        SlidePagerAdapter adapter = new SlidePagerAdapter(this);

        // Set the adapter
        viewPager.setAdapter(adapter);

    }
}