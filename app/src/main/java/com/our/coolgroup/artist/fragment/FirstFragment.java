package com.our.coolgroup.artist.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.our.coolgroup.artist.activity.FenleiActivity;
import com.our.coolgroup.artist.activity.MainScanActivity;
import com.our.coolgroup.artist.adapter.HeaderAdapter;
import com.our.coolgroup.artist.adapter.ViewPagerAdapter;
import com.our.coolgroup.artist.bean.Header_firstBean;
import com.our.coolgroup.artist.bean.TitleBean_first;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.adapter.HeaderAdapter;
import com.our.coolgroup.artist.adapter.ViewPagerAdapter;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
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


    private ImageView iv_title_first1, iv_title_first2, iv_title_first3, iv_title_first4, iv_title_first5, iv_title_first6, iv_title_first7, iv_title_first8;
    private TextView tv_title_first1, tv_title_first2, tv_title_first3, tv_title_first4, tv_title_first5, tv_title_first6, tv_title_first7, tv_title_first8;
    private LinearLayout guijia_first, zuoyi_first, zhuoji_first, chuang_first, shafa_first, dengju_first, zhuangshi_first, qimin_first;
    private TabLayout tabLayout_first;
    private ViewPager viewPager_first;
    private ViewPagerAdapter mViewPagerAdapter;

    //独立设计，匠物精选地址
    private String[] path = {"http://api.jiangwoo.com/api/v2/products?page=1&source=jiangwoo", "http://api.jiangwoo.com/api/v2/products?page=1&source=external"};

    private Bundle bundle;
    private ImageView mImgScan;

    public FirstFragment() {
        // Required empty public constructor
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bean = (Header_firstBean) msg.obj;

            adapter = new HeaderAdapter(getChildFragmentManager());
            if (bean.getHeadlines() != null) {
                adapter.setData(bean.getHeadlines());
            }
            index_header_viewpager.setAdapter(adapter);
            index_header_viewpager.setOffscreenPageLimit(2);//预加载

        }
    };


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case AUTO_MSG:
                    index_header_viewpager.setCurrentItem(index++);
                    if (index == 2) {
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
        bundle = new Bundle();
        initView();

        //设置焦点，置顶
        index_header_viewpager.setFocusable(true);
        index_header_viewpager.setFocusableInTouchMode(true);
        index_header_viewpager.requestFocus();

        //设置默认选中
        ((ImageView) linearLayout_head.getChildAt(0)).setSelected(true);


        mOkHttpClient = new OkHttpClient();
        //header的解析地址
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
                    (linearLayout_head.getChildAt(i)).setSelected(false);
                }
                ((ImageView) linearLayout_head.getChildAt(position)).setSelected(true);

                index_header_viewpager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        setTitle();
        initTab();

        initListner();


        return mView;
    }


    private void initView() {
        index_header_viewpager = (ViewPager) mView.findViewById(R.id.index_header_viewpager);
        linearLayout_head = (LinearLayout) mView.findViewById(R.id.linearLayout_head);

        iv_title_first1 = (ImageView) mView.findViewById(R.id.iv_title_first1);
        iv_title_first2 = (ImageView) mView.findViewById(R.id.iv_title_first2);
        iv_title_first3 = (ImageView) mView.findViewById(R.id.iv_title_first3);
        iv_title_first4 = (ImageView) mView.findViewById(R.id.iv_title_first4);
        iv_title_first5 = (ImageView) mView.findViewById(R.id.iv_title_first5);
        iv_title_first6 = (ImageView) mView.findViewById(R.id.iv_title_first6);
        iv_title_first7 = (ImageView) mView.findViewById(R.id.iv_title_first7);
        iv_title_first8 = (ImageView) mView.findViewById(R.id.iv_title_first8);


        tv_title_first1 = (TextView) mView.findViewById(R.id.tv_title_first1);
        tv_title_first2 = (TextView) mView.findViewById(R.id.tv_title_first2);
        tv_title_first3 = (TextView) mView.findViewById(R.id.tv_title_first3);
        tv_title_first4 = (TextView) mView.findViewById(R.id.tv_title_first4);
        tv_title_first5 = (TextView) mView.findViewById(R.id.tv_title_first5);
        tv_title_first6 = (TextView) mView.findViewById(R.id.tv_title_first6);
        tv_title_first7 = (TextView) mView.findViewById(R.id.tv_title_first7);
        tv_title_first8 = (TextView) mView.findViewById(R.id.tv_title_first8);

        tabLayout_first = (TabLayout) mView.findViewById(R.id.tabLayout_first);
        viewPager_first = (ViewPager) mView.findViewById(R.id.viewPager_first);

        guijia_first = (LinearLayout) mView.findViewById(R.id.guijia_first);
        zuoyi_first = (LinearLayout) mView.findViewById(R.id.zuoyi_first);
        zhuoji_first = (LinearLayout) mView.findViewById(R.id.zhuoji_first);
        chuang_first = (LinearLayout) mView.findViewById(R.id.chuang_first);
        shafa_first = (LinearLayout) mView.findViewById(R.id.shafa_first);
        dengju_first = (LinearLayout) mView.findViewById(R.id.dengju_first);
        zhuangshi_first = (LinearLayout) mView.findViewById(R.id.zhuangshi_first);
        qimin_first = (LinearLayout) mView.findViewById(R.id.qimin_first);
        mImgScan = ((ImageView) mView.findViewById(R.id.img_scan));

    }


    //标题解析
    private void setTitle() {
        Request request = new Request.Builder().url("http://api.jiangwoo.com/api/v1/categories")
                .build();
        final Call call = mOkHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Gson gson = new Gson();
                    if (response != null) {
                        TitleBean_first bean = gson.fromJson(response.body().string(), TitleBean_first.class);
                        List<TitleBean_first.CategoriesBean> categories = bean.getCategories();

                        final String[] img_title = new String[8];
                        final String[] txt_title = new String[8];
                        for (int i = 0; i < categories.size(); i++) {
                            img_title[i] = categories.get(categories.size() - i - 1).getImage_black();
                            txt_title[i] = categories.get(categories.size() - i - 1).getTitle();
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                Glide.with(FirstFragment.this.getContext()).load(img_title[0]).into(iv_title_first1);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[1]).into(iv_title_first2);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[2]).into(iv_title_first3);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[3]).into(iv_title_first4);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[4]).into(iv_title_first5);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[5]).into(iv_title_first6);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[6]).into(iv_title_first7);
                                Glide.with(FirstFragment.this.getContext()).load(img_title[7]).into(iv_title_first8);


                                tv_title_first1.setText(txt_title[0]);
                                tv_title_first2.setText(txt_title[1]);
                                tv_title_first3.setText(txt_title[2]);
                                tv_title_first4.setText(txt_title[3]);
                                tv_title_first5.setText(txt_title[4]);
                                tv_title_first6.setText(txt_title[5]);
                                tv_title_first7.setText(txt_title[6]);
                                tv_title_first8.setText(txt_title[7]);

                            }
                        });

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initTab() {
        List sFragments = new ArrayList<>();
        List sTitles = new ArrayList<>();

        sTitles.add("独立设计");
        sTitles.add("匠物精选");

        for (int i = 0; i < 2; i++) {
            ListFragment fragment = new ListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("path", path[i]);
            fragment.setArguments(bundle);
            sFragments.add(fragment);
        }


        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), sFragments, sTitles);
        viewPager_first.setAdapter(mViewPagerAdapter);

        //mTabLayout和mViewPager  进行关联
        tabLayout_first.setupWithViewPager(viewPager_first);
        //设置TabLayout默认选中
        tabLayout_first.getTabAt(0).select();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void initListner(){
        guijia_first.setOnClickListener(this);
        zuoyi_first.setOnClickListener(this);
        zhuoji_first.setOnClickListener(this);
        chuang_first.setOnClickListener(this);
        shafa_first.setOnClickListener(this);
        dengju_first.setOnClickListener(this);
        zhuangshi_first.setOnClickListener(this);
        qimin_first.setOnClickListener(this);
        mImgScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.guijia_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E6%9F%9C%E6%9E%B6");
                bundle.putString("title","柜架");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.zuoyi_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E5%BA%A7%E6%A4%85");
                bundle.putString("title","座椅");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.zhuoji_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E6%A1%8C%E5%87%A0");
                bundle.putString("title","桌几");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.chuang_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E5%BA%8A");
                bundle.putString("title","床");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.shafa_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E6%B2%99%E5%8F%91");
                bundle.putString("title","沙发");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.dengju_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E7%81%AF%E5%85%B7");
                bundle.putString("title","灯具");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.zhuangshi_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E8%A3%85%E9%A5%B0");
                bundle.putString("title","装饰");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.qimin_first:
                bundle.clear();
                intent = new Intent(FirstFragment.this.getContext(), FenleiActivity.class);
                bundle.putString("path", "http://api.jiangwoo.com/api/v2/products?page=1&category=%E5%99%A8%E7%9A%BF");
                bundle.putString("title","器皿");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.img_scan:

                Intent intent1 = new Intent(getActivity(), MainScanActivity.class);
                startActivity(intent1);
                break;


        }
    }
}
