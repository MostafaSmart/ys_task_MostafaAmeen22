package com.example.ys_task_mostafaameen.data.Repositorys;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
//import com.example.ys_task_mostafaameen.data.Api.RequestModels
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;
import com.example.ys_task_mostafaameen.data.model.UserData;
import com.example.ys_task_mostafaameen.data.Retrofit.LoginApi;
//import com.example.ys_task_mostafaameen.data.Room.Entity.UserDataRoom;
import com.example.ys_task_mostafaameen.data.Room.User.Helpers.UserDatabaseHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Singleton
public class LoginRepository {
    private final LoginApi api;
    private final UserDatabaseHelper dbHelper;

    @Inject
    public LoginRepository(LoginApi api, UserDatabaseHelper dbHelper) {
        this.api = api;
        this.dbHelper = dbHelper;
    }

    public LiveData<ResponseBaseModel<LoginData>> login (LoginRequest authRequest){

        MutableLiveData<ResponseBaseModel<LoginData>> data = new MutableLiveData<>();
        Log.d("data_request" ,authRequest.getValue().getUnitNo() + " " +authRequest.getValue().getPassword());

        Call<ResponseBaseModel<LoginData>> call = api.login(authRequest);

        call.enqueue(new Callback<ResponseBaseModel<LoginData>>() {
            @Override
            public void onResponse(Call<ResponseBaseModel<LoginData>> call, Response<ResponseBaseModel<LoginData>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("API_RESPONSE", response.body().toString());

                    LoginData dd =  response.body().getData();
                    Log.d("API_RESPONSE22", dd.toString());
                    setUserSave(dd.getUserData());


                    data.setValue(response.body());

                } else {

                    Log.d("API_RESPONSE", response.toString());
                    data.setValue(null);
                }

            }

            @Override

            public void onFailure(Call<ResponseBaseModel<LoginData>> call, Throwable t) {
                Log.d("API_ERROR", t.getMessage());
                data.setValue(null);

            }

        });

        return data;
    }

    public LiveData<UserData> getCurrentUserLiveData() {
        return dbHelper.getCurrentUserLiveData();
    }

    private void setUserSave(UserData userData) {
        UserData user = new UserData();

        user.setUserId(userData.getUserId());
        user.setAdminName(userData.getAdminName());
        user.setPassword(userData.getPassword());
        user.setLogin(userData.getLogin());
        user.setTerminalNo(userData.getTerminalNo());
        user.setTerminalName(userData.getTerminalName());
        dbHelper.insertUser(user);
    }


    public boolean logout(){
        dbHelper.logout();
        return dbHelper.getUserCount()==0;
    }


}
