package com.example.ys_task_mostafaameen.adapters;


import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.data.model.RequestModels.BaseRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Order.UpdateOrderRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderMaster;

import java.util.List;

public class GetOrderAdabter extends RecyclerView.Adapter<GetOrderAdabter.OrderViewHolder> {

private List<OrderMaster> postList;
    private int visibleItemCount = 4;
    private OnOrderStatusChangeListener listener;


    public interface OnOrderStatusChangeListener {
        void onOrderStatusChange(BaseRequest<UpdateOrderRequest> order);
    }
public GetOrderAdabter(List<OrderMaster> postList,OnOrderStatusChangeListener listener) {
        this.postList = postList;
        this.listener = listener;

        }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);

        return new OrderViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        OrderMaster data = postList.get(position);

        holder.txtTime.setText(data.getBillTime());

        holder.txtTimee.setText(data.getPassedTime());

        holder.txtOrderState.setText("#order no: " + data.getBillNo());


        if ("محلي".equals(data.getBillDocTypeName())){
            holder.txtDine.setText("Dine in");

        }
        else{
            holder.txtDine.setText("Dine out");

        }

        if ("1".equals(data.getCancelFlag())) {
            holder.txtState.setText("Canceled");
            holder.txtState.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.gry));
            holder.colorItem.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.lite_gry));

            holder.txtOrderState.setPaintFlags(holder.txtOrderState.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            switch (data.getOrderStatus()) {
                case "1":
                    holder.txtState.setText("New");
                    holder.txtState.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));
                    holder.txtOrderState.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));

                    holder.colorItem.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.lite_green));
                    break;
                case "2":
                    holder.txtState.setText("Changed");
                    holder.txtState.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.primmery));
                    holder.txtOrderState.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.primmery));
                    holder.colorItem.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.lite_blue2));

                    break;
                case "3":
                    holder.txtState.setText("Delayed");
                    holder.txtState.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.pink));
                    holder.colorItem.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.lite_pink));

                    break;
                default:

                    break;
            }
        }


          if ("1".equals(data.getProcessedFlag())) {

            holder.btnPUPM.setVisibility(View.VISIBLE);
            holder.btnStartPrepp.setVisibility(View.GONE);
        }
          else if ("-1".equals(data.getProcessedFlag())){
              holder.btnPUPM.setVisibility(View.GONE);
              holder.btnStartPrepp.setVisibility(View.VISIBLE);
          }
          else{
              holder.btnPUPM.setVisibility(View.GONE);
              holder.btnStartPrepp.setVisibility(View.GONE);
          }



          if (data.getOrderDetails()!=null && data.getOrderDetails().size()>0){
              ProdactAdabters adabter = new ProdactAdabters(data.getOrderDetails());
              LinearLayoutManager layoutManager = new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.VERTICAL, false);
              holder.recyclerViewOnePr.setLayoutManager(layoutManager);
              holder.recyclerViewOnePr.setAdapter(adabter);
          }





        holder.btnPUPM.setOnClickListener(v -> {
            updateRequest(data.getOrderSerial());

        });


        holder.btnStartPrepp.setOnClickListener(v -> {
            updateRequest(data.getOrderSerial());

        });
    }

    private void updateRequest(String s_n) {
            UpdateOrderRequest value = new UpdateOrderRequest(s_n,"1","1","87");
        BaseRequest<UpdateOrderRequest> updateOrderRequest =new  BaseRequest(value);

            if (listener != null) {
                listener.onOrderStatusChange(updateOrderRequest);
            }

    }


    @Override
public int getItemCount() {

    return Math.min(visibleItemCount, postList.size());


        }

    public void loadMore() {
        if (visibleItemCount + 4 <= postList.size()) {
            visibleItemCount += 4;
            notifyDataSetChanged();
        }
    }

    public void loadPrevious() {
        if (visibleItemCount > 4) {
            visibleItemCount -= 4;
            notifyDataSetChanged();
        }
    }

    public void updateOrders(List<OrderMaster> newOrders) {
        this.postList.clear();
        this.postList.addAll(newOrders);
        notifyDataSetChanged();
    }
static class OrderViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTime;
    private TextView txtDine;
    private TextView txtState;
    private TextView txtTimee;
    private TextView txtOrderState;
    private android.widget.Button btnStartPrepp;
    private android.widget.Button btnPUPM;

    private CardView colorItem;
    private androidx.recyclerview.widget.RecyclerView recyclerViewOnePr;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);


        txtTime = itemView.findViewById(R.id.txtTime);
        txtDine = itemView.findViewById(R.id.txtDine);
        txtState = itemView.findViewById(R.id.txtState);
        txtTimee =itemView.findViewById(R.id.txtTimee);
        txtOrderState = itemView.findViewById(R.id.txtOrderState);
        recyclerViewOnePr = itemView.findViewById(R.id.recyclerViewOnePr);
        colorItem = itemView.findViewById(R.id.colorItem);


        btnPUPM = itemView.findViewById(R.id.btnPUPM);
        btnStartPrepp = itemView.findViewById(R.id.btnStartPrepp);

    }
}
}


