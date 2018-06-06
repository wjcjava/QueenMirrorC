package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;


import android.content.res.Resources;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.TouchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.TouchbalanceBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.lang.reflect.Field;
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
    @Bind(R.id.tab_detailed)
    TabLayout detailedTab;
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
        initText();
        initDete();
        inithttp();
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("custId", "1a474a8202e84cc49beb65be3addcf9d");
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

    private void initDete() {
        tabList.add("全部");
        tabList.add("收入");
        tabList.add("支出");
        for (int i = 0; i < tabList.size(); i++) {
            detailedTab.addTab(detailedTab.newTab().setText(tabList.get(i)));
        }
        detailedTab.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(detailedTab, 40, 40);
            }
        });


        detailedTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        T.show("你点击了1");
                        break;
                    case 1:
                        T.show("你点击了2");
                        break;
                    case 2:
                        T.show("你点击了3");
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

    private void initText() {
        detailedTitle.setText(getIntent().getStringExtra("name"));
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
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
                    T.show(touchbalanceBean.getMsg());
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