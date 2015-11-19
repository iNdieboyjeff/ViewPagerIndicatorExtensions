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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
