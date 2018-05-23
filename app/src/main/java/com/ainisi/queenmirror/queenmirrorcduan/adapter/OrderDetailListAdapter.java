package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

public class OrderDetailListAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean,BaseViewHolder> {


    public OrderDetailListAdapter(int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean item) {

        helper.setText(R.id.tv_order_detail_price,"￥"+item.getIntfAnsOrderDetails().getUnitPrice())
        .setText(R.id.tv_order_detail_name,item.getIntfAnsOrderDetails().getGoodsName())
        .setText(R.id.tv_order_detail_number,"X "+item.getIntfAnsOrderDetails().getPurchaseNumber());
    }
}
