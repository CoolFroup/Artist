package com.our.coolgroup.artist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> mTitles;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> mTitles) {
        super(fm);
        this.fragments = fragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
