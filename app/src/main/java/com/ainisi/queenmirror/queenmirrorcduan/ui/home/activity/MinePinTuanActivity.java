package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class MinePinTuanActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    String groupId,orderNo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_pin_tuan;
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void initView() {
        title_title.setText("我的拼团");

        Intent intent = this.getIntent();
        groupId = intent.getStringExtra("groupId");
        orderNo = intent.getStringExtra("orderNo");

        getMinePintuanData();
    }

    /**
     * 获取拼团后的数据
     */
    private void getMinePintuanData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("groupId", groupId);//拼团商品的ID
        parames.put("orderNo",orderNo);
        HttpUtils.doPost(ACTION.GETPINTUANAFTER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETPINTUANAFTER:
                L.e("&&&     "+res);

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
