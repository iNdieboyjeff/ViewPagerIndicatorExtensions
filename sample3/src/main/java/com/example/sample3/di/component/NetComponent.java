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

package com.example.sample3.di.component;

import com.example.sample3.di.module.ApplicationModule;
import com.example.sample3.di.module.DataModule;
import com.example.sample3.fragment.ChannelFragment;
import com.example.sample3.manager.ScheduleManager;
import com.example.sample3.service.BBCScheduleService;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by jeff on 26/11/2015.
 */
@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class})
public interface NetComponent {
    OkHttpClient okHttpClient();

    Gson gson();

    BBCScheduleService bbcScheduleService();

    void inject(ChannelFragment fragment);

    void inject(ScheduleManager manager);
}
