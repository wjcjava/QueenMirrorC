package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommendGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 更多
 */
public class RecommendedActivity extends BaseActivity implements RefreshLoadMoreLayout.CallBack ,HttpCallBack{
    @Bind(R.id.re_recommended)
    RecyclerView reRecommended;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    private List<CommendGoodBean> beanList = new ArrayList<>();
    private CommendGoodsAdapter myAdapter;
    private CommendGoodBean goodBean;


    @Override
    public int getLayoutId() {
        return R.layout.activity_recommended;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        initRefresh();
    }

    /**
     * canRefresh 是否下拉刷新
     * canLoadMore 是否上拉加载更多
     * autoLoadMore 自动加载更多（默认不自动加载更多）
     * showLastRefreshTime 是否显示上次刷新时间（默认不显示）
     * multiTask 下拉刷新上拉加载更多可同时进行（默认下拉刷新和上拉加载更多不能同时进行）
     */
    private void initRefresh() {
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
    }
    @Override
    public void onRefresh() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("下拉成功");
                mRefreshLoadMoreLayout.stopRefresh();
            }
        }, 200);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               T.show("上拉成功");
                mRefreshLoadMoreLayout.stopLoadMore();
            }
        }, 1000);
    }


    public void initData() {

        inithttp();

    }




    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }


    }
    private void inithttp() {
        HashMap<String,String> hashMap=new HashMap();
        hashMap.put("saleFlag","2");
        hashMap.put("pageNumber","1");
        hashMap.put("shopId","111");
        HttpUtils.doPost(ACTION.COMMENDGOODS,hashMap, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);



    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.COMMENDGOODS:
                goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if(goodBean.isSuccess()){
                List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list = goodBean.getBody().getApiEcGoodsBasicList();
                    myAdapter = new CommendGoodsAdapter(R.layout.item_shortrecycler, list);

                    reRecommended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    reRecommended.setAdapter(myAdapter);
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
