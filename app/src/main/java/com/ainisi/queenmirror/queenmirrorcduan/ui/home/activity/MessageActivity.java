package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeMessageBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
//消息
public class MessageActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.tv_message_interactive)
    TextView tvInteractive;
    @Bind(R.id.tv_message_system)
    TextView tvSystem;
    @Bind(R.id.tv_message_review)
    TextView tvReview;

    private HomeMessageBean messageBean;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,MessageActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_home_message;
    }

    @Override
    public void initView() {
        initText();

    }

    @Override
    protected void initData() {
        super.initData();
        inithttp();
    }

    private void inithttp() {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("tabType","2");
        hashMap.put("tabFather","0");
        HttpUtils.doPost(ACTION.MESSAGE,hashMap, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    private void initText() {
        title.setText(R.string.message_center);
        title.setTextColor(ContextCompat.getColor(this,R.color.alpha_95_black));
    }

    @OnClick({R.id.title_back,R.id.layout_message_interactive,R.id.layout_message_system,R.id.layout_message_review
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.layout_message_interactive:
                break;
            case R.id.layout_message_system:
                break;
            case R.id.layout_message_review:
                OrderMessageActivity.startActivity(MessageActivity.this);
                break;
            default:
                break;

        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            //首页消息类型列表
            case ACTION.MESSAGE:
                messageBean = GsonUtil.toObj(res, HomeMessageBean.class);
                tvInteractive.setText(messageBean.getBody().getMessageTypeListData().get(0).getDict().getLabel());
                tvSystem.setText(messageBean.getBody().getMessageTypeListData().get(1).getDict().getLabel());
                tvReview.setText(messageBean.getBody().getMessageTypeListData().get(2).getDict().getLabel());
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
