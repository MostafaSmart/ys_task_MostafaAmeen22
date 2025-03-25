package com.example.ys_task_mostafaameen.data.Repositorys;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ys_task_mostafaameen.data.model.RequestModels.BaseRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderListData;
import com.example.ys_task_mostafaameen.data.Retrofit.ApiClient;
import com.example.ys_task_mostafaameen.data.Retrofit.OrdersApi;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Singleton
public class OrderRepository{


    private final OrdersApi api;

    @Inject
    public OrderRepository(OrdersApi api) {
        this.api = api;
    }
    public LiveData<ResponseBaseModel<OrderListData>> getAllOrders ( BaseRequest<GetAllOrderRequest> request){

        MutableLiveData<ResponseBaseModel<OrderListData>> data = new MutableLiveData<>();
        Log.d("data_request" ,request.toString() );

        Call<ResponseBaseModel<OrderListData>> call = api.getAllOrders(request);

        call.enqueue(new Callback<ResponseBaseModel<OrderListData>>() {
            @Override
            public void onResponse(Call<ResponseBaseModel<OrderListData>> call, Response<ResponseBaseModel<OrderListData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    data.setValue(response.body());

                } else {
                    Log.d("API_RESPONSE", response.toString());
                    data.setValue(null);
                }

            }

            @Override

            public void onFailure(Call<ResponseBaseModel<OrderListData>> call, Throwable t) {
                Log.d("API_ERROR", t.getMessage());
                data.setValue(null);

            }

        });

        return data;
    }



    public LiveData<ResponseBaseModel<OrderListData>> updateOrder (BaseRequest<UpdateOrderRequest> updateOrderRequest){

        MutableLiveData<ResponseBaseModel<OrderListData>> data = new MutableLiveData<>();
        Call<ResponseBaseModel<OrderListData>> call = api.UpdateOrder(updateOrderRequest);

        call.enqueue(new Callback<ResponseBaseModel<OrderListData>>() {
            @Override
            public void onResponse(Call<ResponseBaseModel<OrderListData>> call, Response<ResponseBaseModel<OrderListData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API_RESPONSE:", response.body().getResult().getErrMsg().toString());
                    data.setValue(response.body());
                } else {
                    Log.d("API_RESPONSE", response.toString());
                    data.setValue(null);
                }

            }

            @Override

            public void onFailure(Call<ResponseBaseModel<OrderListData>> call, Throwable t) {
                Log.d("API_Error", t.getMessage());
                data.setValue(null);

            }

        });

        return data;
    }





}
