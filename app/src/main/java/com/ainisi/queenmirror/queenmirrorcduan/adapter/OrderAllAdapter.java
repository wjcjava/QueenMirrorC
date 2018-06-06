package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ArefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ScoreActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderAllAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean,BaseViewHolder> implements HttpCallBack{

    Context context;
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderListBeanList = new ArrayList<>();

    OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean apiOrderDetailsListBean;


    double amountNum = 0;
    String shopId,orderId;

    public OrderAllAdapter(Context context,int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> data) {
        super(layoutResId,data);
        this.context = context;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(final BaseViewHolder helper, final OrderMyAllOrderBean.BodyBean.ApiOrderListBean item) {

        helper.setText(R.id.tv_shangpin,item.getIntfAnsShopBasic().getShopName());

        if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UP")){
            //待付款
            helper.setText(R.id.tv_order_tuikuan,"付款")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"取消")
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待付款");

            helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    TextView textView = helper.getView(R.id.tv_jiage);
                    String number = textView.getText().toString().substring(1,textView.getText().toString().length());
                    Intent intent = new Intent(context, SubmitActivity.class);
                    intent.putExtra("businessIds",item.getIntfAnsOrder().getId());
                    intent.putExtra("amount",number+"");
                    context.startActivity(intent);
                }
            });

            helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    T.show("点击了取消");

                    orderId = item.getIntfAnsOrder().getId();
                    shopId = item.getIntfAnsShopBasic().getId();

                    CancelOrderData();
                }
            });
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UT")){
            //待接单
            helper.setText(R.id.tv_order_tuikuan,"退款")
                    .setVisible(R.id.tv_order_again,false)
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待接单");

            /**
             * 退款
             */
            helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ArefundActivity.class);

                    for(int i=0;i<item.getIntfAnsOrder().getApiOrderDetailsList().size();i++){
                        apiOrderDetailsListBean = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean();
                        apiOrderDetailsListBean = item.getIntfAnsOrder().getApiOrderDetailsList().get(i);
                        apiOrderListBeanList.add(apiOrderDetailsListBean);
                    }
                    intent.putExtra("lstBean",(Serializable)apiOrderListBeanList);
                    intent.putExtra("orderNo",item.getIntfAnsOrder().getOrderNo());
                    context.startActivity(intent);
                }
            });

        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("FT")){
            //已接单
            helper.setText(R.id.tv_order_tuikuan,"查看订单")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"退款")
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已接单");

            helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,OrderDetailActivity.class);
                    intent.putExtra("orderNo", item.getIntfAnsOrder().getOrderNo());
                    intent.putExtra("orderTel",item.getIntfAnsShopBasic().getServiceTel());
                    intent.putExtra("orderTime",item.getIntfAnsOrder().getOrderTime());
                    intent.putExtra("OrderHeji",amountNum+"");
                    intent.putExtra("lstBean", (Serializable)item.getIntfAnsOrder().getApiOrderDetailsList());
                    intent.putExtra("orderId",item.getIntfAnsOrder().getId());
                    intent.putExtra("orderState",item.getIntfAnsOrder().getOrderStatus());
                    context.startActivity(intent);

                }
            });

            /**
             * 退款
             */
            helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ArefundActivity.class);

                    for(int i=0;i<item.getIntfAnsOrder().getApiOrderDetailsList().size();i++){
                        apiOrderDetailsListBean = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean();
                        apiOrderDetailsListBean = item.getIntfAnsOrder().getApiOrderDetailsList().get(i);
                        apiOrderListBeanList.add(apiOrderDetailsListBean);
                    }
                    intent.putExtra("lstBean",(Serializable)apiOrderListBeanList);
                    intent.putExtra("orderNo",item.getIntfAnsOrder().getOrderNo());
                    context.startActivity(intent);
                }
            });

        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("US")){
            //待服务
            helper.setText(R.id.tv_order_tuikuan,"查看订单")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"退款")
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待服务");
            helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,OrderDetailActivity.class);
                    intent.putExtra("orderNo", item.getIntfAnsOrder().getOrderNo());
                    intent.putExtra("orderTel",item.getIntfAnsShopBasic().getServiceTel());
                    intent.putExtra("orderTime",item.getIntfAnsOrder().getOrderTime());
                    intent.putExtra("OrderHeji",amountNum+"");
                    intent.putExtra("lstBean", (Serializable)item.getIntfAnsOrder().getApiOrderDetailsList());
                    intent.putExtra("orderId",item.getIntfAnsOrder().getId());
                    intent.putExtra("orderState",item.getIntfAnsOrder().getOrderStatus());
                    context.startActivity(intent);
                }
            });

            /**
             * 退款
             */
            helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ArefundActivity.class);

                    for(int i=0;i<item.getIntfAnsOrder().getApiOrderDetailsList().size();i++){
                        apiOrderDetailsListBean = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean();
                        apiOrderDetailsListBean = item.getIntfAnsOrder().getApiOrderDetailsList().get(i);
                        apiOrderListBeanList.add(apiOrderDetailsListBean);
                    }
                    intent.putExtra("lstBean",(Serializable)apiOrderListBeanList);
                    intent.putExtra("orderNo",item.getIntfAnsOrder().getOrderNo());
                    context.startActivity(intent);
                }
            });

        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UF")){
            //待确认
            helper.setText(R.id.tv_order_tuikuan,"完成服务")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setVisible(R.id.tv_order_again,false)
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"正在服务");
            /**
             * 这里需要添加待确认
             */

            helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /**
                     * 确认服务
                     */
                    orderId = item.getIntfAnsOrder().getId();
                    ConfimServiceData();
                }
            });
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("FN")){
            //已完成
            helper.setVisible(R.id.tv_order_tuikuan,false)
                    .setVisible(R.id.tv_order_again,false)
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已完成");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("UC")){
            //待评价
            helper.setText(R.id.tv_order_tuikuan,"去评价")
                    .setVisible(R.id.tv_order_again,false)
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"待评价");
            helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /**
                     * 评价页面
                     */
                    Intent intent = new Intent(context,ScoreActivity.class);
                    intent.putExtra("apiOrderListBeanList",(Serializable)item.getIntfAnsOrder().getApiOrderDetailsList());
                    intent.putExtra("shopName",item.getIntfAnsShopBasic().getShopName());
                    intent.putExtra("shopId",item.getIntfAnsShopBasic().getId());
                    intent.putExtra("orderId",item.getIntfAnsOrder().getId());
                    context.startActivity(intent);
                }
            });

        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("CA")){
            //已取消
            helper.setGone(R.id.tv_order_tuikuan,false)
                    .setGone(R.id.tv_order_again,false)
                    .setGone(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已取消");

        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("PR")){
            //部分退款中
            helper.setText(R.id.tv_order_tuikuan,"部分退款中")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setText(R.id.tv_order_again,"取消")
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"部分退款中");
        }else if(item.getIntfAnsOrder().getOrderStatus().toString().equals("PF")){
            //部分已退款
            helper.setText(R.id.tv_order_tuikuan,"部分已退款")
                    .setBackgroundRes(R.id.tv_order_tuikuan,R.drawable.button_shap_queen)
                    .setTextColor(R.id.tv_order_tuikuan,context.getResources().getColor(R.color.white))
                    .setVisible(R.id.tv_order_again,false)
                    .setVisible(R.id.tv_order_like, false)
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
            helper.setVisible(R.id.tv_order_tuikuan,false)
                    .setVisible(R.id.tv_order_again,false)
                    .setVisible(R.id.tv_order_like, false)
                    .setText(R.id.tv_submit,"已退款");
        }

        List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderDetailsList = item.getIntfAnsOrder().getApiOrderDetailsList();

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

    /**
     * 确认服务完成
     */
    private void ConfimServiceData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("userId", SP.get(context, SpContent.UserId,"0").toString());
        HttpUtils.doPost(ACTION.CONFIMSERVICE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消订单
     */
    private void CancelOrderData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("shopId", shopId);
        HttpUtils.doPost(ACTION.CANCLEORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.CANCLEORDER:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if (successBean.isSuccess()){
                    T.show("取消成功");
                }else{
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.CONFIMSERVICE:
                SuccessBean successBeans = GsonUtil.toObj(res,SuccessBean.class);
                if (successBeans.isSuccess()){
                    T.show("确认成功");
                }else{
                    T.show(successBeans.getMsg());
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
