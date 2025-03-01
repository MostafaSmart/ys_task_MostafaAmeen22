package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import java.util.List;

import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResultResponse;
import com.google.gson.annotations.SerializedName;

public class OrderResponse {
    @SerializedName("Data")
    private Data data;

    @SerializedName("Result")
    private ResultResponse result;


    public void setResult(ResultResponse result) {
        this.result = result;
    }

    public ResultResponse getResult() {
        return result;
    }
    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public static class Data {
        @SerializedName("OrderMasterList")
        private List<OrderMaster> orderMasterList;

        public List<OrderMaster> getOrderMasterList() { return orderMasterList; }
        public void setOrderMasterList(List<OrderMaster> orderMasterList) { this.orderMasterList = orderMasterList; }
    }
}



