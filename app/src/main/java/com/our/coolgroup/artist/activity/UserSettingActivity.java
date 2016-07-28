package com.our.coolgroup.artist.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.our.coolgroup.artist.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSettingActivity extends BaseActivity {

    @Bind(R.id.img_back)
    ImageView mImgBack;
    @Bind(R.id.txt_hasicon)
    TextView mTxtHasicon;
    @Bind(R.id.relative_change_icon)
    RelativeLayout mRelativeChangeIcon;
    @Bind(R.id.txt_shownickname)
    TextView mTxtShownickname;
    @Bind(R.id.relative_change_nickname)
    RelativeLayout mRelativeChangeNickname;
    @Bind(R.id.relative_changepwd)
    RelativeLayout mRelativeChangepwd;
    @Bind(R.id.txt_hasphonenumber)
    TextView mTxtHasphonenumber;
    @Bind(R.id.relative_phonenumber)
    RelativeLayout mRelativePhonenumber;
    @Bind(R.id.txt_exit)
    TextView mTxtExit;

    @Override
    void initView() {
        setContentView(R.layout.activity_user_setting);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_back, R.id.relative_change_icon, R.id.relative_change_nickname, R.id.relative_changepwd, R.id.relative_phonenumber, R.id.txt_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.relative_change_icon:
                break;
            case R.id.relative_change_nickname:
                break;
            case R.id.relative_changepwd:
                break;
            case R.id.relative_phonenumber:
                break;
            case R.id.txt_exit:
                //退出登录  把token变成none
                SharedPreferences sharedPreferences = getSharedPreferences("token", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("token","None");
                edit.commit();
                Toast.makeText(UserSettingActivity.this, "已退出登录", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
