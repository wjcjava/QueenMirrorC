package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
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
    private final Context context;

    public HomeNewShopAdapter(int layoutResId, @Nullable List<HomeNewShopBean.BodyBean.NewShopListBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewShopBean.BodyBean.NewShopListBean item) {
        ImageView shopLogo=helper.getView(R.id.iv_commodity_picture);
        Glide.with(context).load(item.getAnsShopBasic().getShopLogo()).into(shopLogo);
        helper.setText(R.id.tv_commodity_name,item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_praise,item.getAnsShopBasic().getIndustryCate());

    }
}
