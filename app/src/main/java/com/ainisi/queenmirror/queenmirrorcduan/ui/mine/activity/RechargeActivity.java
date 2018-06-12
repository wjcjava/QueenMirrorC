package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.PayResult;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayInBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RechargeFreashBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.alipay.sdk.app.PayTask;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的钱包—充值功能
 */
public class RechargeActivity extends BaseActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView reTitle;
    @Bind(R.id.et_recharge_money)
    EditText et_recharge_money;
    @Bind(R.id.tv_recharge_really)
    TextView tv_recharge_really;
    @Bind(R.id.li_recharge_select)
    LinearLayout li_recharge_select;//选择支付方式
    @Bind(R.id.rg_recharge_group)
    RadioGroup rg_recharge_group;
    @Bind(R.id.ck_recharge_agree)
    CheckBox ck_recharge_agree;//协议阅读
    @Bind(R.id.bu_recharge_submit)
    Button bu_recharge_submit;//确认支付

    String pay_type="1",aliPayResult="",transId;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,RechargeActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        reTitle.setText(R.string.rcharge);

        rg_recharge_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.male){
                    pay_type = "1";
                }else {
                    pay_type = "2";
                }
            }
        });

        et_recharge_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                /**
                 * 文字输入之后的状态
                 */
                if(et_recharge_money.getText().toString().length()>0) {
                    double amount = Double.parseDouble(et_recharge_money.getText().toString());
                    if (amount <= 500) {
                        tv_recharge_really.setText(amount + "元");
                    } else if (amount > 500 && amount <= 1000) {
                        tv_recharge_really.setText((amount + 200) + "元");
                    } else if (amount > 1000 && amount <= 2000) {
                        tv_recharge_really.setText((amount + 500) + "元");
                    } else if (amount > 2000 && amount <= 3000) {
                        tv_recharge_really.setText((amount + 1200) + "元");
                    } else {
                        tv_recharge_really.setText((amount + 1800) + "元");
                    }
                }else{
                    tv_recharge_really.setText("元");
                }
            }
        });
    }


    @OnClick({R.id.title_back,R.id.bu_recharge_submit})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.bu_recharge_submit:
                if(et_recharge_money.getText().toString().equals("")){
                    T.show("请输入充值金额");
                }else if(ck_recharge_agree.isChecked()){
                    if(pay_type.equals("2")){
                        T.show("请选择支付宝支付");
                    }else{
                        if(aliPayResult.equals("")) {
                            LoadData();
                        }else{
                            startPay();
                        }
                    }
                }else{
                    T.show("请勾选会员充值协议");
                }
                break;
        }
    }

    /**
     * 支付宝支付
     */
    private void LoadData() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("custId", SP.get(RechargeActivity.this, SpContent.UserId,"0")+"");
        parames.put("platformType","3");
        parames.put("chargeAmount",et_recharge_money.getText().toString());
        HttpUtils.doPost(ACTION.QUEENCHARGE,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }
    /**
     * 充值后查看结果
     */
    private void AfterPayData() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("outTradeNo",transId);
        HttpUtils.doPost(ACTION.PAYAFTERREFRESH,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }
    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.QUEENCHARGE:
                PayInBean payInBean = GsonUtil.toObj(res,PayInBean.class);
                aliPayResult = payInBean.getBody().getAliPayResult();
                transId = payInBean.getBody().getTransId();
                startPay();
                break;
            case ACTION.PAYAFTERREFRESH:
                RechargeFreashBean rechargeFreashBean = GsonUtil.toObj(res,RechargeFreashBean.class);
                if(rechargeFreashBean.isSuccess()){
                    if(rechargeFreashBean.getBody().getAnsChargeTrans().getTransStatus().equals("1")){
                        Intent intent = new Intent(RechargeActivity.this,RechargeSuccessAgainActivity.class);
                        intent.putExtra("payStyle",pay_type);
                        intent.putExtra("payMoney",et_recharge_money.getText().toString());
                        startActivity(intent);
                    }else{
                        T.show("充值失败，请联系管理员");
                    }
                }else{
                    T.show(rechargeFreashBean.getMsg());
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


    /**
     * 以下是支付宝部分
     */
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
    private void startPay() {
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(RechargeActivity.this);
                Map<String, String> result = alipay.payV2(aliPayResult, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        payThread = new Thread(payRunnable);
        payThread.start();
    }
}
