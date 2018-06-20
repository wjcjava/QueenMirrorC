package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SpellOrderAdapter extends BaseQuickAdapter<FightaloneBean.BodyBean.GpOrderListBean,BaseViewHolder> {

    int groupnum = 0;
    public SpellOrderAdapter(int layoutResId, @Nullable List<FightaloneBean.BodyBean.GpOrderListBean> data,int groupnum) {
        super(layoutResId, data);
        this.groupnum = groupnum;
    }

    @Override
    protected void convert(BaseViewHolder helper, FightaloneBean.BodyBean.GpOrderListBean item) {
        Date date1 = new Date(Integer.parseInt(item.getGpOrder().getEndTimes()));
        SimpleDateFormat format1 = new SimpleDateFormat("HH:MM");
        helper.setText(R.id.tv_adapter_username,item.getAnsCustBasic().getUserName())
                .setText(R.id.tv_adapter_surplus,"还差"+(groupnum-item.getGpOrder().getJoinNums())+"人")
                .setText(R.id.tv_adapter_shengyu,"剩余:"+format1.format(date1));
    }
}
