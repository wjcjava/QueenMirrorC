package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.TouchbalanceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/5.
 */

public class TouchAdapter extends BaseQuickAdapter<TouchbalanceBean.BodyBean.AccountChargeRecordsBean,BaseViewHolder> {

    public TouchAdapter(int layoutResId, @Nullable List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TouchbalanceBean.BodyBean.AccountChargeRecordsBean item) {
        helper.setText(R.id.tv_touch_name,item.getBusinessId());
        helper.setText(R.id.tv_whole,item.getChargeMethod());
        helper.setText(R.id.tv_touch_time,item.getChargeDate());
        helper.setText(R.id.tv_touch_sum,item.getRechargeConsume());
    }
}
