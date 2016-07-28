package com.our.coolgroup.artist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.SpaceSizeBean;
import com.our.coolgroup.artist.customview.MyDialog;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SpaceSizeActivity extends BaseActivity {

    private LinearLayout mLinearLayout;
    private SpaceSizeBean bean;
    private int type;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            bean = (SpaceSizeBean) msg.obj;

            for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
                SpaceSizeBean.SpaceSizesBean sizesBean = bean.getSpace_sizes().get(i);
                ((TextView) mLinearLayout.getChildAt(i)).setText(sizesBean.getRange_low() + "-" + sizesBean.getRange_high());
            }
        }
    };

    @Override
    void initView() {
        setContentView(R.layout.activity_space_size);
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_SpaceSize);

        type = getIntent().getIntExtra("type", 0);


    }

    @Override
    void initData() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(Conts.URL_DESIGN_SIZE).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Gson gson = new Gson();
                SpaceSizeBean spaceSizeBean = gson.fromJson(response.body().string(), SpaceSizeBean.class);

                Message msg = Message.obtain();
                msg.obj = spaceSizeBean;
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    void initEvent() {

    }

    @Override
    protected void destoryViews() {

    }

    public void onTouchSpaceSizeClick(View view) {
        int index = mLinearLayout.indexOfChild(view);
        Intent intent = new Intent(SpaceSizeActivity.this, SpaceDesignFeesActivity.class);
        Bundle bundle = new Bundle();
        switch (index) {
            case 0:
                bundle.putInt("size", bean.getSpace_sizes().get(0).getId());
                break;
            case 1:
                bundle.putInt("size", bean.getSpace_sizes().get(1).getId());
                break;
            case 2:
                bundle.putInt("size", bean.getSpace_sizes().get(2).getId());
                break;
            case 3:
                bundle.putInt("size", bean.getSpace_sizes().get(3).getId());
                break;
        }
        bundle.putInt("type", type);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void backToDesign(View view) {
        finish();
    }

    public void backToSecond(View view) {
        //退出约设计，对话框
        View view1 = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        final MyDialog dialog = new MyDialog(this, 0, 0, view1, R.style.dialog);

        TextView cancel = (TextView) view1.findViewById(R.id.cancel_dialog);
        TextView ok = (TextView) view1.findViewById(R.id.ok_dialog);

        dialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:回退到SecondFragment
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
}
