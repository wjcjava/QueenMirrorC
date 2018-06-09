package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommentsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopStoreDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter.ShopListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.CouponGetBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.timeutil.CustomDatePicker;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 异业
 */
public class ShopStoreActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.iv_shop)
    ImageView ivShop;
    @Bind(R.id.title_title)
    TextView storeTitle;
    //本店成品
    @Bind(R.id.re_product)
    RecyclerView reProduct;
    //网友评论
    @Bind(R.id.recycler_boutique)
    RecyclerView reBoutique;
    @Bind(R.id.tv_shopname)
    TextView tv_shopname;
    @Bind(R.id.tv_shop_detail_address)
    TextView tv_shop_detail_address;
    @Bind(R.id.li_shop_detail_comment)
    LinearLayout li_shop_detail_comment;
    @Bind(R.id.li_shop_detail_order)
    LinearLayout li_shop_detail_order;
    @Bind(R.id.tv_boutique)
    TextView tvBoutique;
    @Bind(R.id.tv_sume_product)
            TextView sumeProduct;
    int pagenumber = 1;
    boolean isLogin = false;
    private List<SortBean> beanList = new ArrayList<>();
    private CustomPopWindow popWindow;
    String shopName, shopId, service_tel = "13405024815";
    private CommentsBean commentsBean;
    private CustomDatePicker timePicker;
    private String time;
    private String date;
    private int pageSum;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_store;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = this.getIntent();
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");

        storeTitle.setText(shopName);
        storeTitle.setTextColor(Color.BLACK);
        initShop();
        getShopDetailData();
    }

    /**
     * 商品的评价数据
     */
    private void initShop() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("goodsId", "111");
        parames.put("pageNumber", "1");
        parames.put("pageSize", "10");
        HttpUtils.doPost(ACTION.EVALUATION, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void getShopDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", shopId);//商户ID
        params.put("userId", SP.get(this, SpContent.UserId, "").toString() + "");//用户ID
        HttpUtils.doPost(ACTION.SHOPDETAILDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SP.get(this, SpContent.isLogin, "0").toString().equals("1")) {
            isLogin = true;
        } else {
            isLogin = false;
        }
    }

    @Override
    protected void initData() {
        super.initData();

        initPicker();
        inithttpshop();

    }

    private void inithttpshop() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("saleFlag", "2");//2：上架
        parames.put("pageNumber", pagenumber + "");
        parames.put("contentByTitle", "111");
        parames.put("shopCate", "2");//1:美业，2：异业
        parames.put("pageSize", "10");
        HttpUtils.doPost(ACTION.GOODLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initPicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        time = sdf.format(new Date());
        date = time.split(" ")[0];


        /**
         * 设置年月日
         */

        timePicker = new CustomDatePicker(this, "请选择时间", new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                T.show(time);
            }
        }, "2007-01-01 00:00", "2027-12-31 23:59");//"2027-12-31 23:59"
        timePicker.setIsLoop(true);
    }

    @SuppressLint("MissingPermission")
    @OnClick({R.id.title_back, R.id.re_product_two, R.id.re_invincible, R.id.li_shop_detail_comment, R.id.li_shop_detail_order,
            R.id.li_shop_detail_phone, R.id.li_shop_detail_pay})
    public void click(View view) {
        switch (view.getId()) {
            /**
             * 到店付款
             */
            case R.id.li_shop_detail_pay:
                Intent intentp = new Intent(this, PayInShopActivity.class);
                startActivity(intentp);

                break;
            /**
             * 电话
             */
            case R.id.li_shop_detail_phone:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + service_tel);
                intent.setData(data);
                startActivity(intent);
                break;
            /**
             * 在线预约
             */
            case R.id.li_shop_detail_order:
                // 日期格式为yyyy-MM-dd
                timePicker.show(time);
                break;
            /**
             * 点击评价
             */
            case R.id.li_shop_detail_comment:
                startActivity(new Intent(this, CommentActivity.class));
                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.re_invincible:
                View popview = View.inflate(this, R.layout.item_shop_get_ticket, null);
                //弹出popWindow时，背景是否变暗
                // 控制亮度
                popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                        .setView(popview)
                        .setFocusable(true)
                        .size(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT)
                        .setOutsideTouchable(true)
                        .enableBackgroundDark(true) //弹出popWindow时，背景是否变暗
                        .setBgDarkAlpha(0.5f) // 控制亮度
                        .setAnimationStyle(R.style.CustomPopWindowStyle)
                        .create()
                        .showAtLocation(this.findViewById(R.id.main), Gravity.BOTTOM, 0, 0);
                initgetId(popview);
                break;
            case R.id.re_product_two:
                startActivity(new Intent(this, ProductActivity.class));
                break;
            default:
                break;
        }
    }

    private void initgetId(View popview) {
        popview.findViewById(R.id.tv_shop_couponget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLogin) {
                    inithttp();
                } else {
                    T.show("您未登陆请先登陆");
                }
            }
        });
    }

    private void inithttp() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cpId", "1cf04904fa064c4294453ce39c506be1");//优惠券ID
        params.put("userId", SP.get(this, SpContent.UserId, "").toString() + "");//用户ID
        params.put("shopId", shopId);//商品ID
        HttpUtils.doPost(ACTION.COUPONGET, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.EVALUATION:
                commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                if (commentsBean.isSuccess()) {
                    List<CommentsBean.BodyBean.CommentsListDataBean> commList = commentsBean.getBody().getCommentsListData();
                    CommentsAdapter sortAdapter2 = new CommentsAdapter(R.layout.item_fullrecyclertwo, commList);
                    pageSum = commentsBean.getBody().getPageSum();
                    tvBoutique.setText("网友评价"+"("+pageSum+")");
                    reBoutique.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    reBoutique.setAdapter(sortAdapter2);
                } else {
                    T.show(commentsBean.getMsg());
                }

                break;
            case ACTION.COUPONGET:
                CouponGetBean couponGetBean = GsonUtil.toObj(res, CouponGetBean.class);
                if (couponGetBean.isSuccess()) {
                    T.show(couponGetBean.getMsg());
                } else {
                    T.show(couponGetBean.getMsg());
                }
                break;
            //获取店铺详情
            case ACTION.SHOPDETAILDATA:

                L.e("................." + res);
                ShopStoreDetailBean shopStoreDetailBean = GsonUtil.toObj(res, ShopStoreDetailBean.class);

                tv_shopname.setText(shopStoreDetailBean.getBody().getApiShop().getAnsShopBasic().getShopName());
                service_tel = shopStoreDetailBean.getBody().getApiShop().getAnsShopBasic().getServiceTel();
                tv_shop_detail_address.setText(shopStoreDetailBean.getBody().getApiShop().getAnsShopBasic().getAddrProvince() +
                        shopStoreDetailBean.getBody().getApiShop().getAnsShopBasic().getAddrCity() + shopStoreDetailBean.getBody().getApiShop().getAnsShopBasic().getAddrDistrict());
                break;
            case ACTION.GOODLIST:
                ShopListBean shopListBean = GsonUtil.toObj(res, ShopListBean.class);
                if (shopListBean.isSuccess()) {
                    List<ShopListBean.BodyBean.GoodsListDataBean> shoplist = shopListBean.getBody().getGoodsListData();
                    sumeProduct.setText("全部成品"+shopListBean.getBody().getPageSum());
                    ShopListAdapter shopListAdapter = new ShopListAdapter(R.layout.re_shop_store, shoplist);
                    reProduct.setLayoutManager(new GridLayoutManager(this, 2));
                    reProduct.setAdapter(shopListAdapter);
                } else {
                    T.show(shopListBean.getMsg());
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
}