
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BBCSchedule implements Parcelable
{

    @SerializedName("schedule")
    @Expose
    private Schedule schedule;
    public final static Parcelable.Creator<BBCSchedule> CREATOR = new Creator<BBCSchedule>() {


        public BBCSchedule createFromParcel(Parcel in) {
            BBCSchedule instance = new BBCSchedule();
            instance.schedule = ((Schedule) in.readValue((Schedule.class.getClassLoader())));
            return instance;
        }

        public BBCSchedule[] newArray(int size) {
            return (new BBCSchedule[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * 
     * @param schedule
     *     The schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(schedule);
    }

    public int describeContents() {
        return  0;
    }

}
