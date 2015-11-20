
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Schedule implements Parcelable
{

    @SerializedName("service")
    @Expose
    private Service service;
    @SerializedName("day")
    @Expose
    private Day day;
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

    }
    ;

    /**
     * 
     * @return
     *     The service
     */
    public Service getService() {
        return service;
    }

    /**
     * 
     * @param service
     *     The service
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * 
     * @return
     *     The day
     */
    public Day getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    public void setDay(Day day) {
        this.day = day;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(service);
        dest.writeValue(day);
    }

    public int describeContents() {
        return  0;
    }

}
