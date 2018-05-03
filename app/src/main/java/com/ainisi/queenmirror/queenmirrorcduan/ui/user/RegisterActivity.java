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

import com.ainisi.queenmirror.common.commonutils.TUtil;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;

import java.io.IOException;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 注册
 */
public class RegisterActivity extends BaseNewActivity implements HttpCallBack {
    private static final String TAG ="RegisterActivity" ;
    @Bind(R.id.title_title)
    TextView registerTitle;
    @Bind(R.id.tv_phonenumber)
    TextView phoneNumber;
    @Bind(R.id.tv_validation)
    TextView validation;
    @Bind(R.id.et_password)
    EditText passWord;
    @Bind(R.id.iv_login_see)
    ImageView loginSee;
    @Bind(R.id.iv_remove_text)
    ImageView removeText;
    private MyCountDownTimer myCountDownTimer;
    private boolean click;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }
    String url="http://192.168.50.194:8080/wg/a/api/ans/login/verifyCodeGet";
    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        inidTitle();
    }
    @Override
    protected void initData() {
        super.initData();

        loginSee.setImageResource(R.drawable.icon_login_nosee);
        passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
    private void inidTitle() {
        registerTitle.setText(R.string.register);
    }

    @OnClick({R.id.title_back, R.id.tv_validation, R.id.iv_remove_text, R.id.iv_login_see,R.id.user_reg_reg_view})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_validation:
                if(TextUtils.isEmpty(phoneNumber.getText())){
                        T.show("手机号不能为空");
                }
                else {
                    //initValidation();
                    inithttp();
                    myCountDownTimer.start();
                }

                break;
            case R.id.iv_remove_text:

                initRemoveText();

                break;
            case R.id.iv_login_see:
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
                break;
            case R.id.user_reg_reg_view:
                if(TextUtils.isEmpty(phoneNumber.getText().toString().trim())||TextUtils.isEmpty(validation.getText().toString().trim())||TextUtils.isEmpty(passWord.getText().toString().trim())){
                    Toast.makeText(this, "请将信息输入完整", Toast.LENGTH_SHORT).show();
                }else {
                    T.show("登陆成功");
                }
                break;
        }
    }

    private void inithttp() {

    }


    private void initRemoveText() {
        //手机号为空时隐藏
        if(TextUtils.isEmpty(phoneNumber.getText())){
            removeText.setVisibility(View.GONE);
        }
        //手机号为空时
        else {
            removeText.setVisibility(View.VISIBLE);
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
                Toast.makeText(this, res.toString().trim(), Toast.LENGTH_SHORT).show();
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
            initValidation();
            validation.setClickable(true);
        }
    }
}
