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

package com.example.sample3.fragment;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.sample3.MainActivity;
import com.example.sample3.R;
import com.example.sample3.adapter.pager.ChannelFragmentPagerAdapter;
import com.imbryk.viewPager.LoopViewPager;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener {

    private static final Handler handler = new Handler();
    private static final int CIRCLE_INDICATOR_SHOW_TIME = 1000;
    @Bind(R.id.pager)
    LoopViewPager mPager;
    @Bind(R.id.indicator)
    CirclePageIndicator mIndicator;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPager.setAdapter(new ChannelFragmentPagerAdapter(this.getFragmentManager()));
        mIndicator.setViewPager(mPager);
        mPager.setBoundaryCaching(true);
        mIndicator.setOnPageChangeListener(this);
        mPager.setOnTouchListener(this);
        handler.postDelayed(hideRunnable, 2 * CIRCLE_INDICATOR_SHOW_TIME);
        mIndicator.setCurrentItem(0);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) getView().getLayoutParams();
        MyBehavior behavior = (MyBehavior) lp.getBehavior();
        behavior.setLayout(mIndicator);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public MainActivityFragment() {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        handler.removeCallbacks(hideRunnable);
        handler.post(showRunnable);
    }

    @Override
    public void onPageSelected(final int position) {
        handler.postDelayed(hideRunnable, CIRCLE_INDICATOR_SHOW_TIME);
        ((MainActivity) getActivity()).setActionBarTitle(mPager.getAdapter().getPageTitle(position).toString());
        ((MainActivity) getActivity()).setHeaderImage(((ChannelFragmentPagerAdapter) mPager.getAdapter()).getPageHeaderImage(position));
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


}
