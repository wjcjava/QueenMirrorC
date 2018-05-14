package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommentsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
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
    private List<CommendGoodBean> fulllist = new ArrayList<>();
    private List<CommentsBean> fulllist2 = new ArrayList<>();
    private CommentsBean commentsBean;
    private CommendGoodBean goodBean;
    private FullGoodsAdapter myAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_full;
    }

    @Override
    protected void initData() {
        super.initData();
        inithttp();
        initshophttp();
    }

    @Override
    protected void doFirstRequest() {
        super.doFirstRequest();

        doAddDetailData();

    }

    /**
     * 商品浏览次数增加
     */
    private void doAddDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("goodsId", "0b5e8db1e94b4c44b3075940bc67a2e9");//商家ID
        HttpUtils.doPost(ACTION.ADDGOODSLIULAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void initView() {
        initText();


    }

    private void initText() {
        fullTitle.setText("纯色美甲");
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);

        tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
    }

    @OnClick({R.id.tv_purchase, R.id.title_back, R.id.tv_full_shoppingcart})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //提交订单
            case R.id.tv_purchase:
                startActivity(new Intent(FullActivity.this, PurchaseActivity.class));
                break;
            //加入购物车
            case R.id.tv_full_shoppingcart:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
        }


    }

    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", "1");
        hashMap1.put("shopId", "111");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);


    }

    private void inithttp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("goodsId", "111");
        hashMap.put("pageNumber", "2");
        HttpUtils.doPost(ACTION.EVALUATION, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);


    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.EVALUATION:

                for (int i = 0; i < 8; i++) {
                    commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                    fulllist2.add(commentsBean);
                }
                CommentsAdapter sortAdapter2 = new CommentsAdapter(R.layout.item_fullrecyclertwo, fulllist2);
                frecyclertwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                frecyclertwo.setAdapter(sortAdapter2);
                break;
            case ACTION.ADDGOODSLIULAN:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    T.show(successBean.getMsg());
                } else {
                    T.show(successBean.getMsg());
                }


                break;
            //商家商品推荐
            case ACTION.COMMENDGOODS:
                goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if(goodBean.isSuccess()){
                    for (int i = 0; i < 6; i++) {

                        fulllist.add(goodBean);
                    }
                    myAdapter = new FullGoodsAdapter(R.layout.item_fullrecycler, fulllist);
                    frecycler.setLayoutManager(new GridLayoutManager(this, 2));
                    frecycler.setAdapter(myAdapter);
                }else {
                    T.show(goodBean.getMsg());
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
