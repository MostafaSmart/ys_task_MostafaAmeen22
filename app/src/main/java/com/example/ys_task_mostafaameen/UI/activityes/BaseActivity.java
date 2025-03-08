package com.example.ys_task_mostafaameen.UI.activityes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ys_task_mostafaameen.MVVM.ViewModels.SettingsViewModel;
import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.helpers.LocaleHelper;

import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BaseActivity extends AppCompatActivity {
    SettingsViewModel settingsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        settingsViewModel.getLanguage().observe(this, language -> {
            if (language != null) {
                LocaleHelper.setLocale(this,language);
            }
            else{
                settingsViewModel.setLanguage();
            }
        });
        setContentView(R.layout.activity_base);

    }

    public void applyLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}