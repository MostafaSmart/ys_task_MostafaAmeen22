package com.example.ys_task_mostafaameen.adapters;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Order.OrderDetail;

import java.util.List;

public class ProdactAdabters extends RecyclerView.Adapter<ProdactAdabters.ProdactViewHolder> {
    private List<OrderDetail> postList;
    public ProdactAdabters(List<OrderDetail> postList) {
        this.postList = postList;

    }

    @NonNull
    @Override
    public ProdactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prodact_item_order, parent, false);


        return new ProdactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdactViewHolder holder, int position) {
        OrderDetail data = postList.get(position);

        holder.txtProdect.setText(data.getItemName());

        holder.cardMAin.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.normal));

        if("1".equals(data.getCancelFlag())){

            holder.checkBox.setChecked(false);

            holder.txtProdect.setPaintFlags(holder.txtProdect.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.txtProdect.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.gry));
            holder.colorView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.gry));


        }

        else{
            switch (data.getItemStatus()) {
                case "1":
                    holder.colorView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));
                    break;
                case "2":
                    holder.colorView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.primmery));
                    break;
                case "3":
                    holder.colorView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.pink));

                    break;
                default:

                    break;
            }
        }


    }


    @Override
    public int getItemCount() {


    return postList.size();


    }


    static class ProdactViewHolder extends RecyclerView.ViewHolder {
        private View colorView;
        private CheckBox checkBox;
        private TextView txtProdect;
        private CardView cardMAin;



        public ProdactViewHolder(@NonNull View itemView) {
            super(itemView);



            checkBox = itemView.findViewById(R.id.checkBox);
            colorView = itemView.findViewById(R.id.colorView);
            txtProdect = itemView.findViewById(R.id.txtProdect);
            cardMAin = itemView.findViewById(R.id.cardMAin);

        }
    }
}