package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ConfirmRefundAdapter extends BaseQuickAdapter<AreFundBean,BaseViewHolder> {


    public ConfirmRefundAdapter(int layoutResId, @Nullable List<AreFundBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AreFundBean item) {

        helper.setText(R.id.tv_shop_name,item.getIntfAnsOrderDetails().getGoodsName())
                .setText(R.id.tv_confirm_number,"X"+item.getIntfAnsOrderDetails().getPurchaseNumber())
                .setText(R.id.tv_confirm_price,"￥"+item.getIntfAnsOrderDetails().getUnitPrice());
    }
}
