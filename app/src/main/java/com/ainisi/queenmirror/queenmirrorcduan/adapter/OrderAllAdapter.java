package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundActivity;
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

        helper.setText(R.id.tv_shangpin,item.getIntfAnsShopBasic().getShopName());


        if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UP")){
            //待付款
            helper.setText(R.id.tv_order_tuikuan,"付款")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"取消")
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待付款");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UT")){
//待接单
            helper.setText(R.id.tv_order_tuikuan,"退款")
                    .setGone(R.id.tv_order_again,false)
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待接单");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("FT")){
//已接单
            helper.setText(R.id.tv_order_tuikuan,"查看订单")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"退款")
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已接单");

            helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ConfirmRefundActivity.class);

                    context.startActivity(intent);
                }
            });

        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("US")){
//待服务
            helper.setText(R.id.tv_order_tuikuan,"查看订单")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"退款")
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待服务");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("FN")){
//已完成
            helper.setGone(R.id.tv_order_tuikuan,false)
                    .setGone(R.id.tv_order_again,false)
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已完成");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UC")){
//待评价
            helper.setText(R.id.tv_order_tuikuan,"去评价")
                    .setGone(R.id.tv_order_again,false)
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待评价");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("CA")){
//已取消
            helper.setText(R.id.tv_order_tuikuan,"付款")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"取消")
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已取消");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("PR")){
//部分退款中
            helper.setText(R.id.tv_order_tuikuan,"部分退款中")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"取消")
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"部分退款中");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("PF")){
//部分已退款
            helper.setText(R.id.tv_order_tuikuan,"部分已退款")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setGone(R.id.tv_order_again,false)
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"部分已退款");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("RA")){
//退款中
            helper.setText(R.id.tv_order_tuikuan,"退款中")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"取消")
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"退款中");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("RF")){
//已退款
            helper.setGone(R.id.tv_order_tuikuan,false)
                    .setGone(R.id.tv_order_again,false)
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已退款");
        }

        List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderDetailsList = item.getIntfAnsOrder().getApiOrderDetailsList();
        double amountNum = 0;

        if(apiOrderDetailsList.size() == 1){
            helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setGone(R.id.tv_xijian,false)
                    .setGone(R.id.tv_tangran,false)
                    .setGone(R.id.textView29,false)
                    .setGone(R.id.textView30,false);

        }else if(apiOrderDetailsList.size() == 2){
            helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setGone(R.id.tv_tangran,false)
                    .setGone(R.id.textView30,false);

        }else if(apiOrderDetailsList.size() == 3){
            helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setText(R.id.tv_tangran,apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView30,"X "+apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getPurchaseNumber());
        }else{
            helper.setText(R.id.tv_taocan,apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView19,"X "+apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setText(R.id.tv_xijian,apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView29,"X "+apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getPurchaseNumber())
                    .setText(R.id.tv_tangran,apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getGoodsName())
                    .setText(R.id.textView30,"X "+apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getPurchaseNumber());
        }

        for(int i=0;i<apiOrderDetailsList.size();i++){
            amountNum = amountNum + Double.parseDouble(apiOrderDetailsList.get(i).getIntfAnsOrderDetails().getSumAmount());
        }
        if(apiOrderDetailsList.size() > 3){
            helper.setText(R.id.tv_head,"...                        共"+apiOrderDetailsList.size()+"个，商品实付")
                    .setText(R.id.tv_jiage,"￥"+ amountNum);
        }else{
            helper.setText(R.id.tv_head,"共"+apiOrderDetailsList.size()+"个，商品实付")
                    .setText(R.id.tv_jiage,"￥"+ amountNum);
        }

    }
}
