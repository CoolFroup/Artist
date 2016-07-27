package com.our.coolgroup.artist.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.utils.Conts;

public class InfoActivity extends BaseActivity {

    private WebView mWebView;
    private String path;
    private TextView mTextView;

    @Override
    void initView() {
        setContentView(R.layout.activity_info);
        mWebView = (WebView) findViewById(R.id.webview_info);
        mTextView = (TextView) findViewById(R.id.title_info);

        path = getIntent().getStringExtra("path");

        if (Conts.URL_SECOND_HEAD.equals(path)) {
            mTextView.setText("空间简介");
        }

    }

    @Override
    void initData() {
        mWebView.loadUrl(path);
    }

    @Override
    void initEvent() {

    }

    @Override
    protected void destoryViews() {
        finish();
    }

    public void back(View view) {
        finish();
    }
}
