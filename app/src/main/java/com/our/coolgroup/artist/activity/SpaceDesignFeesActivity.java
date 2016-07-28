package com.our.coolgroup.artist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.SpaceFeesBean;
import com.our.coolgroup.artist.customview.CircleView;
import com.our.coolgroup.artist.customview.MyDialog;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class SpaceDesignFeesActivity extends BaseActivity implements View.OnClickListener {

    private CircleView circleView1, circleView2, circleView3, circleView4;
    private SpaceFeesBean bean;
    private int type;
    private int size;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            bean = (SpaceFeesBean) msg.obj;

            List<SpaceFeesBean.SpaceDesignFeesBean> fees = bean.getSpace_design_fees();
            circleView1.setText(fees.get(0).getRange_low() + "-" + fees.get(0).getRange_high());
            circleView2.setText(fees.get(1).getRange_low() + "-" + fees.get(1).getRange_high());
            circleView3.setText(fees.get(2).getRange_low() + "-" + fees.get(2).getRange_high());
            circleView4.setText(fees.get(3).getRange_low() + "-" + fees.get(3).getRange_high());
        }
    };

    @Override
    void initView() {
        setContentView(R.layout.activity_space_design_fees);

        circleView1 = (CircleView) findViewById(R.id.circleView1);
        circleView2 = (CircleView) findViewById(R.id.circleView2);
        circleView3 = (CircleView) findViewById(R.id.circleView3);
        circleView4 = (CircleView) findViewById(R.id.circleView4);

        circleView1.setOnClickListener(this);
        circleView2.setOnClickListener(this);
        circleView3.setOnClickListener(this);
        circleView4.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getInt("type");
        size = bundle.getInt("size");
    }

    @Override
    void initData() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(Conts.URL_DESIGN_FEES).build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Gson gson = new Gson();
                SpaceFeesBean spaceFeesBean = gson.fromJson(response.body().string(), SpaceFeesBean.class);

                Message mag = Message.obtain();
                mag.obj = spaceFeesBean;
                handler.sendMessage(mag);
            }
        });


    }

    @Override
    void initEvent() {

    }

    @Override
    protected void destoryViews() {

    }

    public void backToSpaceSize(View view) {
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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SpaceDesignFeesActivity.this, RegionActivity.class);
        Bundle bundle = new Bundle();
        List<SpaceFeesBean.SpaceDesignFeesBean> been = bean.getSpace_design_fees();
        int fees = 0;
        switch (v.getId()) {
            case R.id.circleView1:
                fees = been.get(0).getId();
                break;
            case R.id.circleView2:
                fees = been.get(1).getId();
                break;
            case R.id.circleView3:
                fees = been.get(2).getId();
                break;
            case R.id.circleView4:
                fees = been.get(3).getId();
                break;
        }
        bundle.putInt("type", type);
        bundle.putInt("size", size);
        bundle.putInt("fees", fees);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
