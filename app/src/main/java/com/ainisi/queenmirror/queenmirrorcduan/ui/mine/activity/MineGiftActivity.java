package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

//邀请有奖
public class MineGiftActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_title)
    TextView title_title;


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,MineGiftActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_gift;
    }

    @Override
    public void initView() {
        title_title.setText("邀请好友");
    }
    @OnClick({R.id.title_back})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
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
