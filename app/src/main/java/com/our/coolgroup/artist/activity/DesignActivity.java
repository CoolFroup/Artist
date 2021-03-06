package com.our.coolgroup.artist.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.bean.DesignTypeBean;
import com.our.coolgroup.artist.customview.MyDialog;
import com.our.coolgroup.artist.utils.Conts;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class DesignActivity extends BaseActivity {
    private DesignTypeBean bean;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            //选择类型
            bean = (DesignTypeBean) msg.obj;

        }
    };

    @Override
    void initView() {
        setContentView(R.layout.activity_design);
    }

    @Override
    void initData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(Conts.URL_DESIGN_TYPE).build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Gson gson = new Gson();
                DesignTypeBean typeBean = gson.fromJson(response.body().string(), DesignTypeBean.class);

                Message msg = new Message();
                msg.obj = typeBean;
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

    public void onTouchClick(View view) {
        Intent intent = new Intent(DesignActivity.this, SpaceSizeActivity.class);
        int type = 0;
        switch (view.getId()) {
            case R.id.canyin_designType:
                type = bean.getSpace_types().get(0).getType_id();
                break;
            case R.id.bangong_designType:
                type = bean.getSpace_types().get(1).getType_id();
                break;
            case R.id.yishu_designType:
                type = bean.getSpace_types().get(2).getType_id();
                break;
            case R.id.jiudian_designType:
                type = bean.getSpace_types().get(3).getType_id();
                break;
            case R.id.shenghuo_designType:
                type = bean.getSpace_types().get(4).getType_id();
                break;
            case R.id.lingshou_designType:
                type = bean.getSpace_types().get(5).getType_id();
                break;
            case R.id.gonggong_designType:
                type = bean.getSpace_types().get(6).getType_id();
                break;
            case R.id.qita_designType:
                type = bean.getSpace_types().get(7).getType_id();
                break;
        }
        intent.putExtra("type", type);
        startActivity(intent);
    }
}
