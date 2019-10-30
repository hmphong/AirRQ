package com.example.airrq.repository.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.airrq.GlobalApplication;
import com.example.airrq.model.AirModel;
import com.example.airrq.viewmodel.RecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {AirKey.class}, version = 1, exportSchema = false)
public abstract class AirRoomDatabase extends RoomDatabase {
    public abstract AirAccess airAccess();

    private static AirRoomDatabase INSTANCE;

    public static AirRoomDatabase getInMemoryDatabase(GlobalApplication application) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(application.getAppContext(), AirRoomDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public void insertData(String city, String index, String ranking, String time){
        if (getRoomDB().size()==0){
            AirRoomDatabase airRoomDatabase = AirRoomDatabase.getInMemoryDatabase(new GlobalApplication());
            AirKey myKey = new AirKey();
            myKey.name = city;
            myKey.air_index = index;
            myKey.ranking = ranking;
            myKey.time = time;
            airRoomDatabase.airAccess().insertCity(myKey);
        } else {

        }
    }

    private List<AirKey> getRoomDB(){
        List<AirKey> list;
        AirRoomDatabase myData = AirRoomDatabase.getInMemoryDatabase(new GlobalApplication());
        list = myData.airAccess().findAllCitySync();
        return list;
    }
    public List<RecyclerViewModel> getDataToList(){
        List<RecyclerViewModel> myList = new ArrayList<>();
        for (int i = 0; i <getRoomDB().size() ; i++) {
            AirModel airModel = new AirModel();
            airModel.setmCity(getRoomDB().get(i).name);
            airModel.setmIndex(getRoomDB().get(i).air_index);
            airModel.setmRanking(getRoomDB().get(i).ranking);
            airModel.setmTime(getRoomDB().get(i).time);
            RecyclerViewModel recyclerViewModel = new RecyclerViewModel(airModel);
            myList.add(recyclerViewModel);
        }
        return myList;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
