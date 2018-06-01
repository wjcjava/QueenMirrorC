package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullShortAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.qbw.log.XLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 综合排序
 */

public class FullshortFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack, HttpCallBack {
    @Bind(R.id.full_sore_recycler)
    RecyclerView recycler;
    List<ClassificationBean.BodyBean.ShopListDataBean> sortlist = new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_fullshort;
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
        XLog.v("onRefresh");
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
        XLog.v("onLoadMore");
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
        inithttp();

    }

    private void inithttp() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", "1");
        params.put("contentByTitle", "");
        params.put("categoryId", "0");
        params.put("pageSize", "10");
        params.put("shopCate", "1");
        HttpUtils.doPost(ACTION.CLASSIFICATION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.CLASSIFICATION:
                ClassificationBean classificationBean = GsonUtil.toObj(res, ClassificationBean.class);

                if (classificationBean.isSuccess()) {
                    sortlist = classificationBean.getBody().getShopListData();

                    FullShortAdapter sortAdapter = new FullShortAdapter(getActivity(), R.layout.item_shortrecycler, sortlist);
                    recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    recycler.setAdapter(sortAdapter);
                    sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            startActivity(new Intent(getActivity(), WorkRoomDetailActivity.class));
                        }
                    });

                } else {
                    T.show(classificationBean.getMsg());
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