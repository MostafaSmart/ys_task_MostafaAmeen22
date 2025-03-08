package com.example.ys_task_mostafaameen.data.Room.Settings;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "settings")
public class SettingsEntity {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    public String key;

    public String value;

    public SettingsEntity(@NonNull String key, String value) {
        this.key = key;
        this.value = value;
    }
}