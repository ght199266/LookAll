package com.lly.lookall.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TabBean[v 1.0.0]
 * classes:com.lly.lookall.entity.TabBean
 *
 * @author lileiyi
 * @date 2016/4/27
 * @time 13:46
 * @description
 */
public class TabBean implements Parcelable {

    private String name;
    private int type;

    public TabBean(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.type);
    }

    protected TabBean(Parcel in) {
        this.name = in.readString();
        this.type = in.readInt();
    }

    public static final Parcelable.Creator<TabBean> CREATOR = new Parcelable.Creator<TabBean>() {
        @Override
        public TabBean createFromParcel(Parcel source) {
            return new TabBean(source);
        }

        @Override
        public TabBean[] newArray(int size) {
            return new TabBean[size];
        }
    };
}
