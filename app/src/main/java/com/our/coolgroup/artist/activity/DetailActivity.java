package com.our.coolgroup.artist.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.adapter.DetailRecyclerAdapter;
import com.our.coolgroup.artist.bean.DetailBean;
import com.our.coolgroup.artist.bean.SecondBean;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class DetailActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private TextView mTextView;
    private DetailRecyclerAdapter adapter;
    private int id;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if ((DetailBean) msg.obj != null) {

                DetailBean bean = (DetailBean) msg.obj;

                adapter.setData(bean.getSpace().getSpace_items());
                mRecyclerView.setAdapter(adapter);
            }
        }
    };

    @Override
    void initView() {
        setContentView(R.layout.activity_detail);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_detail);
        mImageView = (ImageView) findViewById(R.id.iv_title_detail);
        mTextView = (TextView) findViewById(R.id.tv_title_detail);

        Bundle bundle = getIntent().getExtras();
        SecondBean.SpacesBean spacesBean = (SecondBean.SpacesBean) bundle.getSerializable("titleDetail");

        mTextView.setText(spacesBean.getName());

        id = spacesBean.getId();

        String thumb = spacesBean.getThumb();
        Glide.with(this).load("http://" + thumb).into(mImageView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    void initData() {
        adapter = new DetailRecyclerAdapter(DetailActivity.this);
    }

    @Override
    void initEvent() {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format(Conts.URL_SECOND_DETAIL, id))
                .build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Gson gson = new Gson();
                DetailBean bean = gson.fromJson(response.body().string(), DetailBean.class);

                Message msg = Message.obtain();
                msg.obj = bean;
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    protected void destoryViews() {

    }

    public void backToDetail(View view) {
        finish();
    }
}
