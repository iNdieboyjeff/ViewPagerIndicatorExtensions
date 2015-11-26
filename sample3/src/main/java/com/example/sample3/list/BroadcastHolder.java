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

package com.example.sample3.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sample3.R;
import com.example.sample3.model.Broadcast;

import butterknife.Bind;
import butterknife.ButterKnife;
import util.android.support.v7.textviews.AppCompatFontTextView;
import util.android.textviews.ExpandableTextView;

/**
 * Created by jeff on 20/11/2015.
 */
public class BroadcastHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.title) AppCompatFontTextView mTitle;
    @Bind(R.id.synopsis) ExpandableTextView mSynopsis;
    @Bind (R.id.imageView)  ImageView mThumb;


    public BroadcastHolder(View itemView, RecyclerView.Adapter adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindBroadcast(final Broadcast broadcast, int position) {
        mTitle.setText(Broadcast.TIME_FORMAT.format(broadcast.getStartDate()) + " " + broadcast.getProgramme().getDisplayTitles().getTitle());
        mSynopsis.setText(broadcast.getProgramme().getShortSynopsis(), true);
        mSynopsis.setOnViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcast.expanded = !mSynopsis.getContracted();
            }
        });
        mSynopsis.requestLayout();
        mSynopsis.setContracted(!broadcast.expanded);
        Glide.with(mThumb.getContext()).load("http://ichef.bbci.co.uk/images/ic/480x270/" + broadcast.getProgramme().getImage().getPid() + ".jpg").fitCenter().into(mThumb);
    }
}
