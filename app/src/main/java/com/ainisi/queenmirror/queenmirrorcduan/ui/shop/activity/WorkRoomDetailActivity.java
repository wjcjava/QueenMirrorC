package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ShopTuijianAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkCreditAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkRoomAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkShopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.WorkSingleAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopDetailDataBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopSalesProduct;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopTuijianBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopXinyongBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HoveringScrollview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 商户信息
 */
public class WorkRoomDetailActivity extends BaseNewActivity implements HttpCallBack, HoveringScrollview.OnScrollListener {


    @Bind(R.id.tab_workroom)
    TabLayout tabWorkRoom;
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;
    @Bind(R.id.li_workroom_xuan)
    LinearLayout li_workroom_xuan;
    @Bind(R.id.search01)
    LinearLayout search01;
    @Bind(R.id.search2)
    LinearLayout search2;
    @Bind(R.id.whs_workroom_scroll)
    HoveringScrollview whs_workroom_scroll;
    @Bind(R.id.li_workroom_top)
    LinearLayout li_workroom_top;
    @Bind(R.id.re_recommendable_projects_shop)
    RecyclerView re_recommendable_projects_shop;
    private int searchLayoutTop;
    @Bind(R.id.listView)
    NoScrollListview listView;
    @Bind(R.id.tv_shop)
    TextView tvShop;
    @Bind(R.id.list_shop)
    NoScrollListview listShop;
    @Bind(R.id.tv_single)
    TextView tvSingle;
    @Bind(R.id.list_single)
    NoScrollListview listSingle;
    @Bind(R.id.re_workroom_coupon)
    RelativeLayout reCoupu;
    @Bind(R.id.re_infor_massage)
    RelativeLayout reMassage;
    @Bind(R.id.tv_work_detail_hangye)
    TextView tv_work_detail_hangye;
    @Bind(R.id.tv_work_detail_address)
    TextView tv_work_detail_address;
    @Bind(R.id.tv_work_detail_time)
    TextView tv_work_detail_time;
    @Bind(R.id.tv_work_detail_introduce)
    TextView tv_work_detail_introduce;

    List<SortBean> sortlist = new ArrayList<>();
    List<String> tabList = new ArrayList<>();
    private WorkRoomAdapter listadapter;
    int pageNumber = 1,pageSum;
    String shopName,shopId;
    private WorkCreditAdapter creditAdapter;

    List<ShopTuijianBean.BodyBean.ApiEcGoodsBasicListBean> apiEcGoodsBasicList = new ArrayList<>();
    List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList = new ArrayList<>();

    List<ShopXinyongBean.BodyBean.ApiShopScoreListBean> apiShopScoreList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_room_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        initTab();
        Intent intent = getIntent();
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        tv_common_title.setText(shopName);
        whs_workroom_scroll.setOnScrollListener(this);

        doFirstData();

        doGetSaleShop();

    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.SHOPTUIJIANLIST://获取商家推荐商品列表
                ShopTuijianBean shopTuijianBean = GsonUtil.toObj(res,ShopTuijianBean.class);

                apiEcGoodsBasicList = shopTuijianBean.getBody().getApiEcGoodsBasicList();

                ShopTuijianAdapter sortAdapter = new ShopTuijianAdapter(R.layout.re_full_recommend, apiEcGoodsBasicList);
                re_recommendable_projects_shop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                re_recommendable_projects_shop.setAdapter(sortAdapter);
                break;
            case ACTION.SHOPSALEPRODUCT://获取商家所卖商品列表
                ShopSalesProduct shopSalesProduct = GsonUtil.toObj(res,ShopSalesProduct.class);

                apiGoodsList = shopSalesProduct.getBody().getApiGoodsList();
                pageSum = shopSalesProduct.getBody().getPageSum();

                listadapter = new WorkRoomAdapter(WorkRoomDetailActivity.this,apiGoodsList);
                listView.setAdapter(listadapter);
                break;
            case ACTION.SHOPXINYONG://获取门店信用
                ShopXinyongBean shopXinyongBean = GsonUtil.toObj(res,ShopXinyongBean.class);
                apiShopScoreList = shopXinyongBean.getBody().getApiShopScoreList();
                creditAdapter = new WorkCreditAdapter(WorkRoomDetailActivity.this,apiShopScoreList);
                listView.setAdapter(creditAdapter);
                break;
            case ACTION.SHOPDETAILDATA://获取商家具体信息
                ShopDetailDataBean shopDetailDataBean = GsonUtil.toObj(res,ShopDetailDataBean.class);

                tv_work_detail_hangye.setText(shopDetailDataBean.getBody().getApiShop().getIndustryCateLabel());
                tv_work_detail_address.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr());
                tv_work_detail_time.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getOpenTime()+"-"+shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getCloseTime());
                tv_work_detail_introduce.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief().toString());

                break;
        }
    }
    /**
     * 获取商家所卖商品的数据
     */
    private void doGetSaleShop() {
        HashMap<String, String> params = new HashMap<>();
        params.put("saleFlag", "2");//上架标记（2：上架）
        params.put("pageNumber", pageNumber+"");
        params.put("shopId", shopId);//商家ID
        params.put("contentByTitle","");//画面检索输入框输入的内容
        params.put("pageSize","10");
        HttpUtils.doPost(ACTION.SHOPSALEPRODUCT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家推荐商品列表
     */
    private void doFirstData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("saleFlag", "2");//上架标记（2：上架）
        params.put("pageNumber", pageNumber+"");
        params.put("shopId", shopId);//商家ID
        HttpUtils.doPost(ACTION.SHOPTUIJIANLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取门店信用数据
     */
    private void getXinyongData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", shopId);//商家ID
        HttpUtils.doPost(ACTION.SHOPXINYONG, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家具体信息
     */
    private void getShopDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", shopId);//商家ID
        HttpUtils.doPost(ACTION.SHOPDETAILDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    private void initTab() {
        listView.setVisibility(View.VISIBLE);
        tabList.add("门店服务");
        tabList.add("门店信用");
        tabList.add("商家信息");
        tabList.add("优惠券");
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(0)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(1)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(2)));
        tabWorkRoom.addTab(tabWorkRoom.newTab().setText(tabList.get(3)));
        tabWorkRoom.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    //门店服务
                    case 0:
                        listView.setVisibility(View.VISIBLE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        listadapter = new WorkRoomAdapter(WorkRoomDetailActivity.this,apiGoodsList);
                        listView.setAdapter(listadapter);
                        break;
                    //门店信用
                    case 1:
                        listView.setVisibility(View.VISIBLE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);

                        /**
                         * 获取门店信用数据
                         */
                        getXinyongData();

                        break;
                    //商家信息
                    case 2:
                        listView.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.VISIBLE);
                        /**
                         * 获取商家具体信息
                         */
                        getShopDetailData();
                        break;
                    //优惠券
                    case 3:
                        listView.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.VISIBLE);
                        WorkShopAdapter shopAdapter = new WorkShopAdapter(WorkRoomDetailActivity.this);
                        listShop.setAdapter(shopAdapter);
                        listShop.setDividerHeight(0);
                        WorkSingleAdapter singleAdapter = new WorkSingleAdapter(WorkRoomDetailActivity.this);
                        listSingle.setAdapter(singleAdapter);
                        listSingle.setDividerHeight(0);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @OnClick({R.id.iv_common_back, R.id.tv_submit})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_common_back:
                finish();
                break;
            //提交订单
            case R.id.tv_submit:
                startActivity(new Intent(this, PurchaseActivity.class));
                break;
            //购物车
            case R.id.iv_title:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub


        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = li_workroom_top.getBottom();// 获取searchLayout的顶部位置

        }
    }

    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= searchLayoutTop) {
            if (li_workroom_xuan.getParent() != search01) {
                search2.removeView(li_workroom_xuan);
                search01.addView(li_workroom_xuan);
            }
        } else {
            if (li_workroom_xuan.getParent() != search2) {
                search01.removeView(li_workroom_xuan);
                search2.addView(li_workroom_xuan);
            }
        }
    }
}
