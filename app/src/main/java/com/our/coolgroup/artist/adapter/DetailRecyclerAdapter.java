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
import com.our.coolgroup.artist.bean.DetailBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2016/7/27.
 */
public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.DetailViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<DetailBean.SpaceBean.SpaceItemsBean> data;

    public DetailRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<DetailBean.SpaceBean.SpaceItemsBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.detail_item, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        holder.content.setText(data.get(position).getText());
        String image = data.get(position).getImage();

        Glide.with(context).load("http://" + image).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        ImageView iv;

        public DetailViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.tv_content_detail_item);
            iv = (ImageView) itemView.findViewById(R.id.iv_detail_item);
        }
    }
}
