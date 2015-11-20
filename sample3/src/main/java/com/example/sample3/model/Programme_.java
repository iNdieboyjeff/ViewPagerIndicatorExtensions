
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Programme_ implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private Image_ image;
    @SerializedName("first_broadcast_date")
    @Expose
    private String firstBroadcastDate;
    @SerializedName("ownership")
    @Expose
    private Ownership_ ownership;
    public final static Parcelable.Creator<Programme_> CREATOR = new Creator<Programme_>() {


        public Programme_ createFromParcel(Parcel in) {
            Programme_ instance = new Programme_();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.pid = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.image = ((Image_) in.readValue((Image_.class.getClassLoader())));
            instance.firstBroadcastDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.ownership = ((Ownership_) in.readValue((Ownership_.class.getClassLoader())));
            return instance;
        }

        public Programme_[] newArray(int size) {
            return (new Programme_[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * 
     * @param pid
     *     The pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

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
     *     The image
     */
    public Image_ getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(Image_ image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The firstBroadcastDate
     */
    public String getFirstBroadcastDate() {
        return firstBroadcastDate;
    }

    /**
     * 
     * @param firstBroadcastDate
     *     The first_broadcast_date
     */
    public void setFirstBroadcastDate(String firstBroadcastDate) {
        this.firstBroadcastDate = firstBroadcastDate;
    }

    /**
     * 
     * @return
     *     The ownership
     */
    public Ownership_ getOwnership() {
        return ownership;
    }

    /**
     * 
     * @param ownership
     *     The ownership
     */
    public void setOwnership(Ownership_ ownership) {
        this.ownership = ownership;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(pid);
        dest.writeValue(title);
        dest.writeValue(image);
        dest.writeValue(firstBroadcastDate);
        dest.writeValue(ownership);
    }

    public int describeContents() {
        return  0;
    }

}
