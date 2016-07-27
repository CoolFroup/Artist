package com.our.coolgroup.artist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.DetailListBean;
import com.our.coolgroup.artist.utils.CircleBitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2016/7/27.
 */
public class DetailListViewAdapter extends BaseAdapter {
    private List<DetailListBean.CommentsBean> data;
    private Context context;
    private LayoutInflater inflater;

    public DetailListViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<DetailListBean.CommentsBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.detail_list_item, parent, false);

            holder.iv = (ImageView) convertView.findViewById(R.id.iv_icon_list_item);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name_list_item);
            holder.time = (TextView) convertView.findViewById(R.id.tv_time_list_item);
            holder.content = (TextView) convertView.findViewById(R.id.tv_content_list_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        DetailListBean.CommentsBean commentsBean = data.get(position);

        if (commentsBean != null) {
            holder.name.setText(commentsBean.getUsername());
            holder.time.setText(commentsBean.getUpdated_at());
            holder.content.setText(commentsBean.getContent());

            String user_thumb = commentsBean.getUser_thumb();
            Glide.with(context)
                    .load(user_thumb)
                    .transform(new CircleBitmap(context))
                    .into(holder.iv);
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView iv;
        TextView name, time, content;
    }
}
