package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RefundAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ArefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean.RefundBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
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
 * 退款
 */

public class RefundFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack ,HttpCallBack{
    @Bind(R.id.rc_refund)
    RecyclerView refund;
    private List<RefundBean> list=new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private RefundBean refundBean;
    List<RefundBean.BodyBean.ApiRefundListBean> apiRefundList = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_refund;
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
        inithttp();

    }

    private void inithttp() {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("userId", SP.get(getActivity(), SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.REFUND,hashMap, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.REFUND:
                refundBean = GsonUtil.toObj(res, RefundBean.class);
                apiRefundList = refundBean.getBody().getApiRefundList();
                RefundAdapter sbmitWholeAdapter=new RefundAdapter(R.layout.item_refundrecycler,apiRefundList);
                refund.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL,false));
                refund.setAdapter(sbmitWholeAdapter);
                sbmitWholeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        //退款
                        startActivity(new Intent(getActivity(), ArefundActivity.class));
                    }
                });
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
