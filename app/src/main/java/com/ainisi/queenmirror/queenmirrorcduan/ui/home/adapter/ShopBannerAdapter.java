package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopBannerBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/16.
 */

public class ShopBannerAdapter extends BaseQuickAdapter<ShopBannerBean.BodyBean.ShopListDataBean, BaseViewHolder> {
    public ShopBannerAdapter(int layoutResId, @Nullable List<ShopBannerBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBannerBean.BodyBean.ShopListDataBean item) {
        helper.setText(R.id.tv_sort_name,item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_sort_time,item.getAnsShopBasic().getCloseTime());
        Glide.with(mContext).load(item.getAnsShopBasic().getShopLogo()).crossFade().centerCrop().into((ImageView) helper.getView(R.id.iv_homepage_shop_listview));
    }
}
