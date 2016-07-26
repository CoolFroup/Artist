package com.our.coolgroup.artist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ZAN on 2016/7/26.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }
    abstract void initView();
    abstract void initData();
    abstract void initEvent();
}
