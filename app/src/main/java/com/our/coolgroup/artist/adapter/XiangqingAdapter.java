package com.our.coolgroup.artist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.ShoppingBean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class XiangqingAdapter extends BaseAdapter {
    private List<String> data;

    private Context mContext;

    public XiangqingAdapter(List<String> data, Context context) {
        this.data = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
           convertView = LayoutInflater.from(mContext).inflate(R.layout.item_shopping, parent, false);
            holder.iv= (ImageView) convertView.findViewById(R.id.iv_item);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(data.get(position)).into(holder.iv);
        Log.e("TAG", "========"+data );

        return convertView;
    }

    class ViewHolder {
        ImageView iv;

    }
}
