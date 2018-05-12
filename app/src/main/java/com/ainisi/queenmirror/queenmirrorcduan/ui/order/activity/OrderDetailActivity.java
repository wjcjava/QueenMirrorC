package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderDetailListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 订单详情
 */

public class OrderDetailActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;
    @Bind(R.id.rv_orderdetail_order)
    RecyclerView rv_orderdetail_order;
    @Bind(R.id.tv_order_detail_ordernum)
    TextView tv_order_detail_ordernum;
    @Bind(R.id.tv_order_detail_tel)
    TextView tv_order_detail_tel;
    @Bind(R.id.tv_order_detail_ordertime)
    TextView tv_order_detail_ordertime;
    @Bind(R.id.tv_orderdetail_heji)
    TextView tv_orderdetail_heji;

    private List<SortBean> list=new ArrayList<>();

    String orderNo,orderTel,orderTime,OrderHeji;

    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean> getApiOrderDetailsList = new ArrayList();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intentGet = getIntent();
        getApiOrderDetailsList = (List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.AnsOrderBean.ApiOrderDetailsListBean>) intentGet.getSerializableExtra("lstBean");
        orderNo = intentGet.getStringExtra("orderNo");
        orderTel = intentGet.getStringExtra("orderTel");
        orderTime = intentGet.getStringExtra("orderTime");
        OrderHeji = intentGet.getStringExtra("OrderHeji");

        tv_common_title.setText("订单详情页");


        tv_order_detail_ordernum.setText("订单号码："+orderNo);
        tv_order_detail_tel.setText("手机号码："+orderTel);
        tv_order_detail_ordertime.setText("付款时间："+orderTime);

        tv_orderdetail_heji.setText("￥"+OrderHeji);

        OrderDetailListAdapter sbmitWholeAdapter=new OrderDetailListAdapter(R.layout.order_detail_listitem,getApiOrderDetailsList);
        rv_orderdetail_order.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        rv_orderdetail_order.setAdapter(sbmitWholeAdapter);
    }


    @OnClick({R.id.iv_common_back,R.id.re_order_refund})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_common_back:
                finish();
                break;
            case R.id.re_order_refund:
                //退款
                startActivity(new Intent(this, ArefundActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
