package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomeNewShopBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/15.
 */

public class HomeNewShopAdapter extends BaseQuickAdapter<HomeNewShopBean.BodyBean.NewShopListBean,BaseViewHolder> {


    public HomeNewShopAdapter(int layoutResId, @Nullable List<HomeNewShopBean.BodyBean.NewShopListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewShopBean.BodyBean.NewShopListBean item) {
        helper.setText(R.id.tv_commodity_name,item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_praise,item.getAnsShopBasic().getIndustryCate());
        Glide.with(mContext).load(item.getAnsShopBasic().getShopLogo()).crossFade().into((ImageView) helper.getView(R.id.iv_commodity_picture));

    }
}
