package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

public class OrderDetailListAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean,BaseViewHolder> {


    public OrderDetailListAdapter(int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean item) {

        helper.setText(R.id.tv_order_detail_price,"￥"+item.getAnsOrderDetails().getUnitPrice())
        .setText(R.id.tv_order_detail_name,item.getGoodsIdName())
        .setText(R.id.tv_order_detail_number,"X "+item.getAnsOrderDetails().getPurchaseNumber());
    }
}
