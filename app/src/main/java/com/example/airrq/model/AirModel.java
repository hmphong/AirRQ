package com.example.airrq.model;

public class AirModel {
    public String mCity, mIndex, mRanking, mTime;

    public AirModel() {
    }

    public AirModel(String mCity, String mIndex, String mRanking, String mTime) {
        this.mCity = mCity;
        this.mIndex = mIndex;
        this.mRanking = mRanking;
        this.mTime = mTime;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmIndex() {
        return mIndex;
    }

    public void setmIndex(String mIndex) {
        this.mIndex = mIndex;
    }

    public String getmRanking() {
        return mRanking;
    }

    public void setmRanking(String mRanking) {
        this.mRanking = mRanking;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

}
