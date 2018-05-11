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

public class CommentsAdapter extends BaseQuickAdapter<CommentsBean,BaseViewHolder> {

    public CommentsAdapter(int layoutResId, @Nullable List<CommentsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentsBean item) {
        helper.setText(R.id.tv_name,item.getBody().getApiGoodsCommentsList().get(0).getGoodsIdName());
    }
}
