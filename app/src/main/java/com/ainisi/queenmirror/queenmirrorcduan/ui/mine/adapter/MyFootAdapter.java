package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MineFootBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/11.
 */

public class MyFootAdapter extends BaseQuickAdapter<MineFootBean,BaseViewHolder> {

    public MyFootAdapter(int layoutResId, @Nullable List<MineFootBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineFootBean item) {

            helper.setText(R.id.foot_name,item.getBody().getViewListData().get(1).getEcGoodsBasic().getGoodsName());


    }
}
