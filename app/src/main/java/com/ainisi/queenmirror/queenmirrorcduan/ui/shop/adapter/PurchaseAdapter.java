package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/31.
 */

public class PurchaseAdapter extends BaseQuickAdapter<ReceiveDiscounBean.BodyBean.CustCouponListDataBean,BaseViewHolder> {



    public PurchaseAdapter(int layoutResId, @Nullable List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> data) {
        super(layoutResId, data);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, ReceiveDiscounBean.BodyBean.CustCouponListDataBean item) {
        helper.setText(R.id.tv_discount,item.getCpCreateInfo().getCpName());
        helper.setText(R.id.tv_ten,item.getCpCreateInfo().getReduceAmount()+"元");
        helper.setText(R.id.tv_no,item.getCpCreateInfo().getCpUsing());
        helper.setText(R.id.tv_time,item.getCpCreateInfo().getUseFrom()+"~"+item.getCpCreateInfo().getUseTo());
        helper.setText(R.id.tv_purpose,item.getCpCreateInfo().getCpName());
    }
}
