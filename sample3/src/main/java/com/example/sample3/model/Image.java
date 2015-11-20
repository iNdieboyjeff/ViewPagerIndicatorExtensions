
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Image implements Parcelable
{

    @SerializedName("pid")
    @Expose
    private String pid;
    public final static Parcelable.Creator<Image> CREATOR = new Creator<Image>() {


        public Image createFromParcel(Parcel in) {
            Image instance = new Image();
            instance.pid = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    }
    ;

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pid);
    }

    public int describeContents() {
        return  0;
    }

}