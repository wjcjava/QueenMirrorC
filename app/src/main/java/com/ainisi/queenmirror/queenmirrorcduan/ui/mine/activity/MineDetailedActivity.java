package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;


import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.TouchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.TouchbalanceBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的钱包—余额—余额明细
 */
public class MineDetailedActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack, HttpCallBack {
    @Bind(R.id.title_title)
    TextView detailedTitle;
    @Bind(R.id.rc_all_detail)
    RecyclerView detailrecycle;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    private List<String> tabList = new ArrayList<>();
    private List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_detailed;
    }


    @Override
    public void initView() {
        inithttp();
        initText();
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("custId", SP.get(this, SpContent.UserId,"")+"");
        HttpUtils.doPost(ACTION.TOUCHBALANCE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()
                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
    }




    private void initText() {
        detailedTitle.setText(getIntent().getStringExtra("name"));
    }


    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;

        }


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

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {

            case ACTION.TOUCHBALANCE:
                TouchbalanceBean touchbalanceBean = GsonUtil.toObj(res, TouchbalanceBean.class);
                if (touchbalanceBean.isSuccess()) {

                    list = touchbalanceBean.getBody().getAccountChargeRecords();
                    TouchAdapter sortAdapter2 = new TouchAdapter(R.layout.item_rcbean, list);
                    detailrecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    detailrecycle.setAdapter(sortAdapter2);
                } else {
                    T.show(touchbalanceBean.getMsg());
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