package com.example.ys_task_mostafaameen.data.Retrofit;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginResponse;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginApi {

//    @POST("User/GetUserDetails")
//    Call<LoginResponse> login(@Body LoginRequest authRequest);

    @POST("tables.php?action=GetUserDetails")
    Call<ResponseBaseModel<LoginData>> login(@Body LoginRequest authRequest);
}
