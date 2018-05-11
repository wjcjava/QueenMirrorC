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
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

//商品详情
public class FullActivity extends BaseNewActivity implements HttpCallBack{
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
    private List<SortBean> fulllist = new ArrayList<>();
    private List<CommentsBean> fulllist2 = new ArrayList<>();
    private CommentsBean commentsBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_full;
    }

    @Override
    protected void initData() {
        super.initData();
        inithttp();
    }



    @Override
    public void initView() {
        initText();
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("MOCO美容美发沙龙");
            sortBean.setTime("营业时间 9:00-20:00");
            sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
            sortBean.setStars(R.drawable.icon_home_recommend);
            sortBean.setDistance("875m");
            fulllist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.item_fullrecycler,fulllist);
        frecycler.setLayoutManager(new GridLayoutManager(this, 2));
        frecycler.setAdapter(sortAdapter);

    }

    private void initText() {
        fullTitle.setText("纯色美甲");
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);

        tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
    }

    @OnClick({R.id.tv_purchase, R.id.title_back,R.id.tv_full_shoppingcart})
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
    private void inithttp() {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("goodsId","111");
        hashMap.put("pageNumber","2");
        HttpUtils.doPost(ACTION.EVALUATION,hashMap, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);

    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.EVALUATION:

                for (int i = 0; i < 8; i++) {
                    commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                    fulllist2.add(commentsBean);
                }
                CommentsAdapter sortAdapter2 = new CommentsAdapter(R.layout.item_fullrecyclertwo,fulllist2);
                frecyclertwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                frecyclertwo.setAdapter(sortAdapter2);
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
