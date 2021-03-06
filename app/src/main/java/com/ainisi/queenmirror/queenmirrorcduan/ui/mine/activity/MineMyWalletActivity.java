package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.WhetherPassBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.MywallietBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

//我的钱包
public class MineMyWalletActivity extends BaseActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView wallTitle;
    @Bind(R.id.tv_balance)
    TextView tvbalance;
    @Bind(R.id.tv_addcart)
    TextView tvaddcart;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    private int exists;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineMyWalletActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_my_wallet;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    public void initView() {
        wallTitle.setText(R.string.my_wallet);
        inithttp();
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("custId",SP.get(this,SpContent.UserId,"")+"");
        HttpUtils.doPost(ACTION.MYWALLIET, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @OnClick({R.id.title_back, R.id.rc_name, R.id.rc_setup, R.id.img_addcart, R.id.img_balance
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //添加银行卡号
            case R.id.img_addcart:
                Intent intent = new Intent(this, MineAddcartActivity.class);
                intent.putExtra("name", tvaddcart.getText().toString().trim());
                startActivity(intent);
                break;
            //余额
            case R.id.img_balance:
                Intent intent1 = new Intent(this, MineDetailedActivity.class);
                intent1.putExtra("name", "余额明细");
                startActivity(intent1);
                break;
            //实名认证
            case R.id.rc_name:
                startActivity(new Intent(this,RealNameActivity.class));
                break;
            //支付设置
            case R.id.rc_setup:
                inithttpPass();
                break;
            default:
                break;
        }
    }
    //判断是否有支付密码
    private void inithttpPass() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("custId", SP.get(this, SpContent.UserId,"")+"");
        HttpUtils.doPost(ACTION.WHETHERPASS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.WHETHERPASS:
                WhetherPassBean whetherPassBean = GsonUtil.toObj(res, WhetherPassBean.class);
                if (whetherPassBean.isSuccess()) {
                    exists = whetherPassBean.getBody().getIsExists();
                    if (exists == 0) {
                        startActivity(new Intent(this, MinePaymentsettingActivity.class));
                    } else {
                        MineSettingActivity.startActivity(this);
                    }
                } else {
                    T.show(whetherPassBean.getMsg());
                }
                break;
            case ACTION.MYWALLIET:
                MywallietBean mywallietBean = GsonUtil.toObj(res, MywallietBean.class);
                if (mywallietBean.isSuccess()) {
                    int myMoney = mywallietBean.getBody().getAccountBalance();
                    String money = MD5.doubleToString(String.valueOf(myMoney));
                    tvMoney.setText("¥"+money);
                } else {
                    T.show(mywallietBean.getMsg());
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
