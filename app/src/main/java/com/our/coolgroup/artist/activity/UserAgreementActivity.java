package com.our.coolgroup.artist.activity;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.our.coolgroup.artist.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserAgreementActivity extends BaseActivity {

    @Bind(R.id.webview_agreen)
    WebView mWebviewA;


    @Override
    void initView() {
        setContentView(R.layout.activity_user_agreenment);
        ButterKnife.bind(this);

    }

    @Override
    void initData() {

    }

    @Override
    void initEvent() {

        WebSettings webSettings = mWebviewA.getSettings();

        mWebviewA.loadUrl("http://www.jiangwoo.com/zh_user_terms.html");
        mWebviewA.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl("http://www.jiangwoo.com/zh_user_terms.html");
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        mWebviewA.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && mWebviewA.canGoBack()) {

                    mWebviewA.goBack();
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
    @OnClick(R.id.img_back_agree)
    public void onClick() {
        if (mWebviewA.canGoBack()) {
            mWebviewA.goBack();
        }else{
            finish();
        }

    }
}
