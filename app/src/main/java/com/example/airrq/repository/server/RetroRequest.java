package com.example.airrq.repository.server;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.airrq.model.AirModel;
import com.example.airrq.model.Api;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroRequest {
    public static Retrofit retrofit = null;
    RetroGetApi retroGetApi;

    public RetroGetApi getClient() {

            retrofit = new Retrofit.Builder()
                    .baseUrl(RetroGetApi.HTTP_URL)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        retroGetApi = retrofit.create(RetroGetApi.class);

        return retroGetApi;
    }

    public LiveData<AirModel> getDataApi(){
        final MutableLiveData<AirModel> mutableLiveData = new MutableLiveData<>();
        getClient().getApiReq().enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                AirModel airModel = new AirModel();
                airModel.setmCity(response.body().getData().getCity().getName());
                airModel.setmIndex(response.body().getData().getAqi().toString());
                airModel.setmTime(response.body().getData().getTime().getS());
                airModel.setmRanking(getResultRanking(response.body().getData().getAqi()));

                mutableLiveData.setValue(airModel);
            }

            @Override
            public void onFailure(Call<Api> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    public String getResultRanking(Integer mIndex){
        String mRanking;
        if (mIndex >= 0) {
            mRanking= "Good";
            return mRanking;
        } else if (mIndex >= 51) {
            mRanking ="Moderate";
            return mRanking;
        } else if (mIndex >= 101) {
            mRanking = "Unhealthy for sensitive";
            return mRanking;
        } else if (mIndex >= 151) {
            mRanking = "Unhealthy";
            return mRanking;
        } else if (mIndex >= 201) {
            mRanking = "Very unhealthy";
            return mRanking;
        } else if (mIndex >= 301) {
            mRanking = "Hazardous";
            return mRanking;
        }
        return "Ranking";
    }
}
