package com.example.airrq.repository.server;

import com.example.airrq.model.AirModel;
import com.example.airrq.model.Api;
import com.example.airrq.viewmodel.AirViewModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroGetApi {
    String HTTP_URL = "https://api.waqi.info";

    @GET("/feed/hanoi/?token=bb16506b22747c218e060bc860dd6bbd188cd370")
    Call<Api> getApiReq();
}
