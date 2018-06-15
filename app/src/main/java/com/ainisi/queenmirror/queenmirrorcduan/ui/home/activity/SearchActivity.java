package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SearchGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.GoodsSearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.ShopSearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.LabelBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopSearchBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.FlowLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2017/11/12.
 * 搜索
 */

public class SearchActivity extends BaseNewActivity implements HttpCallBack {

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
    @Bind(R.id.rg_search_list_type)
    RadioGroup rg_search_list_type;
    @Bind(R.id.et_search_title)
    EditText et_search_title;
    @Bind(R.id.search_recycler_view)
    RecyclerView search_recycler_view;
    @Bind(R.id.btn_clear_history_search)
    Button btn_clear_history_search;
    @Bind(R.id.tv_history_search)
    TextView tv_history_search;

    String shopCate;
    ShopListHomeBean shopListHomeBean;
    private List<ShopListHomeBean.BodyBean.ShopListBean> shoplist = new ArrayList<>();
    List<GoodsListBean.BodyBean.GoodsListDataBean> goodsListDataBeans = new ArrayList<>();

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
        Intent intent = this.getIntent();
        shopCate = intent.getStringExtra("shopCate");

        inithttp();
    }

    @OnClick({R.id.title_back, R.id.title_search})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_search:
                if(et_search_title.getText().toString().equals("")){
                    T.show("请输入店铺或商品关键字");
                }else{
                    if (searchShop.isChecked()) {
                        initShopSearch();
                    } else if (searchNails.isChecked()) {
                        initNailsSearch();
                    } else {
                        T.show("请选择条件进行搜索");
                    }
                }
                break;
            default:
                break;

        }
    }

    /**
     * 搜索商品列表
     */
    private void initNailsSearch() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("saleFlag", "2");//活动的ID
        parames.put("pageNumber", "1");//商铺状态ID 1.首页 2.异业
        parames.put("contentByTitle", et_search_title.getText().toString());
        parames.put("shopCate",shopCate);
        parames.put("pageSize","10");
        HttpUtils.doPost(ACTION.GOODLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    /**
     * 获取搜索店铺列表
     */
    private void initShopSearch() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", "1");//活动的ID
        parames.put("contentByTitle", et_search_title.getText().toString());//商铺状态ID 1.首页 2.异业
        parames.put("shopCate",shopCate);
        parames.put("pageSize","10");
        HttpUtils.doPost(ACTION.SHOPLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
            case ACTION.GOODLIST:
                /**
                 * 获取搜索商品列表
                 */
                GoodsListBean goodsListBean = GsonUtil.toObj(res,GoodsListBean.class);

                if(goodsListBean.isSuccess()){
                    if(goodsListBean.getBody().getGoodsListData().size()>0){
                        goodsListDataBeans = goodsListBean.getBody().getGoodsListData();
                        shopsearchRecycler.setVisibility(View.GONE);
                        btn_clear_history_search.setVisibility(View.GONE);
                        tv_history_search.setVisibility(View.GONE);
                        SearchGoodsAdapter searchGoodsAdapter = new SearchGoodsAdapter(R.layout.re_workroom_short,goodsListDataBeans);
                        initstartAdapter(search_recycler_view, searchGoodsAdapter);
                    }else{
                        T.show("暂无商品信息");
                    }
                }else{
                    T.show(goodsListBean.getMsg());
                }

                break;
            /**
             * 获取店铺列表
             */
            case ACTION.SHOPLIST:
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (shopListHomeBean.isSuccess()) {
                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                        shoplist=shopListHomeBean.getBody().getShopList();
                        shopsearchRecycler.setVisibility(View.GONE);
                        btn_clear_history_search.setVisibility(View.GONE);
                        tv_history_search.setVisibility(View.GONE);
                        ShopSearchAdapter searchAdapter = new ShopSearchAdapter(R.layout.item_shopsearch, shoplist);
                        initstartAdapter(search_recycler_view, searchAdapter);
                    } else {
                        T.show("暂无店铺信息");
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }
                break;
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
                            et_search_title.setText(text);
                        }
                    });
                } else {
                    T.show(labelBean.getMsg());
                }
                break;
            /*case ACTION.ACTIVITYSHOPS:
                ShopSearchBean shopSearchBean = GsonUtil.toObj(res, ShopSearchBean.class);
                if (shopSearchBean.isSuccess()) {
                    shopsearchRecycler.setVisibility(View.VISIBLE);
                    footprineRelayout.setVisibility(View.GONE);
                    List<ShopSearchBean.BodyBean.ShopListDataBean> shopList = shopSearchBean.getBody().getShopListData();
                    ShopSearchAdapter searchAdapter = new ShopSearchAdapter(R.layout.item_shopsearch, shopList);
                    initstartAdapter(shopsearchRecycler, searchAdapter);

                } else {
                    T.show(shopSearchBean.getMsg());
                }
                break;*/
            case ACTION.ACTIVITYGOODS:
                GoodsBean goodsBean = GsonUtil.toObj(res, GoodsBean.class);
                if (goodsBean.isSuccess()) {
                    shopsearchRecycler.setVisibility(View.VISIBLE);
                    footprineRelayout.setVisibility(View.GONE);
                    List<GoodsBean.BodyBean.ActivityListDataBean> goodsList = goodsBean.getBody().getActivityListData();
                    GoodsSearchAdapter searchAdapter = new GoodsSearchAdapter(R.layout.item_shopsearch, goodsList);
                    initstartAdapter(shopsearchRecycler, searchAdapter);

                } else {
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
