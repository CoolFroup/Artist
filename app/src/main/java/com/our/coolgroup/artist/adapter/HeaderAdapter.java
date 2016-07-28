package com.our.coolgroup.artist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.our.coolgroup.artist.bean.Header_firstBean;
import com.our.coolgroup.artist.fragment.HeaderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class HeaderAdapter extends FragmentPagerAdapter {

    private List<Header_firstBean.HeadlinesBean> data;


    public void setData(List<Header_firstBean.HeadlinesBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public HeaderAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        HeaderFragment headerFragment = new HeaderFragment();
        headerFragment.setImgUrl(data.get(position).getThumb(),data.get(position).getTarget_id());
        return headerFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
