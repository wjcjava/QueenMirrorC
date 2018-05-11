package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopTuijianBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ShopTuijianAdapter extends BaseQuickAdapter<ShopTuijianBean.BodyBean.ApiEcGoodsBasicListBean,BaseViewHolder> {


    public ShopTuijianAdapter(int layoutResId, @Nullable List<ShopTuijianBean.BodyBean.ApiEcGoodsBasicListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopTuijianBean.BodyBean.ApiEcGoodsBasicListBean item) {
        helper.setText(R.id.tv_commodity_name,item.getEcGoodsBasic().getGoodsName())
        .setText(R.id.tv_present_price,"￥"+item.getEcGoodsBasic().getGoodsPrice())
        .setText(R.id.original_price,"￥"+item.getEcGoodsBasic().getOfflinePrice());

       TextView original_price = helper.convertView.findViewById(R.id.original_price);
        original_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
    }
}
