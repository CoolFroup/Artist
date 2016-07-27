package com.our.coolgroup.artist.fragment;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.activity.DesignActivity;
import com.our.coolgroup.artist.activity.DetailActivity;
import com.our.coolgroup.artist.activity.InfoActivity;
import com.our.coolgroup.artist.adapter.SecondRecyclerAdapter;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {
    private ImageView mImageView;
    private FrameLayout mFrameLayout;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private SecondRecyclerAdapter adapter;

    private int page = 1;
    private boolean isDown = false;
    private List<com.our.coolgroup.artist.bean.SecondBean.SpacesBean> data;
    private TextView mTextView;

    public SecondFragment() {
        // Required empty public constructor
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            com.our.coolgroup.artist.bean.SecondBean bean = (com.our.coolgroup.artist.bean.SecondBean) msg.obj;

            data = bean.getSpaces();
            adapter.setData(data);
            mRecyclerView.setAdapter(adapter);

            //跳转详情页面
            adapter.setItemClickListener(new SecondRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Intent intent = new Intent(SecondFragment.this.getActivity(), DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("titleDetail", adapter.getList().get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    };


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        mImageView = (ImageView) view.findViewById(R.id.iv_cloud_second);
        mFrameLayout = (FrameLayout) view.findViewById(R.id.frameLayout_second);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_second);
        mTextView = (TextView) view.findViewById(R.id.tv_GoToDesign);
        mTextView.setOnClickListener(this);

        mImageView.setFocusable(true);
        mImageView.setFilterTouchesWhenObscured(true);
        mImageView.requestFocus();

        //下拉刷新
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout_second);

        final LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

        adapter = new SecondRecyclerAdapter(getContext());

        //下载字符串
        String path = String.format(Conts.URL_SECOND_INDEX, page);
        loadData(path);

        //下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clearList();
                        adapter.notifyDataSetChanged();

                        String path = String.format(Conts.URL_SECOND_INDEX, ++page);
                        if (page == 8)
                            page = 1;
                        loadData(path);

                        //判断是否正在刷新
                        if (mSwipeRefreshLayout.isRefreshing()) {
                            //如果正在刷新，则关闭刷新
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }).start();
            }
        });

        //上拉加载
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastVisibleItemPosition;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = manager.findLastVisibleItemPosition();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == adapter.getItemCount()) {
                    if (!isDown) {
                        isDown = true;
                        loadData(String.format(Conts.URL_SECOND_INDEX, ++page));
                        if (page == 8)
                            page = 1;
                        adapter.notifyDataSetChanged();
                    } else {
                        isDown = false;
                    }
                }
            }
        });

        mFrameLayout.setOnClickListener(this);

        //云动画
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.translate_cloud);
        mImageView.setAnimation(animation);
        return view;
    }

    private void loadData(String path) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response != null) {
                    Gson gson = new Gson();
                    String string = response.body().string();
                    com.our.coolgroup.artist.bean.SecondBean secondBean = gson.fromJson(string, com.our.coolgroup.artist.bean.SecondBean.class);

                    Message msg = Message.obtain();
                    msg.obj = secondBean;
                    mHandler.sendMessage(msg);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.frameLayout_second:
                intent = new Intent(SecondFragment.this.getActivity(), InfoActivity.class);
                intent.putExtra("path", Conts.URL_SECOND_HEAD);
                startActivity(intent);
                break;
            case R.id.tv_GoToDesign:
                intent = new Intent(SecondFragment.this.getActivity(), DesignActivity.class);
                startActivity(intent);
                break;
        }

    }

}
