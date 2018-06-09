package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/11.
 */

public class CommentsAdapter extends BaseQuickAdapter<CommentsBean.BodyBean.CommentsListDataBean,BaseViewHolder> {


    public CommentsAdapter(int layoutResId, @Nullable List<CommentsBean.BodyBean.CommentsListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentsBean.BodyBean.CommentsListDataBean item) {
        helper.setText(R.id.tv_name,item.getGoodsIdName());
    }
}
