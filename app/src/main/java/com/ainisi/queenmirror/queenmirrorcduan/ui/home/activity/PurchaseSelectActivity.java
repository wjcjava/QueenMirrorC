package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter.PurchaseAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 选择优惠券
 */
public class PurchaseSelectActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.pur_rey_distance)
    RecyclerView pur_rey_distance;

    String shopId = "", goodsIds = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_purchase_select;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("选择优惠券");

        Intent intent = this.getIntent();
        shopId = intent.getStringExtra("shopId");
        goodsIds = intent.getStringExtra("goodsIds");

        getPurData();
    }

    /**
     * 获取可用的优惠券
     */
    private void getPurData() {
        HashMap<String, String> params = new HashMap<>();
        //  params.put("userId", SP.get(PurchaseSelectActivity.this, SpContent.UserId,"")+"");//用户ID
        params.put("userId", "111");
        //params.put("shopId",shopId);
        params.put("shopId", "12");
        // params.put("goodsIds",goodsIds);
        params.put("goodsIds", "123");
        HttpUtils.doPost(ACTION.GETUSEYOUHUIQUAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GETUSEYOUHUIQUAN:
                L.e("^^^^^" + res);
                ReceiveDiscounBean receiveBean = GsonUtil.toObj(res, ReceiveDiscounBean.class);

                if (receiveBean.isSuccess()) {
                    List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> receiveList = receiveBean.getBody().getCustCouponListData();
                    PurchaseAdapter purchaseAdapter = new PurchaseAdapter(R.layout.item_discount, receiveList);
                    pur_rey_distance.setLayoutManager(new LinearLayoutManager(PurchaseSelectActivity.this, LinearLayoutManager.VERTICAL, false));
                    pur_rey_distance.setAdapter(purchaseAdapter);
                } else {
                    T.show(receiveBean.getMsg());
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