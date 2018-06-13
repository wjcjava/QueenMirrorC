package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginThridOpenidBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.HomePageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.title_right)
    TextView loginRighrTitle;
    @Bind(R.id.et_login_pghone)
    public EditText et_login_pghone;
    @Bind(R.id.bt_login_submit)
    Button bt_login_submit;
    @Bind(R.id.et_login_pass)
    EditText et_login_pass;

    @Bind(R.id.user_reg_qq_login_view)
    ImageView user_reg_qq_login_view;
    @Bind(R.id.user_reg_wechat_login_view)
    ImageView user_reg_wechat_login_view;
    @Bind(R.id.check_choice)
    CheckBox choice;
    String deviceToken,nickName,headPic,openId,loginToken,loginFlag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitle();
        choice.setChecked(true);
    }

    private void initTitle() {
        loginTitle.setText(R.string.login);
        loginRighrTitle.setText(R.string.register);

    }

    @OnClick({R.id.title_back, R.id.title_right, R.id.tv_forgetcipher,R.id.bt_login_submit,R.id.user_reg_qq_login_view,R.id.user_reg_wechat_login_view})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //注册
            case R.id.title_right:
                Intent intent = new Intent(this,RegisterActivity.class);
                intent.putExtra("where","login");
                startActivity(intent);
                break;
            //忘记密码
            case R.id.tv_forgetcipher:
                startActivity(new Intent(this, ForgetcipherActivity.class));
                break;
            /**
             * 登录按钮
             */
            case R.id.bt_login_submit:
                if(et_login_pghone.getText().toString().equals("")||et_login_pass.getText().toString().equals("")){
                    T.show("请完善相关信息");
                }else{

                    if(choice.isChecked()){
                        SP.remove(this,SpContent.Remember);
                        LoginData();
                    }
                    else {
                        SP.put(this,SpContent.Remember,"0");
                        LoginData();
                    }
                }
                break;
            case R.id.user_reg_qq_login_view:
              UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.QQ, authListener);
                loginFlag = "2";
                break;

            case R.id.user_reg_wechat_login_view:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.WEIXIN, authListener);
                loginFlag = "1";
                break;
        }
    }
    /**
     * 登录数据
     */
    private void LoginData() {
        //传参数
        HashMap<String, String> params = new HashMap<>();
        params.put("deviceToken", SP.get(this,SpContent.UserToken,"")+"");
        params.put("cellPhone", et_login_pghone.getText().toString());
        params.put("userPass", MD5.md5(et_login_pass.getText().toString()+ "MYN888"));
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.LOGIN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.LOGIN://登录
                LoginBean loginBean = GsonUtil.toObj(res,LoginBean.class);
                if(loginBean.isSuccess()){
                    SP.put(LoginActivity.this,SpContent.UserId ,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
                    SP.put(LoginActivity.this,SpContent.UserCall,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
                    SP.put(LoginActivity.this,SpContent.UserName,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserName());
                    SP.put(LoginActivity.this,SpContent.isLogin,"1");
                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }else{
                    T.show(loginBean.getMsg());

                }
                break;
            //第三方直接登录
            case ACTION.THIRDLOGINONE:
                LoginBean loginBean1 = GsonUtil.toObj(res,LoginBean.class);
                if(loginBean1.isSuccess()){
                    SP.put(LoginActivity.this,SpContent.UserId ,loginBean1.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
                    SP.put(LoginActivity.this,SpContent.UserCall,loginBean1.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
                    SP.put(LoginActivity.this,SpContent.UserName,loginBean1.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserName());
                    SP.put(LoginActivity.this,SpContent.isLogin,"1");
                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }else{
                    T.show(loginBean1.getMsg());
                }
                break;
            case ACTION.CHECKOPENID:
                LoginThridOpenidBean loginThridOpenidBean = GsonUtil.toObj(res, LoginThridOpenidBean.class);
                if(loginThridOpenidBean.isSuccess()){
                    String isExists = loginThridOpenidBean.getBody().getExists();
                    if(isExists.equals("0")){
                        //不存在
                        Intent intent = new Intent(LoginActivity.this,LoginThirdActivity.class);
                        intent.putExtra("nickName",nickName);
                        intent.putExtra("headPic",headPic);
                        intent.putExtra("openId",openId);
                        intent.putExtra("loginToken",loginToken);
                        intent.putExtra("loginFlag",loginFlag);
                        startActivity(intent);
                    }else{
                        //存在
                        ThirdLoginData();
                    }
                }else{
                    T.show(loginThridOpenidBean.getMsg());
                }
                break;
        }
    }

    /**
     * 第三方直接登录
     */
    private void ThirdLoginData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginFlag", loginFlag);
        params.put("openId", openId);
        params.put("loginToken",loginToken);
        params.put("deviceToken",SP.get(this,SpContent.UserToken,"")+"");
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.THIRDLOGINONE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            T.show("成功了");

            UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                @Override
                public void onStart(SHARE_MEDIA share_media) {

                }

                @Override
                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> data) {

                    Set<String> set = data.keySet();
                    for (String string : set) {
                        String str = data.get(string);
                        // 设置头像
                        // 设置昵称
                        if (string.equals("screen_name")) {
                            nickName = str;
                        }
                        if(string.equals("profile_image_url")){
                            headPic = str;
                        }
                        if(string.equals("openid")){
                            openId = str;
                        }
                        if(string.equals("access_token")){
                            loginToken = str;
                        }
                    }

                    CheckOpenIdData();

                }
                @Override
                public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                }

                @Override
                public void onCancel(SHARE_MEDIA share_media, int i) {
                }
            });
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            T.show("失败"+t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            T.show("取消了");
        }
    };

    /**
     * 第三方登录OpenId检验
     */
    private void CheckOpenIdData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginFlag", loginFlag);
        params.put("openId", openId);
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.CHECKOPENID, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      //  UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}
