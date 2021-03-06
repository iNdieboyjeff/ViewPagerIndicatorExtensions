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
public class Schedule implements Parcelable {

    public final static Parcelable.Creator<Schedule> CREATOR = new Creator<Schedule>() {


        public Schedule createFromParcel(Parcel in) {
            Schedule instance = new Schedule();
            instance.service = ((Service) in.readValue((Service.class.getClassLoader())));
            instance.day = ((Day) in.readValue((Day.class.getClassLoader())));
            return instance;
        }

        public Schedule[] newArray(int size) {
            return (new Schedule[size]);
        }

    };
    @SerializedName("service")
    @Expose
    private Service service;
    @SerializedName("day")
    @Expose
    private Day day;

    /**
     * @return The service
     */
    public Service getService() {
        return service;
    }

    /**
     * @param service The service
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * @return The day
     */
    public Day getDay() {
        return day;
    }

    /**
     * @param day The day
     */
    public void setDay(Day day) {
        this.day = day;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(service);
        dest.writeValue(day);
    }

}
