package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PurchaseListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.SelectLinkPeopleActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 提交订单
 */
public class PurchaseActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.list_order)
    ListView listOrder;
    @Bind(R.id.title_title)
    TextView purtitle;
    private PurchaseListViewAdapter listadapter;
    @Bind(R.id.rl_purchase_top)
    RelativeLayout rl_purchase_top;
    @Bind(R.id.tv_name)
    TextView tv_name;
    @Bind(R.id.tv_sex)
    TextView tv_sex;
    @Bind(R.id.tv_phone)
    TextView tv_phone;

    ShoppingCartBean shoppingCartBean;
    List<ShoppingCartBean.BodyBean.ShopListBean> shopList = new ArrayList<>();
    String lick_name,lick_phone,link_sex;

    @Override
    public int getLayoutId() {
        return R.layout.activity_purchase;
    }

    @Override
    public void initView() {
        purtitle.setText("提交订单");
    }

    @Override
    protected void onResume() {
        super.onResume();

        lick_name = SP.get(this,SpContent.Lickname,"")+"";
        lick_phone = SP.get(this,SpContent.LickPhone,"")+"";
        link_sex = SP.get(this,SpContent.LickSex,"")+"";

        if(lick_name.equals("")){
            tv_name.setText("请添加联系人");
        }else{
            tv_name.setText(lick_name);
        }
        tv_sex.setText(link_sex);
        tv_phone.setText(lick_phone);
        getShopCartData();
    }

    /**
     * 获取购物车数据
     */
    private void getShopCartData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(PurchaseActivity.this, SpContent.UserId,"")+"");//用户ID
        HttpUtils.doPost(ACTION.GETSHOPPINDCART, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.tv_submit,R.id.title_back,R.id.rl_purchase_top})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.rl_purchase_top:
                startActivity(new Intent(PurchaseActivity.this,SelectLinkPeopleActivity.class));
                break;
            //提交订单
            case R.id.tv_submit:
                startActivity(new Intent(PurchaseActivity.this,SubmitActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.GETSHOPPINDCART:

                shoppingCartBean = GsonUtil.toObj(res,ShoppingCartBean.class);

                shopList = shoppingCartBean.getBody().getShopList();
                L.e("@@@@@    "+shopList);
                listadapter = new PurchaseListViewAdapter(this,shopList);
                listOrder.setAdapter(listadapter);
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
