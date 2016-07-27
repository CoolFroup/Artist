package com.our.coolgroup.artist.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.our.coolgroup.artist.R;
import com.our.coolgroup.artist.activity.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    @Bind(R.id.webview)
    WebView mWebview;
    @Bind(R.id.img_third_shopping)
    ImageView mImgThirdShopping;
    @Bind(R.id.img_third_setting)
    ImageView mImgThirdSetting;
    @Bind(R.id.img_user_icon)
    ImageView mImgUserIcon;
    @Bind(R.id.txt_isLogin)
    TextView mTxtIsLogin;
    @Bind(R.id.linear_login)
    LinearLayout mLinearLogin;
    @Bind(R.id.txt_preparePay_num)
    TextView mTxtPreparePayNum;
    @Bind(R.id.linear_preparePay)
    LinearLayout mLinearPreparePay;
    @Bind(R.id.txt_prepareRecieve_num)
    TextView mTxtPrepareRecieveNum;
    @Bind(R.id.linear_prepareRecieve)
    LinearLayout mLinearPrepareRecieve;
    @Bind(R.id.txt_compelete_num)
    TextView mTxtCompeleteNum;
    @Bind(R.id.linear_compelete)
    LinearLayout mLinearCompelete;
    @Bind(R.id.linear_orders)
    LinearLayout mLinearOrders;
    @Bind(R.id.linear_message)
    LinearLayout mLinearMessage;
    @Bind(R.id.linear_sddress)
    LinearLayout mLinearSddress;
    @Bind(R.id.linear_coupons)
    LinearLayout mLinearCoupons;
    @Bind(R.id.linear_space_orders)
    LinearLayout mLinearSpaceOrders;
    @Bind(R.id.linear_space_like)
    LinearLayout mLinearSpaceLike;
    @Bind(R.id.linear_products_liked)
    LinearLayout mLinearProductsLiked;
    @Bind(R.id.linear_customer_service)
    LinearLayout mLinearCustomerService;
    @Bind(R.id.linear_esigners_in)
    LinearLayout mLinearEsignersIn;
    private boolean isLogin = false;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_default_portrait);
        mImgUserIcon.setImageBitmap(toRoundBitmap(bitmap));

    }

    public Bitmap toRoundBitmap(Bitmap bitmap) {
        //圆形图片宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //正方形的边长
        int r = 0;
        //取最短边做边长
        if (width > height) {
            r = height;
        } else {
            r = width;
        }
        //构建一个bitmap
        Bitmap backgroundBmp = Bitmap.createBitmap(width,
                height, Bitmap.Config.ARGB_8888);
        //new一个Canvas，在backgroundBmp上画图
        Canvas canvas = new Canvas(backgroundBmp);
        Paint paint = new Paint();
        //设置边缘光滑，去掉锯齿
        paint.setAntiAlias(true);
        //宽高相等，即正方形
        RectF rect = new RectF(0, 0, r, r);
        //通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径时，
        //且都等于r/2时，画出来的圆角矩形就是圆形
        canvas.drawRoundRect(rect, r / 2, r / 2, paint);
        //设置当两个图形相交时的模式，SRC_IN为取SRC图形相交的部分，多余的将被去掉
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //canvas将bitmap画在backgroundBmp上
        canvas.drawBitmap(bitmap, null, rect, paint);
        //返回已经绘画好的backgroundBmp
        return backgroundBmp;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.img_third_shopping, R.id.img_third_setting, R.id.linear_login, R.id.linear_preparePay, R.id.linear_prepareRecieve, R.id.linear_compelete, R.id.linear_orders, R.id.linear_message, R.id.linear_sddress, R.id.linear_coupons, R.id.linear_space_orders, R.id.linear_space_like, R.id.linear_products_liked, R.id.linear_customer_service, R.id.linear_esigners_in})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_third_shopping:
                if (isLogin) {


                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.img_third_setting:

                break;
            case R.id.linear_login:
                if (isLogin) {


                } else {
                    Intent intent3 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent3);
                }
                break;
            case R.id.linear_preparePay:
                if (isLogin) {


                } else {
                    Intent intent4 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent4);
                }
                break;
            case R.id.linear_prepareRecieve:
                if (isLogin) {


                } else {
                    Intent intent5 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent5);
                }
                break;
            case R.id.linear_compelete:
                if (isLogin) {


                } else {
                    Intent intent6 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent6);
                }
                break;
            case R.id.linear_orders:
                if (isLogin) {


                } else {
                    Intent intent7 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent7);
                }
                break;
            case R.id.linear_message:
                if (isLogin) {


                } else {
                    Intent intent8 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent8);
                }
                break;
            case R.id.linear_sddress:
                if (isLogin) {


                } else {
                    Intent intent9 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent9);
                }
                break;
            case R.id.linear_coupons:
                if (isLogin) {


                } else {
                    Intent intent10 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent10);
                }
                break;
            case R.id.linear_space_orders:
                if (isLogin) {


                } else {
                    Intent intent11 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent11);
                }
                break;
            case R.id.linear_space_like:
                if (isLogin) {


                } else {
                    Intent intent12 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent12);
                }
                break;
            case R.id.linear_products_liked:
                if (isLogin) {


                } else {
                    Intent intent13 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent13);
                }
                break;
            case R.id.linear_customer_service:

                break;
            case R.id.linear_esigners_in:
                WebSettings webSettings = mWebview.getSettings();

                mWebview.loadUrl("http://www.baidu.com");
                //                mWebview.setWebViewClient(new WebViewClient(){
                //                    @Override
                //                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //                        view.loadUrl("http://www.jiangwoo.com/designers/join_us.html");
                //                        return super.shouldOverrideUrlLoading(view, url);
                //                    }
                //                });
                break;
        }
    }


}
