package com.our.coolgroup.artist.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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

public class FenleiActivity extends AppCompatActivity {
    private String path, title;
    private RecyclerView mRecyclerView;
    private ListAdapter_first adapter;
    private OkHttpClient mOkHttpClient;
    private List<ItemBean_first.ProductsBean> data;
    private TextView title_fenlei_first;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);

        path = getIntent().getExtras().getString("path");
        title = getIntent().getExtras().getString("title");
        initView();
        initData();
    }


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            data = (List<ItemBean_first.ProductsBean>) msg.obj;


            GridLayoutManager layoutManager = new GridLayoutManager(FenleiActivity.this, 2);
            mRecyclerView.setLayoutManager(layoutManager);
            adapter = new ListAdapter_first(FenleiActivity.this, data);
            mRecyclerView.setAdapter(adapter);
        }
    };

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_fenlei_first);
        title_fenlei_first = (TextView) findViewById(R.id.title_fenlei_first);
    }


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

        title_fenlei_first.setText(title);
    }

    public void back(View view) {
        finish();
    }
}
