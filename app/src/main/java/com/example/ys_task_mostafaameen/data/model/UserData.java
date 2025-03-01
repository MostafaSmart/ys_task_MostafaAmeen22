package com.example.ys_task_mostafaameen.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user_data")
public class UserData {
    @NonNull
    @PrimaryKey
    @SerializedName("U_ID")
    @ColumnInfo(name = "user_id")
    private String userId;

    @SerializedName("مدير النظام")
    @ColumnInfo(name = "admin_name")
    private String adminName;

    @SerializedName("PASSWORD")
    @ColumnInfo(name = "password")
    private String password;

    @SerializedName("LOGIN")
    @ColumnInfo(name = "login")
    private String login;

    @SerializedName("TRMNL_NO")
    @ColumnInfo(name = "terminal_no")
    private String terminalNo;

    @SerializedName("TRMNL_NM")
    @ColumnInfo(name = "terminal_name")
    private String terminalName;

    // Getters and Setters
    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId='" + userId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", terminalNo='" + terminalNo + '\'' +
                ", terminalName='" + terminalName + '\'' +
                '}';
    }
}
