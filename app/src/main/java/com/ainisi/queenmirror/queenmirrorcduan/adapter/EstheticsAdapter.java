package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class EstheticsAdapter  extends BaseQuickAdapter<EstheticsBean.BodyBean.ApiShopListBean,BaseViewHolder> {

    public EstheticsAdapter(int layoutResId, @Nullable List<EstheticsBean.BodyBean.ApiShopListBean> apiShopList) {
        super(layoutResId, apiShopList);
    }

    @Override
    protected void convert(BaseViewHolder helper, EstheticsBean.BodyBean.ApiShopListBean item) {
        helper.setText(R.id.tv_commodity_name,item.getAnsShopBasic().getShopName());
    }
}
