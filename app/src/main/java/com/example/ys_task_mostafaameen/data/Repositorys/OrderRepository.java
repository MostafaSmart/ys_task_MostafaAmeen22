package com.example.ys_task_mostafaameen.data.Repositorys;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderResponse;
import com.example.ys_task_mostafaameen.data.Retrofit.ApiClient;
import com.example.ys_task_mostafaameen.data.Retrofit.OrdersApi;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderUpdateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository{


    private OrdersApi api;

    public OrderRepository() {
        this.api = ApiClient.getClient().create(OrdersApi.class);
    }

    public LiveData<OrderResponse> getAllOrders (GetAllOrderRequest orderRequest){

        MutableLiveData<OrderResponse> data = new MutableLiveData<>();
        Log.d("data_request" ,orderRequest.toString() );

        Call<OrderResponse> call = api.getAllOrders(orderRequest);

        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("API_RESPONSE", response.body().getData().toString());

                    data.setValue(response.body());

                } else {

                    Log.d("API_RdddESPONSE", response.toString());
                    data.setValue(null);
                }

            }

            @Override

            public void onFailure(Call<OrderResponse> call, Throwable t) {
                Log.d("API_ERROR", t.getMessage());
                data.setValue(null);

            }

        });

        return data;
    }



    public LiveData<OrderUpdateResponse> updateOrder (UpdateOrderRequest updateOrderRequest){

        MutableLiveData<OrderUpdateResponse> data = new MutableLiveData<>();
        Log.d("data_request" ,updateOrderRequest.getValue().getP_ORDR_SRL().toString() );

        Call<OrderUpdateResponse> call = api.UpdateOrder(updateOrderRequest);

        call.enqueue(new Callback<OrderUpdateResponse>() {
            @Override
            public void onResponse(Call<OrderUpdateResponse> call, Response<OrderUpdateResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("OrderUpdateResponse", response.body().toString());

                    data.setValue(response.body());

                } else {

                    Log.d("OrderUpdateResponse2", response.toString());
                    data.setValue(null);
                }

            }

            @Override

            public void onFailure(Call<OrderUpdateResponse> call, Throwable t) {
                Log.d("OrderUpdate_ERROR", t.getMessage());
                data.setValue(null);

            }

        });

        return data;
    }





}
