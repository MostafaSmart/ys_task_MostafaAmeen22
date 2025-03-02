package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderListData {
    @SerializedName("OrderMasterList")
    private List<OrderMaster> orderMasterList;

    public List<OrderMaster> getOrderMasterList() { return orderMasterList; }
    public void setOrderMasterList(List<OrderMaster> orderMasterList) { this.orderMasterList = orderMasterList; }
}
