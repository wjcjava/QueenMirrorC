package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ArefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 退款
 */

public class RefundFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack {
    @Bind(R.id.rc_refund)
    RecyclerView refund;
    private List<SortBean> list=new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
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
        for (int i = 0; i <10 ; i++) {
            SortBean sortBean=new SortBean();
            list.add(sortBean);
        }
        MyAdapter sbmitWholeAdapter=new MyAdapter(R.layout.item_refundrecycler,list);
        refund.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL,false));
        refund.setAdapter(sbmitWholeAdapter);
        sbmitWholeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //退款
                startActivity(new Intent(getActivity(), ArefundActivity.class));
            }
        });

    }
}
