package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean.RefundBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 */

public class RefundAdapter extends BaseQuickAdapter<RefundBean,BaseViewHolder> {

    public RefundAdapter(int layoutResId, @Nullable List<RefundBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RefundBean item) {
        helper.setText(R.id.tv_refund_name,item.getBody().getApiRefundList().get(0).getEcGoodsBasic().getGoodsName());
    }
}
