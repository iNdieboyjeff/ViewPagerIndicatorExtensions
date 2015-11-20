
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DisplayTitles implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    public final static Parcelable.Creator<DisplayTitles> CREATOR = new Creator<DisplayTitles>() {


        public DisplayTitles createFromParcel(Parcel in) {
            DisplayTitles instance = new DisplayTitles();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.subtitle = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public DisplayTitles[] newArray(int size) {
            return (new DisplayTitles[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 
     * @param subtitle
     *     The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(subtitle);
    }

    public int describeContents() {
        return  0;
    }

}
