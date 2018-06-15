package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

public class SearchGoodsAdapter extends BaseQuickAdapter<GoodsListBean.BodyBean.GoodsListDataBean, BaseViewHolder> {
    public SearchGoodsAdapter(int layoutResId, @Nullable List<GoodsListBean.BodyBean.GoodsListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsListBean.BodyBean.GoodsListDataBean item) {
        helper.setText(R.id.tv_weorkroom_title,item.getEcGoodsBasic().getGoodsName())
                .setText(R.id.tv_weorkroom_name,item.getEcGoodsBasic().getGoodsBrief())
        .setText(R.id.tv_workroom_service_time,item.getEcGoodsBasic().getServiceTime())
        .setText(R.id.tv_price,"￥"+item.getEcGoodsBasic().getSalesPrice())
        .setText(R.id.tv_workroom_service_price,"￥"+item.getEcGoodsBasic().getMarketPrice());
    }
}
