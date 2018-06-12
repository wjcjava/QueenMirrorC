package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/5/17.
 */

public class MyCommentsAdapter extends BaseQuickAdapter<MyCommentsBean.BodyBean.CommentsListDataBean,BaseViewHolder>{

    private final Context context;
    private List<MyCommentsBean.BodyBean.CommentsListDataBean.ApiEcAppraiseReplyListBean> replyList = new ArrayList<>();

    public MyCommentsAdapter(int layoutResId, @Nullable List<MyCommentsBean.BodyBean.CommentsListDataBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final MyCommentsBean.BodyBean.CommentsListDataBean item) {
        helper.setText(R.id.tv_shopname,item.getShopIdName())
                .setText(R.id.tv_mine_evaluate_goodname,item.getGoodsIdName())
                .setText(R.id.tv_mine_evaluate_content,item.getEcAppraiseGoods().getApprDetails());
        CustomRatingBar score_mine_evaluate = helper.getView(R.id.score_mine_evaluate);

        if(item.getEcAppraiseGoods().getEmployeeAbility().equals("")){
            score_mine_evaluate.setRating(1);
        }else{
            score_mine_evaluate.setRating(Float.parseFloat(item.getEcAppraiseGoods().getEmployeeAbility()));
        }

    }
}
