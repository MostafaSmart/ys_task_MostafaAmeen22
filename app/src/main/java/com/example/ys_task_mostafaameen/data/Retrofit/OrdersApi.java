package com.example.ys_task_mostafaameen.data.Retrofit;

import com.example.ys_task_mostafaameen.data.model.RequestModels.BaseRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderListData;

import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface OrdersApi {
//    @POST("Order/GetOrders")
//    Call<OrderResponse> getAllOrders(@Body GetAllOrderRequest orderRequest);
//
//
//    @POST("Order/SetOrderProcessed")
//    Call<OrderUpdateResponse> UpdateOrder(@Body UpdateOrderRequest updateOrderRequest);
//

    @POST("tables.php?action=GetOrders")
    Call<ResponseBaseModel<OrderListData>> getAllOrders(@Body BaseRequest<GetAllOrderRequest> request);


    @POST("tables.php?action=SetOrderProcessed")
    Call<ResponseBaseModel<OrderListData>> UpdateOrder(@Body BaseRequest<UpdateOrderRequest> updateOrderRequest);

}
