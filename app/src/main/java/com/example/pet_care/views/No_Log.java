package com.example.pet_care.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.view.View.OnClickListener;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pet_care.R;
import com.example.pet_care.adapters.SlidePagerAdapter;

public class No_Log extends AppCompatActivity implements  View.OnClickListener {
    private ViewPager2 viewPager;
    Intent intent = new Intent(this, login_page.class);
    Button button = findViewById(R.id.btNologinSkip);


    @Override
    public void onClick(View v) {
        button.setOnClickListener(this);
        if (v.getId() == R.id.btNologinSkip) {
            // Handle button click logic
            if (currentFrame == totalFrames) {
                button.setText("Iniciar sesión");
            }
            startActivity(new Intent(this, TargetActivity.class));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_log);
        viewPager = findViewById(R.id.vpStart);

        // Create the adapter
        SlidePagerAdapter adapter = new SlidePagerAdapter(this);

        // Set the adapter
        viewPager.setAdapter(adapter);

        // Add a listener to the ViewPager
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position)
            {
                // Update the button position
                switch (position) {
                    case 0:
                        button.setX(0);
                        break;
                    case 1:
                        button.setX(100);
                        break;
                    default:
                        button.setX(200);
                        break;
                }
            }
        });

    }

}