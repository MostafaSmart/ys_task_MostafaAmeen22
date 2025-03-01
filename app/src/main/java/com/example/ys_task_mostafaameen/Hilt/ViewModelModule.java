package com.example.ys_task_mostafaameen.Hilt;


import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public class ViewModelModule {

    @Provides
    public static ViewModelProvider.Factory provideViewModelFactory(ViewModelProvider.Factory factory) {
        return factory;
    }
}