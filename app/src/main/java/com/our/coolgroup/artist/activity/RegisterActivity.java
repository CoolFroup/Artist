package com.our.coolgroup.artist.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.GetCodeBean;
import com.our.coolgroup.artist.bean.RegistBackBean;
import com.our.coolgroup.artist.bean.RegistPostBean;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @Bind(R.id.et_username)
    TextInputEditText mEtUsername;
    @Bind(R.id.et_pwd)
    TextInputEditText mEtPwd;
    @Bind(R.id.et_message_code)
    TextInputEditText mEtMessageCode;
    @Bind(R.id.view)
    TextInputLayout mView;
    @Bind(R.id.txt_get_code)
    TextView mTxtGetCode;
    @Bind(R.id.txt_login_use_before)
    TextView mTxtLoginUseBefore;
    @Bind(R.id.btn_regist)
    Button mBtnRegist;
    @Bind(R.id.txt_user_agreement)
    TextView mTxtUserAgreement;
    @Bind(R.id.txt_any_question)
    TextView mTxtAnyQuestion;
    @Bind(R.id.img_cancle)
    ImageView mImgCancle;
    public static final MediaType JSON
        = MediaType.parse("application/json; charset=utf-8");
    int time = 60;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String textRemind = (String) msg.obj;
            Toast.makeText(RegisterActivity.this, textRemind, Toast.LENGTH_SHORT).show();
        }
    };
    private Handler mHandler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RegistBackBean.UserBean user = (RegistBackBean.UserBean) msg.obj;
            if (user == null) {
                //user为空的时候提示已注册
                Bundle bundle = msg.getData();
                String textRemind = bundle.getString("textRemind");
                Toast.makeText(RegisterActivity.this, textRemind, Toast.LENGTH_SHORT).show();
            } else {
                //user不为空，注册成功
                SharedPreferences sharedPreferences = RegisterActivity.this.getSharedPreferences("token", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                String auth_token = user.getAuth_token();
                edit.putString("token", auth_token);
                String username = user.getUsername();
                edit.putString("username", username);
                edit.commit();
                Toast.makeText(RegisterActivity.this, "注册成功" + username, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }
        }
    };

    @Override
    void initView() {
        setContentView(R.layout.activity_register);
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


    @OnClick({R.id.txt_get_code, R.id.txt_login_use_before, R.id.btn_regist, R.id.txt_user_agreement, R.id.txt_any_question, R.id.img_cancle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_get_code:

                getCode();

                break;
            case R.id.txt_login_use_before:

                finish();

                break;
            case R.id.btn_regist:

                regist();

                break;
            case R.id.txt_user_agreement:
                Intent intent = new Intent(this, UserAgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_any_question:


                break;
            case R.id.img_cancle:
                finish();
                break;
        }
    }

    //注册
    private void regist() {

        RegistPostBean registPostBean = new RegistPostBean();
        registPostBean.setDevice("Android");
        registPostBean.setVersion("1.3.0");
        registPostBean.setValid_code(mEtMessageCode.getText().toString().trim());

        RegistPostBean.UserBean userBean = new RegistPostBean.UserBean();

        userBean.setEmail(mEtUsername.getText().toString().trim());
        userBean.setPassword(mEtPwd.getText().toString().trim());
        userBean.setUsername(mEtUsername.getText().toString().trim());
        userBean.setCountry("CN");

        registPostBean.setUser(userBean);
        String postJson = new Gson().toJson(registPostBean);

        Log.e("===postJson", postJson);

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, postJson);
        Request request = new Request.Builder().url(Conts.URL_REGIST)
                              .post(requestBody).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String textRemind;
                if (response != null) {
                    String registResult = response.body().string();
                    Log.e("===registResult", registResult);
                    RegistBackBean registBackBean = new Gson().fromJson(registResult, RegistBackBean.class);
                    if (registBackBean.getError_code() == 409) {
                        textRemind = "您已注册";
                        Message message = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString("textRemind", textRemind);
                        message.setData(bundle);
                        mHandler2.sendMessage(message);
                    }
                    RegistBackBean.UserBean user = registBackBean.getUser();
                    if (user != null) {
                        textRemind = "注册成功";
                        Message message = Message.obtain();
                        message.obj = user;
                        mHandler2.sendMessage(message);
                        // TODO: 2016/7/27 发送user？  得到token 或者 username 跳转到首页

                    }
                }
            }
        });
    }

    //发送验证码
    private void getCode() {
        String phone = mEtUsername.getText().toString().trim();
        String country = "CN";
        OkHttpClient okHttpClient = new OkHttpClient();
        FormEncodingBuilder encodingBuilder = new FormEncodingBuilder();
        encodingBuilder.add("phone", phone);
        encodingBuilder.add("country", country);
        final Request request = new Request.Builder().url(Conts.URL_GETCODE)
                                    .post(encodingBuilder.build()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (response != null) {

                    String jsonString = response.body().string();

                    Log.e("===response", jsonString);

                    String textRemind;

                    Gson gson = new Gson();
                    GetCodeBean getCodeBean = gson.fromJson(jsonString, GetCodeBean.class);

                    String result = getCodeBean.getResult();

                    if (result != null) {
                        if (result.equals("ok")) {
                            textRemind = "请求成功";
                            Message message = Message.obtain();
                            message.obj = textRemind;
                            mHandler.sendMessage(message);
                        }
                    }

                    int error_code = getCodeBean.getError_code();

                    if (error_code == 420) {
                        textRemind = "请求失败,操作过于频繁";
                        Message message = Message.obtain();
                        message.obj = textRemind;
                        mHandler.sendMessage(message);
                    }
                }
            }
        });
    }
}
