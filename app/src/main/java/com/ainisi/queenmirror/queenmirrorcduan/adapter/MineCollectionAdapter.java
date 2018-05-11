package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineCollectionListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MineCollectionAdapter extends BaseQuickAdapter<MineCollectionListBean.BodyBean.CollectListDataBean,BaseViewHolder> {


    public MineCollectionAdapter(int layoutResId, @Nullable List<MineCollectionListBean.BodyBean.CollectListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineCollectionListBean.BodyBean.CollectListDataBean item) {
        helper.setText(R.id.tv_name,item.getGoodsIdName())
        .setText(R.id.tv_price,item.getEcGoodsBasic().getGoodsPrice());

    }
}
