package com.example.ys_task_mostafaameen.Hilt;


import android.content.Context;

import androidx.room.Room;

import com.example.ys_task_mostafaameen.data.Room.AppDatabase;
import com.example.ys_task_mostafaameen.data.Room.User.Dao.UserDao;
import com.example.ys_task_mostafaameen.data.Room.Settings.SettingsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                "app_database"
        ).fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public static UserDao provideUserDao(AppDatabase appDatabase) {
        return appDatabase.userDao();
    }

    @Provides
    @Singleton
    public static SettingsDao provideSettingsDao(AppDatabase database) {
        return database.settingsDao();
    }

}