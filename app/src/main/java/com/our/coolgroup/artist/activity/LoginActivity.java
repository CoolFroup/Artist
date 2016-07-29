package com.our.coolgroup.artist.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.LoginBean;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

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
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LoginBean loginBean = (LoginBean) msg.obj;
            if (loginBean != null) {
                if (loginBean.getError_code() == 400) {
                    mProgressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, loginBean.getError_message(), Toast.LENGTH_SHORT).show();
                    Log.e("responseError", loginBean.getError());
                    Log.e("responseError", loginBean.getError_code() + "");
                    Log.e("responseError", loginBean.getError_message());
                } else {
                    mProgressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(LoginActivity.this, MainmainActivity.class);
                    startActivity(intent1);
                    LoginBean.UserBean user = loginBean.getUser();
                    String auth_token = user.getAuth_token();
                    String username = user.getUsername();
                    SharedPreferences sharedPreferences = getSharedPreferences("token", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token",auth_token);
                    editor.putString("username",username);
                    boolean commit = editor.commit();
//                    String token = sharedPreferences.getString("token", "0");

                    Log.e("response", user.getStatus() + auth_token+commit);
                    
                }
            }
        }
    };


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

                downloadLoginData();
                progressbar();

                break;
            case R.id.btn_login_wechat:

                break;
            case R.id.img_cancle:
                finish();
                break;
        }
    }

    private void progressbar() {
        mProgressBar.setVisibility(View.VISIBLE);

        //        new Timer().schedule(new TimerTask() {
        //            @Override
        //            public void run() {
        //
        //                runOnUiThread(new Runnable() {
        //                    @Override
        //                    public void run() {
        //                        mProgressBar.setVisibility(View.GONE);
        //                        Intent intent1 = new Intent(LoginActivity.this, MainmainActivity.class);
        //                        startActivity(intent1);
        //                    }
        //                });
        //            }
        //        }, 3000);
    }

    private void downloadLoginData() {
        String device = "Android";
        String password = mEtPwd.getText().toString().trim();
        String email = mEtUsername.getText().toString().trim();
        String version = "1.3.0";

        OkHttpClient okHttpClient = new OkHttpClient();
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        formEncodingBuilder.add("device", device);
        formEncodingBuilder.add("password", password);
        formEncodingBuilder.add("email", email);
        formEncodingBuilder.add("version", version);
        Request request = new Request.Builder().url(Conts.URL_LOGIN)
                              .post(formEncodingBuilder.build()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response != null) {
                    //                            Log.e("response", response.body().string());
                    String string = response.body().string();
                    LoginBean loginBean = null;
                    loginBean = new Gson().fromJson(string, LoginBean.class);
                    Message message = Message.obtain();
                    message.obj = loginBean;
                    mHandler.sendMessageDelayed(message, 3000);

                }
            }
        });
    }
}
