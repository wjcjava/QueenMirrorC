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
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderAllAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
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
   /* @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;*/
    double amountNum;
    int pageSum,pageNumber = 1;
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> apiOrderList = new ArrayList();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_whole;
    }

    @Override
    public void initPresenter() {
       /* mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()
                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());*/
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doFirstData();
            }
        }, 200);
    }

    @Override
    public void onLoadMore() {

        if(pageSum <= pageNumber * 10){
            T.show("您已获取全部数据");
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pageNumber++;
                    doFirstData();
                }
            }, 1000);
        }
    }

    @Override
    protected void initView() {
        doFirstData();
    }
    /**
     * 获取全部订单的数据
     */
    private void doFirstData(){
        HashMap<String, String> params = new HashMap<>();
        params.put("orderStatus", "");
        params.put("pageNumber", pageNumber+"");
        params.put("userId", "1111");
        params.put("pageSize", "10");
        HttpUtils.doPost(ACTION.ALLOFMYORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
     }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.ALLOFMYORDER:
              /*  mRefreshLoadMoreLayout.stopRefresh();
                mRefreshLoadMoreLayout.stopLoadMore();*/
                OrderMyAllOrderBean orderMyAllOrderBean = GsonUtil.toObj(res,OrderMyAllOrderBean.class);

                if(orderMyAllOrderBean.isSuccess()){


                    pageSum = orderMyAllOrderBean.getBody().getPageSum();
                    apiOrderList = orderMyAllOrderBean.getBody().getApiOrderList();
           // case ACTION.ALLOFMYORDER:

                    OrderAllAdapter sbmitWholeAdapter = new OrderAllAdapter(R.layout.item_sbmitrecycler, apiOrderList);
                    whole.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
                    whole.setAdapter(sbmitWholeAdapter);

                    sbmitWholeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            amountNum = 0;
                            for(int i=0;i<apiOrderList.get(position).getAnsOrder().getApiOrderDetailsList().size();i++){
                                amountNum  = amountNum + Double.parseDouble(apiOrderList.get(position).getAnsOrder().getApiOrderDetailsList().get(i).getAnsOrderDetails().getSumAmount());
                            }
                            Intent intent = new Intent(getActivity(),OrderDetailActivity.class);
                            intent.putExtra("orderNo", apiOrderList.get(position).getAnsOrder().getOrderNo());
                            intent.putExtra("orderTel",apiOrderList.get(position).getAnsShopBasic().getServiceTel());
                            intent.putExtra("orderTime",apiOrderList.get(position).getAnsOrder().getOrderTime());
                            intent.putExtra("OrderHeji",amountNum+"");
                            intent.putExtra("lstBean", (Serializable)apiOrderList.get(position).getAnsOrder().getApiOrderDetailsList());
                            startActivity(intent);
                        }
                    });
                }else{
                    //这里是获取失败的情况
                    T.show(orderMyAllOrderBean.getMsg());
                }
                break;
          //      break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
