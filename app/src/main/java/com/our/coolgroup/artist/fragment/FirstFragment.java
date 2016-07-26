package com.our.coolgroup.artist.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.our.coolgroup.artist.Bean.Header_firstBean;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.adapter.HeaderAdapter;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private ViewPager index_header_viewpager;
    private View mView;
    private LinearLayout linearLayout_head;
    private OkHttpClient mOkHttpClient;

    //循环ViewPager
    private final int AUTO_MSG = 1;
    private static final int PHOTO_CHANGE_TIME = 3000;//定时变量
    private int index = 0;

    private HeaderAdapter adapter;
    private Header_firstBean bean;

    public FirstFragment() {
        // Required empty public constructor
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bean = (Header_firstBean) msg.obj;

            adapter=new HeaderAdapter(getChildFragmentManager());
            if (bean.getHeadlines() != null) {
                adapter.setData(bean.getHeadlines());
            }
            index_header_viewpager.setAdapter(adapter);
            index_header_viewpager.setOffscreenPageLimit(2);//预加载

        }
    };




    private  Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case AUTO_MSG:
                    index_header_viewpager.setCurrentItem(index++);
                    if (index ==2) {
                        index = 0;
                    }
                    break;
            }
            mHandler.sendEmptyMessageDelayed(AUTO_MSG, PHOTO_CHANGE_TIME);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_first, container, false);
        initView();

        //设置焦点，置顶
        index_header_viewpager.setFocusable(true);
        index_header_viewpager.setFocusableInTouchMode(true);
        index_header_viewpager.requestFocus();

        //设置默认选中
        ((ImageView) linearLayout_head.getChildAt(0)).setSelected(true);


        mOkHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url("http://api.jiangwoo.com/api/v1/headlines?page=1")
                .build();
        final Call call = mOkHttpClient.newCall(request);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Gson gson = new Gson();
                    if (response != null) {
                        Header_firstBean bean = gson.fromJson(response.body().string(), Header_firstBean.class);

                        Message msg = Message.obtain();
                        msg.obj = bean;
                        handler.sendMessage(msg);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //开始循环
        mHandler.sendEmptyMessageDelayed(AUTO_MSG, PHOTO_CHANGE_TIME);

        index_header_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < linearLayout_head.getChildCount(); i++) {
                    ( linearLayout_head.getChildAt(i)).setSelected(false);
                }
                ((ImageView) linearLayout_head.getChildAt(position)).setSelected(true);

                index_header_viewpager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        return mView;
    }

    private void initView() {
        index_header_viewpager = (ViewPager) mView.findViewById(R.id.index_header_viewpager);
        linearLayout_head = (LinearLayout) mView.findViewById(R.id.linearLayout_head);


    }


}
