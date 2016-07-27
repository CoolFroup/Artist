package com.our.coolgroup.artist.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.adapter.ListAdapter_first;
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
public class ListFragment extends Fragment {

    private View mView;
    private RecyclerView mRecyclerView;
    private ListAdapter_first adapter;
    private OkHttpClient mOkHttpClient;
    private List<ItemBean_first.ProductsBean> data;
    private String path ="" ;
   private Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = LayoutInflater.from(getContext()).inflate(R.layout.listfragment, container, false);
        bundle = getArguments();
        path = bundle.getString("path");

        initView();
        initData();
        return mView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView_first);

    }


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            data = (List<ItemBean_first.ProductsBean>) msg.obj;


            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
            mRecyclerView.setLayoutManager(layoutManager);
            adapter = new ListAdapter_first(getContext(), data);
            mRecyclerView.setAdapter(adapter);
        }
    };

    private void initData() {
        mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(path)
                .build();
        final Call call = mOkHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Gson gson = new Gson();
                    if (response != null) {
                        ItemBean_first bean_first = gson.fromJson(response.body().string(), ItemBean_first.class);
                        data = bean_first.getProducts();
                        Message msg = new Message();
                        msg.obj = data;
                        handler.sendMessage(msg);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
