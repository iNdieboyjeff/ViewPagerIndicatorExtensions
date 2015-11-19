package com.example.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jeff on 19/11/2015.
 */
public class ExampleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    @Override
    public Fragment getItem(int position) {
        return ExampleFragment1.newInstance("","");
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
    }
}
