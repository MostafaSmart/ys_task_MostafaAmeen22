package com.example.ys_task_mostafaameen.data.Room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ys_task_mostafaameen.data.model.UserData;
import com.example.ys_task_mostafaameen.data.Room.User.Dao.UserDao;
import com.example.ys_task_mostafaameen.data.Room.Settings.SettingsDao;
import com.example.ys_task_mostafaameen.data.Room.Settings.SettingsEntity;


@Database(entities = {UserData.class, SettingsEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract SettingsDao settingsDao();


    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
