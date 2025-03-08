package com.example.ys_task_mostafaameen.data.Room.Settings;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


@Dao
public interface SettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SettingsEntity settings);

    @Query("SELECT value FROM settings WHERE key = :key LIMIT 1")
    LiveData<String> getLanguage(String key);
}