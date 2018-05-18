package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/17.
 */

public class MyCommentsAdapter extends BaseQuickAdapter<MyCommentsBean.BodyBean.CommentsListDataBean,BaseViewHolder>{

    public MyCommentsAdapter(int layoutResId, @Nullable List<MyCommentsBean.BodyBean.CommentsListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCommentsBean.BodyBean.CommentsListDataBean item) {
        helper.setText(R.id.tv_shopname,item.getShopIdName());
        helper.setText(R.id.tv_name,item.getGoodsIdName()+"");

    }
}
