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

package com.example.sample3.adapter.pager;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sample3.Application;
import com.example.sample3.R;
import com.example.sample3.fragment.ChannelFragment;
import com.example.sample3.manager.ScheduleManager;
import com.example.sample3.model.Channel;

/**
 * Created by jeff on 19/11/2015.
 */
public class ChannelFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final String LOG_TAG = ChannelFragmentPagerAdapter.class.getSimpleName();

    Activity activity;

    ScheduleManager scheduleManager;

    public ChannelFragmentPagerAdapter(Activity activity, FragmentManager fm) {
        super(fm);
        this.activity = activity;
        scheduleManager = ScheduleManager.getInstance((Application) activity.getApplication());
    }

    @Override
    public Fragment getItem(int position) {
        Channel c = scheduleManager.getChannelConfig().getChannels().get(position);
        if (c != null) {
            return ChannelFragment.newInstance(scheduleManager.getChannelConfig().getChannels().get(position));
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        if (scheduleManager == null || scheduleManager.getChannelConfig() == null) {
            return 0;
        } else {
            return scheduleManager.getChannelConfig().getChannels().size();
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (scheduleManager == null || scheduleManager.getChannelConfig() == null || scheduleManager.getChannelConfig().getChannels().size() < position)
            return "";
        return scheduleManager.getChannelConfig().getChannels().get(position).getName();
    }

    public int getPageHeaderImage(int position) {
        if (scheduleManager == null || scheduleManager.getChannelConfig() == null || scheduleManager.getChannelConfig().getChannels().size() < position)
            return R.drawable.header_01;
        return activity.getResources().getIdentifier(scheduleManager.getChannelConfig().getChannels().get(position).getLogo(), "drawable", activity.getPackageName());
    }

    public String getStreamingURL(int position) {
        if (scheduleManager == null || scheduleManager.getChannelConfig() == null || scheduleManager.getChannelConfig().getChannels().size() < position)
            return "";
        return scheduleManager.getChannelConfig().getChannels().get(position).getStream();
    }
}
