package com.our.coolgroup.artist.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.activity.ShoppingActivity;
import com.our.coolgroup.artist.bean.ItemBean_first;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */

public class ListAdapter_first extends RecyclerView.Adapter<ListAdapter_first.ViewHolder> {
    private Context mContext;
    private String path = "http://api.jiangwoo.com/api/v1/products/%d";
    private List<ItemBean_first.ProductsBean> data;
    private int id;
    private String path1 = "";
    private RecyclerView mRecyclerView;

    public ListAdapter_first(Context context, List<ItemBean_first.ProductsBean> data) {
        if (this.data != null) {
            this.data.clear();
        }
        this.mContext = context;
        this.data = data;
    }


    @Override
    public ListAdapter_first.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ListAdapter_first.ViewHolder holder, final int position) {
        Glide.with(mContext).load(data.get(position).getThumb()).into(holder.iv_item_first);
        holder.tv_item1_first.setText(data.get(position).getTitle());
        holder.tv_item2_first.setText(data.get(position).getView_count() + "");
        holder.tv_item3_first.setText(data.get(position).getFavs_count() + "");

        holder.item_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = data.get(position).getId();
                path1 = String.format(path, id);

                Intent intent = new Intent(mContext, ShoppingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("path", path1);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_item_first;
        public TextView tv_item1_first, tv_item2_first, tv_item3_first;
        public LinearLayout item_first;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_item_first = (ImageView) itemView.findViewById(R.id.iv_item_first);
            tv_item1_first = (TextView) itemView.findViewById(R.id.tv_item1_first);
            tv_item2_first = (TextView) itemView.findViewById(R.id.tv_item2_first);
            tv_item3_first = (TextView) itemView.findViewById(R.id.tv_item3_first);

            item_first = (LinearLayout) itemView.findViewById(R.id.item_first);
        }
    }


}
