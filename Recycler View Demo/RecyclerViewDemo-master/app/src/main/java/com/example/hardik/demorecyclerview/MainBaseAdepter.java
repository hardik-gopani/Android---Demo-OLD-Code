package com.example.hardik.demorecyclerview;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hardik on 22-05-2017.
 */

public class MainBaseAdepter extends RecyclerView.Adapter<MainBaseAdepter.MyViewHolder> {

    private List<MainItem> nameList;

    public MainBaseAdepter(List<MainItem> mainList) {
        nameList = mainList;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name,number;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.catv1);
            number = (TextView) view.findViewById(R.id.catv2);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custome_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MainItem name = nameList.get(position);
        holder.name.setText("Name : "+name.getName());
        holder.number.setText("Number : "+name.getNumber());
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}
