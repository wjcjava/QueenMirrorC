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
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HoveringScrollview;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
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
    @Bind(R.id.tv_workroom_service_jubao)
    TextView tv_workroom_service_jubao;

    @Bind(R.id.tv_work_detail_guanzhu)
    TextView tv_work_detail_guanzhu;
    @Bind(R.id.rl_full_collection)
    RelativeLayout rl_full_collection;

    List<SortBean> sortlist = new ArrayList<>();
    List<String> tabList = new ArrayList<>();
    private WorkRoomAdapter listadapter;
    int pageNumber = 1,pageSum;
    String shopName,shopId;
    private WorkCreditAdapter creditAdapter;

    boolean isColl = false;

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

        doAddliulanData();

        doFirstData();

        doGetSaleShop();

    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.ADDLIULAN://添加浏览量
                SuccessBean successBeans = GsonUtil.toObj(res,SuccessBean.class);
                if(successBeans.isSuccess()){
                    T.show(successBeans.getMsg());//成功
                }else{
                    T.show(successBeans.getMsg());
                }
                break;
            case ACTION.COLLECTIONPRODUCT://收藏商品
                isColl = true;
                SuccessBean successBean1 = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean1.isSuccess()){
                    T.show(successBean1.getMsg());//成功
                }else{
                    T.show(successBean1.getMsg());
                }
                break;
            case ACTION.CANCELCOLLECTION:
                isColl = false;
                SuccessBean successBean2 = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean2.isSuccess()){
                    T.show(successBean2.getMsg());//成功
                }else{
                    T.show(successBean2.getMsg());
                }
                break;
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
            case ACTION.GUANZHUSHOP://关注店铺

                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.isSuccess()){
                    T.show(successBean.getMsg());
                    tv_work_detail_guanzhu.setText("取消关注");
                }else{
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.CANCELGUANZHUSHOP://取消关注店铺
                SuccessBean cancelsuccessBean = GsonUtil.toObj(res,SuccessBean.class);
                if(cancelsuccessBean.isSuccess()){
                    T.show(cancelsuccessBean.getMsg());
                    tv_work_detail_guanzhu.setText("关注");
                }else{
                    T.show(cancelsuccessBean.getMsg());
                }
                break;
            case ACTION.JUBAOSHOP:
                /**
                 * 接口还需要修改
                 */
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

    /**
     * 关注店铺
     */
    private void guanzhuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("userId","111");
        HttpUtils.doPost(ACTION.GUANZHUSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消关注
     */
    private void cancelGuanzhuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopId", shopId);//商家ID
        params.put("userId","111");
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

    /**
     * 收藏商品
     */
    private void getCollectionData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", "111");//
        params.put("goodsId","0b5e8db1e94b4c44b3075940bc67a2e9");
        HttpUtils.doPost(ACTION.COLLECTIONPRODUCT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消收藏商品
     */
    private void getCancleCollectionData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", "111");//
        params.put("goodsId","0b5e8db1e94b4c44b3075940bc67a2e9");
        HttpUtils.doPost(ACTION.CANCELCOLLECTION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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

    @OnClick({R.id.iv_common_back, R.id.tv_submit,R.id.tv_work_detail_guanzhu,R.id.tv_workroom_service_jubao,R.id.rl_full_collection})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.rl_full_collection:
                L.e("点击收藏。。。。。。。。。。。。。。。。。。");
                if(isColl){
                    getCancleCollectionData();
                }else {
                    getCollectionData();
                }
                break;
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
            /**
             * 关注店铺
             */
            case R.id.tv_work_detail_guanzhu:
                /**
                 * 这里应该判断是否登录，有没有关注过
                 */

                if(tv_work_detail_guanzhu.getText().equals("关注")){
                    guanzhuData();//关注
                }else{
                    cancelGuanzhuData();//取消关注
                }
                break;
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
}
