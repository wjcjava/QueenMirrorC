package com.ainisi.queenmirror.queenmirrorcduan.ui.order.orderadapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 王军超 on 2018/3/22.
 */

public class ScoreAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean,BaseViewHolder> {


    public ScoreAdapter(int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean item) {
        helper.setText(R.id.tv_shop_name,item.getIntfAnsOrderDetails().getGoodsName());
        CustomRatingBar score_custom_list = helper.getView(R.id.score_custom_list);
        score_custom_list.setmOnStarChangeListener(new CustomRatingBar.onStarChangedListener() {
            @Override
            public void onStarChange(CustomRatingBar ratingBar, float mark) {
                if(mark == 1){
                    helper.setText(R.id.tv_score,"非常差");
                }else if(mark == 2){
                    helper.setText(R.id.tv_score,"差");
                }else if(mark == 3){
                    helper.setText(R.id.tv_score,"一般");
                }else if(mark == 4){
                    helper.setText(R.id.tv_score,"好");
                }else if(mark == 5){
                    helper.setText(R.id.tv_score,"非常好");
                }
            }
        });


    }
}
