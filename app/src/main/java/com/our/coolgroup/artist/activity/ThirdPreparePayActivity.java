package com.our.coolgroup.artist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.our.coolgroup.artist.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThirdPreparePayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_prepare_pay);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.img_back_join)
    public void onClick() {
        finish();
    }
}
