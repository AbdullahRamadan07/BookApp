package com.example.finalrecycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList<Information> data;


    public CustomAdapter(Context context, ArrayList<Information> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.mycardview,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).images);
        holder.textView1.setText(data.get(position).name);
        holder.textView2.setText(data.get(position).author);

        int currentPosition = position;
        Information infodata = data.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SecondActvity.class);
                intent.putExtra("data1",Data.getData().get(position).name);
                intent.putExtra("data2",Data.getData().get(position).description);
                intent.putExtra("images",Data.getData().get(position).images);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeItem(infodata);
                return true;
            }
        });
    }
    private void removeItem(Information information){
        int currPosition = data.indexOf(information);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.myimageView);
        textView1 = itemView.findViewById(R.id.mytext1);
        textView2 = itemView.findViewById(R.id.mytext2);

    }
}
}
