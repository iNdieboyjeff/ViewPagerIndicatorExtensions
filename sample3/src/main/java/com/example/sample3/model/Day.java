
package com.example.sample3.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Day implements Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("has_next")
    @Expose
    private int hasNext;
    @SerializedName("has_previous")
    @Expose
    private int hasPrevious;
    @SerializedName("broadcasts")
    @Expose
    private List<Broadcast> broadcasts = new ArrayList<Broadcast>();
    public final static Parcelable.Creator<Day> CREATOR = new Creator<Day>() {


        public Day createFromParcel(Parcel in) {
            Day instance = new Day();
            instance.date = ((String) in.readValue((String.class.getClassLoader())));
            instance.hasNext = ((int) in.readValue((int.class.getClassLoader())));
            instance.hasPrevious = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.broadcasts, (com.example.sample3.model.Broadcast.class.getClassLoader()));
            return instance;
        }

        public Day[] newArray(int size) {
            return (new Day[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The hasNext
     */
    public int getHasNext() {
        return hasNext;
    }

    /**
     * 
     * @param hasNext
     *     The has_next
     */
    public void setHasNext(int hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 
     * @return
     *     The hasPrevious
     */
    public int getHasPrevious() {
        return hasPrevious;
    }

    /**
     * 
     * @param hasPrevious
     *     The has_previous
     */
    public void setHasPrevious(int hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    /**
     * 
     * @return
     *     The broadcasts
     */
    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    /**
     * 
     * @param broadcasts
     *     The broadcasts
     */
    public void setBroadcasts(List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(hasNext);
        dest.writeValue(hasPrevious);
        dest.writeList(broadcasts);
    }

    public int describeContents() {
        return  0;
    }

}
