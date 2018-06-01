package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.PayResult;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayInBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.alipay.sdk.app.PayTask;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class SubmitActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.img_wechat_unpayment)
    ImageView wcunpayment;
    @Bind(R.id.img_queen_unpayment)
    ImageView queenunpayment;
    @Bind(R.id.img_wechat_payment)
    ImageView wcpayment;
    @Bind(R.id.img_queen_payment)
    ImageView queenpayment;
    @Bind(R.id.img_alipay_unalipay)
    ImageView unalipay;
    @Bind(R.id.img_wechat_alipay)
    ImageView alipay;
    @Bind(R.id.tv_submit_price)
    TextView tv_submit_price;
    @Bind(R.id.tv_submit_bottom_price)
    TextView tv_submit_bottom_price;

    String businessIds = "";
    String transId = "";
    List<String> orderIdList = new ArrayList<>();
    String amount = "0",aliPayResult="";
    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        T.show("支付成功");

                        AfterPayData();
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        T.show("支付失败");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };
    private Thread payThread;

    @Override
    public int getLayoutId() {
        return R.layout.activity_submit;
    }

    @Override
    public void initView() {

        Intent intent = this.getIntent();
        businessIds =  intent.getStringExtra("businessIds");
        amount = intent.getStringExtra("amount");

        tv_submit_price.setText(amount);
        tv_submit_bottom_price.setText(amount);

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(SubmitActivity.this);
                Map<String, String> result = alipay.payV2(aliPayResult, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        payThread = new Thread(payRunnable);

    }


    @OnClick({R.id.img_wechat_unpayment, R.id.img_queen_unpayment, R.id.title_back, R.id.img_alipay, R.id.img_alipay_unalipay, R.id.payV2
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.img_wechat_unpayment:
                wcpayment.setVisibility(View.VISIBLE);
                queenpayment.setVisibility(View.GONE);
                alipay.setVisibility(View.GONE);
                break;

            case R.id.img_queen_unpayment:
                queenpayment.setVisibility(View.VISIBLE);
                alipay.setVisibility(View.GONE);
                wcpayment.setVisibility(View.GONE);
                break;
            case R.id.img_alipay_unalipay:
                alipay.setVisibility(View.VISIBLE);
                queenpayment.setVisibility(View.GONE);
                wcpayment.setVisibility(View.GONE);
                break;
            case R.id.payV2:
                if (alipay.getVisibility() == View.VISIBLE) {
                    getData();
                } else if (wcpayment.getVisibility() == View.VISIBLE) {
                    T.show("抱歉微信还在开发中");
                } else if (queenpayment.getVisibility() == View.VISIBLE) {
                    T.show("抱歉女王卡还在开发中");
                }else {
                    T.show("请选择支付方式");
                    return;
                }
                break;

        }

    }

    /**
     * 支付前调用
     */
    private void getData() {

        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(SubmitActivity.this,SpContent.UserId,"0")+"");
        params.put("platformType", "3");
        //params.put("payAmount",amount.substring(1,amount.length()));
        params.put("payAmount","0.01");
        params.put("businessIds", businessIds);
        HttpUtils.doPost(ACTION.PayBefore, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 支付宝付款成功后调用
     */
    private void AfterPayData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("outTradeNo", transId);
        HttpUtils.doPost(ACTION.AliPayAfterRefresh, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            /**
             * 调用支付宝之后调用
             */
            case ACTION.AliPayAfterRefresh:
                L.e("&&&&&   "+res);
                break;
            case ACTION.PayBefore:
                PayInBean payInBean = GsonUtil.toObj(res,PayInBean.class);
                aliPayResult = payInBean.getBody().getAliPayResult();
                payThread.start();
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
