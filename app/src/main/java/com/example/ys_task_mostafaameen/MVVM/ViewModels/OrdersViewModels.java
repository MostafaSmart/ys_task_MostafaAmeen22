package com.example.ys_task_mostafaameen.MVVM.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderResponse;
import com.example.ys_task_mostafaameen.data.Repositorys.OrderRepository;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderUpdateResponse;

public class OrdersViewModels extends ViewModel {


    private MutableLiveData<OrderResponse> orderResponseMutableLiveData;

    private MutableLiveData<OrderUpdateResponse> updateResponseMutableLiveData;

    private OrderRepository orderRepository;

    public OrdersViewModels(OrderRepository orderRepository) {
        this.orderResponseMutableLiveData = new MutableLiveData<>();
        this.updateResponseMutableLiveData = new MutableLiveData<>();
        this.orderRepository=orderRepository;
    }

    public void getAllOrders (GetAllOrderRequest getAllOrderRequest){
        orderRepository.getAllOrders(getAllOrderRequest).observeForever(response -> orderResponseMutableLiveData.setValue(response));
    }

    public void setUpdateResponseMutableLiveData (UpdateOrderRequest updateOrderRequest){
        orderRepository.updateOrder(updateOrderRequest).observeForever(response -> updateResponseMutableLiveData.setValue(response));
    }


    public LiveData<OrderResponse> getAllOrdersResponse() {
        return orderResponseMutableLiveData;
    }

    public MutableLiveData<OrderUpdateResponse> getUpdateResponseMutableLiveData() {
        return updateResponseMutableLiveData;
    }
}
