package com.example.ys_task_mostafaameen.UI.home.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ys_task_mostafaameen.adapters.GetOrderAdabter;
import com.example.ys_task_mostafaameen.data.model.RequestModels.BaseRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderMaster;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResultResponse;
import com.example.ys_task_mostafaameen.databinding.FragmentOrderBinding;
import com.example.ys_task_mostafaameen.helpers.Utils;

import java.util.List;


import dagger.hilt.android.AndroidEntryPoint;
@AndroidEntryPoint
public class OrderFragment extends Fragment {

    private GetOrderAdabter adapter ;

    private final Handler handler = new Handler();
    private Runnable updateOrdersRunnable;

    private FragmentOrderBinding binding;

    private OrdersViewModels ordersViewModels;
    public OrderFragment() {
    }

    public static OrderFragment newInstance() {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ordersViewModels = new ViewModelProvider(this).get(OrdersViewModels.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        initializeViews();
        setupViewModels();
        setupAutoRefresh();

        binding.btnRefresh.setOnClickListener(v -> fetchOrders());

        return binding.getRoot();
    }

    private void setupViewModels() {
        observeOrders();
        observeOrderUpdates();
    }

    private void setupAutoRefresh() {
        updateOrdersRunnable = new Runnable() {
            @Override
            public void run() {
                fetchOrders();
                handler.postDelayed(this, 30000);
            }
        };
        handler.post(updateOrdersRunnable);
    }


    private void observeOrderUpdates() {
        ordersViewModels.getUpdateResponseMutableLiveData().observe(getViewLifecycleOwner(), orderResponse -> {
            if (orderResponse == null || orderResponse.getResult() == null) return;

            ResultResponse result = orderResponse.getResult();
            String message = (result.getErrNo() == 0) ? "The Order is updated!" : "The Order update failed!";
            int status = (result.getErrNo() == 0) ? 1 : 0;
            Utils.showCustomSnackbar(requireContext(), requireView(), message, status);
        });
    }

    private void observeOrders() {
        ordersViewModels.getAllOrdersResponse().observe(getViewLifecycleOwner(), orderResponse -> {
            if (orderResponse == null || orderResponse.getData() == null || orderResponse.getResult().getErrNo() != 0) {
                binding.textEmptyMasseg.setVisibility(View.VISIBLE);
                return;
            }

            List<OrderMaster> orders = orderResponse.getData().getOrderMasterList();
            if (orders == null || orders.isEmpty()) {
                binding.textEmptyMasseg.setVisibility(View.VISIBLE);
            } else {
                binding.textEmptyMasseg.setVisibility(View.GONE);
                if (adapter == null) {
                    adapter = new GetOrderAdabter(orders, ordersViewModels::setUpdateResponseMutableLiveData);
                    binding.orderRecyclerView.setAdapter(adapter);
                } else {
                    adapter.updateOrders(orders);
                }

                binding.btnNext.setOnClickListener(v -> adapter.loadMore());
                binding.btnPrevious.setOnClickListener(v -> adapter.loadPrevious());
            }
        });
    }

    private void fetchOrders() {
        GetAllOrderRequest value = new GetAllOrderRequest("87", "1", "4", "2");

        BaseRequest<GetAllOrderRequest> request = new BaseRequest(value);

        ordersViewModels.getAllOrders(request);
    }
    private void initializeViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateOrdersRunnable);
    }
}