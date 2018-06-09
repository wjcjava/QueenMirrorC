package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
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
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.MyFootAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MineFootBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

//我的足迹
public class MineMyFootActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack, HttpCallBack {

    @Bind(R.id.mine_foot_recycler)
    RecyclerView recycler;
    @Bind(R.id.title_title)
    TextView folltitle;
    @Bind(R.id.title_right)
    TextView titleRight;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    List<MineFootBean> sortlist = new ArrayList<>();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineMyFootActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_my_foot;
    }


    @Override
    protected void initView() {
        super.initView();
        folltitle.setText("我的足迹");
        folltitle.setTextSize(16);
        titleRight.setText("编辑");
        titleRight.setTextSize(14);
        titleRight.setVisibility(View.GONE);

    }

    @Override
    protected void initData() {
        super.initData();
        inithttp();
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
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

    private void inithttp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userId", "111");
        hashMap.put("pageNumber", "1");
        HttpUtils.doPost(ACTION.MYFOOT, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void onSuccess(int action, String res) {

        switch (action) {
            //我的足迹
            case ACTION.MYFOOT:
                for (int i = 0; i < 6; i++) {
                    MineFootBean sortBean = GsonUtil.toObj(res,MineFootBean.class);
                    sortlist.add(sortBean);
                }

                MyFootAdapter sortAdapter = new MyFootAdapter(R.layout.item_fullshortrecycler, sortlist);
                recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                recycler.setAdapter(sortAdapter);
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
