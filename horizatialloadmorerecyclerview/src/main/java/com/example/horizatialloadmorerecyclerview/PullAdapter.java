package com.example.horizatialloadmorerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by limiao on 2018/8/13.
 */
public class PullAdapter extends RecyclerView.Adapter<PullAdapter.PullViewHolder>{

    private Context mContext;
    private List<String> data;


    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(String str){
        data.add(str);
        notifyDataSetChanged();
    }


    public PullAdapter() {
    }

    public PullAdapter(Context context, List<String> data) {
        mContext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PullViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        PullViewHolder holder = new PullViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PullViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class PullViewHolder extends RecyclerView.ViewHolder{

        public PullViewHolder(View itemView) {
            super(itemView);
        }
    }
}
