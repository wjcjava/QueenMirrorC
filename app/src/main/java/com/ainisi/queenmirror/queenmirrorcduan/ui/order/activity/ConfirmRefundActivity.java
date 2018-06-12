package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ConfirmRefundAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ConfirmRefundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 申请退款
 */
public class ConfirmRefundActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.re_arefund)
    RecyclerView recyclerView;
    @Bind(R.id.title_title)
    TextView areTitle;
    /**
     * 退款金额
     */
    @Bind(R.id.tv_confirm_amount)
    TextView tv_confirm_amount;
    /**
     * 退款说明
     */
    @Bind(R.id.et_confirm_backresuion)
    EditText et_confirm_backresuion;

    @Bind(R.id.tv_arefund_select)
    public TextView tv_arefund_select;
    List<AreFundBean> areFundCheckList = new ArrayList<>();
    public static ConfirmRefundActivity instance = null;
    double amount = 0;
    String outTradeNo="",shopId,orderId,type_reson;
    List<ConfirmRefundBean> list;

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_confirm_refund;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = this.getIntent();
        outTradeNo = intent.getStringExtra("orderNo");
        areFundCheckList = (List<AreFundBean>) intent.getSerializableExtra("lstBean");
        shopId = intent.getStringExtra("shopId");
        orderId = intent.getStringExtra("orderId");

        areTitle.setText(R.string.arefund);

        for(int i=0;i<areFundCheckList.size();i++){
            amount = amount + Double.parseDouble(areFundCheckList.get(i).getIntfAnsOrderDetails().getAfterAmount());

            L.e("******    "+areFundCheckList.get(i).getIntfAnsOrderDetails().getId());
        }
        tv_confirm_amount.setText("￥" + amount);

        ConfirmRefundAdapter confirmRefundAdapter = new ConfirmRefundAdapter(R.layout.confirmrefund_re_listitem,areFundCheckList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(confirmRefundAdapter);
    }
    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.title_back, R.id.layout_arefund_reason,R.id.bt_confirm_refund})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //退款原因
            case R.id.layout_arefund_reason:
                startActivity(new Intent(this,RefundReasonActivity.class));
                break;
            /**
             * 提交
             */
            case R.id.bt_confirm_refund:
                if(tv_arefund_select.getText().toString().equals("")||tv_arefund_select.getText().toString().equals("请选择")){
                    T.show("请选择退款原因");
                }else{
                    DoOutData();
                }
                break;
        }
    }
    /**
     * 退款
     */
    private void DoOutData() {
        if(tv_arefund_select.getText().toString().equals("不喜欢/效果不好")){
            type_reson = "1";
        }else if(tv_arefund_select.getText().toString().equals("拍错了")){
            type_reson = "2";
        }else if(tv_arefund_select.getText().toString().equals("不想去了")){
            type_reson = "3";
        }else if(tv_arefund_select.getText().toString().equals("重拍")){
            type_reson = "4";
        }else if(tv_arefund_select.getText().toString().equals("太远了")){
            type_reson = "5";
        }else if(tv_arefund_select.getText().toString().equals("其他")){
            type_reson = "9";
        }

        list = new ArrayList<>();
        for(int i=0;i<areFundCheckList.size();i++){
            ConfirmRefundBean confirmRefundBean = new ConfirmRefundBean();
            confirmRefundBean.setOrderId(orderId);//订单ID
            confirmRefundBean.setDetailsId(areFundCheckList.get(i).getIntfAnsOrderDetails().getId());//
            confirmRefundBean.setShopId(shopId);
            confirmRefundBean.setCustId(SP.get(ConfirmRefundActivity.this,SpContent.UserId,"")+"");
            confirmRefundBean.setGoodsId(areFundCheckList.get(i).getIntfAnsOrderDetails().getGoodsId());
            confirmRefundBean.setRefundReason(type_reson);
            confirmRefundBean.setRefundAmount(areFundCheckList.get(i).getIntfAnsOrderDetails().getSumAmount());
            confirmRefundBean.setActualAmount(areFundCheckList.get(i).getIntfAnsOrderDetails().getAfterAmount());
            confirmRefundBean.setRefundDetails(et_confirm_backresuion.getText().toString());
            confirmRefundBean.setRefundEvidence("");
            list.add(confirmRefundBean);
        }

        Gson gson = new Gson();
        String toGson = gson.toJson(list);

        HashMap<String, String> params = new HashMap<>();
        params.put("refundInfo", toGson);
        params.put("userId", SP.get(ConfirmRefundActivity.this,SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.DOOUTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.DOOUTDATA:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.isSuccess()){
                    T.show("申请成功");
                    finish();
                }else{
                    T.show(successBean.getMsg());
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
