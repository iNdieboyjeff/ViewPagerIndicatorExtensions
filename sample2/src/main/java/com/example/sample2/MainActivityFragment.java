package com.example.sample2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imbryk.viewPager.LoopViewPager;

import util.android.viewpagerindicator.FontableTabPageIndicator;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    LoopViewPager mPager;
    FontableTabPageIndicator mIndicator;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPager = (LoopViewPager) view.findViewById(R.id.pager);
        mIndicator = (FontableTabPageIndicator) view.findViewById(R.id.indicator);
        mPager.setAdapter(new ExampleFragmentPagerAdapter(this.getFragmentManager()));
        mIndicator.setViewPager(mPager);
        mPager.setBoundaryCaching(true);
    }
}
