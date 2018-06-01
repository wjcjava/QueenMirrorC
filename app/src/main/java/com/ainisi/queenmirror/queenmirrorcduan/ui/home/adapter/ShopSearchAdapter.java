package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopSearchBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/1.
 */

public class ShopSearchAdapter  extends BaseQuickAdapter<ShopSearchBean.BodyBean.ShopListDataBean,BaseViewHolder> {
    public ShopSearchAdapter(int layoutResId, @Nullable List<ShopSearchBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ShopSearchBean.BodyBean.ShopListDataBean item) {
        helper.setText(R.id.tv_search_shopname,item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_search_shoptime,item.getAnsShopBasic().getJoinTime());
    }
}
