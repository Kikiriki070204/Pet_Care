package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pet_care.R;
import com.example.pet_care.adapters.SlidePagerAdapter;

public class No_Log extends AppCompatActivity  {
    private ViewPager2 viewPager;
    //private Intent intent = new Intent(this, login_page.class);
     private Button button ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_log);
        viewPager = findViewById(R.id.vpStart);
        button = findViewById(R.id.btnologinskip);

        // Create the adapter
        SlidePagerAdapter adapter = new SlidePagerAdapter(this);

        // Set the adapter
        viewPager.setAdapter(adapter);

        // Add a listener to the ViewPager
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Do something when the page scrolls
            }

            @Override
            public void onPageSelected(int position) {
                // Update the button position
                switch (position) {
                    case 0:
                    case 1:
                        button.setX(800);
                        button.setText("Skip");
                        break;
                    default:
                        button.setX(450);
                        button.setText("Inicia session");
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                // Do something when the page scroll state changes
            }
        });


    }




}