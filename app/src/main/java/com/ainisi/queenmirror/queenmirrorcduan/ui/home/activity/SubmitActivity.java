package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.OrderInfoUtil2_0;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.PayResult;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
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

    List<String> orderIdList = new ArrayList<>();
    String amount = "0",aliPayResult="";
    String transId;

    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "2017090608586413";

    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /**
     * 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1
     */
    public static final String RSA2_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPZIQ2M38cU069uIFsj2I8+Y2jabIL6/1kk0SbFUhFyfD+0QupRVdfBrVsjKVRgut8CwUTjw0/DJUbnN/uTEJhmd27SekUfju1FA4kHGxCj/UjzlpZAzz9q4y/DDEzsyElEC0o8DkUMgxYkdtGcx3psOuErCCZ9VPkFPEgtWgu9jvIX3dLzzBrc8OttcEY0uH1hUZhlJHv5qFfHMJFccBrFPGKHi+46Hgy5k9uTpfZENJXb1FR3VFtD7TUCy74rOopzevbbTBgQQA6+3l8ULVGp/r+GUOb6DH22n64JLqVNqON69aEjJrssIm8qiAV8aoZCZ2oy8mZlX6RqM21YZcBAgMBAAECggEAGMEvmfPV89vl8hbSMR2nxgMHErkChdBd1GkgJO3Npk6wji0kqDpSVRNharX1LFc/tBBq9e9yR/oyG6w/dHIx24umndiqpmEMibxGnLFTd0JG/cF4E3ndo6VkDO9b5yL7i9x5D2I5WGUzgG7dvhHNjjR+1E6q6ilSLEP5RL5MmB6jEi/3LVkfmpWaY+0Wm3MXnjpwMIaMFO92TvEBWl7PBJlB8dCRgPuhWKhLDBykholhUR839ZJMrtOg3Vk87vmbzqwFLfDAqT2xuEmONJ7aru6D722RDj2GOnAeesTW2C3DCLJAWofDK+TTWD2UbUueuOpgpxokjHdw3aou4cuAAQKBgQDkZltgrpQoaIDYicI/Z1MO1SozkpEt9TB2c0508QcgdvMpaYkT4IrJlYlQYAYLdoDtQdu8SvGb541vWJTsWXEa+50a2/UWjKLRmr4/uVOTh5VVgrUz2vKidJSylE8rO3TR6rbNz4XyG5CT+YK1uKAS97+RFtVWTUoUefk0egGJgQKBgQCguG1RR0l9rXuQApxtLmf/Q5tqK/KWcupoUjr+pdL+Xb9u6HTQJVyt1sDJjooPrzlT8cTLLYQptRvS9+g/cw3ExAeMZO3thf/0HQUZlRPdaw4OYZuIFm4mqC/24nVE1w0AyA9QXwqabxr/1GuB1NUkcfOf1l5FK7ZRldRVCP/NgQKBgF6lo/w+nBrao3oYLCzGDn85CpHwjMT0tC6BveNr9j4XzNA+cZWRGTJMC2kJQbgCVY78Gai/jbvDirK3jI8cyWgbGJGG0NuVT+t4KpqRm/ao2tNipOBmPOHhWbVfDCeoLdLHZxWGh8U6cwE/BlFzvrHdhL8FLUbkJGyz1vdOD9EBAoGActHPJ1XqZuLdd5Cl+EpC+dZu3XbwJBOM62JzyyDkj9yhurZPXbSTdY4KxPQUJghkyFfc49pspO9CJYH+ZfXoTD5PtjkU0a/9n4Rr9E7Qlkq5DAUnfB2qK+vT+GjopnmMTJageiasCJB/lW1IMMTAUP0ns3UOfBQyeC62NtnrBgECgYEA3AuOlQ97g28ZWd5NdWCSqGl56KnoShoqrgrw2mH4Rv+kmj/kMO4idKNzzkUkexEerUL51VUUUYLC3bsLmSsZh7q337ZxV49len0zRIWUM1WzGj5ORg3zEcnNEOpMyKW43g8qSpd7Yn0/KlvhKhbQMZVMFm6Fm8ArJJS3OavSEL0=";
    public static final String RSA_PRIVATE = "";
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
        orderIdList =  (List<String>) intent.getSerializableExtra("orderIdList");
        amount = intent.getStringExtra("amount");

        tv_submit_price.setText(amount);
        tv_submit_bottom_price.setText(amount);

        if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }

        /**
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;

        L.e("************    "+orderParam+"      "+privateKey+"          "+sign+"            "+orderInfo);

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
        String businessIds = "";
        for(int i=0;i<orderIdList.size();i++){
            businessIds = businessIds+orderIdList.get(i)+",";
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(SubmitActivity.this,SpContent.UserId,"0")+"");
        params.put("platformType", "3");
        params.put("payAmount",amount.substring(1,amount.length()));
        params.put("businessIds", businessIds);
        HttpUtils.doPost(ACTION.PayBefore, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.PayBefore:
                PayInBean payInBean = GsonUtil.toObj(res,PayInBean.class);
                aliPayResult = payInBean.getBody().getAliPayResult();

                transId = payInBean.getBody().getTransId();

                L.e("支付前   "+transId);
                SP.put(SubmitActivity.this,SpContent.TransId,transId);

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
