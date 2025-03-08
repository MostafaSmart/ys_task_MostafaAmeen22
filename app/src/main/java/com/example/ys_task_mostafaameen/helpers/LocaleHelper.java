package com.example.ys_task_mostafaameen.helpers;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import com.example.ys_task_mostafaameen.data.Room.AppDatabase;

import java.util.concurrent.Executors;
import java.util.Locale;

public class LocaleHelper {
    public static void setLocale(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);

        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}
