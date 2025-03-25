package com.example.ys_task_mostafaameen.data.model.RequestModels.Login;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginValue;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("Value")
    private LoginValue value;

    public LoginRequest(LoginValue value) {
        this.value = value;
    }

    public LoginValue getValue() {
        return value;
    }
    public void setValue(LoginValue value) {
        this.value = value;
    }
}

