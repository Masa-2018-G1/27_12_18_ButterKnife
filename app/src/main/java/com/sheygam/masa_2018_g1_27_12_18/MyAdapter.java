package com.sheygam.masa_2018_g1_27_12_18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Callback callback;
    private List<String> list;

    public MyAdapter(){
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Title" + i);
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.titleTxt.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.titleTxt) TextView titleTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.row_container)
        public void onRowClick(){
            callback.onRowClick(getAdapterPosition());
        }
    }

    interface Callback{
        void onRowClick(int position);
    }
}
