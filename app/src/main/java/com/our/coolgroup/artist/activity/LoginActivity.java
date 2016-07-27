package com.our.coolgroup.artist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.our.coolgroup.artist.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.et_username)
    TextInputEditText mEtUsername;
    @Bind(R.id.et_pwd)
    TextInputEditText mEtPwd;
    @Bind(R.id.txt_newUser)
    TextView mTxtNewUser;
    @Bind(R.id.txt_forget_pwd)
    TextView mTxtForgetPwd;
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.btn_login_wechat)
    Button mBtnLoginWechat;
    @Bind(R.id.img_cancle)
    ImageView mImgCancle;
    @Bind(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @Override
    void initData() {

    }

    @Override
    void initEvent() {

    }

    @Override
    protected void destoryViews() {
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.txt_newUser, R.id.txt_forget_pwd, R.id.btn_login, R.id.btn_login_wechat, R.id.img_cancle})
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.txt_newUser:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_forget_pwd:


                break;
            case R.id.btn_login:

               mProgressBar.setVisibility(View.VISIBLE);
                 new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mProgressBar.setVisibility(View.GONE);
                            }
                        });
                    }
                },4000);

                break;
            case R.id.btn_login_wechat:

                break;
            case R.id.img_cancle:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
