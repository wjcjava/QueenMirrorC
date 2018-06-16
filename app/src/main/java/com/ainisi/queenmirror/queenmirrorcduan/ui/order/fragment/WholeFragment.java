package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderAllAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 全部订单
 */

public class WholeFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.rc_whole)
    RecyclerView whole;
   /* @Bind(R.id.order_main_refresh)
    MaterialRefreshLayout order_main_refresh;*/
   @Bind(R.id.refreshLayout)
   SmartRefreshLayout refreshLayout;
    private List<SortBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    double amountNum;
    int pageSum = 0, pageNumber = 1,pageIndex = 0;
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean>apiOrderList = new ArrayList();
    String state;
    public static WholeFragment instance = null;

    OrderAllAdapter sbmitWholeAdapter;

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.fragment_sort_whole;
    }

    public WholeFragment newInstance(String flag) {
        Bundle bundle = new Bundle();
        bundle.putString("state", flag);
        WholeFragment testFm = new WholeFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void onResume() {
        super.onResume();
        doFirstData();
    }

    @Override
    protected void initView() {

        sbmitWholeAdapter = new OrderAllAdapter(getActivity(), R.layout.item_sbmitrecycler, apiOrderList);
        whole.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        whole.setAdapter(sbmitWholeAdapter);


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                doFirstData();
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < pageIndex && pageSum <= (pageIndex+Integer.parseInt(SpContent.pageSize))){
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    doFirstData();
                    refreshlayout.finishLoadmore(2000);
                }

            }
        });
    }

    /**
     * 获取全部订单的数据
     */
    public void doFirstData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            state = bundle.getString("state");
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("orderStatus", state);
        params.put("pageNumber", pageNumber + "");
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("pageSize", SpContent.pageSize);
        HttpUtils.doPost(ACTION.ALLOFMYORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {

            case ACTION.ALLOFMYORDER:

                OrderMyAllOrderBean orderMyAllOrderBean = GsonUtil.toObj(res, OrderMyAllOrderBean.class);
                if (orderMyAllOrderBean.isSuccess()) {
                    pageSum = orderMyAllOrderBean.getBody().getPageSum();

                    if(pageSum < pageIndex && pageSum <= (pageIndex+Integer.parseInt(SpContent.pageSize))){
                        refreshLayout.setEnableLoadmore(false);
                        T.show("您已加载完全部数据");
                    }else{
                        refreshLayout.setEnableLoadmore(true);
                    }

                    loadMoreData(orderMyAllOrderBean.getBody().getApiOrderList());

                    sbmitWholeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            amountNum = 0;
                            for (int i = 0; i < apiOrderList.get(position).getIntfAnsOrder().getApiOrderDetailsList().size(); i++) {
                                amountNum = amountNum + Double.parseDouble(apiOrderList.get(position).getIntfAnsOrder().getApiOrderDetailsList().get(i).getIntfAnsOrderDetails().getSumAmount());
                            }
                            Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                            intent.putExtra("orderId",apiOrderList.get(position).getIntfAnsOrder().getId());
                            intent.putExtra("orderNo", apiOrderList.get(position).getIntfAnsOrder().getOrderNo());
                            intent.putExtra("orderTel", apiOrderList.get(position).getIntfAnsShopBasic().getServiceTel());
                            intent.putExtra("orderTime", apiOrderList.get(position).getIntfAnsOrder().getOrderTime());
                            intent.putExtra("orderState",apiOrderList.get(position).getIntfAnsOrder().getOrderStatus());
                            intent.putExtra("shopId",apiOrderList.get(position).getIntfAnsShopBasic().getId());
                            intent.putExtra("OrderHeji", amountNum + "");
                            intent.putExtra("lstBean", (Serializable) apiOrderList.get(position).getIntfAnsOrder().getApiOrderDetailsList());
                            startActivity(intent);
                        }
                    });
                } else {
                    T.show(orderMyAllOrderBean.getMsg());
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

    public void loadMoreData(List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> apiOrderListMore){

        if(apiOrderList == null){
            apiOrderList = new ArrayList<>();
        }

        if(pageIndex == 0){
            sbmitWholeAdapter.setmDate(null);
        }
        apiOrderList.addAll(apiOrderListMore);

        if(pageIndex == 0){
            sbmitWholeAdapter.setmDate(apiOrderList);
        }else{
            sbmitWholeAdapter.notifyDataSetChanged();
        }
       pageIndex += Integer.parseInt(SpContent.pageSize);
    }
}
