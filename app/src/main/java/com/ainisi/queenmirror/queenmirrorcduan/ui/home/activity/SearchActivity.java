package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.GoodsSearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.ShopSearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.LabelBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopSearchBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.FlowLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2017/11/12.
 * 搜索
 */

public class SearchActivity extends BaseNewActivity implements HttpCallBack {

    @Bind(R.id.et_title)
    TextView etTitle;
    @Bind(R.id.his_flowLayout)
    FlowLayout his_flowLayout;
    @Bind(R.id.search_radio_shop)
    RadioButton searchShop;
    @Bind(R.id.search_radio_nails)
    RadioButton searchNails;
    @Bind(R.id.re_search_footprint)
    RelativeLayout footprineRelayout;
    @Bind(R.id.recycler_shopsearch)
    RecyclerView shopsearchRecycler;

    public static void startActivity(Context context) {
        Intent in = new Intent(context, SearchActivity.class);
        context.startActivity(in);
    }

    @Override
    public int getLayoutId() {
        StatusBarUtil.getStatusBarLightMode(getWindow());
        return R.layout.activity_search;

    }

    @Override
    public void initView() {

        initHotTag();
        inithttp();

    }

    private void initShopSearch() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("activityId","111");//活动的ID
        parames.put("shopCate","1");//商铺状态ID 1.首页 2.异业
        HttpUtils.doPost(ACTION.ACTIVITYSHOPS,parames,CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }


    @OnClick({R.id.title_back, R.id.title_search
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_search:
                if(searchShop.isChecked()){
                    initShopSearch();
                }else if(searchNails.isChecked()){
                    initNailsSearch();
                }
                else {
                    T.show("请选择条件进行搜索");
                }

                break;
            default:
                break;

        }
    }
    private void initNailsSearch() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("activityId","111");//活动的ID
        parames.put("shopCate","1");//商铺状态ID 1.首页 2.异业
        HttpUtils.doPost(ACTION.ACTIVITYGOODS,parames,CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }
    /**
     * 热门搜索
     */
    private void initHotTag() {

    }

    private void inithttp() {
        HashMap<String, String> params = new HashMap<>();
        params.put("tabCategory", "2");
        params.put("belongCate", "");
        HttpUtils.doPost(ACTION.LABEL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.LABEL:
                LabelBean labelBean = GsonUtil.toObj(res, LabelBean.class);
                if (labelBean.isSuccess()) {
                    String[] mStrings = new String[labelBean.getBody().getTabListData().size()];
                    for (int i = 0; i < labelBean.getBody().getTabListData().size(); i++) {
                        mStrings[i] = labelBean.getBody().getTabListData().get(i).getEcTab().getTabName();
                    }
                    his_flowLayout.setColorful(false);//设置是否是多彩的颜色
                    his_flowLayout.setData(mStrings);
                    his_flowLayout.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
                        @Override
                        public void TagClick(String text) {
                            etTitle.setText(text);
                        }
                    });
                } else {
                    T.show(labelBean.getMsg());
                }
                break;
            case ACTION.ACTIVITYSHOPS:
                ShopSearchBean shopSearchBean = GsonUtil.toObj(res, ShopSearchBean.class);
                if (shopSearchBean.isSuccess()) {
                    shopsearchRecycler.setVisibility(View.VISIBLE);
                    footprineRelayout.setVisibility(View.GONE);
                    List<ShopSearchBean.BodyBean.ShopListDataBean> shopList = shopSearchBean.getBody().getShopListData();
                    ShopSearchAdapter searchAdapter = new ShopSearchAdapter(R.layout.item_shopsearch, shopList);
                    initstartAdapter(shopsearchRecycler,searchAdapter);

                } else {
                    T.show(shopSearchBean.getMsg());
                }
                break;
            case ACTION.ACTIVITYGOODS:
                GoodsBean goodsBean = GsonUtil.toObj(res, GoodsBean.class);
                if (goodsBean.isSuccess()) {
                    shopsearchRecycler.setVisibility(View.VISIBLE);
                    footprineRelayout.setVisibility(View.GONE);
                    List<GoodsBean.BodyBean.ActivityListDataBean> goodsList = goodsBean.getBody().getActivityListData();
                    GoodsSearchAdapter searchAdapter = new GoodsSearchAdapter(R.layout.item_shopsearch, goodsList);
                    initstartAdapter(shopsearchRecycler,searchAdapter);

                }else {
                    T.show(goodsBean.getMsg());
                }
                break;
        }
    }

    private void initstartAdapter(RecyclerView shopsearchRecycler, BaseQuickAdapter adapter) {
        shopsearchRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        shopsearchRecycler.setAdapter(adapter);
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
