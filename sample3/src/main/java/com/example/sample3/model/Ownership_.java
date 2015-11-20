
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Ownership_ implements Parcelable
{

    @SerializedName("service")
    @Expose
    private Service__ service;
    public final static Parcelable.Creator<Ownership_> CREATOR = new Creator<Ownership_>() {


        public Ownership_ createFromParcel(Parcel in) {
            Ownership_ instance = new Ownership_();
            instance.service = ((Service__) in.readValue((Service__.class.getClassLoader())));
            return instance;
        }

        public Ownership_[] newArray(int size) {
            return (new Ownership_[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The service
     */
    public Service__ getService() {
        return service;
    }

    /**
     * 
     * @param service
     *     The service
     */
    public void setService(Service__ service) {
        this.service = service;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(service);
    }

    public int describeContents() {
        return  0;
    }

}
