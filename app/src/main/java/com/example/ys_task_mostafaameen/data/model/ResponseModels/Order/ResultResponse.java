package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import com.google.gson.annotations.SerializedName;

public class ResultResponse {


    @SerializedName("ErrNo")
    private int errNo ;

    @SerializedName("ErrMsg")
    private String errMsg ;



    public void setErrNo(int errNo){this.errNo=errNo;}
    public int getErrNo(){return errNo;}


    public void setErrMsg(String errMsg){this.errMsg=errMsg;}
    public String getErrMsg(){return errMsg;}


}
