package com.example.pet_care.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.example.pet_care.R;
import com.example.pet_care.fragments.FragmentStar1;
import com.example.pet_care.fragments.FragmentStar2;
import com.example.pet_care.fragments.FragmentStar3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidePagerAdapter  extends RecyclerView.Adapter {
    private final List<String> titles = Arrays.asList("Tab 1", "Tab 2", "Tab 3");

    public SlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentStar1.newInstance(titles.get(position));
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}