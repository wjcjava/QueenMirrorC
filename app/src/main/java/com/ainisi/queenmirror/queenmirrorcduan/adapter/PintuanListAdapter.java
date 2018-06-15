package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

public class PintuanListAdapter extends BaseQuickAdapter<PinTuanBean.BodyBean.GroupActivityListDataBean,BaseViewHolder> {
    public PintuanListAdapter(int layoutResId, @Nullable List<PinTuanBean.BodyBean.GroupActivityListDataBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, PinTuanBean.BodyBean.GroupActivityListDataBean item) {
        helper.setText(R.id.tv_fightalone_name,item.getEcGoodsBasic().getGoodsName())
        .setText(R.id.tv_fightalone_briefintroduction,item.getEcGoodsBasic().getGoodsBrief())
        .setText(R.id.tv_fightalone_presentprice,item.getEcGoodsBasic().getSalesPrice())
        .setText(R.id.tv_fightalone_number,"已拼"+item.getGpActivity().getSaleNums()+"件");
    }
}