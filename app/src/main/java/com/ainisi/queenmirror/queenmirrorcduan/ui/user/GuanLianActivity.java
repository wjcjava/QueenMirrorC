package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class GuanLianActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.gl_et_login_pghone)
    EditText gl_et_login_pghone;
    @Bind(R.id.gl_et_login_pass)
    EditText gl_et_login_pass;
    @Bind(R.id.gl_bt_login_submit)
    TextView gl_bt_login_submit;

    String nickName,headPic,openId,loginToken,deviceToken,loginFlag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guan_lian;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("关联账号");

        Intent intent = this.getIntent();
        nickName = intent.getStringExtra("nickName");
        headPic = intent.getStringExtra("headPic");
        openId = intent.getStringExtra("openId");
        loginToken = intent.getStringExtra("loginToken");
        loginFlag = intent.getStringExtra("loginFlag");


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

    @OnClick({R.id.title_back,R.id.gl_bt_login_submit})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.gl_bt_login_submit:
                if(gl_et_login_pghone.getText().toString().equals("")||gl_et_login_pass.getText().toString().equals("")){
                    T.show("请完善相关信息");
                }else{
                    LoginData();
                }
                break;
        }
    }
    /**
     * 登录数据
     */
    private void LoginData() {
        //传参数
        HashMap<String, String> params = new HashMap<>();
        params.put("loginFlag", loginFlag);
        params.put("nickName", nickName);
        params.put("headPic",headPic);
        params.put("openId",openId);
        params.put("loginToken",loginToken);
        params.put("bindingTel",gl_et_login_pghone.getText().toString());
        params.put("userPass",gl_et_login_pass.getText().toString());
        params.put("contractConfirm","1");
        params.put("ifFirst","0");
        params.put("deviceToken",deviceToken);
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.LOGIN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
