package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 到店付款
 */
public class PayInShopActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    TextView title_back;
    @Bind(R.id.title_title)
    TextView title_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_in_shop;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("这里是店铺名字");
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
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}