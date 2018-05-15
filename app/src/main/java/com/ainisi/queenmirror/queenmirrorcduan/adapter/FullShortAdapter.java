package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 */

public class FullShortAdapter extends BaseQuickAdapter<ClassificationBean.BodyBean.ShopListDataBean, BaseViewHolder> {


    public FullShortAdapter(int layoutResId, @Nullable List<ClassificationBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassificationBean.BodyBean.ShopListDataBean item) {
        helper.setText(R.id.sort_name, item.getAnsShopBasic().getShopName());
        helper.setText(R.id.sort_time, item.getAnsShopBasic().getCloseTime());
    }


}
