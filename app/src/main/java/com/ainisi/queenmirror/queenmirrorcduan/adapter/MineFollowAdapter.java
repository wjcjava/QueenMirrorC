package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineFollowBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MineFollowAdapter extends BaseQuickAdapter<MineFollowBean.BodyBean.CommentsListDataBean,BaseViewHolder> {


    public MineFollowAdapter(int layoutResId, @Nullable List<MineFollowBean.BodyBean.CommentsListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineFollowBean.BodyBean.CommentsListDataBean item) {

        L.e("测试的方法"+item.getAnsShopBasic().getShopName());

        helper.setText(R.id.sote_name,item.getAnsShopBasic().getShopName())
        .setText(R.id.tv_mine_follow_score,"5")
        .setText(R.id.sort_time,"营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());
    }
}
