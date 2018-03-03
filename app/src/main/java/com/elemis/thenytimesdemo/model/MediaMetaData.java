package com.elemis.thenytimesdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elemis on 2018. 02. 24..
 */

public class MediaMetaData implements Parcelable {
    private String url;
    private String format;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.format);
    }

    public MediaMetaData() {
    }

    protected MediaMetaData(Parcel in) {
        this.url = in.readString();
        this.format = in.readString();
    }

    public static final Creator<MediaMetaData> CREATOR = new Creator<MediaMetaData>() {
        @Override
        public MediaMetaData createFromParcel(Parcel source) {
            return new MediaMetaData(source);
        }

        @Override
        public MediaMetaData[] newArray(int size) {
            return new MediaMetaData[size];
        }
    };
}
