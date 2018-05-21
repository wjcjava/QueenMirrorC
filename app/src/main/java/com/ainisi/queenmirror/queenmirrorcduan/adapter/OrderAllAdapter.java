package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class OrderAllAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean,BaseViewHolder> {

    Context context;

    public OrderAllAdapter(Context context,int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean item) {

        //OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsShopBasicBeanX ansShopBasicBean = item.getAnsShopBasic();
/*
        if(ansShopBasicBean == null){

        }else{

            helper.setText(R.id.tv_shangpin,ansShopBasicBean.getShopName());*/

            if(item.getAnsOrder().getOrderStatus().equals("UP")){
                //待付款
                helper.setText(R.id.tv_order_tuikuan,"付款")
                        .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again,"取消")
                        .setGone(R.id.tv_order_like, false);
            }else if(item.getAnsOrder().getOrderStatus().equals("UT")){
//待接单
                helper.setText(R.id.tv_order_tuikuan,"退款")
                        .setGone(R.id.tv_order_again,false)
                        .setGone(R.id.tv_order_like, false);

            }else if(item.getAnsOrder().getOrderStatus().equals("FT")){
//已接单
                helper.setText(R.id.tv_order_tuikuan,"查看订单")
                        .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again,"退款")
                        .setGone(R.id.tv_order_like, false);
            }else if(item.getAnsOrder().getOrderStatus().equals("US")){
//待服务
                helper.setText(R.id.tv_order_tuikuan,"查看订单")
                        .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again,"退款")
                        .setGone(R.id.tv_order_like, false);
            }else if(item.getAnsOrder().getOrderStatus().equals("FN")){
//已完成
                helper.setGone(R.id.tv_order_tuikuan,false)
                        .setGone(R.id.tv_order_again,false)
                        .setGone(R.id.tv_order_like, false);
            }else if(item.getAnsOrder().getOrderStatus().equals("UC")){
//待评价
                helper.setText(R.id.tv_order_tuikuan,"评价")
                        .setGone(R.id.tv_order_again,false)
                        .setGone(R.id.tv_order_like, false);
            }else if(item.getAnsOrder().getOrderStatus().equals("CA")){
//已取消
            }else if(item.getAnsOrder().getOrderStatus().equals("PR")){
//部分退款中
            }else if(item.getAnsOrder().getOrderStatus().equals("PF")){
//部分已退款
            }else if(item.getAnsOrder().getOrderStatus().equals("RA")){
//退款中
            }else if(item.getAnsOrder().getOrderStatus().equals("RF")){
//已退款
            }

            List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean> apiOrderDetailsList = item.getAnsOrder().getApiOrderDetailsList();
            double amountNum = 0;

            if(apiOrderDetailsList.size() == 1){
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setGone(R.id.tv_xijian,false)
                        .setGone(R.id.tv_tangran,false)
                        .setGone(R.id.textView29,false)
                        .setGone(R.id.textView30,false);

            }else if(apiOrderDetailsList.size() == 2){
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getAnsOrderDetails().getPurchaseNumber())
                        .setGone(R.id.tv_tangran,false)
                        .setGone(R.id.textView30,false);

            }else if(apiOrderDetailsList.size() == 3){
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_tangran,apiOrderDetailsList.get(2).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView30,"X "+apiOrderDetailsList.get(2).getAnsOrderDetails().getPurchaseNumber());
            }else{
                helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getEcGoodsBasic().getGoodsName())
                        .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_tangran,apiOrderDetailsList.get(2).getEcGoodsBasic().getGoodsName())
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



        //}

    }
}
