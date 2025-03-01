package com.example.ys_task_mostafaameen.Hilt;

import com.example.ys_task_mostafaameen.data.Retrofit.ApiClient;
import com.example.ys_task_mostafaameen.data.Retrofit.OrdersApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public static OrdersApi provideOrdersApi() {
        return ApiClient.getClient().create(OrdersApi.class);
    }
}
