package com.our.coolgroup.artist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.our.coolgroup.artist.bean.Header_firstBean;
import com.our.coolgroup.artist.bean.ShoppingBean;
import com.our.coolgroup.artist.fragment.HeaderFragment;
import com.our.coolgroup.artist.fragment.PingLunFragment;
import com.our.coolgroup.artist.fragment.XiangQingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ShoppingAdapter extends FragmentPagerAdapter {

    private List<String> data;


    public void setData(List<String> data) {
        if (data != null) {
            this.data = data;

        } else {
            this.data = new ArrayList<>();

        }
    }

    public ShoppingAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                XiangQingFragment xiangQingFragment = new XiangQingFragment();
                xiangQingFragment.setData(data);
                return xiangQingFragment;

            case 1:
                PingLunFragment pingLunFragment = new PingLunFragment();
               return pingLunFragment;

        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
