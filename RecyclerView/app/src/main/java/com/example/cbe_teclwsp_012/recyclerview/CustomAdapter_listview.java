package com.example.cbe_teclwsp_012.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter_listview extends RecyclerView.Adapter<CustomAdapter_listview.MyViewHolder> {

    Context context;
    ArrayList<String> list;


    public CustomAdapter_listview(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_listview, null );

        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.name.setText(list.get(i));

    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        name= (TextView) itemView.findViewById(R.id.name);

        }
    }
}
