package com.example.sample3.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.sample3.event.ScheduleLoadedEvent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated("org.jsonschema2pojo")
public class ChannelConfig implements Parcelable {

    public final static Parcelable.Creator<ChannelConfig> CREATOR = new Creator<ChannelConfig>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ChannelConfig createFromParcel(Parcel in) {
            ChannelConfig instance = new ChannelConfig();
            in.readList(instance.channels, (com.example.sample3.model.Channel.class.getClassLoader()));
            return instance;
        }

        public ChannelConfig[] newArray(int size) {
            return (new ChannelConfig[size]);
        }

    };
    private static final String LOG_TAG = ChannelConfig.class.getSimpleName();
    @SerializedName("channels")
    @Expose
    @Valid
    private List<Channel> channels = new ArrayList<Channel>();

    /**
     * @return The channels
     */
    public List<Channel> getChannels() {
        return channels;
    }

    /**
     * @param channels The channels
     */
    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public ChannelConfig withChannels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(channels);
    }

    public void updateSchedule(BBCSchedule schedule) {
        String key = schedule.getSchedule().getService().getKey();
        for (Channel channel : channels) {
            if (channel.getChannelId().equalsIgnoreCase(key)) {
                Log.d(LOG_TAG, "Update schedule info for " + channel.getName());
                channel.schedule = schedule;
            }
        }
        EventBus.getDefault().post(new ScheduleLoadedEvent());
    }

}
