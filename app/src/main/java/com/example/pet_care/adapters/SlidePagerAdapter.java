package com.example.pet_care.adapters;


import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.StatefulAdapter;

import com.example.pet_care.fragments.FragmentStar1;
import com.example.pet_care.fragments.FragmentStar2;
import com.example.pet_care.fragments.FragmentStar3;

import java.util.ArrayList;
import java.util.List;
public class SlidePagerAdapter extends FragmentStateAdapter {
    public SlidePagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentStar1();
            case 1:
                return new FragmentStar2();
            default:
                return new FragmentStar3();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Replace with the actual number of fragments
    }
}
