package com.example.task51c;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {
    private String _title;
    private String _category;
    private String _publisher;
    private String _description;
    private int _image;
    private int _thumb;

    public News(String title, String description, String publisher, String category, int image, int thumb) {
        _title = title;
        _description = description;
        _publisher = publisher;
        _category = category;
        _image = image;
        _thumb = thumb;
    }

    protected News(Parcel in) {
        _title = in.readString();
        _category = in.readString();
        _publisher = in.readString();
        _description = in.readString();
        _image = in.readInt();
        _thumb = in.readInt();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getTitle() { return _title; }
    public void setTitle(String title) { _title = title; }

    public String getCategory() { return _category; }
    public void setCategory(String category) { _category = category; }

    public String getDesc() { return _description; }
    public void setDesc(String description) { _description = description; }

    public String getPublisher() { return _publisher; }
    public void setPublisher(String publisher) { _publisher = publisher; }

    public int getImage() { return _image; }
    public void setImage(int image) { _image = image; }

    public int getThumb() { return _thumb; }
    public void setThumb(int thumb) { _thumb = thumb; }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_title);
        parcel.writeString(_category);
        parcel.writeString(_publisher);
        parcel.writeString(_description);
        parcel.writeInt(_image);
        parcel.writeInt(_thumb);
    }
}
