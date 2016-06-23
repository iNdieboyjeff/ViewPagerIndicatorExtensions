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

package com.example.sample3.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.sample3.Application;
import com.example.sample3.R;
import com.example.sample3.adapter.list.ScheduleAdapter;
import com.example.sample3.di.component.NetComponent;
import com.example.sample3.event.ScheduleLoadedEvent;
import com.example.sample3.model.BBCSchedule;
import com.example.sample3.service.BBCScheduleService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChannelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChannelFragment extends Fragment implements retrofit2.Callback<BBCSchedule> {

    private static final String LOG_TAG = ChannelFragment.class.getSimpleName();
    private static final String CHANNEL_NAME = "channel_name";
    private static final String CHANNEL_ID = "channel_id";
    private static final String SCHEDULE_TYPE = "schedule_type";
    private static final String HEADER_IMAGE = "header_image";
    @Inject
    BBCScheduleService scheduleService;
    @BindView(R.id.scheduleView)
    RecyclerView scheduleList;
    @BindView(R.id.progressBar)
    ProgressBar progress;
    private String mChannelName;
    private String mChannelId;
    private String mScheduleType;
    private int mHeaderResource;
    private BBCSchedule mSchedule;

    public ChannelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param channelDisplayName Parameter 1.
     * @param channelId          Parameter 2.
     * @param scheduleType
     * @return A new instance of fragment ChannelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChannelFragment newInstance(String channelDisplayName, String channelId, String scheduleType, int channelHeader) {
        ChannelFragment fragment = new ChannelFragment();
        Bundle args = new Bundle();
        args.putString(CHANNEL_NAME, channelDisplayName);
        args.putString(CHANNEL_ID, channelId);
        args.putString(SCHEDULE_TYPE, scheduleType);
        args.putInt(HEADER_IMAGE, channelHeader);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        NetComponent netComponent = ((Application) getActivity().getApplication()).getNetComponent();

        if (netComponent != null) {
            netComponent.inject(this);
        } else {
            Log.e(LOG_TAG, "netComponent is null");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mChannelName = getArguments().getString(CHANNEL_NAME);
            mChannelId = getArguments().getString(CHANNEL_ID);
            mScheduleType = getArguments().getString(SCHEDULE_TYPE);
            mHeaderResource = getArguments().getInt(HEADER_IMAGE);
        }

        if (scheduleService != null) {
            scheduleService.getSchedule(mChannelId, mScheduleType).enqueue(this);
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scheduleList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mSchedule != null) {
            scheduleList.post(new Runnable() {
                @Override
                public void run() {
                    scheduleList.setAdapter(new ScheduleAdapter(mSchedule.getSchedule().getDay().getBroadcasts()));
                    progress.setVisibility(View.GONE);
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

    @Override
    public void onResponse(retrofit2.Call<BBCSchedule> call, final retrofit2.Response<BBCSchedule> response) {
        if (response.isSuccessful()) {
            scheduleList.post(new Runnable() {
                @Override
                public void run() {
                    scheduleList.setAdapter(new ScheduleAdapter(response.body().getSchedule().getDay().getBroadcasts()));
                    progress.setVisibility(View.GONE);
                    EventBus.getDefault().post(new ScheduleLoadedEvent());
                }
            });
        }
    }

    @Override
    public void onFailure(retrofit2.Call<BBCSchedule> call, Throwable t) {
        if (mSchedule != null) {
            scheduleList.post(new Runnable() {
                @Override
                public void run() {
                    scheduleList.setAdapter(new ScheduleAdapter(mSchedule.getSchedule().getDay().getBroadcasts()));
                    progress.setVisibility(View.GONE);
                    EventBus.getDefault().post(new ScheduleLoadedEvent());
                }
            });
        }
    }
}
