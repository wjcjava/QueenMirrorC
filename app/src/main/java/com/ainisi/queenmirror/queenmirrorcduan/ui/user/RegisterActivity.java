package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        inidTitle();
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
                if (TextUtils.isEmpty(phoneNumber.getText().toString().trim()) || TextUtils.isEmpty(validation.getText().toString().trim()) || TextUtils.isEmpty(passWord.getText().toString().trim())) {
                    Toast.makeText(this, "请将信息输入完整", Toast.LENGTH_SHORT).show();
                } else {
                    T.show("注册成功");
                    HashMap<String, String> paramsRegister = new HashMap<>();
                    paramsRegister.put("cellPhone",phoneNumber.getText().toString());
                    paramsRegister.put("userPass",passWord.getText().toString());
                    paramsRegister.put("contractConfirm","1");
                    paramsRegister.put("inviteCode","");
                    paramsRegister.put("ifFirst","0");
                   // paramsRegister.put("verifyCode",ceshiBean.getBody().getVerifyCode());
                    paramsRegister.put("verifyCodeCust",etValidation.getText().toString());
                    HttpUtils.doPost(ACTION.REGIST, paramsRegister, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
                }
                break;
        }
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

    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneNumber.getText().toString().trim());

        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.VERIFY://获取验证码
                ceshiBean = GsonUtil.toObj(res,LoginCeshiBean.class);

                if(ceshiBean.isSuccess()){
                    myCountDownTimer.start();
                    L.e(ceshiBean.getMsg()+"      "+ ceshiBean.getErrorCode());
                }else{
                    T.show("系统出错，请稍后再试");
                }

                break;
                case ACTION.REGIST:
                    System.out.println(res);
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
