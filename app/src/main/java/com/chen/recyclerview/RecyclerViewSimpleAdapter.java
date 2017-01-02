package com.chen.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chen on 2016-12-29.
 */
public class RecyclerViewSimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    protected List<String> mDatas;

//    public interface OnItemClickListener {
//        void onItemClick(View view, int position);
//
//        void onLongItemClick(View view, int position);
//    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public RecyclerViewSimpleAdapter(Context context, List<String> datas) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mDatas = datas;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_simple_textview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText(mDatas.get(position));
        setUpItemEvent(holder);
    }

    protected void setUpItemEvent(final MyViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onLongItemClick(holder.itemView, layoutPosition);
                    return false;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int position) {
        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void deleteData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);

        tv = (TextView) itemView.findViewById(R.id.id_tv);
    }
}

