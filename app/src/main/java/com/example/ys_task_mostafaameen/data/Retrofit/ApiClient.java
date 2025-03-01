package com.example.ys_task_mostafaameen.data.Retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//     static final String BASE_URL = "http://mdev.yemensoft.net:8087/OnyxRmsService/api/OnyxChef/";
    private static final String BASE_URL = "http://192.168.43.122/cheef/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}