package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.HomePageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

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

    String deviceToken,nickName,headPic,openId,loginToken,loginFlag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitle();
    }

    private void initTitle() {
        loginTitle.setText(R.string.login);
        loginRighrTitle.setText(R.string.register);

        //获取手机token值  唯一设备码
        TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        deviceToken = TelephonyMgr.getDeviceId();
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
                    LoginData();
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
        params.put("deviceToken", deviceToken);
        params.put("cellPhone", et_login_pghone.getText().toString());
        params.put("userPass",et_login_pass.getText().toString());
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
                    SP.put(LoginActivity.this, SpContent.UserId ,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
                    SP.put(LoginActivity.this,SpContent.UserCall,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
                    SP.put(LoginActivity.this,SpContent.UserName,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserName());
                    SP.put(LoginActivity.this,SpContent.isLogin,"1");
                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }else{
                    T.show(loginBean.getMsg());
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

                    Intent intent = new Intent(LoginActivity.this,LoginThirdActivity.class);
                    intent.putExtra("nickName",nickName);
                    intent.putExtra("headPic",headPic);
                    intent.putExtra("openId",openId);
                    intent.putExtra("loginToken",loginToken);
                    intent.putExtra("loginFlag",loginFlag);
                    startActivity(intent);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}
