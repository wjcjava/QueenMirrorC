package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.DiscountAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.ItemCouponsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 历史优惠券
 */

public class HistorydiscountFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack, HttpCallBack {
    @Bind(R.id.re_distance)
    RecyclerView disrecycler;
    @Bind(R.id.re_itemcoupons)
    RecyclerView itemCoupons;
    List<SortBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private int position;
    private ReceiveDiscounBean receiveBean;
    private List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> discountList;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_history_mine;
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
        initDate();
        position = getArguments().getInt("position");
        getReceiveDiscoun();

    }

    private void getReceiveDiscoun() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", "111");//用户ID
        params.put("cpStatus", position + "");
        HttpUtils.doPost(ACTION.RECEIVEDISCOUN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initDate() {
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }



    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.RECEIVEDISCOUN:
                receiveBean = GsonUtil.toObj(res, ReceiveDiscounBean.class);
                if (receiveBean.isSuccess()) {
                    discountList = receiveBean.getBody().getCustCouponListData();
                    DiscountAdapter sortAdapter = new DiscountAdapter(R.layout.item_discount, discountList, position);
                    disrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    disrecycler.setAdapter(sortAdapter);

                    ItemCouponsAdapter couponsAdapter = new ItemCouponsAdapter(R.layout.item_itemcount, discountList,position);
                    itemCoupons.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    itemCoupons.setAdapter(couponsAdapter);

                } else {
                    T.show(receiveBean.getMsg());
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
