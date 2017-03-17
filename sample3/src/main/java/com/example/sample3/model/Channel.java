package com.example.sample3.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Channel implements Parcelable {

    public final static Parcelable.Creator<Channel> CREATOR = new Creator<Channel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Channel createFromParcel(Parcel in) {
            Channel instance = new Channel();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.scheduleFormat = ((String) in.readValue((String.class.getClassLoader())));
            instance.channelId = ((String) in.readValue((String.class.getClassLoader())));
            instance.scheduleType = ((String) in.readValue((String.class.getClassLoader())));
            instance.logo = ((String) in.readValue((String.class.getClassLoader())));
            instance.stream = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Channel[] newArray(int size) {
            return (new Channel[size]);
        }

    };
    public BBCSchedule schedule;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("scheduleFormat")
    @Expose
    private String scheduleFormat;
    @SerializedName("channelId")
    @Expose
    private String channelId;
    @SerializedName("scheduleType")
    @Expose
    private String scheduleType;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("stream")
    @Expose
    private String stream;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Channel withName(String name) {
        this.name = name;
        return this;
    }


    /**
     * @return The name
     */
    public String getStream() {
        return stream;
    }

    /**
     * @param name The name
     */
    public void setStream(String stream) {
        this.stream = stream;
    }

    public Channel withStream(String stream) {
        this.stream = stream;
        return this;
    }

    /**
     * @return The scheduleFormat
     */
    public String getScheduleFormat() {
        return scheduleFormat;
    }

    /**
     * @param scheduleFormat The scheduleFormat
     */
    public void setScheduleFormat(String scheduleFormat) {
        this.scheduleFormat = scheduleFormat;
    }

    public Channel withScheduleFormat(String scheduleFormat) {
        this.scheduleFormat = scheduleFormat;
        return this;
    }

    /**
     * @return The channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @param channelId The channelId
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Channel withChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    /**
     * @return The scheduleType
     */
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * @param scheduleType The scheduleType
     */
    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Channel withScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
        return this;
    }

    /**
     * @return The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Channel withLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(scheduleFormat);
        dest.writeValue(channelId);
        dest.writeValue(scheduleType);
        dest.writeValue(logo);
        dest.writeValue(stream);
    }

}
