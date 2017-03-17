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

package com.example.sample3.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Ownership_ implements Parcelable {

    public final static Parcelable.Creator<Ownership_> CREATOR = new Creator<Ownership_>() {


        public Ownership_ createFromParcel(Parcel in) {
            Ownership_ instance = new Ownership_();
            instance.service = ((Service__) in.readValue((Service__.class.getClassLoader())));
            return instance;
        }

        public Ownership_[] newArray(int size) {
            return (new Ownership_[size]);
        }

    };
    @SerializedName("service")
    @Expose
    private Service__ service;

    /**
     * @return The service
     */
    public Service__ getService() {
        return service;
    }

    /**
     * @param service The service
     */
    public void setService(Service__ service) {
        this.service = service;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(service);
    }

}
