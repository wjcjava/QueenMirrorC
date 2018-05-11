package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class OrderAllAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean,BaseViewHolder> {


    public OrderAllAdapter(int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean item) {

        OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsShopBasicBean ansShopBasicBean = item.getAnsShopBasic();
        L.e("测试的数据"+ansShopBasicBean);

        if(ansShopBasicBean == null){

        }else{

            helper.setText(R.id.tv_shangpin,ansShopBasicBean.getShopName());

            List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean> apiOrderDetailsList = item.getAnsOrder().getApiOrderDetailsList();
            double amountNum = 0;

            if(apiOrderDetailsList.size() == 1){
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getGoodsIdName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setGone(R.id.tv_xijian,false)
                        .setGone(R.id.tv_tangran,false)
                        .setGone(R.id.textView29,false)
                        .setGone(R.id.textView30,false);

            }else if(apiOrderDetailsList.size() == 2){
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getGoodsIdName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getGoodsIdName())
                        .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getAnsOrderDetails().getPurchaseNumber())
                        .setGone(R.id.tv_tangran,false)
                        .setGone(R.id.textView30,false);

            }else if(apiOrderDetailsList.size() == 3){
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getGoodsIdName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getGoodsIdName())
                        .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_tangran,apiOrderDetailsList.get(2).getGoodsIdName())
                        .setText(R.id.textView30,"X "+apiOrderDetailsList.get(2).getAnsOrderDetails().getPurchaseNumber());
            }else{
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getGoodsIdName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getGoodsIdName())
                        .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_tangran,apiOrderDetailsList.get(2).getGoodsIdName())
                        .setText(R.id.textView30,"X "+apiOrderDetailsList.get(2).getAnsOrderDetails().getPurchaseNumber());
            }

            for(int i=0;i<apiOrderDetailsList.size();i++){
                amountNum = amountNum + Double.parseDouble(apiOrderDetailsList.get(i).getAnsOrderDetails().getSumAmount());
            }

            if(apiOrderDetailsList.size() > 3){
                helper.setText(R.id.tv_head,"...                        共"+apiOrderDetailsList.size()+"个，商品实付")
                        .setText(R.id.tv_jiage,"￥"+ amountNum);
            }else{
                helper.setText(R.id.tv_head,".共"+apiOrderDetailsList.size()+"个，商品实付")
                        .setText(R.id.tv_jiage,"￥"+ amountNum);
            }



        }

    }
}
