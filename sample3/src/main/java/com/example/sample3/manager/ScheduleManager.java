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

package com.example.sample3.manager;

import android.util.Log;

import com.example.sample3.Application;
import com.example.sample3.di.component.NetComponent;
import com.example.sample3.model.BBCSchedule;
import com.example.sample3.model.Channel;
import com.example.sample3.model.ChannelConfig;
import com.example.sample3.service.BBCScheduleService;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class ScheduleManager implements retrofit2.Callback<BBCSchedule> {

    private static final String LOG_TAG = ScheduleManager.class.getSimpleName();
    private static ChannelConfig channelConfig;
    private static ScheduleManager mInstance;
    @Inject
    BBCScheduleService bbcScheduleService;
    @Inject
    Gson gson;
    Application application;

    public ScheduleManager(Application context) {
        this.application = context;
        NetComponent netComponent = context.getNetComponent();

        if (netComponent != null) {
            netComponent.inject(this);
        } else {
            Log.e(LOG_TAG, "netComponent is null");
        }

        try {
            Log.d(LOG_TAG, "Loading channel configuration...");
            channelConfig = gson.fromJson(new InputStreamReader(context.getAssets().open("channels.json"), "UTF-8"), ChannelConfig.class);

            for (Channel c : channelConfig.getChannels()) {
                if (bbcScheduleService != null) {
                    bbcScheduleService.getSchedule(c.getChannelId(), c.getScheduleType()).enqueue(this);
                } else {
                    Log.e(LOG_TAG, "okHTTPclient is null");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ScheduleManager getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new ScheduleManager(application);
        }
        return mInstance;
    }

    public static ScheduleManager getInstance() throws ManagerNotInitialisedException {
        if (mInstance == null) {
            throw new ManagerNotInitialisedException("ScheduleManager has not been initialised");
        }
        return mInstance;
    }

    public ChannelConfig getChannelConfig() {
        if (channelConfig != null) {
            return channelConfig;
        } else {
            return null;
        }
    }

    @Override
    public void onResponse(Call<BBCSchedule> call, Response<BBCSchedule> response) {
        if (response != null) {
            channelConfig.updateSchedule(response.body());
        }
    }

    @Override
    public void onFailure(Call<BBCSchedule> call, Throwable t) {
        t.printStackTrace();
    }
}
