package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/31.
 */

public class DiscountAdapter extends BaseQuickAdapter<ReceiveDiscounBean.BodyBean.CustCouponListDataBean,BaseViewHolder> {


    private final int cpStatus;

    public DiscountAdapter(int layoutResId, @Nullable List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> data, int cpStatus) {
        super(layoutResId, data);
        this.cpStatus=cpStatus;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, ReceiveDiscounBean.BodyBean.CustCouponListDataBean item) {
        if(cpStatus==0){
        }else if(cpStatus==1){
            helper.setVisible(R.id.iv_minediscount,true);
        }else if(cpStatus==2){
            helper.setVisible(R.id.iv_minediscount,false);
            helper.setVisible(R.id.iv_overdued,true);
            helper.setBackgroundColor(R.id.relativeLayout,R.color.alpha_05_black);
        }
        helper.setText(R.id.tv_discount,item.getCpCreateInfo().getCpName());
        helper.setText(R.id.tv_ten,item.getCpCreateInfo().getReduceAmount()+"元");
        helper.setText(R.id.tv_no,item.getCpCreateInfo().getCpUsing());
        helper.setText(R.id.tv_time,item.getCpCreateInfo().getUseFrom()+"~"+item.getCpCreateInfo().getUseTo());
        helper.setText(R.id.tv_purpose,item.getCpCreateInfo().getCpName());
    }
}
