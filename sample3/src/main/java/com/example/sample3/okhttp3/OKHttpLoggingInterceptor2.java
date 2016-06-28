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

package com.example.sample3.okhttp3;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <p>A more basic interceptor for OKHttp that logs the request and response to the logcat.</p>
 */
public class OKHttpLoggingInterceptor2 implements Interceptor {

    private static final String LOG_TAG = OKHttpLoggingInterceptor2.class.getSimpleName();

    /**
     * @param chain
     * @return
     * @throws IOException
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.d(LOG_TAG, "Request to:    [" + request.method() + "] " + request.url().toString());

        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.d(LOG_TAG, String.format("Response from: %s in %.1fms%n",
                response.request().url().toString(), (t2 - t1) / 1e6d));
        Log.d(LOG_TAG, "Response code: " + response.code() + " " + response.message());


        return response;
    }
}
