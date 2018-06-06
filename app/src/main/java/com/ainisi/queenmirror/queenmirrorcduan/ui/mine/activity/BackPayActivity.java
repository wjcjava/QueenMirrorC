package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

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
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private MyCountDownTimer myCountDownTimer;
    private LoginCeshiBean ceshiBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_back_pay;
    }

    @Override
    protected void initView() {
        super.initView();
        payBack.setText(getIntent().getStringExtra("payback"));
    }

    @Override
    protected void initData() {
        super.initData();
        initKey();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
    }

    private void initbackPay() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("cellPhone", backPaypass.getText().toString());//手机号
        parames.put("verifyCodeCust", backVerification.getText().toString());//验证码
        parames.put("userPass", MD5.md5(backLoginpass.getText().toString() + "MYN888"));//登录密码
        parames.put("payPass", MD5.md5(backPaypass.getText().toString() + "MYN888"));//新密码
        HttpUtils.doPost(ACTION.FORGOTPAYPASS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back, R.id.tv_ok_submit, R.id.tv_validation
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
        sb.append(2).append(uuid).append(backPhone).append(dataTime);
        Log.e("字符串拼接", sb.toString());
    }

    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", backPhone.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.FORGOTPAYPASS:

                break;
            case ACTION.VERIFY://获取验证码
                ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if (ceshiBean.isSuccess()) {
                    myCountDownTimer.start();
                } else {
                    T.show("系统出错，请稍后再试");
                }
                break;
        }
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
            backVerification.setClickable(false);
            backVerification.setText((l / 1000) + "s后重新获取");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            backVerification.setText("重新获取验证码");
            //设置可点击
            //initValidation();
            backVerification.setClickable(true);
        }
    }
}
