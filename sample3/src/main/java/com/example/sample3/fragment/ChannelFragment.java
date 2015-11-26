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

package com.example.sample3.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample3.Application;
import com.example.sample3.R;
import com.example.sample3.adapter.list.ScheduleAdapter;
import com.example.sample3.di.component.NetComponent;
import com.example.sample3.model.BBCSchedule;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChannelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChannelFragment extends Fragment implements Callback {

private static final String LOG_TAG = ChannelFragment.class.getSimpleName();

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Gson gson;

    private static final String CHANNEL_NAME = "channel_name";
    private static final String SCHEDULE_LINK = "schedule_link";
    private static final String HEADER_IMAGE = "header_image";

    private String mChannelName;
    private String mScheduleLink;
    private int mHeaderResource;

    private BBCSchedule mSchedule;

    @Bind(R.id.scheduleView)
    RecyclerView scheduleList;

    public ChannelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChannelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChannelFragment newInstance(String param1, String param2, int param3) {
        ChannelFragment fragment = new ChannelFragment();
        Bundle args = new Bundle();
        args.putString(CHANNEL_NAME, param1);
        args.putString(SCHEDULE_LINK, param2);
        args.putInt(HEADER_IMAGE, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mChannelName = getArguments().getString(CHANNEL_NAME);
            mScheduleLink = getArguments().getString(SCHEDULE_LINK);
            mHeaderResource = getArguments().getInt(HEADER_IMAGE);
        }

        if (okHttpClient != null) {
            Request request = new Request.Builder().url(mScheduleLink).build();
            okHttpClient.newCall(request).enqueue(this);
        } else {
            Log.e(LOG_TAG, "okHTTPclient is null");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example_fragment1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        NetComponent netComponent = ((Application)getActivity().getApplication()).getNetComponent();

        if (netComponent != null) {
            netComponent.inject(this);
        } else {
            Log.e(LOG_TAG, "netComponent is null");
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scheduleList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onFailure(Request request, IOException e) {

    }

    @Override
    public void onResponse(Response response) throws IOException {
        if (response.isSuccessful()) {
            final String body = response.body().string();
            mSchedule = gson.fromJson(body, BBCSchedule.class);
            scheduleList.post(new Runnable() {
                @Override
                public void run() {
                    scheduleList.setAdapter(new ScheduleAdapter(mSchedule.getSchedule().getDay().getBroadcasts()));
                }
            });

        }
    }

    public String getChannelName() {
        if (mChannelName == null) {
            mChannelName = getArguments().getString(CHANNEL_NAME);
        }
        return mChannelName;
    }

    public int getHeaderResource() {
        if (mHeaderResource < 1) {
            mHeaderResource = getArguments().getInt(HEADER_IMAGE);
        }
        return mHeaderResource;
    }
}
