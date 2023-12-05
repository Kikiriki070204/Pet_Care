package com.example.pet_care.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.example.pet_care.R;
import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter  extends PagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public SlidePagerAdapter() {
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }

    @Override


    public

    int

    getCount()

    {
        return fragments.size();
    }

    @Override


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