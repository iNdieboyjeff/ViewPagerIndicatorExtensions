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
public class Image_ implements Parcelable {

    public final static Parcelable.Creator<Image_> CREATOR = new Creator<Image_>() {


        public Image_ createFromParcel(Parcel in) {
            Image_ instance = new Image_();
            instance.pid = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Image_[] newArray(int size) {
            return (new Image_[size]);
        }

    };
    @SerializedName("pid")
    @Expose
    private String pid;

    /**
     * @return The pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid The pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pid);
    }

}
