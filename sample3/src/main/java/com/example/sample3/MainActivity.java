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

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import util.android.textviews.TypefaceSpan;

public class MainActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);
        setActionBarTitle();
    }

    private void setActionBarTitle() {
        if (getSupportActionBar() == null) return;
        TypefaceSpan span = new TypefaceSpan(this, "Audiowide-Regular");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.CYAN);

        SpannableString title = new SpannableString("VPagerIndicator3");
        title.setSpan(span, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setSpan(colorSpan, 9, title.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(title);
        collapsing.setTitle(title);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
        collapsing.setTitle(title);
    }
}
