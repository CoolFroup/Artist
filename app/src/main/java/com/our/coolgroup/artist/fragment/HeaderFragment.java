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
public class HeaderFragment extends Fragment {
    private ImageView iv;
    private String imgUrl;
    private int id;
    private String path = "http://api.jiangwoo.com/api/v1/products/%d";

    public void setImgUrl(String imgUrl, int id) {
        this.imgUrl = imgUrl;
        this.id = id;
    }

    public HeaderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_header, container, false);
        iv = (ImageView) view.findViewById(R.id.header_pager_iv);
        path = String.format(path, id);
        Glide.with(getContext()).load(imgUrl).into(iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeaderFragment.this.getContext(), ShoppingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("path",path);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }
}
