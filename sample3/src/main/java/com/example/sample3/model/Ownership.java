
package com.example.sample3.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Ownership implements Parcelable
{

    @SerializedName("service")
    @Expose
    private Service_ service;
    public final static Parcelable.Creator<Ownership> CREATOR = new Creator<Ownership>() {


        public Ownership createFromParcel(Parcel in) {
            Ownership instance = new Ownership();
            instance.service = ((Service_) in.readValue((Service_.class.getClassLoader())));
            return instance;
        }

        public Ownership[] newArray(int size) {
            return (new Ownership[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The service
     */
    public Service_ getService() {
        return service;
    }

    /**
     * 
     * @param service
     *     The service
     */
    public void setService(Service_ service) {
        this.service = service;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(service);
    }

    public int describeContents() {
        return  0;
    }

}
