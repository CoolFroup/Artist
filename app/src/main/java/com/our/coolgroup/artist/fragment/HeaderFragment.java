package com.our.coolgroup.artist.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.our.coolgroup.artist.R;

/**
 * Created by Administrator on 2016/7/26.
 */
public class HeaderFragment  extends Fragment{
    private ImageView iv;
    private String imgUrl;

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public HeaderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_header, container, false);
        iv = (ImageView) view.findViewById(R.id.header_pager_iv);
        Glide.with(getContext()).load(imgUrl).into(iv);

        return view;
    }
}
