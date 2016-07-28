package com.our.coolgroup.artist.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.adapter.ShoppingAdapter;
import com.our.coolgroup.artist.bean.ShoppingBean;
import com.our.coolgroup.artist.snapscrollview.McoyProductContentPage;
import com.our.coolgroup.artist.snapscrollview.McoyProductDetailInfoPage;
import com.our.coolgroup.artist.snapscrollview.McoySnapPageLayout;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {
    private String path = "";
    private McoySnapPageLayout mcoySnapPageLayout = null;
    private McoyProductContentPage bottomPage = null;
    private McoyProductDetailInfoPage topPage = null;
    private View mViewA, mViewB;
    private ImageView ivHeader_shopping_first, ivSave_shopping_first, ivShare_shopping_first, iv_V_shopping, iv_Video_shopping;
    private TextView tvName_shopping_first, tvMoney_shopping, tvStyle_shopping_first, tvMessage_shopping_first;
    private OkHttpClient mOkHttpClient;
    private ShoppingBean bean;
    private LinearLayout layout1_shopping, layout2_shopping, buyLayout_shopping, layout3_shopping;
    private ViewPager viewPager_shopping;
    private ShoppingAdapter adapter;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        path = getIntent().getExtras().getString("path");

        mcoySnapPageLayout = (McoySnapPageLayout) findViewById(R.id.flipLayout);

        topPage = new McoyProductDetailInfoPage(ShoppingActivity.this,
                getLayoutInflater().inflate(
                        R.layout.mcoy_produt_detail_layout, null));
        bottomPage = new McoyProductContentPage(ShoppingActivity.this,
                getLayoutInflater().inflate(
                        R.layout.mcoy_product_content_page, null));

        mcoySnapPageLayout.setSnapPages(topPage, bottomPage);
        initView();
        download();


    }


    //获取解析控件
    private void initView() {
        ivHeader_shopping_first = (ImageView) mcoySnapPageLayout.findViewById(R.id.ivHeader_shopping_first);
        tvName_shopping_first = (TextView) mcoySnapPageLayout.findViewById(R.id.tvName_shopping_first);
        ivSave_shopping_first = (ImageView) mcoySnapPageLayout.findViewById(R.id.ivSave_shopping_first);
        ivShare_shopping_first = (ImageView) mcoySnapPageLayout.findViewById(R.id.ivShare_shopping_first);
        iv_V_shopping = (ImageView) mcoySnapPageLayout.findViewById(R.id.iv_V_shopping);
        iv_Video_shopping = (ImageView) mcoySnapPageLayout.findViewById(R.id.iv_Video_shopping);
        tvMoney_shopping = (TextView) mcoySnapPageLayout.findViewById(R.id.tvMoney_shopping);
        tvStyle_shopping_first = (TextView) mcoySnapPageLayout.findViewById(R.id.tvStyle_shopping_first);
        tvMessage_shopping_first = (TextView) mcoySnapPageLayout.findViewById(R.id.tvMessage_shopping_first);
        buyLayout_shopping = (LinearLayout) findViewById(R.id.buyLayout_shopping);
        layout1_shopping = (LinearLayout) mcoySnapPageLayout.findViewById(R.id.layout1_shopping);
        layout2_shopping = (LinearLayout) mcoySnapPageLayout.findViewById(R.id.layout2_shopping);
        layout3_shopping = (LinearLayout) mcoySnapPageLayout.findViewById(R.id.layout3_shopping);
        viewPager_shopping = (ViewPager) mcoySnapPageLayout.findViewById(R.id.viewPager_shopping);

    }

    public void back(View view) {
        finish();
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_nextStyle_shopping:

                break;
        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bean = (ShoppingBean) msg.obj;
            Glide.with(ShoppingActivity.this).load(bean.getProduct().getThumb()).into(ivHeader_shopping_first);
            tvName_shopping_first.setText(bean.getProduct().getTitle());
            if (bean.getProduct().getVideo() == null) {
                iv_Video_shopping.setVisibility(View.GONE);
            }

            tvMoney_shopping.setText(bean.getProduct().getPrice());
            tvStyle_shopping_first.setText(bean.getProduct().getBrand());
            tvMessage_shopping_first.setText(bean.getProduct().getIntro());

            if (bean.getProduct().getSource().equals("external")) {
                layout1_shopping.setVisibility(View.GONE);
                layout2_shopping.setVisibility(View.GONE);
                buyLayout_shopping.setVisibility(View.GONE);
            }
            adapter = new ShoppingAdapter(getSupportFragmentManager());

            data = new ArrayList<>();
            for (int i = 0; i < bean.getProduct().getDesign_photos().size(); i++) {
                data.add(bean.getProduct().getDesign_photos().get(i).getImage());
            }
            for (int i = 0; i < bean.getProduct().getCraft_photos().size(); i++) {
                data.add(bean.getProduct().getCraft_photos().get(i).getImage());
            }
            for (int i = 0; i < bean.getProduct().getLife_photos().size(); i++) {
                data.add(bean.getProduct().getLife_photos().get(i).getImage());
            }

            adapter.setData(data);
            viewPager_shopping.setAdapter(adapter);
        }
    };

    private void download() {
        mOkHttpClient = new OkHttpClient();
        //header的解析地址
        Request request = new Request.Builder().url(path)
                .build();
        Log.e("TAG", "============111" + path);
        final Call call = mOkHttpClient.newCall(request);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Gson gson = new Gson();
                    if (response != null) {
                        ShoppingBean bean = gson.fromJson(response.body().string(), ShoppingBean.class);

                        Message msg = Message.obtain();
                        msg.obj = bean;
                        handler.sendMessage(msg);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void changePage(View view) {
        int indexOfChild = layout3_shopping.indexOfChild(view);
        for (int i = 0; i < 2; i++) {
            layout3_shopping.getChildAt(0).setBackgroundResource(R.mipmap.a);
            layout3_shopping.getChildAt(1).setBackgroundResource(R.mipmap.b);

        }

        switch (indexOfChild) {
            case 0:
                layout3_shopping.getChildAt(0).setBackgroundResource(R.mipmap.c);
                break;
            case 1:
                layout3_shopping.getChildAt(1).setBackgroundResource(R.mipmap.d);
                break;
        }
        viewPager_shopping.setCurrentItem(indexOfChild);
    }
}
