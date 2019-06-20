package com.maxwell.kaavidesam;

import android.os.Parcel;
import android.os.Parcelable;

import com.applandeo.materialcalendarview.EventDay;

import java.util.Calendar;

public class MyEvents extends EventDay implements Parcelable {
    private String mNote;

    MyEvents(Calendar day, int imageResource, String note) {
        super(day, imageResource);
        mNote = note;
    }

    String getNote() {
        return mNote;
    }

    private MyEvents(Parcel in) {
        super((Calendar) in.readSerializable(), in.readInt());
        mNote = in.readString();
    }

    public static final Creator<MyEvents> CREATOR = new Creator<MyEvents>() {
        @Override
        public MyEvents createFromParcel(Parcel in) {
            return new MyEvents(in);
        }

        @Override
        public MyEvents[] newArray(int size) {
            return new MyEvents[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(getCalendar());
        parcel.writeInt(getImageResource());
        parcel.writeString(mNote);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
