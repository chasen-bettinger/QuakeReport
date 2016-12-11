package com.example.android.quakereport;

/**
 * Created by Chasen on 12/9/2016.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private Long mTimeInMilliseconds;

    public Earthquake (double magnitude, String location, Long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public Long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
