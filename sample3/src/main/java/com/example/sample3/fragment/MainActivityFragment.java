/*
 *  Copyright (c) 2015-2016 Jeff Sutton
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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.sample3.R;
import com.example.sample3.activity.MainActivity;
import com.example.sample3.activity.PlayerActivity;
import com.example.sample3.adapter.pager.ChannelFragmentPagerAdapter;
import com.example.sample3.event.PlayChannelEvent;
import com.example.sample3.event.ScheduleLoadedEvent;
import com.example.sample3.manager.ScheduleManager;
import com.google.android.exoplayer.util.Util;
import com.viewpagerindicator.CirclePageIndicator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener {

    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    private static final Handler handler = new Handler();
    private static final int CIRCLE_INDICATOR_SHOW_TIME = 1000;
    private final Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            if (getIndicator() == null) return;
            getIndicator().setAnimation(AnimationUtils
                    .loadAnimation(getContext(),
                            android.R.anim.fade_out));
            getIndicator().setVisibility(View.GONE);
        }
    };
    private final Runnable showRunnable = new Runnable() {
        @Override
        public void run() {
            handler.removeCallbacks(hideRunnable);
            if (getIndicator() == null) return;
            if (getIndicator().getVisibility() == View.GONE) {
                getIndicator().setAnimation(AnimationUtils
                        .loadAnimation(getContext(),
                                android.R.anim.fade_in));
                getIndicator().setVisibility(View.VISIBLE);
            }
            handler.postDelayed(hideRunnable, CIRCLE_INDICATOR_SHOW_TIME);
        }
    };
    @BindView(R.id.pager)
    ViewPager mPager;

    @Inject
    ScheduleManager scheduleManager;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPager.setAdapter(new ChannelFragmentPagerAdapter(getActivity(), this.getFragmentManager()));
        mPager.setOffscreenPageLimit(4);
        mPager.setOnTouchListener(this);
        handler.postDelayed(hideRunnable, 2 * CIRCLE_INDICATOR_SHOW_TIME);
        mPager.setCurrentItem(0);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateActivityTitle();
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_play) {
           playChannel();
        }
        return super.onOptionsItemSelected(item);
    }

    private void playChannel() {
        Intent mpdIntent = new Intent(getActivity(), PlayerActivity.class)
                .setData(Uri.parse(((ChannelFragmentPagerAdapter) mPager.getAdapter()).getStreamingURL(mPager.getCurrentItem())))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, "")
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, Util.TYPE_HLS)
                .putExtra(PlayerActivity.PROVIDER_EXTRA, "");
        startActivity(mpdIntent);
    }

    private void updateActivityTitle() {
        ((MainActivity) getActivity()).setActionBarTitle(mPager.getAdapter().getPageTitle(mPager.getCurrentItem()).toString());
        ((MainActivity) getActivity()).setHeaderImage(((ChannelFragmentPagerAdapter) mPager.getAdapter()).getPageHeaderImage(mPager.getCurrentItem()));
        if (getIndicator() != null) {
            getIndicator().setViewPager(mPager);
            getIndicator().setOnPageChangeListener(this);
        }
    }

    private CirclePageIndicator getIndicator() {
        if (getActivity() instanceof MainActivity) {
            return ((MainActivity) getActivity()).getIndicator();
        } else {
            return null;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        handler.removeCallbacks(hideRunnable);
        handler.post(showRunnable);
    }

    @Override
    public void onPageSelected(final int position) {
        handler.postDelayed(hideRunnable, CIRCLE_INDICATOR_SHOW_TIME);
        updateActivityTitle();
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

    @Subscribe
    public void onScheduleLoadedEvent(ScheduleLoadedEvent event) {
        Log.d(LOG_TAG, "onScheduleLoadedEvent <-");
        mPager.setAdapter(new ChannelFragmentPagerAdapter(getActivity(), this.getFragmentManager()));
        updateActivityTitle();
        mPager.getAdapter().notifyDataSetChanged();
    }

    @Subscribe
    public void onPlayChannelEvent(PlayChannelEvent event) {
        playChannel();
    }

}
