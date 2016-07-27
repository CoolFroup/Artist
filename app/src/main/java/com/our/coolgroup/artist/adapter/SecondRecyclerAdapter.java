package com.our.coolgroup.artist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.SecondBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2016/7/26.
 */
public class SecondRecyclerAdapter extends RecyclerView.Adapter<SecondRecyclerAdapter.SecondViewHolder> implements View.OnClickListener {
    private List<SecondBean.SpacesBean> data;
    private List<SecondBean.SpacesBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;
    private OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public SecondRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<SecondBean.SpacesBean> data) {
        if (data != null) {
            this.data = data;
            list.addAll(data);
        } else {
            this.data = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public void clearList() {
        list.clear();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;

    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }

    @Override
    public SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.second_index_item, parent, false);

        view.setOnClickListener(this);
        return new SecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SecondViewHolder holder, int position) {
        holder.title.setText(list.get(position).getName());
        holder.like.setText(list.get(position).getFavs_count() + "");

        String thumb = list.get(position).getThumb();

        Glide.with(context).load("http://" + thumb).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);

        if (itemClickListener != null)
            itemClickListener.onItemClick(position);
    }

    class SecondViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title, like;

        public SecondViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_second_item);
            title = (TextView) itemView.findViewById(R.id.title_second_item);
            like = (TextView) itemView.findViewById(R.id.like_second_item);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
