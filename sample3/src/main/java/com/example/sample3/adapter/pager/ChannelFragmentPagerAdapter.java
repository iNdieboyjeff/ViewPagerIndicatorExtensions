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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sample3.R;
import com.example.sample3.fragment.ChannelFragment;

import java.util.ArrayList;

/**
 * Created by jeff on 19/11/2015.
 */
public class ChannelFragmentPagerAdapter extends FragmentPagerAdapter {

    static ArrayList<ChannelFragment> mItems = new ArrayList<>();

    public ChannelFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        if (mItems.size() < 3) {
            mItems.add(ChannelFragment.newInstance("BBC One", "bbcone", "schedules/london", R.drawable.bbc_one_ident));
            mItems.add(ChannelFragment.newInstance("BBC Two", "bbctwo", "schedules/england", R.drawable.bbc_two_ident));
            mItems.add(ChannelFragment.newInstance("BBC News", "bbcnews", "schedules", R.drawable.header_01));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        if (mItems == null) {
            return 0;
        } else {
            return mItems.size();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mItems.get(position).getChannelName();
    }

    public int getPageHeaderImage(int position) {
        return mItems.get(position).getHeaderResource();
    }
}
