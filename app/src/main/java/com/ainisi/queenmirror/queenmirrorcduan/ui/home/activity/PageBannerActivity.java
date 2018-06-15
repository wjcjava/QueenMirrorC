package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.webkit.WebView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;

public class PageBannerActivity extends BaseNewActivity {
    @Bind(R.id.web_home_banner)
    WebView webBanner;
    String weburl;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_page_banner;

    }
}
