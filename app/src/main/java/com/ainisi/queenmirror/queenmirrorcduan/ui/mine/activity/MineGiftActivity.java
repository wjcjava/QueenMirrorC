package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.InvitePaizeBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

//邀请有奖
public class MineGiftActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_mine_modou_number)
    TextView tv_mine_modou_number;
    CustomShareListener mShareListener;
    ShareAction mShareAction;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,MineGiftActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_gift;
    }

    @Override
    public void initView() {
        title_title.setText("邀请有奖");

        getMineMoDouData();
        inithttp();
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
        mShareListener = new CustomShareListener(MineGiftActivity.this);

    }

    private void inithttp() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("objectType","1");
        parames.put("objectId",SP.get(this,SpContent.UserId,"")+"");
        HttpUtils.doPost(ACTION.INVITEPRIZE,parames,CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    /**
     * 获取我的魔豆
     */
    private void getMineMoDouData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(MineGiftActivity.this, SpContent.UserId, "") + "");
        HttpUtils.doPost(ACTION.GETMINEMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back,R.id.tv_gift_firend,R.id.tv_gift_shop})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_gift_firend:
                mShareAction.open();
                break;
            case R.id.tv_gift_shop:
                mShareAction.open();
                break;
            default:
                break;
        }
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.GETMINEMODOU:
                int moDou = 0;
                MoDouBean moDouBean = GsonUtil.toObj(res,MoDouBean.class);
                if(moDouBean.isSuccess()){
                    moDou = moDouBean.getBody().getAnsMemberBasic().getCardBalance();
                    tv_mine_modou_number.setText(moDou+"");
                }else{
                    T.show(moDouBean.getMsg());
                }
                break;
            case ACTION.INVITEPRIZE:
              InvitePaizeBean invitePaizeBean= GsonUtil.toObj(res, InvitePaizeBean.class);
              if(invitePaizeBean.isSuccess()){
                  final String url = invitePaizeBean.getBody().getInviteUrlGenForC();
                  mShareAction = new ShareAction(MineGiftActivity.this).setDisplayList(
                          SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                          SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                  ).setShareboardclickCallback(new ShareBoardlistener() {
                      @Override
                      public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                          UMWeb web = new UMWeb(url);
                          web.setTitle("来自女王魔镜");
                          web.setDescription("来自女王魔镜内容");
                          web.setThumb(new UMImage(MineGiftActivity.this, R.mipmap.fill));
                          new ShareAction(MineGiftActivity.this).withMedia(web)
                                  .setPlatform(share_media)
                                  .setCallback(mShareListener)
                                  .share();
                      }
                  });
                  T.show(invitePaizeBean.getMsg());
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
    private static class CustomShareListener implements UMShareListener {

        private WeakReference<MineGiftActivity> mActivity;
        private CustomShareListener(MineGiftActivity activity) {
            mActivity = new WeakReference(activity);
        }
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(mActivity.get(), platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                        && platform != SHARE_MEDIA.EMAIL
                        && platform != SHARE_MEDIA.FLICKR
                        && platform != SHARE_MEDIA.FOURSQUARE
                        && platform != SHARE_MEDIA.TUMBLR
                        && platform != SHARE_MEDIA.POCKET
                        && platform != SHARE_MEDIA.PINTEREST
                        && platform != SHARE_MEDIA.INSTAGRAM
                        && platform != SHARE_MEDIA.GOOGLEPLUS
                        && platform != SHARE_MEDIA.YNOTE
                        && platform != SHARE_MEDIA.EVERNOTE) {
                    Toast.makeText(mActivity.get(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                }
            }
        }
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                    && platform != SHARE_MEDIA.EMAIL
                    && platform != SHARE_MEDIA.FLICKR
                    && platform != SHARE_MEDIA.FOURSQUARE
                    && platform != SHARE_MEDIA.TUMBLR
                    && platform != SHARE_MEDIA.POCKET
                    && platform != SHARE_MEDIA.PINTEREST
                    && platform != SHARE_MEDIA.INSTAGRAM
                    && platform != SHARE_MEDIA.GOOGLEPLUS
                    && platform != SHARE_MEDIA.YNOTE
                    && platform != SHARE_MEDIA.EVERNOTE) {
                Toast.makeText(mActivity.get(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            }
            if (t != null) {
                L.e("throw", "throw:" + t.getMessage());
            }
        }
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mActivity.get(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    }
}