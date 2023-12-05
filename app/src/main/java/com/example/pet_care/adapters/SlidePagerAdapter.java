package com.example.pet_care.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.example.pet_care.R;
import com.example.pet_care.fragments.FragmentStar1;
import com.example.pet_care.fragments.FragmentStar2;
import com.example.pet_care.fragments.FragmentStar3;

import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter  extends PagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public SlidePagerAdapter() {
        fragments.add(new FragmentStar1());
        fragments.add(new FragmentStar2());
        fragments.add(new FragmentStar3());
    }

    @Override


    public

    int

    getCount()

    {
        return fragments.size();
    }
    public Fragment getItem(int

                                    position)

    {
        return fragments.get(position);
    }

    @Override


    public

    void

    destroyItem(ViewGroup container, int position, Object object)

    {
        container.removeView((View) object);
    }

    @Override


    public

    boolean

    isViewFromObject(View view, Object object)

    {
        return view == object;
    }
}