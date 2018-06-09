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
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.SetPayPessBean;
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

public class ModifyPayActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView paymodify;
    @Bind(R.id.et_system_phone)
    EditText phoneText;
    @Bind(R.id.et_system_loginpass)
    EditText loginPasstext;
    @Bind(R.id.et_pay_password)
    EditText payPasstext;
    @Bind(R.id.et_system_verification)
    EditText verification;
    @Bind(R.id.tv_validation)
    TextView validation;
    private String passwrd;
    private LoginCeshiBean ceshiBean;
    private MyCountDownTimer myCountDownTimer;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_pay;
    }

    @Override
    protected void initView() {
        super.initView();
        paymodify.setText("设置支付密码");

    }

    @Override
    protected void initData() {
        super.initData();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
    }

    private void initPayPass() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("loginCellPhone", phoneText.getText().toString());
        parames.put("verifyCodeCust",verification.getText().toString());
        parames.put("loginPass", MD5.md5(loginPasstext.getText().toString() + "MYN888"));
        parames.put("payPass", MD5.md5(payPasstext.getText().toString() + "MYN888"));

        HttpUtils.doPost(ACTION.SETPAYPASS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back, R.id.tv_ok_submit,R.id.tv_validation
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_ok_submit:
                    initPayPass();
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(phoneText.getText())) {
                    T.show("手机号不能为空");
                } else {
                    initKey();
                    initValidation();
                }
        }


    }
    private void initKey() {
        //随机生成的UUID
        uuid = java.util.UUID.randomUUID().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        dataTime =simpleDateFormat.format(date);
        initPinjie();
    }

    private void initPinjie() {
        sb = new StringBuilder();
        sb.append(2).append(uuid).append(phoneText.getText().toString()).append(dataTime);
        Log.e("字符串拼接", sb.toString());
    }
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneText.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.SETPAYPASS:
                SetPayPessBean payPessBean = GsonUtil.toObj(res, SetPayPessBean.class);
                if (payPessBean.isSuccess()) {
                    T.show("支付密码设置成功");
                    finish();
                } else {
                    T.show(payPessBean.getMsg());
                }
                break;
            case ACTION.VERIFY://获取验证码
                ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if (ceshiBean.isSuccess()) {
                    myCountDownTimer.start();
                } else {
                   T.show(ceshiBean.getMsg());
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
            validation.setClickable(false);
            validation.setText((l / 1000) + "s后重新获取");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            validation.setText("重新获取验证码");
            //设置可点击
            //initValidation();
            validation.setClickable(true);
        }
    }
}
