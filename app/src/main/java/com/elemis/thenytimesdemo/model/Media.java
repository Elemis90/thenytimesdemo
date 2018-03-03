package com.elemis.thenytimesdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by elemis on 2018. 02. 24..
 */

public class Media implements Parcelable {
    private String type;
    @SerializedName("media-metadata")
    private ArrayList<MediaMetaData> mediaMetaData;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<MediaMetaData> getMediaMetaData() {
        return mediaMetaData;
    }

    public void setMediaMetaData(ArrayList<MediaMetaData> mediaMetaData) {
        this.mediaMetaData = mediaMetaData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeList(this.mediaMetaData);
    }

    public Media() {
    }

    protected Media(Parcel in) {
        this.type = in.readString();
        this.mediaMetaData = new ArrayList<MediaMetaData>();
        in.readList(this.mediaMetaData, MediaMetaData.class.getClassLoader());
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };
}
