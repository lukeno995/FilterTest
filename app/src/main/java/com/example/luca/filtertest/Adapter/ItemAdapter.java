package com.example.luca.filtertest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.example.luca.filtertest.Model.FilterPassenger;
import com.example.luca.filtertest.R;
import com.example.luca.filtertest.DataStorage.SharedClass;

import java.util.ArrayList;


/**
 * Created by Luca on 19/02/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<FilterPassenger> passengerList;
    private Context  ctx;
    public ItemAdapter(ArrayList<FilterPassenger> filterList , Context ctx) {
        this.passengerList =  filterList;
        this.ctx = ctx;

    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list_dialog_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        final FilterPassenger item = passengerList.get(position);
        holder.sw.setChecked(item.isCheck());
        holder.tx.setText(item.getNome());
        holder.sw.setSelected(item.isCheck());
        holder.sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    SharedClass.changeCheck(item , ctx);
                }else{
                    SharedClass.changeCheck(item , ctx);
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return passengerList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder  {
        public Switch sw;
        public TextView tx;

        public ViewHolder(View itemView) {
            super(itemView);
            sw =  itemView.findViewById(R.id.sw);
            tx = itemView.findViewById(R.id.textView);

        }

    }
}
