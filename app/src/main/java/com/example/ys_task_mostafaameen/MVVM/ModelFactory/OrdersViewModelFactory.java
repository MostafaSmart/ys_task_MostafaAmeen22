package com.example.ys_task_mostafaameen.MVVM.ModelFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ys_task_mostafaameen.MVVM.ViewModels.OrdersViewModels;
import com.example.ys_task_mostafaameen.data.Repositorys.OrderRepository;

public class OrdersViewModelFactory implements ViewModelProvider.Factory {
    private final OrderRepository orderRepository;

    public OrdersViewModelFactory(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(OrdersViewModels.class)) {
            return (T) new OrdersViewModels(orderRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
