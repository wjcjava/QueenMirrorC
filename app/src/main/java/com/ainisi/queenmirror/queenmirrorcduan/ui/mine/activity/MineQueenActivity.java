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
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.QueenDeiailsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

//女王卡
public class MineQueenActivity extends BaseActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView queentitle;
    @Bind(R.id.tv_queen_name)
    TextView queenName;
    @Bind(R.id.tv_queen_wallet)
    TextView queenWallet;
    @Bind(R.id.tv_queen_phone)
    TextView queenPhone;
    @Bind(R.id.tv_queen_money)
    TextView queenMoney;
    private QueenDeiailsBean deiailsBean;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineQueenActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_queen;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        inithttp();
    }

    @Override
    public void initView() {
        queentitle.setText("我的女王卡");
    }


    @OnClick({R.id.title_back, R.id.bt_recharge,R.id.bt_see
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //我要充值
            case  R.id.bt_recharge:
                RechargeActivity.startActivity(this);
                break;
            //查看订单记录
            case R.id.bt_see:
                SeeActivity.startActivity(this);
                break;
            default:
                break;

        }
    }
    private void inithttp() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("userId", SP.get(MineQueenActivity.this, SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.QUEENDETAILS,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.QUEENDETAILS:
                deiailsBean = GsonUtil.toObj(res, QueenDeiailsBean.class);
                if(deiailsBean.isSuccess()){
                    QueenDeiailsBean.BodyBean.QueenCardDataBean.AnsQueenCardBean dataBean = deiailsBean.getBody().getQueenCardData().getAnsQueenCard();
                    queenName.setText(SP.get(MineQueenActivity.this,SpContent.UserName,"")+"");
                    queenPhone.setText(SP.get(MineQueenActivity.this,SpContent.UserCall,"")+"");
                    queenWallet.setText(MD5.doubleToString(dataBean.getCardBalance())+"  女王币");
                }else {
                    T.show(deiailsBean.getMsg());
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
