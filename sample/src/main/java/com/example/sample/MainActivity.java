package com.example.sample;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import util.android.textviews.TypefaceSpan;
import util.android.viewpagerindicator.FontableTabPageIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;
    FontableTabPageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setActionBarTitle();

        mPager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (FontableTabPageIndicator) findViewById(R.id.indicator);

        mPager.setAdapter(new ExampleFragmentPagerAdapter(getSupportFragmentManager()));

        mIndicator.setViewPager(mPager);
    }

    private void setActionBarTitle() {
        if (getSupportActionBar() == null) return;
        TypefaceSpan span = new TypefaceSpan(this, "Audiowide-Regular");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.CYAN);

        SpannableString title = new SpannableString("ViewPagerIndicator");
        title.setSpan(span, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setSpan(colorSpan, 9, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(title);
    }

}
