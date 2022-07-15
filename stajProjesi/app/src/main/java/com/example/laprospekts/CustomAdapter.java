package com.example.laprospekts;

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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    ArrayList<Ilaclar> ilacList;
    Context context;
    ViewHolder viewHolder;
    LayoutInflater layoutInflater;

    public CustomAdapter(ArrayList<Ilaclar> ilacList, Context context){
        this.ilacList = ilacList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        layoutInflater = layoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_ilaclar, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        int src = context.getResources().getIdentifier("s" + ilacList.get(position).getBarkod(), "mipmap", context.getPackageName());
        holder.ilacImg.setImageResource(src);
        holder.ilacAdTv.setText(ilacList.get(position).getIlacAdi());

        holder.ilacAdTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,bilgiGoster.class);
                intent.putExtra("barkod", ilacList.get(position).getBarkod());
                context.startActivity(intent);
            }
        });
        holder.ilacImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,bilgiGoster.class);
                intent.putExtra("barkod", ilacList.get(position).getBarkod());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return ilacList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ilacImg;
        TextView ilacAdTv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            ilacImg = itemView.findViewById(R.id.ilacImg);
            ilacAdTv = itemView.findViewById(R.id.ilacAd);
        }
    }
}
