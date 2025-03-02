package com.example.ys_task_mostafaameen.data.Room.Helpers;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ys_task_mostafaameen.data.model.UserData;
import com.example.ys_task_mostafaameen.data.Room.AppDatabase;
import com.example.ys_task_mostafaameen.data.Room.Dao.UserDao;

import javax.inject.Inject;

public class UserDatabaseHelper {

    private final UserDao userDao;

    @Inject
    public UserDatabaseHelper(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser(UserData userData) {
        AsyncTask.execute(() -> userDao.insertUser(userData));
    }

    public UserData getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public LiveData<UserData> getCurrentUserLiveData() {
        return userDao.getCurrentUser();
    }

    public void logout() {
         userDao.deleteAllUsers();
    }


    public int getUserCount(){

        return userDao.getUserCount();
    }




}
