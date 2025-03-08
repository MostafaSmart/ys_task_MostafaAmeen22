package com.example.ys_task_mostafaameen.data.Repositorys;

import androidx.lifecycle.LiveData;

import com.example.ys_task_mostafaameen.data.Room.AppDatabase;
import com.example.ys_task_mostafaameen.data.Room.Settings.SettingsDao;
import com.example.ys_task_mostafaameen.data.Room.Settings.SettingsEntity;

import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class SettingsRepository {
    private final SettingsDao settingsDao;

    @Inject
    public SettingsRepository(AppDatabase database) {
        this.settingsDao = database.settingsDao();
    }

    public void setLanguage(String language) {
        Executors.newSingleThreadExecutor().execute(() ->
                settingsDao.insert(new SettingsEntity("language", language))
        );
    }

    public LiveData<String> getLanguage() {
        return settingsDao.getLanguage("language");
    }
}
