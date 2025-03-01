package com.example.ys_task_mostafaameen.data.Retrofit;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderResponse;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderUpdateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OrdersApi {

    @POST("Order/GetOrders")
    Call<OrderResponse> getAllOrders(@Body GetAllOrderRequest orderRequest);


    @POST("Order/SetOrderProcessed")
    Call<OrderUpdateResponse> UpdateOrder(@Body UpdateOrderRequest updateOrderRequest);




}
