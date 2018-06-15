package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;

public class HomeAdvertisingActivity extends BaseNewActivity {
    @Bind(R.id.web_home_banner)
    WebView bannerWeb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_advertising;
    }

    @Override
    protected void initView() {
        super.initView();
        String url = getIntent().getStringExtra("weburl");
        WebSettings settings = bannerWeb.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        settings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        settings.setSupportZoom(true);//是否可以缩放，默认true
        settings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        settings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        settings.setAppCacheEnabled(true);//是否使用缓存
        settings.setDomStorageEnabled(true);//DOM Storage
        bannerWeb.loadUrl(url);

        //该方法解决的问题是打开浏览器不调用系统浏览器，直接用webview打开
         bannerWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
