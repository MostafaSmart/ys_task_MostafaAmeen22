package com.example.ys_task_mostafaameen.MVVM.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderListData;
import com.example.ys_task_mostafaameen.data.Repositorys.OrderRepository;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class OrdersViewModels extends ViewModel {


    private MutableLiveData<ResponseBaseModel<OrderListData>> orderResponseMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<ResponseBaseModel<OrderListData>> updateResponseMutableLiveData = new MutableLiveData<>();

    private OrderRepository orderRepository;
    @Inject
    public OrdersViewModels(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void getAllOrders (GetAllOrderRequest getAllOrderRequest){
        orderRepository.getAllOrders(getAllOrderRequest).observeForever(response -> orderResponseMutableLiveData.setValue(response));
    }

    public void setUpdateResponseMutableLiveData (UpdateOrderRequest updateOrderRequest){
        orderRepository.updateOrder(updateOrderRequest).observeForever(response -> updateResponseMutableLiveData.setValue(response));
    }


    public LiveData<ResponseBaseModel<OrderListData>> getAllOrdersResponse() {
        return orderResponseMutableLiveData;
    }

    public MutableLiveData<ResponseBaseModel<OrderListData>> getUpdateResponseMutableLiveData() {
        return updateResponseMutableLiveData;
    }
}
