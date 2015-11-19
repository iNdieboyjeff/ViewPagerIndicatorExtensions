package com.example.sample2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import util.android.textviews.TypefaceSpan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setActionBarTitle();
    }

    private void setActionBarTitle() {
        if (getSupportActionBar() == null) return;
        TypefaceSpan span = new TypefaceSpan(this, "Audiowide-Regular");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.CYAN);

        SpannableString title = new SpannableString("ViewPagerIndicator2");
        title.setSpan(span, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setSpan(colorSpan, 9, title.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(title);
    }
}
