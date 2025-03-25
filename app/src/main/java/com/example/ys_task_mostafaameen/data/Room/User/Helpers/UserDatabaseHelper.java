package com.example.ys_task_mostafaameen.data.Room.User.Helpers;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.ys_task_mostafaameen.data.Room.User.Dao.UserDao;
import com.example.ys_task_mostafaameen.data.model.UserData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class UserDatabaseHelper {

    private final UserDao userDao;
    private final ExecutorService executorService;

    @Inject
    public UserDatabaseHelper(UserDao userDao) {
        this.userDao = userDao;
        this.executorService = Executors.newSingleThreadExecutor();

    }

    public void insertUser(UserData userData) {
        executorService.execute(() -> userDao.insertUser(userData));
    }

    

    public UserData getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public LiveData<UserData> getCurrentUserLiveData() {
        return userDao.getCurrentUser();
    }


    public void logout(Runnable callback) {
        executorService.execute(() -> {
            userDao.deleteAllUsers();
            new Handler(Looper.getMainLooper()).post(callback);
        });
    }
    public  LiveData<Integer> getUserCount() {
        return userDao.getUserCount();
    }




}
