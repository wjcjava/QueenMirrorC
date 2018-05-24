package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.ForgetCipherBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class ForgetcipherActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.et_phonenumber)
    EditText phoneNumber;
    @Bind(R.id.et_validation)
    EditText etvalidation;
    @Bind(R.id.et_password)
    EditText passWord;

    @Bind(R.id.iv_login_see)
    ImageView loginSee;
    @Bind(R.id.tv_validation)
    TextView validation;
    private boolean click;
    private MyCountDownTimer myCountDownTimer;
    private LoginCeshiBean ceshiBean;
    private String vConfig;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetcipher;
    }

    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        initText();

        loginSee.setImageResource(R.drawable.icon_login_nosee);
        passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
    private void initText() {
        loginTitle.setText(R.string.forgetcipher);
    }

    @OnClick({R.id.title_back, R.id.iv_remove_text, R.id.iv_login_see, R.id.tv_validation, R.id.bt_user_forgotpassword})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.iv_remove_text:
                phoneNumber.setText("");
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(phoneNumber.getText().toString().trim())) {
                    T.show("手机号不能为空");
                } else {
                    initValidation();
                    myCountDownTimer.start();
                }

                break;
            //密码是否可见
            case R.id.iv_login_see:
                if (click) {
                    loginSee.setImageResource(R.drawable.icon_login_nosee);
                    passWord.setSelection(passWord.getText().length());
                    passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    click = false;
                } else {
                    //如果选中，显示密码
                    loginSee.setImageResource(R.drawable.icon_login_see);
                    passWord.setSelection(passWord.getText().length());
                    passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    click = true;
                }
                break;
            case R.id.bt_user_forgotpassword:
                if (TextUtils.isEmpty(phoneNumber.getText().toString()) || TextUtils.isEmpty(validation.getText().toString()) || TextUtils.isEmpty(passWord.getText().toString())) {
                    T.show("请输入完整信息");
                } else {
                    HashMap<String, String> parames = new HashMap<>();
                    parames.put("cellPhone",phoneNumber.getText().toString().trim());
                    parames.put("verifyCode",vConfig);
                    parames.put("verifyCodeCust",etvalidation.getText().toString().trim());
                    parames.put("userPass",passWord.getText().toString());
                    HttpUtils.doPost(ACTION.FORGOTPASSWORD,parames,CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
                }
                break;
        }


    }

    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneNumber.getText().toString().trim());
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.VERIFY:
                ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);

                if (ceshiBean.isSuccess()) {
                    myCountDownTimer.start();
                    vConfig = ceshiBean.getBody().getVerifyCode();
                } else {
                    T.show("系统出错，请稍后再试");
                }
                break;
            case ACTION.FORGOTPASSWORD:
                ForgetCipherBean cipherBean=GsonUtil.toObj(res, ForgetCipherBean.class);
                if(cipherBean.isSuccess()){
                    T.show(cipherBean.getMsg());
                    Intent intent=new Intent(this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    T.show(cipherBean.getMsg());
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
            validation.setClickable(true);
        }
    }

}
