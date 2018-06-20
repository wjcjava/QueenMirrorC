package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import cz.msebera.android.httpclient.extras.Base64;

/**
 * 找回支付密码
 */
public class BackPayActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView payBack;
    @Bind(R.id.et_back_phone)
    EditText backPhone;
    @Bind(R.id.et_back_loginpass)
    EditText backLoginpass;
    @Bind(R.id.et_back_verification)
    EditText backVerification;
    @Bind(R.id.et_back_cureenpass)
    EditText backPaypass;
    @Bind(R.id.et_graphics_validation)
    EditText evValidateCode;
    @Bind(R.id.re_graphics_validation)
    RelativeLayout reValidation;
    @Bind(R.id.iv_graphics_validation)
    ImageView ivValidation;
    @Bind(R.id.tv_validation)
    TextView tv_validation;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private MyCountDownTimer myCountDownTimer;
    private LoginCeshiBean ceshiBean;
    private boolean addvalidatecode=false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_back_pay;
    }

    @Override
    protected void initView() {
        super.initView();
        payBack.setText(getIntent().getStringExtra("payback"));

        initKey();
    }

    @Override
    protected void initData() {
        super.initData();

        myCountDownTimer = new MyCountDownTimer(60000, 1000);
    }

    private void initbackPay() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("cellPhone", backPhone.getText().toString());//手机号
        parames.put("verifyCodeCust", backVerification.getText().toString());//验证码
        parames.put("userPass", MD5.md5(backLoginpass.getText().toString() + "MYN888"));//登录密码
        parames.put("payPass", MD5.md5(backPaypass.getText().toString() + "MYN888"));//新密码
        HttpUtils.doPost(ACTION.FORGOTPAYPASS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back, R.id.tv_ok_submit, R.id.tv_validation,R.id.iv_graphics_validation
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_ok_submit:
                initbackPay();
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(backPhone.getText())) {
                    T.show("手机号不能为空");
                } else {
                    initValidation();
                }
                break;
            case R.id.iv_graphics_validation:
                initgetShape();
                break;
        }
    }

    private void initKey() {
        //随机生成的UUID
        uuid = java.util.UUID.randomUUID().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        dataTime = simpleDateFormat.format(date);
        initPinjie();
    }

    private void initPinjie() {
        sb = new StringBuilder();
    }

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", backPhone.getText().toString());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.append("2").append(uuid).append(backPhone.getText().toString()).append(dataTime).toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        if (addvalidatecode) {
            String tvValidation = evValidateCode.getText().toString();
            if (!TextUtils.isEmpty(tvValidation)) {
                params.put("imgValidateCode", tvValidation);
            } else {
                T.show("请您输入图形验证码");
            }
        }
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    //获取图形验证码
    private void initgetShape() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("telNo", backPhone.getText().toString().trim());
        HttpUtils.doPost(ACTION.GETSHAPE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.FORGOTPAYPASS:

                break;
            //验证码获取
            case ACTION.VERIFY:
                ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if (ceshiBean.isSuccess()) {
                    reValidation.setVisibility(View.GONE);
                    myCountDownTimer.start();
                } else {
                    if (ceshiBean.getErrorCode().equals("3")) {
                        reValidation.setVisibility(View.VISIBLE);
                        initgetShape();
                    }else{
                        T.show(ceshiBean.getMsg());
                    }
                }
                break;
            //获取图形验证码
            case ACTION.GETSHAPE:
                GetShareBean getShareBean=GsonUtil.toObj(res,GetShareBean.class);
                if(getShareBean.isSuccess()){
                    String imagestr = getShareBean.getBody().getImageStr();
                    if(!TextUtils.isEmpty(imagestr)){
                        Bitmap image = stringtoBitmap(imagestr);
                        ivValidation.setImageBitmap(image);
                        addvalidatecode=true;
                    }
                }else {
                    T.show(getShareBean.getMsg());
                }
                break;
        }
    }
    public static Bitmap stringtoBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            tv_validation.setClickable(false);
            tv_validation.setText((l / 1000) + "s后重新获取");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            tv_validation.setText("重新获取验证码");
            //设置可点击
            //initValidation();
            tv_validation.setClickable(true);
        }
    }
}
