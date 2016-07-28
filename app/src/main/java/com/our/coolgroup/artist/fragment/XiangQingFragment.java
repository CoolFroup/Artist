package com.our.coolgroup.artist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.activity.ShoppingActivity;
import com.our.coolgroup.artist.adapter.XiangqingAdapter;
import com.our.coolgroup.artist.bean.ShoppingBean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class XiangQingFragment extends Fragment {
    private ListView lv;
    private XiangqingAdapter mAdapter;

    private List<String> data;

    public void setData(List<String> data) {
        this.data = data;

    }

    public XiangQingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xiangqing, container, false);
        lv = (ListView) view.findViewById(R.id.lv_xiangqing);
        mAdapter = new XiangqingAdapter(data,getContext());
        lv.setAdapter(mAdapter);

        return view;
    }
}
