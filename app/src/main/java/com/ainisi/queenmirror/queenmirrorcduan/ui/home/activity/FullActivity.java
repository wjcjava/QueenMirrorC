package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommentsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProductDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.youth.banner.Banner;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 商品详情
 */
public class FullActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.full_recycler)
    RecyclerView frecycler;
    @Bind(R.id.full_recyclertwo)
    RecyclerView frecyclertwo;
    @Bind(R.id.title_title)
    TextView fullTitle;
    @Bind(R.id.title_photo)
    ImageView fullPhoto;

    @Bind(R.id.tv_shopping_oldprice)
    TextView tv_shopping_oldprice;
    @Bind(R.id.rl_full_collection)
    RelativeLayout rl_full_collection;
    @Bind(R.id.iv_full_collection)
    ImageView iv_full_collection;

    @Bind(R.id.full_cash)
    TextView full_cash;
    @Bind(R.id.tv_brief)
    TextView tv_brief;
    @Bind(R.id.tv_time)
    TextView tv_time;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.tv_full_shoppingcart)
    TextView tv_full_shoppingcart;
    @Bind(R.id.ttv_ping)
    TextView tvPing;
    @Bind(R.id.banner_fullactivity)
    Banner banner_fullactivity;
    @Bind(R.id.re_full_shop)
    RelativeLayout re_full_shop;

    @Bind(R.id.tv_fullactivity_name)
    TextView tv_fullactivity_name;

    private CommentsBean commentsBean;
    private CommendGoodBean goodBean;
    private FullGoodsAdapter myAdapter;
    private String url="https://mmbiz.qlogo.cn/mmbiz_png/XDC8ot2yPvMMpEwKmIrIgD6zqnVE3ex8vmXLnMMdq31GN9kalYqIvWZnL8zTfmEliaSTibRSibc27iacE9mPyj1kZA/0?wx_fmt=png";
    boolean isColl = false;
    String goodsId, shopId, isLogin, userId,shopName;

    CustomShareListener mShareListener;
    ShareAction mShareAction;
    private int pageSum;

    @Override
    public int getLayoutId() {
        return R.layout.activity_full;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = this.getIntent();
        goodsId = intent.getStringExtra("goodsId");
        shopId = intent.getStringExtra("shopId");
        shopName = intent.getStringExtra("shopName");
        isLogin = SP.get(FullActivity.this, SpContent.isLogin, "0").toString();
        userId = SP.get(FullActivity.this, SpContent.UserId, "0").toString();
        inithttp();
        getProductDetailData();

        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

        mShareListener = new CustomShareListener(this);
        mShareAction = new ShareAction(FullActivity.this).setDisplayList(
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
        ).setShareboardclickCallback(new ShareBoardlistener() {
            @Override
            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                UMWeb web = new UMWeb("http://baidu.com");
                web.setTitle("来自女王魔镜");
                web.setDescription("来自女王魔镜内容");
                web.setThumb(new UMImage(FullActivity.this,url));
                new ShareAction(FullActivity.this).withMedia(web)
                        .setPlatform(share_media)
                        .setCallback(mShareListener)

                        .share();
            }
        });
    }

    private static class CustomShareListener implements UMShareListener {

        private WeakReference<FullActivity> mActivity;

        private CustomShareListener(FullActivity activity) {
            mActivity = new WeakReference(activity);
        }

        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {

            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(mActivity.get(), platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                        && platform != SHARE_MEDIA.EMAIL
                        && platform != SHARE_MEDIA.FLICKR
                        && platform != SHARE_MEDIA.FOURSQUARE
                        && platform != SHARE_MEDIA.TUMBLR
                        && platform != SHARE_MEDIA.POCKET
                        && platform != SHARE_MEDIA.PINTEREST
                        && platform != SHARE_MEDIA.INSTAGRAM
                        && platform != SHARE_MEDIA.GOOGLEPLUS
                        && platform != SHARE_MEDIA.YNOTE
                        && platform != SHARE_MEDIA.EVERNOTE) {
                    Toast.makeText(mActivity.get(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                }

            }
        }
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                    && platform != SHARE_MEDIA.EMAIL
                    && platform != SHARE_MEDIA.FLICKR
                    && platform != SHARE_MEDIA.FOURSQUARE
                    && platform != SHARE_MEDIA.TUMBLR
                    && platform != SHARE_MEDIA.POCKET
                    && platform != SHARE_MEDIA.PINTEREST
                    && platform != SHARE_MEDIA.INSTAGRAM
                    && platform != SHARE_MEDIA.GOOGLEPLUS
                    && platform != SHARE_MEDIA.YNOTE
                    && platform != SHARE_MEDIA.EVERNOTE) {
                Toast.makeText(mActivity.get(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            }
            if (t != null) {
                L.e("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {

            Toast.makeText(mActivity.get(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void doFirstRequest() {
        super.doFirstRequest();
        doAddDetailData();
    }

    /**
     * 获取商品详情信息
     */
    private void getProductDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", goodsId);//商品ID
        params.put("userId", userId);//UID  可以不传
        HttpUtils.doPost(ACTION.GETPRODUCTDETAIL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商品浏览次数增加
     */
    private void doAddDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("goodsId", goodsId);//商品ID  0b5e8db1e94b4c44b3075940bc67a2e9
        HttpUtils.doPost(ACTION.ADDGOODSLIULAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商家推荐商品的数据
     */
    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", "1");
        hashMap1.put("shopId", shopId);//shopId  111
        hashMap1.put("pageSize", "10");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商品的评价数据
     */
    private void inithttp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("goodsId", "111");
        hashMap.put("pageNumber", "1");
        hashMap.put("pageSize", "10");
        HttpUtils.doPost(ACTION.EVALUATION, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    /**
     * 收藏商品
     */
    private void getCollectionData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);//
        params.put("goodsId", goodsId);
        HttpUtils.doPost(ACTION.COLLECTIONPRODUCT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消收藏商品
     */
    private void getCancleCollectionData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);//
        params.put("goodsId", goodsId);
        HttpUtils.doPost(ACTION.CANCELCOLLECTION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 添加购物车
     */
    private void AddCatData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", userId);//用户ID
        params.put("goodsId", goodsId);
        params.put("unitPrice", full_cash.getText().toString().substring(1, full_cash.getText().toString().length()));//价格
        params.put("purchaseNumber", "1");//数量
        HttpUtils.doPost(ACTION.ADDTOCAT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void initView() {
        initText();
        initshophttp();
    }

    private void initText() {
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
        tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
    }

    @OnClick({R.id.tv_purchase, R.id.title_back, R.id.tv_full_shoppingcart, R.id.rl_full_collection, R.id.title_photo,R.id.re_full_shop})

    public void OnClick(View view) {
        switch (view.getId()) {
            /**
             * 点击底部店铺
             */
            case R.id.re_full_shop:
                Intent intentr = new Intent(this, WorkRoomDetailActivity.class);
                intentr.putExtra("shopName",shopName);
                intentr.putExtra("shopId",shopId);
                startActivity(intentr);
                break;
            /**
             * 分享
             */
            case R.id.title_photo:
                mShareAction.open();
                break;
            case R.id.title_back:
                finish();
                break;
            //提交订单
            case R.id.tv_purchase:
                T.show("你点击了我");
                Intent intent = new Intent(FullActivity.this, PurchaseNowActivity.class);
                intent.putExtra("shopName",shopName);
                intent.putExtra("shopId",shopId);
                intent.putExtra("goodId",goodsId);
                intent.putExtra("goodName",fullTitle.getText().toString());
                intent.putExtra("goodPrice",full_cash.getText().toString());
                intent.putExtra("goodPriceSale",tv_shopping_oldprice.getText().toString());
                startActivity(intent);
                break;
            //加入购物车
            case R.id.tv_full_shoppingcart:
                if (isLogin.equals("1")) {
                    AddCatData();
                } else {
                    T.show("请您先登录APP");
                }
                break;
            //收藏
            case R.id.rl_full_collection:
                if (isLogin.equals("1")) {
                    if (isColl) {
                        getCancleCollectionData();
                    } else {
                        getCollectionData();
                    }
                } else {
                    T.show("请您先登录APP");
                }
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 加入购物车
             */
            case ACTION.ADDTOCAT:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    T.show(successBean.getMsg());
                    startActivity(new Intent(this, ShoppingCartActivity.class));
                } else {
                    T.show(successBean.getMsg());
                }
                break;
            /**
             * 商品详情
             */
            case ACTION.GETPRODUCTDETAIL:
                ProductDetailBean productDetailBean = GsonUtil.toObj(res, ProductDetailBean.class);
                String isCollection = productDetailBean.getBody().getIfCollect();
                if (isCollection.equals("1")) {
                    isColl = true;
                    iv_full_collection.setImageResource(R.drawable.collection_bein);
                } else {
                    isColl = false;
                    iv_full_collection.setImageResource(R.drawable.icon_full_collection);
                }
                full_cash.setText("￥" + productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getSalesPrice());
                tv_shopping_oldprice.setText("￥" + productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getMarketPrice());
                tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
                tv_brief.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsBrief());
                tv_time.setText("服务时长：" + productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getServiceTime());
                textView4.setText("已浏览：" + "200" + "次");
                //  tv_introduction.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsDetails().toString());
                fullTitle.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                tv_fullactivity_name.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                break;
            case ACTION.EVALUATION:
                commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                List<CommentsBean.BodyBean.CommentsListDataBean> commList = commentsBean.getBody().getCommentsListData();
                CommentsAdapter sortAdapter2 = new CommentsAdapter(R.layout.item_fullrecyclertwo, commList);
                pageSum=commentsBean.getBody().getPageSum();
                tvPing.setText("评价("+pageSum+")");
                frecyclertwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                frecyclertwo.setAdapter(sortAdapter2);
                break;
            case ACTION.ADDGOODSLIULAN://添加浏览量
                SuccessBean successBean1 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean1.isSuccess()) {

                } else {
                    T.show(successBean1.getMsg());
                }
                break;
            //商家商品推荐
            case ACTION.COMMENDGOODS:
                goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if (goodBean.isSuccess()) {
                    List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list = goodBean.getBody().getApiEcGoodsBasicList();
                    myAdapter = new FullGoodsAdapter(R.layout.item_fullrecycler, list);
                    frecycler.setLayoutManager(new GridLayoutManager(this, 2));
                    frecycler.setAdapter(myAdapter);
                } else {
                    T.show(goodBean.getMsg());
                }

                break;
            case ACTION.COLLECTIONPRODUCT://收藏商品
                isColl = true;
                SuccessBean successBean2 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean2.isSuccess()) {
                    iv_full_collection.setImageResource(R.drawable.collection_bein);
                    //collection_bein
                    T.show(successBean2.getMsg());//成功
                } else {
                    iv_full_collection.setImageResource(R.drawable.icon_full_collection);
                    T.show(successBean2.getMsg());
                }
                break;
            case ACTION.CANCELCOLLECTION://取消收藏
                isColl = false;
                SuccessBean successBean3 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean3.isSuccess()) {
                    iv_full_collection.setImageResource(R.drawable.icon_full_collection);
                    T.show(successBean3.getMsg());//成功
                } else {
                    iv_full_collection.setImageResource(R.drawable.collection_bein);
                    T.show(successBean3.getMsg());
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
