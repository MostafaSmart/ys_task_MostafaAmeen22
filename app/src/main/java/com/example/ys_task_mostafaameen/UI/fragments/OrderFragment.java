package com.example.ys_task_mostafaameen.UI.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ys_task_mostafaameen.MVVM.ViewModels.OrdersViewModels;
import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.adapters.GetOrderAdabter;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.GetAllOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderMaster;
import com.example.ys_task_mostafaameen.data.Repositorys.OrderRepository;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResultResponse;
import com.example.ys_task_mostafaameen.helpers.Utils;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
@AndroidEntryPoint
public class OrderFragment extends Fragment {
    private Button btnRefresh;
    private TextView trxtTitsl;
    private GetOrderAdabter adapter ;
    private ImageButton btnNext;
    private LinearLayout cardHed;
    private final Handler handler = new Handler();
    private Runnable updateOrdersRunnable;
    private ImageButton btnPrevious;
    private TextView textEmptyMasseg;
    private androidx.recyclerview.widget.RecyclerView orderRecyclerView;

    @Inject
    OrderRepository orderRepository;
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
        View view=  inflater.inflate(R.layout.fragment_order, container, false);

        initializeViews(view);
        setupViewModels();
        setupAutoRefresh();

        btnRefresh.setOnClickListener(v -> fetchOrders());

        return view;
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
                textEmptyMasseg.setVisibility(View.VISIBLE);
                return;
            }

            List<OrderMaster> orders = orderResponse.getData().getOrderMasterList();
            if (orders == null || orders.isEmpty()) {
                textEmptyMasseg.setVisibility(View.VISIBLE);
            } else {
                textEmptyMasseg.setVisibility(View.GONE);
                if (adapter == null) {
                    adapter = new GetOrderAdabter(orders, ordersViewModels::setUpdateResponseMutableLiveData);
                    orderRecyclerView.setAdapter(adapter);
                } else {
                    adapter.updateOrders(orders);
                }

                btnNext.setOnClickListener(v -> adapter.loadMore());
                btnPrevious.setOnClickListener(v -> adapter.loadPrevious());
            }
        });
    }

    private void fetchOrders() {
        GetAllOrderRequest.ValueGetOrder value = new GetAllOrderRequest.ValueGetOrder("87", "1", "4", "2");
        GetAllOrderRequest request = new GetAllOrderRequest(value);
        ordersViewModels.getAllOrders(request);
    }
    private void initializeViews(View view) {
        cardHed = view.findViewById(R.id.cardHed);
        btnNext = view.findViewById(R.id.btnNext);
        trxtTitsl = view.findViewById(R.id.trxtTitsl);
        btnRefresh = view.findViewById(R.id.btnRefresh);
        btnPrevious = view.findViewById(R.id.btnPrevious);
        orderRecyclerView = view.findViewById(R.id.orderRecyclerView);
        textEmptyMasseg = view.findViewById(R.id.textEmptyMasseg);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        orderRecyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateOrdersRunnable);
    }
}