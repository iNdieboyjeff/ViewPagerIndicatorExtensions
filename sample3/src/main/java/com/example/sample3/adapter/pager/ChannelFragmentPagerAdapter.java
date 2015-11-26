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

package com.example.sample3.adapter.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.sample3.fragment.ChannelFragment;
import com.example.sample3.R;

import java.util.ArrayList;

/**
 * Created by jeff on 19/11/2015.
 */
public class ChannelFragmentPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<ChannelFragment> mItems = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("PAGER", "Looking for position " + position);
        position = position + 1;
        if (position > getCount()) {
            position = 1;
        }
        Log.d("PAGER", "Returning position " + position);
        return mItems.get(position).getChannelName();
    }

    public int getPageHeaderImage(int position) {
        Log.d("PAGER", "Looking for position " + position);
        position = position + 1;
        if (position > getCount()) {
            position = 1;
        }
        Log.d("PAGER", "Returning position " + position);
        return mItems.get(position).getHeaderResource();
    }

    public ChannelFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mItems.add(ChannelFragment.newInstance("BBC Four", "http://www.bbc.co.uk/bbcfour/programmes/schedules.json", R.drawable.header_01));
        mItems.add(ChannelFragment.newInstance("BBC One", "http://www.bbc.co.uk/bbcone/programmes/schedules/london.json", R.drawable.bbc_one_ident));
        mItems.add(ChannelFragment.newInstance("BBC Two", "http://www.bbc.co.uk/bbctwo/programmes/schedules/england.json", R.drawable.bbc_two_ident));
        mItems.add(ChannelFragment.newInstance("BBC Three", "http://www.bbc.co.uk/bbcthree/programmes/schedules.json", R.drawable.header_01));
        mItems.add(ChannelFragment.newInstance("BBC Four", "http://www.bbc.co.uk/bbcfour/programmes/schedules.json", R.drawable.header_01));
        mItems.add(ChannelFragment.newInstance("BBC One", "http://www.bbc.co.uk/bbcone/programmes/schedules/london.json", R.drawable.bbc_one_ident));
    }
}
