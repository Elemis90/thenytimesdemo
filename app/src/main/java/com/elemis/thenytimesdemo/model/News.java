package com.elemis.thenytimesdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by elemis on 2018. 02. 24..
 */

public class News implements Parcelable {
    private long id;
    private String url;
    private String title;
    private String type;
    @SerializedName("abstract")
    private String abstractText;
    private String source;
    private String section;
    @SerializedName("published_date")
    private String publishedDate;
    private String byline;
    private ArrayList<Media> media;
    private Boolean selected = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public Boolean isSelected() {
        return selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.type);
        dest.writeString(this.abstractText);
        dest.writeString(this.source);
        dest.writeString(this.section);
        dest.writeString(this.publishedDate);
        dest.writeString(this.byline);
        dest.writeList(this.media);
        dest.writeValue(this.selected);
    }

    public News() {
    }

    protected News(Parcel in) {
        this.id = in.readLong();
        this.url = in.readString();
        this.title = in.readString();
        this.type = in.readString();
        this.abstractText = in.readString();
        this.source = in.readString();
        this.section = in.readString();
        this.publishedDate = in.readString();
        this.byline = in.readString();
        this.media = new ArrayList<Media>();
        in.readList(this.media, Media.class.getClassLoader());
        this.selected = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
