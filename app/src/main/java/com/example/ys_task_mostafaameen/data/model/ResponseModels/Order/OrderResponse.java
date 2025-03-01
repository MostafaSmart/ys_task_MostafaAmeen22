package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class OrderResponse {
    @SerializedName("Data")
    private Data data;

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public static class Data {
        @SerializedName("OrderMasterList")
        private List<OrderMaster> orderMasterList;

        public List<OrderMaster> getOrderMasterList() { return orderMasterList; }
        public void setOrderMasterList(List<OrderMaster> orderMasterList) { this.orderMasterList = orderMasterList; }
    }
}



