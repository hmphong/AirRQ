package com.example.airrq.repository.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AirKey  {
    @PrimaryKey(autoGenerate = true)
    public long nameId;
    @ColumnInfo
    public String name;
    public String air_index;
    public String ranking;
    public String time;
}
