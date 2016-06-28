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
import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * <p>Interceptor for OKHttp that logs the request and response to the logcat.</p>
 */
public class OKHttpLoggingInterceptor implements Interceptor {

    private static final String LOG_TAG = OKHttpLoggingInterceptor.class.getSimpleName();

    /**
     * @param chain
     * @return
     * @throws IOException
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.d(LOG_TAG, "Request to:    [" + request.method() + "] " + request.url().toString());

        try {
            if (request.body() != null) {
                Buffer buffer = new Buffer();
                request.body().writeTo(buffer);
                Log.d(LOG_TAG, "Request body:  " + buffer.readUtf8());
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        Log.d(LOG_TAG, "Request headers:  ");
        Headers headers = request.headers();
        for (Map.Entry<String, List<String>> entry : headers.toMultimap().entrySet()) {
            Log.d(LOG_TAG, "Request head:  " + entry.getKey()
                    + ": " + entry.getValue());
        }

        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        String msg = response.body().string();
        Log.d(LOG_TAG, String.format("Response from: %s in %.1fms%n\n%s",
                response.request().url().toString(), (t2 - t1) / 1e6d, msg));
        Log.d(LOG_TAG, "Response code: " + response.code() + " " + response.message());

        Headers headers2 = response.headers();
        for (Map.Entry<String, List<String>> entry : headers2.toMultimap().entrySet()) {
            Log.d(LOG_TAG, "Response head: " + entry.getKey()
                    + ": " + entry.getValue());
        }

        Log.d(LOG_TAG, "Response body: " + msg);
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), msg))
                .build();
    }
}
