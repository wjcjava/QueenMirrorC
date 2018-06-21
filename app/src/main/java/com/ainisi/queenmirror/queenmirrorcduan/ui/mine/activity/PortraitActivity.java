package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.DateUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSRespContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;
import com.ufo.imageselector.DWImages;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

//我的账号
public class PortraitActivity extends BaseNewActivity implements View.OnClickListener, HttpCallBack {
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.iv_portrait_head)
    CircleImageView iv_portrait_head;
    @Bind(R.id.tv_portrait_loginout)
    TextView tv_portrait_loginout;
    @Bind(R.id.tv_portrait_username)
    TextView tv_portrait_username;
    @Bind(R.id.tv_portrait_nickname)
    TextView tv_portrait_nickname;
    @Bind(R.id.tv_userphone)
    TextView tv_userphone;
    private CustomPopWindow popWindow;

    private String securityToken;
    private String securityAppKey;

    private String securityAccessKeySecret;

    private String securityExpiration;


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, PortraitActivity.class));
    }

    @Override
    protected void initView() {
        super.initView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        tv_portrait_username.setText(SP.get(this, SpContent.UserName, "") + "");
        tv_portrait_nickname.setText(SP.get(this,SpContent.UserName,"")+"");
        tv_userphone.setText(SP.get(this,SpContent.UserCall,"")+"");
    }

    @Override
    protected void initData() {
        super.initData();
        title.setText("我的账号");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_portrait;
    }

    @OnClick({R.id.layout_userimg, R.id.layout_username, R.id.layout_password, R.id.layout_passphone, R.id.title_back, R.id.tv_portrait_loginout})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_portrait_loginout:
                LoadOutData();
                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.layout_userimg:

                getOSSToken();

                break;
            //修改用户名
            case R.id.layout_username:
                UserNameActivity.startActivity(this);
                break;
            //账户密码
            case R.id.layout_password:
                UserpassActivity.startActivity(this);
                break;
            //修改手机号
            case R.id.layout_passphone:
                UserphoneActivity.startActivity(this);
                break;
            default:
                break;
        }
    }

    /**
     * 退出当前账号
     */
    private void LoadOutData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", SP.get(this, SpContent.UserCall, "") + "");
        HttpUtils.doPost(ACTION.LOGINOUT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取OSSToken
     */
    private void getOSSToken() {
        HashMap<String, String> params = new HashMap<>();
        HttpUtils.doPost(ACTION.OSSGETTOKEN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //退出
            case R.id.btn_cancel:
                popWindow.dissmiss();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        DWImages.parserResult(requestCode, data, new DWImages.GetImagesCallback() {
            @Override
            public void onResult(List<String> images) {
                // Log.d(TAG, "onResult:--> : images: " + images.size());

                String objectKey = DateUtil.getCurrentDateTime("yyyyMMddhhmmssSSS") + ((int) ((Math.random() * 9 + 1) * 10000) + "") + ".jpg";

                OSSUtil.getInstance().setBucket("nwptest").asyncPutImage(objectKey, images.get(0), new OSSProgressCallback<PutObjectRequest>() {
                    @Override
                    public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {

                    }
                }, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                    @Override
                    public void onSuccess(PutObjectRequest request, PutObjectResult result) {

                        Log.i("这里是显示是否上传成功返回值    ：   ", "上传成功---" + result.toString());
                    }

                    @Override
                    public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {

                    }
                });
            }
        });
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.LOGINOUT:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    SP.put(this, SpContent.isLogin, "0");
                    SP.put(this, SpContent.UserId, "0");
                    SP.put(this, SpContent.UserName, "");
                    finish();
                } else {
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.OSSGETTOKEN:

                OSSRespContent ossstsModel = GsonUtil.toObj(res,OSSRespContent.class);

                L.e("%%%%%%%      "+res);

                if(ossstsModel.isSuccess()){
                    OSSUtil.getInstance().initOSS(PortraitActivity.this, SpContent.ENDPOINT, ossstsModel);
                    DWImages.getImages(this, DWImages.ACTION_ALBUM, 1);
                }
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
