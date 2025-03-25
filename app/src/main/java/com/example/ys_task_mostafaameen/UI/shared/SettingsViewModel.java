package com.example.ys_task_mostafaameen.UI.shared;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ys_task_mostafaameen.data.Repositorys.SettingsRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class SettingsViewModel extends ViewModel {
    private final SettingsRepository repository;
    private final LiveData<String> language;

    @Inject
    public SettingsViewModel(SettingsRepository repository) {
        this.repository = repository;
        this.language = repository.getLanguage();
    }

    public String setLanguage(String laa) {
        repository.setLanguage(laa);

        return laa;
    }

    public LiveData<String> getLanguage() {
        return language;
    }
}
