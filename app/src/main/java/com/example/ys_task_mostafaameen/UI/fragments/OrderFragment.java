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
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderResponse;
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
    private GetOrderAdabter adabter ;
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


//        OrderRepository orderRepository = new OrderRepository();
//        OrdersViewModelFactory authViewModelFactory = new OrdersViewModelFactory(orderRepository);
//
//        ordersViewModels = new ViewModelProvider(this,authViewModelFactory).get(OrdersViewModels.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_order, container, false);



        implmnet(view);
        setupViewModel();
        setUpUpdateViewModel();


        return view;
    }


    private void setUpUpdateViewModel(){
        ordersViewModels.getUpdateResponseMutableLiveData().observe(getViewLifecycleOwner(), orderResponse -> {
            if (orderResponse != null && orderResponse.getResult() != null) {
                ResultResponse result = orderResponse.getResult();
                if(result.getErrNo() ==0){
                    Utils.showCustomSnackbar(requireContext(), requireView(), "The Order Is update !",1);

                }
                else{
                    Utils.showCustomSnackbar(requireContext(), requireView(), "The Order Is not update X",0);

                }

            }
        });
    }

    private void setupViewModel() {

        updateOrdersRunnable = new Runnable() {
            @Override
            public void run() {
                fetchOrders();
                handler.postDelayed(this, 30000);
            }
        };
        handler.post(updateOrdersRunnable);



        ordersViewModels.getAllOrdersResponse().observe(getViewLifecycleOwner(), orderResponse -> {
            if (orderResponse != null && orderResponse.getData() != null) {
                OrderResponse.Data dd=    orderResponse.getData();

                List<OrderMaster> orders =  dd.getOrderMasterList();

                if(orders !=null){
                    Log.d("Couns :", String.valueOf(orders.size()));
                    textEmptyMasseg.setVisibility(View.GONE);

                    if (adabter == null) {

                        adabter = new GetOrderAdabter(orders, order -> {
                            ordersViewModels.setUpdateResponseMutableLiveData(order);
                        });
                        orderRecyclerView.setAdapter(adabter);
                    } else {
                        adabter.updateOrders(orders);
                    }

                    btnNext.setOnClickListener(v ->
                    {
                        adabter.loadMore();
                    });

                    btnPrevious.setOnClickListener(v -> {
                        adabter.loadPrevious();
                    });
                }
                else{
                    textEmptyMasseg.setVisibility(View.VISIBLE);

                }


            }
        });
    }
    private void fetchOrders() {
        GetAllOrderRequest.ValueGetOrder value = new GetAllOrderRequest.ValueGetOrder("87", "1", "4", "2");
        GetAllOrderRequest request = new GetAllOrderRequest(value);
        ordersViewModels.getAllOrders(request);
    }
    private void implmnet(View view) {
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
}