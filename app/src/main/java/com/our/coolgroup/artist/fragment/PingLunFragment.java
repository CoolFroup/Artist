package com.our.coolgroup.artist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.activity.ShoppingActivity;

/**
 * Created by Administrator on 2016/7/26.
 */
public class PingLunFragment extends Fragment {
    private String path;

    public void setImgUrl(String imgUrl) {
        path = imgUrl;
    }

    public PingLunFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pinglun, container, false);

        return view;
    }
}
