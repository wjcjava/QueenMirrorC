package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
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
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopSalesProduct;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopTuijianBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopXinyongBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HoveringScrollview;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.Serializable;
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
    LinearLayout reCoupu;
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
    @Bind(R.id.tv_workroom_service_jubao)
    TextView tv_workroom_service_jubao;
    @Bind(R.id.tv_workdetail_topfenshu)
    TextView tv_workdetail_topfenshu;
    @Bind(R.id.tv_work_detail_guanzhu)
    TextView tv_work_detail_guanzhu;
    @Bind(R.id.text_shop)
    TextView textShop;
    @Bind(R.id.text_single)
    TextView textSingle;
    @Bind(R.id.tv_submit)
    TextView tv_submit;

    @Bind(R.id.iv_information_one)
    ImageView iv_information_one;
    @Bind(R.id.iv_information_two)
    ImageView iv_information_two;
    @Bind(R.id.iv_information_three)
    ImageView iv_information_three;
    @Bind(R.id.iv_information_four)
    ImageView iv_information_four;

    List<SortBean> sortlist = new ArrayList<>();
    List<String> tabList = new ArrayList<>();
    private WorkRoomAdapter listadapter;
    int pageNumber = 1, pageSum = 0;
    String shopName, shopId;
    private WorkCreditAdapter creditAdapter;
    String isLogin, userId;
    boolean isColl = false;

    List<ShopTuijianBean.BodyBean.ApiEcGoodsBasicListBean> apiEcGoodsBasicList = new ArrayList<>();
    List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList = new ArrayList<>();
    ShopDetailDataBean shopDetailDataBean;
    String top_detail="";
    private WorkShopAdapter shopAdapter;
    ShoppingCartBean shoppingCartBean;
    public static WorkRoomDetailActivity instance = null;
    private WorkSingleAdapter singleAdapter;
    private List<ShopDiscounBean.BodyBean.CouponListDataItemBean> list1;
    private List<ShopDiscounBean.BodyBean.CouponListDataBean> list;

    ShopXinyongBean.BodyBean.ApiShopScoreGetBean apiShopScoreGet = new ShopXinyongBean.BodyBean.ApiShopScoreGetBean();

    @Bind(R.id.workroom_refreshLayout)
    SmartRefreshLayout workroom_refreshLayout;
    int pageIndex = 0;

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_work_room_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        isLogin = (String) SP.get(WorkRoomDetailActivity.this, SpContent.isLogin, "");

        initTab();
        Intent intent = getIntent();
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        tv_common_title.setText(shopName);
        whs_workroom_scroll.setOnScrollListener(this);

        listadapter = new WorkRoomAdapter(WorkRoomDetailActivity.this, apiGoodsList);
        listView.setAdapter(listadapter);

        workroom_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;

                doGetSaleShop();
                refreshlayout.finishRefresh(2000);
            }
        });
        workroom_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum <= (pageIndex+Integer.parseInt(SpContent.pageSize))){
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    doGetSaleShop();
                    refreshlayout.finishLoadmore(2000);
                }
            }
        });


        /**
         * 获取商家具体信息
         */
        getShopDetailData();

        doAddliulanData();
        doFirstData();
        /**
         * 商家所卖商品
         */
        doGetSaleShop();
        /**
         * 获取门店信用数据
         */
        getXinyongData();
        /**
         * 获取购物车信息
         */
        getShopCartData();
    }

    /**
     * 获取购物车信息
     */
    public void getShopCartData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(WorkRoomDetailActivity.this, SpContent.UserId, "") + "");//用户ID
        HttpUtils.doPost(ACTION.GETSHOPPINDCART, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 这里需要修改
     */
    private void geeshopDiscoun() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cpCate", "1");
        params.put("cpScope", "1");
        params.put("shopId", shopId);//商品ID
        params.put("userId", SP.get(this,SpContent.UserId,"")+"");//用户ID
        HttpUtils.doPost(ACTION.SHOPDISCOUN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GETSHOPPINDCART://购物车
                shoppingCartBean = GsonUtil.toObj(res, ShoppingCartBean.class);

                if(shoppingCartBean.getBody().getShopList().size()>0){
                    tv_submit.setVisibility(View.VISIBLE);
                }else{
                    tv_submit.setVisibility(View.GONE);
                }
                break;
            case ACTION.ADDLIULAN://添加浏览量
                SuccessBean successBeans = GsonUtil.toObj(res, SuccessBean.class);
                if (successBeans.isSuccess()) {
                    //T.show(successBeans.getMsg());//成功
                } else {
                    T.show(successBeans.getMsg());
                }
                break;
            case ACTION.COLLECTIONPRODUCT://收藏商品
                isColl = true;
                SuccessBean successBean1 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean1.isSuccess()) {
                    // T.show(successBean1.getMsg());//成功
                } else {
                    T.show(successBean1.getMsg());
                }
                break;
            case ACTION.CANCELCOLLECTION://取消收藏
                isColl = false;
                SuccessBean successBean2 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean2.isSuccess()) {
                    //  T.show(successBean2.getMsg());//成功
                } else {
                    T.show(successBean2.getMsg());
                }
                break;
            case ACTION.SHOPTUIJIANLIST://获取商家推荐商品列表
                ShopTuijianBean shopTuijianBean = GsonUtil.toObj(res, ShopTuijianBean.class);
                apiEcGoodsBasicList = shopTuijianBean.getBody().getApiEcGoodsBasicList();
                ShopTuijianAdapter sortAdapter = new ShopTuijianAdapter(R.layout.re_full_recommend, apiEcGoodsBasicList);
                re_recommendable_projects_shop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                re_recommendable_projects_shop.setAdapter(sortAdapter);
                break;
            case ACTION.SHOPSALEPRODUCT://获取商家所卖商品列表
                ShopSalesProduct shopSalesProduct = GsonUtil.toObj(res, ShopSalesProduct.class);
                pageSum = shopSalesProduct.getBody().getPageSum();

                loadMoreData(shopSalesProduct.getBody().getApiGoodsList());
                break;
            case ACTION.SHOPXINYONG://获取门店信用
                ShopXinyongBean shopXinyongBean = GsonUtil.toObj(res, ShopXinyongBean.class);

                apiShopScoreGet = shopXinyongBean.getBody().getApiShopScoreGet();

                // top_detail = top_detail + "评分" + apiShopScoreList.get(0).getEcShopScore().getShopScore();
                break;
            case ACTION.SHOPDETAILDATA://获取商家具体信息
                shopDetailDataBean = GsonUtil.toObj(res, ShopDetailDataBean.class);
                if (shopDetailDataBean.isSuccess()) {

                    top_detail = top_detail + "  浏览量" + (int)shopDetailDataBean.getBody().getApiShop().getAnsShopBrowses().getBrowseCounts() + "次";
                    tv_workdetail_topfenshu.setText(top_detail);

                    if (shopDetailDataBean.getBody().getIfFollow().equals("1")) {
                        /**
                         * 已关注
                         */
                        tv_work_detail_guanzhu.setText("取消关注");
                    } else {
                        /**
                         * 未关注
                         */
                        tv_work_detail_guanzhu.setText("关注");
                    }
                } else {
                    T.show(shopDetailDataBean.getMsg());
                }
                break;
            case ACTION.GUANZHUSHOP://关注店铺

                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    T.show("关注成功");
                    tv_work_detail_guanzhu.setText("取消关注");
                } else {
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.CANCELGUANZHUSHOP://取消关注店铺
                SuccessBean cancelsuccessBean = GsonUtil.toObj(res, SuccessBean.class);
                if (cancelsuccessBean.isSuccess()) {
                    T.show("取消关注成功");
                    tv_work_detail_guanzhu.setText("关注");
                } else {
                    T.show(cancelsuccessBean.getMsg());
                }
                break;
            case ACTION.JUBAOSHOP:
                /**
                 * 接口还需要修改
                 */
                break;
            case ACTION.SHOPDISCOUN:
                ShopDiscounBean discounBean = GsonUtil.toObj(res, ShopDiscounBean.class);
                if (discounBean.isSuccess()) {
                    list = discounBean.getBody().getCouponListData();
                    list1 = discounBean.getBody().getCouponListDataItem();
                    shopAdapter = new WorkShopAdapter(WorkRoomDetailActivity.this, list);
                    singleAdapter = new WorkSingleAdapter(WorkRoomDetailActivity.this, list1);
                    listShop.setAdapter(shopAdapter);
                    listShop.setDividerHeight(0);
                    listSingle.setAdapter(shopAdapter);
                    listSingle.setDividerHeight(0);
                    if (list.size() > 0) {
                        textShop.setVisibility(View.GONE);
                        textSingle.setVisibility(View.GONE);
                    } else {
                        textShop.setVisibility(View.VISIBLE);
                        textSingle.setVisibility(View.VISIBLE);
                    }
                } else {
                    T.show(discounBean.getMsg());
                }
                break;
        }
    }

    /**
     * 添加浏览次数
     */
    private void doAddliulanData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        HttpUtils.doPost(ACTION.ADDLIULAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家所卖商品的数据
     */
    private void doGetSaleShop() {
        HashMap<String, String> params = new HashMap<>();
        params.put("saleFlag", "2");//上架标记（2：上架）
        params.put("pageNumber", pageNumber + "");
        params.put("shopId", shopId);//商家ID
        params.put("contentByTitle", "");//画面检索输入框输入的内容
        params.put("pageSize", "10");
        HttpUtils.doPost(ACTION.SHOPSALEPRODUCT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取商家推荐商品列表
     */
    private void doFirstData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("saleFlag", "2");//上架标记（2：上架）
        params.put("pageNumber", pageNumber + "");
        params.put("shopId", shopId);//商家ID
        params.put("pageSize", SpContent.pageSize);
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
        params.put("userId",SP.get(WorkRoomDetailActivity.this,SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.SHOPDETAILDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 关注店铺
     */
    private void guanzhuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("userId", userId);
        HttpUtils.doPost(ACTION.GUANZHUSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消关注
     */
    private void cancelGuanzhuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("userId", userId);
        HttpUtils.doPost(ACTION.CANCELGUANZHUSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 举报商家
     */
    private void jubaoData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("complainInfo", shopId);//商家ID
        HttpUtils.doPost(ACTION.JUBAOSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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

                        loadMoreData(apiGoodsList);
                        break;
                    //门店信用
                    case 1:
                        listView.setVisibility(View.VISIBLE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);

                        creditAdapter = new WorkCreditAdapter(WorkRoomDetailActivity.this, apiShopScoreGet);
                        listView.setAdapter(creditAdapter);
                        break;
                    //商家信息
                    case 2:
                        listView.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.GONE);
                        reMassage.setVisibility(View.VISIBLE);
                        String envPhoto = shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopEnvPhoto();
                        String []envPhotos = new String[]{};

                        if(envPhoto != null && envPhoto.length()>0){
                            envPhotos = envPhoto.split(",");
                        }else{
                        }

                        if(envPhotos.length < 1){

                        }else if(envPhotos.length < 2){
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).into(iv_information_one);
                        }else if(envPhotos.length < 3){
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).into(iv_information_one);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[1]).into(iv_information_two);
                        }else if(envPhotos.length < 4){
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).into(iv_information_one);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[1]).into(iv_information_two);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[2]).into(iv_information_three);
                        }else if(envPhotos.length < 5){
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[0]).into(iv_information_one);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[1]).into(iv_information_two);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[2]).into(iv_information_three);
                            Glide.with(WorkRoomDetailActivity.this).load(envPhotos[3]).into(iv_information_four);
                        }

                        if(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopTab() == null ||shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopTab().equals("")){

                        }else{
                            tv_work_detail_hangye.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopTab());
                        }
                        if(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr() == null ||shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr().equals("")){
                            tv_work_detail_address.setText("暂无地址");
                        }else{
                            tv_work_detail_address.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopAddr());
                        }

                        if(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief() == null ||shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief().toString().equals("")){
                            tv_work_detail_introduce.setText("等待商家补成");
                        }else{
                            tv_work_detail_introduce.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getShopBrief());
                        }
                        tv_work_detail_time.setText(shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getOpenTime() + "-" + shopDetailDataBean.getBody().getApiShop().getAnsShopBasic().getCloseTime());

                        break;
                    //优惠券
                    case 3:
                        listView.setVisibility(View.GONE);
                        reMassage.setVisibility(View.GONE);
                        reCoupu.setVisibility(View.VISIBLE);

                        /**
                         * 商家优惠券
                         */
                        geeshopDiscoun();
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

    @OnClick({R.id.iv_common_back, R.id.tv_submit, R.id.tv_work_detail_guanzhu, R.id.tv_workroom_service_jubao, R.id.iv_title})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_common_back:
                finish();
                break;
            //提交订单
            case R.id.tv_submit:
                Intent intent = new Intent(this, PurchaseActivity.class);
                intent.putExtra("cartBean", (Serializable) shoppingCartBean);
                startActivity(intent);
                break;
            //购物车
            case R.id.iv_title:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            /**
             * 关注店铺
             */
            case R.id.tv_work_detail_guanzhu:
                if (isLogin.equals("1")) {

                    userId = (String) SP.get(WorkRoomDetailActivity.this, SpContent.UserId, "");
                    if (tv_work_detail_guanzhu.getText().equals("关注")) {
                        guanzhuData();//关注
                    } else {
                        cancelGuanzhuData();//取消关注
                    }
                } else {
                    T.show("请您先登录APP");
                }
                break;
            //举报
            case R.id.tv_workroom_service_jubao:
                jubaoData();
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



    public void loadMoreData(List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiOrderListMore){

        if(apiGoodsList == null){
            apiGoodsList = new ArrayList<>();
        }
        if(pageIndex == 0){
            listadapter.Clear();
        }

        apiGoodsList.addAll(apiOrderListMore);
        if(pageIndex == 0){
            listadapter.setmDate(apiGoodsList);
        }else{
            listadapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);
    }
}
