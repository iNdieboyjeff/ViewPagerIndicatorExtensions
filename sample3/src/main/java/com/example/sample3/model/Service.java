
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Service implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("outlet")
    @Expose
    private Outlet outlet;
    public final static Parcelable.Creator<Service> CREATOR = new Creator<Service>() {


        public Service createFromParcel(Parcel in) {
            Service instance = new Service();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.key = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.outlet = ((Outlet) in.readValue((Outlet.class.getClassLoader())));
            return instance;
        }

        public Service[] newArray(int size) {
            return (new Service[size]);
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
     *     The key
     */
    public String getKey() {
        return key;
    }

    /**
     * 
     * @param key
     *     The key
     */
    public void setKey(String key) {
        this.key = key;
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
     *     The outlet
     */
    public Outlet getOutlet() {
        return outlet;
    }

    /**
     * 
     * @param outlet
     *     The outlet
     */
    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(key);
        dest.writeValue(title);
        dest.writeValue(outlet);
    }

    public int describeContents() {
        return  0;
    }

}
