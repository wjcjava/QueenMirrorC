package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;

/**
 * 我的——成为美业人
 */
public class MineBeautyActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView beautyTitle;
    @Bind(R.id.title_right)
    TextView titleRight;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineBeautyActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_beauty;
    }

    @Override
    public void initView() {
        beautyTitle.setText(R.string.beauty);
        titleRight.setText(R.string.reservation);
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
