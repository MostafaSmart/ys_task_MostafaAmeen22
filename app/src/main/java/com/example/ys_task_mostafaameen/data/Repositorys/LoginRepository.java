package com.example.ys_task_mostafaameen.data.Repositorys;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginResponse;
//import com.example.ys_task_mostafaameen.data.Api.RequestModels
import com.example.ys_task_mostafaameen.data.model.UserData;
import com.example.ys_task_mostafaameen.data.Retrofit.ApiClient;
import com.example.ys_task_mostafaameen.data.Retrofit.LoginApi;
//import com.example.ys_task_mostafaameen.data.Room.Entity.UserDataRoom;
import com.example.ys_task_mostafaameen.data.Room.Helpers.UserDatabaseHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {


    private LoginApi api;
    private Context context;
    UserDatabaseHelper dbHelper ;

    public LoginRepository(Context context) {
        this.api = ApiClient.getClient().create(LoginApi.class);
        this.context = context;
        dbHelper= new UserDatabaseHelper(context);
    }

    public LiveData<LoginResponse> login (LoginRequest authRequest){

        MutableLiveData<LoginResponse> data = new MutableLiveData<>();
        Log.d("data_request" ,authRequest.getValue().getUnitNo() + " " +authRequest.getValue().getPassword());

        Call<LoginResponse> call = api.login(authRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("API_RESPONSE", response.toString());

                    LoginData dd =  response.body().getData();
                    Log.d("API_RESPONSE22", dd.toString());
                    UserData userData = dd.getUserData();

                    UserData user = new UserData();

                    user.setUserId("123");
                    user.setAdminName("Admin");
                    user.setPassword("pass123");
                    user.setLogin("adminLogin");
                    user.setTerminalNo("1001");
                    user.setTerminalName("Terminal A");
                 dbHelper.insertUser(user);



                    data.setValue(response.body());

                } else {

                    Log.d("API_RESPONSE", response.toString());
                    data.setValue(null);
                }

            }

            @Override

            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("API_ERROR", t.getMessage());
                data.setValue(null);

            }

        });

        return data;
    }




}
