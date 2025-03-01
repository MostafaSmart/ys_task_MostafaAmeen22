package com.example.ys_task_mostafaameen.data.model.ResponseModels.Login;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("Data")
    private LoginData data;

    @SerializedName("Result")
    private Result result;

    public LoginData getData() { return data; }
    public void setData(LoginData data) { this.data = data; }
    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }
}

class Result {
    @SerializedName("ErrNo")
    private int errNo;

    @SerializedName("ErrMsg")
    private String errMsg;

    public int getErrNo() { return errNo; }
    public void setErrNo(int errNo) { this.errNo = errNo; }
    public String getErrMsg() { return errMsg; }
    public void setErrMsg(String errMsg) { this.errMsg = errMsg; }
}



//class Value {
//    @SerializedName("UNT_NO")
//    private String unitNo;
//
//    @SerializedName("P_LANG_NO")
//    private String languageNo;
//
//    @SerializedName("P_PASSWORD")
//    private String password;
//
//    public Value(String unitNo, String languageNo, String password) {
//        this.unitNo = unitNo;
//        this.languageNo = languageNo;
//        this.password = password;
//    }
//
//    public String getUnitNo() {
//        return unitNo;
//    }
//    public void setUnitNo(String unitNo) {
//        this.unitNo = unitNo;
//    }
//    public String getLanguageNo() {
//        return languageNo;
//    }
//    public void setLanguageNo(String languageNo) {
//        this.languageNo = languageNo;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }

