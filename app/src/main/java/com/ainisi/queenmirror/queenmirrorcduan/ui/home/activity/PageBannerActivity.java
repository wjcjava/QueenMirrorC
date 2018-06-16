package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.text.Html;
import android.view.View;
import android.webkit.WebView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;

import butterknife.Bind;

public class PageBannerActivity extends BaseNewActivity {
    @Bind(R.id.web_home_banner)
    WebView webBanner;

    private String bannerDetails;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_page_banner;

    }

    @Override
    protected void initView() {
        super.initView();
        bannerDetails=getIntent().getStringExtra("bannerDetails");
        new WebService(this, Html.fromHtml(bannerDetails).toString(), webBanner);

        //硬件加速
        webBanner.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
}
