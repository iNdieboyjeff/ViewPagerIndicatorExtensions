package com.example.sample2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.imbryk.viewPager.LoopViewPager;

import java.util.ArrayList;

/**
 * Created by jeff on 19/11/2015.
 */
public class ExampleFragmentPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<ExampleFragment1> mItems = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    public ExampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mItems.add(ExampleFragment1.newInstance(String.valueOf(2), ""));
        mItems.add(ExampleFragment1.newInstance(String.valueOf(0), ""));
        mItems.add(ExampleFragment1.newInstance(String.valueOf(1), ""));
        mItems.add(ExampleFragment1.newInstance(String.valueOf(2), ""));
        mItems.add(ExampleFragment1.newInstance(String.valueOf(0), ""));
    }
}
