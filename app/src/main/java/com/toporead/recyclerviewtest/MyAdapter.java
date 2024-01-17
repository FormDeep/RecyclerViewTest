package com.toporead.recyclerviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> data;


    public MyAdapter(List<String> data){
        this.data=data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.deleteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,data.size());

            }
        });
        String item =data.get(position);
        holder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //recyclerview视图中的控件在这里绑定
        TextView textView;
        Button deleteBTN ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.recyclertextview);
            deleteBTN =itemView.findViewById(R.id.recyclerbtn);
        }
    }
}
