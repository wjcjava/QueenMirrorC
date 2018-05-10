package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 全部订单
 */

public class WholeFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack, HttpCallBack {
    @Bind(R.id.rc_whole)
    RecyclerView whole;
    private List<SortBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_whole;
    }

    @Override
    public void initPresenter() {
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

    @Override
    protected void initView() {
        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }
        MyAdapter sbmitWholeAdapter = new MyAdapter(R.layout.item_sbmitrecycler, list);
        whole.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        whole.setAdapter(sbmitWholeAdapter);

        sbmitWholeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), OrderDetailActivity.class));
            }
        });


        doFirstData();
    }

    /**
     * 获取全部订单的数据
     */
    private void doFirstData(){
        HashMap<String, String> params = new HashMap<>();
        params.put("orderStatus", "");
        params.put("pageNumber", "1");
        params.put("userId", "1111");
        params.put("pageSize", "5");
        HttpUtils.doPost(ACTION.ALLOFMYORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.ALLOFMYORDER:

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
