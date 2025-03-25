package com.example.ys_task_mostafaameen.data.Repositorys;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.function.Consumer;

import com.example.ys_task_mostafaameen.data.model.RequestModels.BaseRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginValue;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
//import com.example.ys_task_mostafaameen.data.Api.RequestModels
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;
import com.example.ys_task_mostafaameen.data.model.UserData;
import com.example.ys_task_mostafaameen.data.Retrofit.LoginApi;
//import com.example.ys_task_mostafaameen.data.Room.Entity.UserDataRoom;
import com.example.ys_task_mostafaameen.data.Room.User.Helpers.UserDatabaseHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Singleton
public class LoginRepository {
    private final LoginApi api;
    private final UserDatabaseHelper dbHelper;
    private final ExecutorService executorService;


    @Inject
    public LoginRepository(LoginApi api, UserDatabaseHelper dbHelper) {
        this.api = api;
        this.dbHelper = dbHelper;
        this.executorService = Executors.newSingleThreadExecutor();

    }

    public LiveData<ResponseBaseModel<LoginData>> login (BaseRequest<LoginValue>  authRequest){

        MutableLiveData<ResponseBaseModel<LoginData>> data = new MutableLiveData<>();

        Call<ResponseBaseModel<LoginData>> call = api.login(authRequest);

        call.enqueue(new Callback<ResponseBaseModel<LoginData>>() {
            @Override
            public void onResponse(Call<ResponseBaseModel<LoginData>> call, Response<ResponseBaseModel<LoginData>> response) {
                if (response.isSuccessful() && response.body() != null) {
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
    public void insertUserLoacl(UserData userData) {
        executorService.execute(() -> dbHelper.insertUser(userData));
    }

    public LiveData<UserData> getCurrentUser() {
        return dbHelper.getCurrentUserLiveData();
    }


    public void logout(Runnable callback) {
        dbHelper.logout(callback);
    }

    public LiveData<Integer> getUserCount() {
        return dbHelper.getUserCount();
    }

}
