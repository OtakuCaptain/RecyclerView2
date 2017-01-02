package com.chen.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewStaggeredAdapter extends RecyclerViewSimpleAdapter {

    private List<Integer> mHeights;

    public RecyclerViewStaggeredAdapter(Context context, List<String> datas) {
        super(context, datas);

        mHeights = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));

        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));

        setUpItemEvent(holder);
    }


}
