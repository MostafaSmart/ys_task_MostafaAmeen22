package com.example.ys_task_mostafaameen.data.model.ResponseModels.Login;

import com.example.ys_task_mostafaameen.data.model.UserData;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("UserData")
    private UserData userData;

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "Data{" +
                "userData=" + userData +
                '}';
    }
}
