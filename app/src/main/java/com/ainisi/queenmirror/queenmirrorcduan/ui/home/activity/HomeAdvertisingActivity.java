package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.net.Uri;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

public class HomeAdvertisingActivity extends BaseNewActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_advertising;
    }

    @Override
    protected void initView() {
        super.initView();
        String url = getIntent().getStringExtra("weburl");
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
