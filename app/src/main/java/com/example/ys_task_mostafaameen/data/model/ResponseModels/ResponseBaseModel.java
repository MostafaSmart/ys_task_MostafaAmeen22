package com.example.ys_task_mostafaameen.data.model.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class ResponseBaseModel<T> {
    @SerializedName("Data")
    private T Data;
    @SerializedName("Result")
    private ResultResponse Result;

    public ResponseBaseModel(T data, ResultResponse result) {
        this.Data = data;
        this.Result = result;
    }

    public T getData() {
        return Data;
    }

    public ResultResponse getResult() {
        return Result;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "Data=" + (Data != null ? Data.toString() : "null") +
                ", Result=" + (Result != null ? Result.toString() : "null") +
                '}';
    }
}
