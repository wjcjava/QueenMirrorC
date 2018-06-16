package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBannerBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/16.
 */

public class GoodsBannerAdapter extends BaseQuickAdapter<GoodsBannerBean.BodyBean.BannerListDataBean, BaseViewHolder> {
    public GoodsBannerAdapter(int layoutResId, @Nullable List<GoodsBannerBean.BodyBean.BannerListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBannerBean.BodyBean.BannerListDataBean item) {
            helper.setText(R.id.tv_sort_name,item.getEcGoodsBasic().getGoodsName());
            helper.setText(R.id.tv_sort_time,item.getEcGoodsBasic().getServiceTime());

    }
}
