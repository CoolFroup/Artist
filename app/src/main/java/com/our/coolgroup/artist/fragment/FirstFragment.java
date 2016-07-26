package com.our.coolgroup.artist.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.our.coolgroup.artist.Bean.Header_firstBean;
import com.our.coolgroup.artist.Bean.TitleBean_first;
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


    private ImageView iv_title_first1, iv_title_first2, iv_title_first3, iv_title_first4, iv_title_first5, iv_title_first6, iv_title_first7, iv_title_first8;
    private TextView tv_title_first1, tv_title_first2, tv_title_first3, tv_title_first4, tv_title_first5, tv_title_first6, tv_title_first7, tv_title_first8;
    private TabLayout tabLayout_first;
    private ViewPager viewPager_first;
    private ViewPagerAdapter mViewPagerAdapter;

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

        tabLayout_first= (TabLayout) mView.findViewById(R.id.tabLayout_first);
        viewPager_first= (ViewPager) mView.findViewById(R.id.viewPager_first);
    }


    private void setTitle() {
        Request request = new Request.Builder().url("http://api.jiangwoo.com/api/v1/categories")
                .build();
        final Call call = mOkHttpClient.newCall(request);
        Log.e("TAG", "========1111110000" );
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Gson gson = new Gson();
                    Log.e("TAG", "========0000" );
                    if (response != null) {
                        Log.e("TAG", "========0011" );
                        TitleBean_first bean = gson.fromJson(response.body().string(), TitleBean_first.class);
                        List<TitleBean_first.CategoriesBean> categories = bean.getCategories();

                        final String[] img_title=new String[8];
                        final String[] txt_title=new String[8];
                        for (int i = 0; i < categories.size(); i++) {
                            img_title[i]=categories.get(categories.size()-i-1).getImage_black();
                            txt_title[i]= categories.get(categories.size()-i-1).getTitle();
                        }
                        Log.e("TAG", "========1111"+img_title );
                        Log.e("TAG", "========2222"+txt_title );



                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                Log.e("TAG", "========3333"+img_title );
                                Log.e("TAG", "========4444"+txt_title );
                                Glide.with(getContext()).load(img_title[0]).into(iv_title_first1);
                                Glide.with(getContext()).load(img_title[1]).into(iv_title_first2);
                                Glide.with(getContext()).load(img_title[2]).into(iv_title_first3);
                                Glide.with(getContext()).load(img_title[3]).into(iv_title_first4);
                                Glide.with(getContext()).load(img_title[4]).into(iv_title_first5);
                                Glide.with(getContext()).load(img_title[5]).into(iv_title_first6);
                                Glide.with(getContext()).load(img_title[6]).into(iv_title_first7);
                                Glide.with(getContext()).load(img_title[7]).into(iv_title_first8);


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


        sFragments.add(new ListFragment());
        sFragments.add(new ListFragment());


        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), sFragments, sTitles);
        viewPager_first.setAdapter(mViewPagerAdapter);

        //mTabLayout和mViewPager  进行关联
        tabLayout_first.setupWithViewPager(viewPager_first);
        //设置TabLayout默认选中
        tabLayout_first.getTabAt(1).select();
    }


}
