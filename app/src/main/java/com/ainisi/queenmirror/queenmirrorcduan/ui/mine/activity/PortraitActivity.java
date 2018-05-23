package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.ainisi.queenmirror.queenmirrorcduan.utils.LQRPhotoSelectUtils;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;

import java.io.File;
import java.util.HashMap;

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
    private CustomPopWindow popWindow;
    private LQRPhotoSelectUtils mLqrPhotoSelectUtils;


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, PortraitActivity.class));
    }

    @Override
    protected void initView() {
        super.initView();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_portrait_username.setText(SP.get(this, SpContent.UserName, "") + "");
    }

    private void init() {
        // 1、创建LQRPhotoSelectUtils（一个Activity对应一个LQRPhotoSelectUtils）
        mLqrPhotoSelectUtils = new LQRPhotoSelectUtils(this, new LQRPhotoSelectUtils.PhotoSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                Glide.with(PortraitActivity.this).load(outputUri).into(iv_portrait_head);
            }
        }, false);//true裁剪，false不裁剪

        //Glide.with(this).load(SP.get(this,SpContent.UserName,"")).into(iv_portrait_head);

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
                View popview = View.inflate(this, R.layout.alert_dialog, null);
                //弹出popWindow时，背景是否变暗
                // 控制亮度
                popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                        .setView(popview)
                        .setFocusable(true)
                        .size(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT)
                        .setOutsideTouchable(true)
                        .enableBackgroundDark(true) //弹出popWindow时，背景是否变暗
                        .setBgDarkAlpha(0.7f) // 控制亮度
                        .setAnimationStyle(R.style.CustomPopWindowStyle)
                        .create()
                        .showAtLocation(this.findViewById(R.id.main), Gravity.BOTTOM, 0, 0);
                initPopview(popview);
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

    private void initPopview(View popview) {
        TextView takephone = popview.findViewById(R.id.btn_take_photo);
        TextView pickphone = popview.findViewById(R.id.btn_pick_photo);
        TextView cancel = popview.findViewById(R.id.btn_cancel);
        takephone.setOnClickListener(this);
        pickphone.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //拍照
            case R.id.btn_take_photo:
                // 3、调用拍照方法
                PermissionGen.with(PortraitActivity.this)
                        .addRequestCode(LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
                        .permissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA
                        ).request();

                popWindow.dissmiss();
                break;
            //相册选择
            case R.id.btn_pick_photo:
                // 3、调用从图库选取图片方法
                PermissionGen.needPermission(PortraitActivity.this,
                        LQRPhotoSelectUtils.REQ_SELECT_PHOTO,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE});
                popWindow.dissmiss();
                break;
            //退出
            case R.id.btn_cancel:
                popWindow.dissmiss();
                break;
        }
    }

    @PermissionSuccess(requestCode = LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
    private void takePhoto() {
        mLqrPhotoSelectUtils.takePhoto();
    }

    @PermissionSuccess(requestCode = LQRPhotoSelectUtils.REQ_SELECT_PHOTO)
    private void selectPhoto() {
        mLqrPhotoSelectUtils.selectPhoto();
    }

    @PermissionFail(requestCode = LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
    private void showTip1() {
        //        Toast.makeText(getApplicationContext(), "不给我权限是吧，那就别玩了", Toast.LENGTH_SHORT).show();
        showDialog();
    }

    @PermissionFail(requestCode = LQRPhotoSelectUtils.REQ_SELECT_PHOTO)
    private void showTip2() {
        //        Toast.makeText(getApplicationContext(), "不给我权限是吧，那就别玩了", Toast.LENGTH_SHORT).show();
        showDialog();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 2、在Activity中的onActivityResult()方法里与LQRPhotoSelectUtils关联
        mLqrPhotoSelectUtils.attachToActivityForResult(requestCode, resultCode, data);
    }

    public void showDialog() {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置对话框显示小图标
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //设置标题
        builder.setTitle("权限申请");
        //设置正文
        builder.setMessage("在设置-应用-虎嗅-权限 中开启相机、存储权限，才能正常使用拍照或图片选择功能");
        //添加确定按钮点击事件
        builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {//点击完确定后，触发这个事件

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //这里用来跳到手机设置页，方便用户开启权限
                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + PortraitActivity.this.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        //添加取消按钮点击事件
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //使用构建器创建出对话框对象
        AlertDialog dialog = builder.create();
        dialog.show();//显示对话框
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
                    //finish();
                } else {
                    T.show(successBean.getMsg());
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
}
