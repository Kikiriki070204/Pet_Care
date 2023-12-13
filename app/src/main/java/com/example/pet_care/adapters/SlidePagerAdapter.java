package com.example.pet_care.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.pet_care.views.fragments.FragmentStar1;
import com.example.pet_care.views.fragments.FragmentStar2;
import com.example.pet_care.views.fragments.FragmentStar3;

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
