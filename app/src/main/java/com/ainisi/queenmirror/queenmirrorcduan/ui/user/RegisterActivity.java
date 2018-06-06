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
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.PhoneCheckBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 注册
 */
public class RegisterActivity extends BaseNewActivity implements HttpCallBack {
    private static final String TAG = "RegisterActivity";
    @Bind(R.id.title_title)
    TextView registerTitle;
    @Bind(R.id.tv_phonenumber)
    EditText phoneNumber;
    @Bind(R.id.tv_validation)
    TextView validation;
    @Bind(R.id.et_password)
    EditText passWord;
    @Bind(R.id.et_validation)
    EditText etValidation;
    @Bind(R.id.iv_login_see)
    ImageView loginSee;
    @Bind(R.id.iv_remove_text)
    ImageView removeText;
    private MyCountDownTimer myCountDownTimer;
    private boolean click;
    private LoginCeshiBean ceshiBean;
    String vConfig = "";
    String nickName, headPic, openId, loginToken, where, loginFlag;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        inidTitle();


        Intent intent = this.getIntent();
        where = intent.getStringExtra("where");

        if (where.equals("third")) {
            nickName = intent.getStringExtra("nickName");
            headPic = intent.getStringExtra("headPic");
            openId = intent.getStringExtra("openId");
            loginToken = intent.getStringExtra("loginToken");
            loginFlag = intent.getStringExtra("loginFlag");
        } else {
        }
    }

    private void initKey() {
        //随机生成的UUID
        uuid = java.util.UUID.randomUUID().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        dataTime=simpleDateFormat.format(date);

        initPinjie();
    }

    private void initPinjie() {
        sb = new StringBuilder();
        sb.append("2").append(uuid).append(phoneNumber.getText().toString()).append(dataTime);

    }

    @Override
    protected void initData() {
        super.initData();
        initRemoveText();
        loginSee.setImageResource(R.drawable.icon_login_nosee);
        passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    private void inidTitle() {
        registerTitle.setText(R.string.register);
    }

    @OnClick({R.id.title_back, R.id.tv_validation, R.id.iv_remove_text, R.id.iv_login_see, R.id.bt_user_confirmregistration})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(phoneNumber.getText())) {
                    T.show("手机号不能为空");
                } else {
                    initKey();
                    initValidation();
                }
                break;
            case R.id.iv_remove_text:
                initRemoveText();
                break;
            case R.id.iv_login_see:
                initSee();
                break;
            case R.id.bt_user_confirmregistration:
                initcheck();
                break;
        }
    }

    private void initcheck() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cellPhone", phoneNumber.getText().toString().trim());
        HttpUtils.doPost(ACTION.PHONECHECK, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    private void initSee() {
        //判断第一次选中和第二次选中状态
        if (click) {
            loginSee.setImageResource(R.drawable.icon_login_nosee);
            passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
            click = false;
        } else {
            loginSee.setImageResource(R.drawable.icon_login_see);
            //如果选中，显示密码
            passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            click = true;
        }
    }

    private void initRemoveText() {
        phoneNumber.setText("");
        //手机号为空时隐藏
        if (!TextUtils.isEmpty(phoneNumber.getText())) {
            removeText.setVisibility(View.VISIBLE);
        }
        //手机号为空时
        else {
            removeText.setVisibility(View.GONE);
        }

    }

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneNumber.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");


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
                }else {
                    T.show(ceshiBean.getMsg());
                }
                break;
            case ACTION.REGIST://注册
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    T.show(successBean.getMsg());
                    if (where.equals("third")) {
                        Intent intent = new Intent(RegisterActivity.this, GuanLianActivity.class);
                        intent.putExtra("nickName", nickName);
                        intent.putExtra("headPic", headPic);
                        intent.putExtra("openId", openId);
                        intent.putExtra("loginToken", loginToken);
                        intent.putExtra("loginFlag", loginFlag);
                        startActivity(intent);
                    } else {
                        RegisterActivity.this.finish();
                    }
                } else {
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.PHONECHECK:
                PhoneCheckBean checkBean = GsonUtil.toObj(res, PhoneCheckBean.class);
                if (checkBean.isSuccess()) {
                    boolean exists = checkBean.getBody().isExists();
                    if (exists == true) {
                        T.show("此手机号已注册过请勿再次注册");
                    } else {
                        if (phoneNumber.getText().toString().trim().equals("") || passWord.getText().toString().trim().equals("") || etValidation.getText().toString().trim().equals("")) {
                            T.show("请完善相关信息");
                        } else {
                            HashMap<String, String> paramsRegister = new HashMap<>();
                            paramsRegister.put("cellPhone", phoneNumber.getText().toString().trim());
                            paramsRegister.put("userPass", MD5.md5(passWord.getText().toString() + "MYN888"));
                            paramsRegister.put("contractConfirm", "1");
                            paramsRegister.put("ifFirst", "0");
                            paramsRegister.put("verifyCode", vConfig);
                            paramsRegister.put("verifyCodeCust", etValidation.getText().toString().trim());
                            HttpUtils.doPost(ACTION.REGIST, paramsRegister, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
                        }
                    }
                } else {
                    T.show(checkBean.getMsg());
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