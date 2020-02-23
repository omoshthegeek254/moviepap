package com.example.movie101.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie101.R;
import com.example.movie101.models.Series;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private  Context mContext;
    private  List<Series> mData;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_item_movie,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_series.setText(mData.get(position).getTitle());
        holder.iv_series.setImageResource(mData.get(position).getPoster() );

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_series;
        ImageView iv_series;
        public MyViewHolder(View itemView){
            super(itemView);
            tv_series=(TextView) itemView.findViewById(R.id.movie_title);
            iv_series=(ImageView) itemView.findViewById(R.id.movie_poster);
        }

    }
}




