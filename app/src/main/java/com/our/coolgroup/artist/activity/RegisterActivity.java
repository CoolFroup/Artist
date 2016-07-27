package com.our.coolgroup.artist.activity;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.our.coolgroup.artist.R;

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
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.txt_user_agreement)
    TextView mTxtUserAgreement;
    @Bind(R.id.txt_any_question)
    TextView mTxtAnyQuestion;
    @Bind(R.id.img_cancle)
    ImageView mImgCancle;

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


    @OnClick({R.id.txt_get_code, R.id.txt_login_use_before, R.id.btn_login, R.id.txt_user_agreement, R.id.txt_any_question, R.id.img_cancle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_get_code:
                break;
            case R.id.txt_login_use_before:
                finish();
                break;
            case R.id.btn_login:

                break;
            case R.id.txt_user_agreement:

                break;
            case R.id.txt_any_question:

                break;
            case R.id.img_cancle:
                finish();
                break;
        }
    }
}
