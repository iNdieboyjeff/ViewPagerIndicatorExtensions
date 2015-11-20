/*
 *  Copyright (c) 2015 Jeff Sutton
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.sample3;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.imbryk.viewPager.LoopViewPager;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener {

    private LoopViewPager mPager;
    private CirclePageIndicator mIndicator;

    private static final Handler handler = new Handler();

    private static final int CIRCLE_INDICATOR_SHOW_TIME = 1000;


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
        mIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        mPager.setAdapter(new ExampleFragmentPagerAdapter(this.getFragmentManager()));
        mIndicator.setViewPager(mPager);
        mPager.setBoundaryCaching(true);
        mIndicator.setOnPageChangeListener(this);
        mPager.setOnTouchListener(this);
        handler.postDelayed(hideRunnable, 2 * CIRCLE_INDICATOR_SHOW_TIME);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        handler.removeCallbacks(hideRunnable);
        handler.post(showRunnable);
    }

    @Override
    public void onPageSelected(int position) {
        handler.postDelayed(hideRunnable, CIRCLE_INDICATOR_SHOW_TIME);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        handler.removeCallbacks(hideRunnable);
        handler.post(showRunnable);
        return false;
    }

    private final Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            mIndicator.setAnimation(AnimationUtils
                    .loadAnimation(getContext(),
                            android.R.anim.fade_out));
            mIndicator.setVisibility(View.GONE);
        }
    };

    private final Runnable showRunnable = new Runnable() {
        @Override
        public void run() {
            handler.removeCallbacks(hideRunnable);
            if (mIndicator.getVisibility() == View.GONE) {
                mIndicator.setAnimation(AnimationUtils
                        .loadAnimation(getContext(),
                                android.R.anim.fade_in));
                mIndicator.setVisibility(View.VISIBLE);
            }
            handler.postDelayed(hideRunnable, CIRCLE_INDICATOR_SHOW_TIME);
        }
    };
}
