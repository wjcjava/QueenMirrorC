package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.GoodsBannerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.ShopBannerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class HomeAdvertisingActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.web_home_banner)
    WebView bannerWeb;
    @Bind(R.id.re_banner_activity)
    RecyclerView reBanner;
    @Bind(R.id.line_banner)
    LinearLayout lineBanner;
    @Bind(R.id.iv_banner)
    ImageView ivBanner;
    @Bind(R.id.title_title)
    TextView title_banner;
    private String bannerId;
    private String bannerStyle;
    private String bannerLogo;
    private String bannerTitle;
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_advertising;
    }

    @Override
    protected void initView() {
        super.initView();
        url = getIntent().getStringExtra("weburl");
        bannerId = getIntent().getStringExtra("bannerId");
        bannerStyle = getIntent().getStringExtra("bannerStyle");
        bannerLogo = getIntent().getStringExtra("bannerLogo");
        bannerTitle = getIntent().getStringExtra("bannerTitle");
        if(bannerStyle.equals("5")){
            bannerWeb.setVisibility(View.GONE);
            lineBanner.setVisibility(View.VISIBLE);
            title_banner.setText(bannerTitle);
            Glide.with(this).load(bannerLogo).centerCrop().into(ivBanner);
            initHttpBannerGood();
        }else if(bannerStyle.equals("4")){
            bannerWeb.setVisibility(View.GONE);
            lineBanner.setVisibility(View.VISIBLE);
            title_banner.setText(bannerTitle);
            Glide.with(this).load(bannerLogo).centerCrop().into(ivBanner);
            initHttpBannerShop();
        }else if(bannerStyle.equals("2")){
            bannerWeb.setVisibility(View.VISIBLE);
            lineBanner.setVisibility(View.GONE);
            title_banner.setText(bannerTitle);
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
        }else if(bannerStyle.equals("1")){
            bannerWeb.setVisibility(View.VISIBLE);
            lineBanner.setVisibility(View.GONE);
            title_banner.setText(bannerTitle);
            new WebService(this, Html.fromHtml(url).toString(), bannerWeb);
            //硬件加速
            bannerWeb.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

    }
    //banner商家列表数据
    private void initHttpBannerShop() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("bannerId",bannerId);
        parames.put("shopCate","1");
        HttpUtils.doPost(ACTION.SHOPSBANNER,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    //banner商品列表数据
    private void initHttpBannerGood() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("bannerId",bannerId);
        parames.put("shopCate","1");
        HttpUtils.doPost(ACTION.GOODSBANNER,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GOODSBANNER:
               GoodsBannerBean bannerBean= GsonUtil.toObj(res, GoodsBannerBean.class);
               if(bannerBean.isSuccess()){
                   List<GoodsBannerBean.BodyBean.BannerListDataBean> shopList = bannerBean.getBody().getBannerListData();
                   GoodsBannerAdapter bannerAdapter=new GoodsBannerAdapter(R.layout.item_shortrecycler,shopList);
                   reBanner.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                   reBanner.setAdapter(bannerAdapter);

               }else {
                   T.show(bannerBean.getMsg());
               }
                break;
            case ACTION.SHOPSBANNER:
                ShopBannerBean shopBannerBean= GsonUtil.toObj(res, ShopBannerBean.class);
                if(shopBannerBean.isSuccess()){
                    List<ShopBannerBean.BodyBean.ShopListDataBean> shopList = shopBannerBean.getBody().getShopListData();
                    ShopBannerAdapter bannerAdapter=new ShopBannerAdapter(R.layout.item_shortrecycler,shopList);
                    reBanner.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                    reBanner.setAdapter(bannerAdapter);

                }else {
                    T.show(shopBannerBean.getMsg());
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
    @OnClick({R.id.title_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;
        }
    }
}
