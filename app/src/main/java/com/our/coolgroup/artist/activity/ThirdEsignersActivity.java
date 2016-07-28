package com.our.coolgroup.artist.activity;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.our.coolgroup.artist.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThirdEsignersActivity extends BaseActivity {

    @Bind(R.id.webview_e)
    WebView mWebviewE;
    @Bind(R.id.img_back_join)
    ImageView mImgBackJoin;


    @Override
    void initView() {
        setContentView(R.layout.activity_third_esigners);
        ButterKnife.bind(this);

    }

    @Override
    void initData() {

    }

    @Override
    void initEvent() {

        WebSettings webSettings = mWebviewE.getSettings();

        mWebviewE.loadUrl("http://www.jiangwoo.com/designers/join_us.html");
        mWebviewE.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl("http://www.jiangwoo.com/designers/join_us.html");
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        mWebviewE.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && mWebviewE.canGoBack()) {

                    mWebviewE.goBack();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void destoryViews() {
        ButterKnife.unbind(this);

    }
    @OnClick(R.id.img_back_join)
    public void onClick() {
        if (mWebviewE.canGoBack()) {
            mWebviewE.goBack();
        }else{
            finish();
        }

    }
}
