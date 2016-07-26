package com.our.coolgroup.artist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.adapter.ListAdapter_first;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ListFragment extends Fragment {

    private View mView;
    private RecyclerView mRecyclerView;
    private ListAdapter_first adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView= LayoutInflater.from(getContext()).inflate(R.layout.listfragment,container,false);
        initView();
        return mView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView_first);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new ListAdapter_first(getContext());
        mRecyclerView.setAdapter(adapter);
    }
}
