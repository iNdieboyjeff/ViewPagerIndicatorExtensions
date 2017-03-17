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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.sample3.R;
import com.example.sample3.adapter.list.ScheduleAdapter;
import com.example.sample3.model.Channel;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChannelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChannelFragment extends Fragment {

    private static final String LOG_TAG = ChannelFragment.class.getSimpleName();

    @BindView(R.id.scheduleView)
    RecyclerView scheduleList;
    @BindView(R.id.progressBar)
    ProgressBar progress;

    Channel channel;

    public ChannelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ChannelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChannelFragment newInstance(Channel channel) {
        ChannelFragment fragment = new ChannelFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.channel = channel;
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if (channel != null && channel.schedule != null) {
            scheduleList.post(new Runnable() {
                @Override
                public void run() {
                    scheduleList.setAdapter(new ScheduleAdapter(channel.schedule.getSchedule().getDay().getBroadcasts()));
                    progress.setVisibility(View.GONE);
                }
            });
        }
    }

    public String getChannelName() {

        return channel.getName();
    }

    public String getStreamUrl() {
        return channel.getStream();
    }

    public int getHeaderResource() {
        return getResources().getIdentifier(channel.getLogo(), "drawable", getActivity().getPackageName());
    }
}
