package com.example.airrq.repository.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface AirAccess {
    @Insert(onConflict = REPLACE)
    void insertCity(AirKey airKey);

    @Update(onConflict = REPLACE)
    void updateCity(AirKey airKey);

    @Delete
    void deleteCity(AirKey airKey);

    @Query("SELECT * FROM AirKey")
    List<AirKey> findAllCitySync();
}
