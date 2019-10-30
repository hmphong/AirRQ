package com.example.airrq.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.airrq.GlobalApplication;
import com.example.airrq.model.AirModel;
import com.example.airrq.repository.database.AirRoomDatabase;
import com.example.airrq.repository.server.RetroRequest;

import java.util.List;

public class AirViewModel extends AndroidViewModel {
    private LiveData<AirModel> liveData;
    private ObservableField<AirModel> observableField = new ObservableField<>();
    private RetroRequest retroRequest = new RetroRequest();
    public AirViewModel(@NonNull Application application) {
        super(application);
        liveData = retroRequest.getDataApi();

    }
    public void setViewModel(AirModel airModel) {
        this.observableField.set(airModel);
        insertDB();
    }
    public String getCity(){
        return observableField.get().getmCity();
    }
    public String getTime(){
        return observableField.get().getmTime();
    }
    public String getAqi(){
        return observableField.get().getmIndex();
    }
    public String getRanking(){
        return observableField.get().getmRanking();
    }


    public LiveData<AirModel> getLiveModel(){
        return liveData;
    }

    public void insertDB(){
        AirRoomDatabase myAirRoom = AirRoomDatabase.getInMemoryDatabase(new GlobalApplication());
        myAirRoom.insertData(getCity(),getAqi(),getRanking(),getTime());
    }

    public List<RecyclerViewModel> getListToRecycler(){
        AirRoomDatabase myAirRoom = AirRoomDatabase.getInMemoryDatabase(new GlobalApplication());
        return myAirRoom.getDataToList();
    }
}
