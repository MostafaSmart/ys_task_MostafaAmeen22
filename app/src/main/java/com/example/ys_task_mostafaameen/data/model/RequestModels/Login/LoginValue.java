package com.example.ys_task_mostafaameen.data.model.RequestModels.Login;

import com.google.gson.annotations.SerializedName;

public class LoginValue {
    @SerializedName("UNT_NO")
    private String unitNo;

    @SerializedName("P_LANG_NO")
    private String languageNo;

    @SerializedName("P_PASSWORD")
    private String password;

    public LoginValue(String unitNo, String languageNo, String password) {
        this.unitNo = unitNo;
        this.languageNo = languageNo;
        this.password = password;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getLanguageNo() {
        return languageNo;
    }

    public void setLanguageNo(String languageNo) {
        this.languageNo = languageNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
