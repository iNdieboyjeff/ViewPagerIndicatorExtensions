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

package com.example.sample3.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.example.sample3.Application;
import com.example.sample3.R;
import com.example.sample3.event.PlayChannelEvent;
import com.example.sample3.manager.ScheduleManager;
import com.viewpagerindicator.CirclePageIndicator;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.header)
    ImageView headerImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.indicator)
    CirclePageIndicator mIndicator;

    @Inject
    ScheduleManager scheduleManager;

    boolean isExpanded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScheduleManager.getInstance((Application) getApplication());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionBarTitle();

        appBarLayout.addOnOffsetChangedListener(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new PlayChannelEvent());
            }
        });
    }

    private void setActionBarTitle() {
        if (getSupportActionBar() == null) return;
        setActionBarTitle("");
    }

    public void setActionBarTitle(String title) {
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setTitle(title);
        collapsing.setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_play).setVisible(!floatingActionButton.isShown());
        return super.onCreateOptionsMenu(menu);
    }

    public void setHeaderImage(int resourceId) {
        headerImage.setImageResource(resourceId);
    }

    public CirclePageIndicator getIndicator() {
        return mIndicator;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        invalidateOptionsMenu();
    }
}
