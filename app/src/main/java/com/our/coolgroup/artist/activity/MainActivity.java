package com.our.coolgroup.artist.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.fragment.FirstFragment;
import com.our.coolgroup.artist.fragment.SecondFragment;
import com.our.coolgroup.artist.fragment.ThirdFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.linear_main_fragment)
    LinearLayout mLinearMainFragment;
    @Bind(R.id.radio_first)
    RadioButton mRadioFirst;
    @Bind(R.id.radio_second)
    RadioButton mRadioSecond;
    @Bind(R.id.radio_third)
    RadioButton mRadioThird;

    @Override
    void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        transaction1.replace(R.id.linear_main_fragment, firstFragment).commit();
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


    @OnClick({R.id.radio_first, R.id.radio_second, R.id.radio_third})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio_first:
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
                FirstFragment firstFragment = new FirstFragment();
                transaction1.replace(R.id.linear_main_fragment, firstFragment).commit();
                break;
            case R.id.radio_second:
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
                SecondFragment secondFragment = new SecondFragment();
                transaction2.replace(R.id.linear_main_fragment, secondFragment).commit();
                break;
            case R.id.radio_third:
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction transaction3 = fragmentManager3.beginTransaction();
                ThirdFragment thirdFragment = new ThirdFragment();
                transaction3.replace(R.id.linear_main_fragment, thirdFragment).commit();
                break;
        }
    }
}
