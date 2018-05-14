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

public class FullShortAdapter extends BaseQuickAdapter<ClassificationBean, BaseViewHolder> {


    public FullShortAdapter(int layoutResId, @Nullable List<ClassificationBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassificationBean item) {
        List<ClassificationBean.BodyBean.ShopListDataBean> list = item.getBody().getShopListData();

            helper.setText(R.id.tv_sort_name, list.get(0).getAnsShopBasic().getShopName());
            helper.setText(R.id.tv_sort_time, list.get(0).getAnsShopBasic().getCloseTime());

    }
}
