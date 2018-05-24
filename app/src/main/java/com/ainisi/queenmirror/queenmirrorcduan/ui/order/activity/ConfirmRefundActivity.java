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
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 申请退款
 */
public class ConfirmRefundActivity extends BaseNewActivity{
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

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_confirm_refund;
    }

    @Override
    protected void initView() {
        super.initView();
        areTitle.setText(R.string.arefund);

        Intent intentGet = getIntent();
        areFundCheckList = (List<AreFundBean>) intentGet.getSerializableExtra("lstBean");

        for(int i=0;i<areFundCheckList.size();i++){
            amount = amount + Double.parseDouble(areFundCheckList.get(i).getIntfAnsOrderDetails().getSumAmount());
        }

        tv_confirm_amount.setText("￥"+amount);

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

                }
                break;
        }
    }
}
