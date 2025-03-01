package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import com.google.gson.annotations.SerializedName;

public class OrderUpdateResponse {


    @SerializedName("Result")
    private ResultResponse result;


    public void setResult(ResultResponse result) {
        this.result = result;
    }

    public ResultResponse getResult() {
        return result;
    }
}
