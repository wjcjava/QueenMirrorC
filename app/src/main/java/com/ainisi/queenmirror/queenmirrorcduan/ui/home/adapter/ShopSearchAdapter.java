package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopSearchBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/1.
 */

public class ShopSearchAdapter extends BaseQuickAdapter<ShopListHomeBean.BodyBean.ShopListBean, BaseViewHolder> {
    public ShopSearchAdapter(int layoutResId, @Nullable List<ShopListHomeBean.BodyBean.ShopListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopListHomeBean.BodyBean.ShopListBean item) {
        helper.setText(R.id.tv_search_shopname, item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_search_shoptime, item.getAnsShopBasic().getJoinTime());
    }
}
