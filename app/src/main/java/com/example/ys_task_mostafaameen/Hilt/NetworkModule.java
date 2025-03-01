package com.example.ys_task_mostafaameen.Hilt;

import com.example.ys_task_mostafaameen.data.Repositorys.OrderRepository;
import com.example.ys_task_mostafaameen.data.Retrofit.ApiClient;
import com.example.ys_task_mostafaameen.data.Retrofit.LoginApi;
import com.example.ys_task_mostafaameen.data.Retrofit.OrdersApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//
//@Module
//@InstallIn(SingletonComponent.class)
//public class NetworkModule  {
//
//    @Provides
//    @Singleton
//    public static OrdersApi provideGetOrdersApi() {
//        return ApiClient.getClient().create(OrdersApi.class);
//    }
//
//    @Provides
//    @Singleton
//    public static OrderRepository provideOrdersRepository(OrdersApi ordersApi) { // تمرير OrdersApi هنا
//        return new OrderRepository(ordersApi);
//    }
//}
@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    private static final String BASE_URL = "http://192.168.43.122/cheef/";

    @Provides
    @Singleton
    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public static OrdersApi provideOrdersApi(Retrofit retrofit) {
        return retrofit.create(OrdersApi.class);
    }

    @Provides
    @Singleton
    public static LoginApi provideLoginApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }
}