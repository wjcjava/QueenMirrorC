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
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderDetailsListInfoBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPayDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPurchaseBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.SelectLinkPeopleActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 提交订单
 */
public class PurchaseActivity extends BaseNewActivity implements HttpCallBack {
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
    @Bind(R.id.tv_shopping_cart_number)
    TextView tv_shopping_cart_number;
    ShoppingCartBean shoppingCartBean;
    List<ShoppingCartBean.BodyBean.ShopListBean> shopList = new ArrayList<>();
    String lick_name, lick_phone, link_sex, shopId;
    List<OrderDetailsListInfoBean> orderDetailsListInfo;
    List<OrderPurchaseBean> orderPurchaseBeans;
    List<String> orderIdList = new ArrayList<>();
    double end_price = 0,flag = 0;
    String cartId = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_purchase;
    }

    @Override
    public void initView() {
        purtitle.setText("提交订单");

        Intent intent = this.getIntent();
        shoppingCartBean = (ShoppingCartBean) intent.getSerializableExtra("cartBean");
    }

    @Override
    protected void onResume() {
        super.onResume();

        lick_name = SP.get(this, SpContent.Lickname, "") + "";
        lick_phone = SP.get(this, SpContent.LickPhone, "") + "";
        link_sex = SP.get(this, SpContent.LickSex, "") + "";

        if (lick_name.equals("")) {
            tv_name.setText("请添加联系人");
        } else {
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
        shopList = shoppingCartBean.getBody().getShopList();
        orderPurchaseBeans = new ArrayList<>();
        orderDetailsListInfo = new ArrayList<>();

        for (int i = 0; i < shopList.size(); i++) {
            cartId = "";
            for (int j = 0; j < shopList.get(i).getApiAnsCustCartList().size(); j++) {

                end_price = end_price + (double) shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber() * (double) shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice();
                OrderDetailsListInfoBean orderDetailsListInfoBean = new OrderDetailsListInfoBean();
                orderDetailsListInfoBean.setGoodsId(shopList.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getId());
                orderDetailsListInfoBean.setPurchaseNumber(shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber() + "");
                orderDetailsListInfoBean.setUnitPrice(shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice() + "");
                orderDetailsListInfoBean.setSumAmount((double) shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber() * (double) shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice() + "");
                orderDetailsListInfoBean.setDiscountAmount("");
                orderDetailsListInfoBean.setUsePoints("");

                orderDetailsListInfo.add(orderDetailsListInfoBean);
                cartId = cartId + shopList.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getId() + ",";
            }
            shopId = shopList.get(i).getId();

            OrderPurchaseBean orderPurchaseBean = new OrderPurchaseBean();
            orderPurchaseBean.setShopId(shopId);
            orderPurchaseBean.setCpId("");
            orderPurchaseBean.setCpMethod("");
            orderPurchaseBean.setCartIds(cartId);
            orderPurchaseBean.setOrderDetailsListInfo(orderDetailsListInfo);

            orderPurchaseBeans.add(orderPurchaseBean);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(end_price);
        tv_shopping_cart_number.setText("￥" + str);

        listadapter = new PurchaseListViewAdapter(this, shopList);
        listOrder.setAdapter(listadapter);
        listadapter.notifyDataSetChanged();

    }

    @OnClick({R.id.tv_submit, R.id.title_back, R.id.rl_purchase_top})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.rl_purchase_top:
                startActivity(new Intent(PurchaseActivity.this, SelectLinkPeopleActivity.class));
                break;
            //提交订单
            case R.id.tv_submit:
                UploadData();
                break;
        }
    }

    /**
     * 提交订单
     */
    private void UploadData() {
        Gson gson = new Gson();
        String str = gson.toJson(orderPurchaseBeans);
        HashMap<String, String> params = new HashMap<>();
        params.put("orderInfo", str);
        params.put("userId", SP.get(PurchaseActivity.this, SpContent.UserId, "") + "");
        params.put("platform", "3");
        HttpUtils.doPost(ACTION.UPLOADORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.UPLOADORDER://提交订单

                OrderPayDetailBean successBean = GsonUtil.toObj(res, OrderPayDetailBean.class);
                if (successBean.isSuccess()) {
                    String businessIds = "";
                    orderIdList = successBean.getBody().getOrderIdList();
                    for (int i = 0; i < orderIdList.size(); i++) {
                        businessIds = businessIds + orderIdList.get(i) + ",";
                    }
                    Intent intent = new Intent(PurchaseActivity.this, SubmitActivity.class);
                    intent.putExtra("businessIds", businessIds);
                    intent.putExtra("amount", tv_shopping_cart_number.getText().toString());
                    startActivity(intent);
                    finish();
                    T.show(successBean.getMsg());
                } else {
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
