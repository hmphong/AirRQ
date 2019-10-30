package com.example.airrq.viewmodel;

import com.example.airrq.model.AirModel;

import java.util.Observable;

public class RecyclerViewModel extends Observable {
    private AirModel airModel;

    public RecyclerViewModel(AirModel airModel) {
        this.airModel = airModel;
    }

    public String getCityToList(){
        return airModel.getmCity();
    }
    public String getIndexToList(){
        return airModel.getmIndex();
    }
    public String getRankingToList(){
        return airModel.getmRanking();
    }
    public String getTimeToList(){
        return airModel.getmTime();
    }
}
