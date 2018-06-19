package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PurchaseNowBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.SelectLinkPeopleActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 立即购买
 */
public class PurchaseNowActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;

    String lick_name, lick_phone, link_sex;
    @Bind(R.id.tv_name)
    TextView tv_name;
    @Bind(R.id.tv_sex)
    TextView tv_sex;
    @Bind(R.id.tv_phone)
    TextView tv_phone;
    @Bind(R.id.tv_now_submit)
    TextView tv_now_submit;//提交
    @Bind(R.id.tv_shopping_cart_number_now)
    TextView tv_shopping_cart_number_now;//总价
    @Bind(R.id.purchase_shop_name)
    TextView purchase_shop_name;//店铺名字
    @Bind(R.id.li_purchase_product)
    LinearLayout li_purchase_product;//店铺商品
    @Bind(R.id.tv_pur_youhui)
    TextView tv_pur_youhui;//优惠券
    @Bind(R.id.tv_pur_modou)
    TextView tv_pur_modou;//魔豆
    @Bind(R.id.tv_pur_selectname)
    TextView tv_pur_selectname;//魔豆优惠券文字
    @Bind(R.id.rl_purchase_select)
    RelativeLayout rl_purchase_select;//魔豆优惠券选择
    @Bind(R.id.rl_purchase_top)
    RelativeLayout rl_purchase_top;

    private boolean moudou = false;

    String shopName,shopId,goodId,goodName,goodPrice,goodPriceSale;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_purchase_now;
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
    }
    @Override
    protected void initView() {
        super.initView();
        title_title.setText("提交订单");
        Intent intent = this.getIntent();
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        goodId = intent.getStringExtra("goodId");
        goodName = intent.getStringExtra("goodName");
        goodPrice = intent.getStringExtra("goodPrice");
        goodPriceSale = intent.getStringExtra("goodPriceSale");
        purchase_shop_name.setText(shopName);
        tv_shopping_cart_number_now.setText(goodPrice);
        View _view = LayoutInflater.from(this).inflate(R.layout.layout_upload_product, null);
        // 3、在布局中添加组件，设置组件属性
        li_purchase_product.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        TextView tv_purchase_name = _view.findViewById(R.id.tv_purchase_name);
        tv_purchase_name.setText(goodName);
        TextView tv_purchase_presentprice = _view.findViewById(R.id.tv_purchase_presentprice);
        tv_purchase_presentprice.setText(goodPrice);
        TextView tv_purchase_originalprice = _view.findViewById(R.id.tv_purchase_originalprice);
        tv_purchase_originalprice.setText(goodPriceSale);
        tv_purchase_originalprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        TextView tv_purchase_adapter_number = _view.findViewById(R.id.tv_purchase_adapter_number);
        tv_purchase_adapter_number.setText("X 1");
    }

    @OnClick({R.id.title_back,R.id.tv_now_submit,R.id.rl_purchase_top,R.id.tv_pur_modou,R.id.tv_pur_youhui,R.id.rl_purchase_select})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_now_submit:
                T.show("你点击了我！");
                UploadData();
                break;
            case R.id.rl_purchase_top:
                startActivity(new Intent(PurchaseNowActivity.this, SelectLinkPeopleActivity.class));
                break;
            case R.id.tv_pur_youhui:
                if(moudou){
                    //true代表现在是在魔豆
                    tv_pur_selectname.setText("请选择优惠券");
                    moudou = false;
                    tv_pur_youhui.setBackground(this.getResources().getDrawable(R.drawable.back_pur_right_select));
                    tv_pur_youhui.setTextColor(this.getResources().getColor(R.color.alpha_85_black));
                    tv_pur_modou.setBackground(this.getResources().getDrawable(R.drawable.back_pur_select));
                    tv_pur_modou.setTextColor(this.getResources().getColor(R.color.white));
                }else{
                    //flase代表现在在优惠券
                }
                break;
            case R.id.tv_pur_modou:
                if(moudou){
                    //true代表现在是在魔豆
                }else{
                    //flase代表现在在优惠券
                    tv_pur_selectname.setText("请选择抵扣商品");
                    moudou = true;
                    tv_pur_youhui.setTextColor(this.getResources().getColor(R.color.white));
                    tv_pur_modou.setTextColor(this.getResources().getColor(R.color.alpha_85_black));
                    tv_pur_youhui.setBackground(this.getResources().getDrawable(R.drawable.back_pur_select));
                    tv_pur_modou.setBackground(this.getResources().getDrawable(R.drawable.back_pur_right_select));
                }
                break;
            case R.id.rl_purchase_select:
                if(moudou){
                    /**
                     * 代表选择的是魔豆
                     */
                    Intent intent = new Intent(PurchaseNowActivity.this,PurchaseSelectActivity.class);
                    intent.putExtra("shopId",shopId);
                    intent.putExtra("goodsIds",goodId);
                    startActivity(intent);
                }else{
                    /**
                     * 代表选择的是优惠券
                     */
                    Intent intentP = new Intent(PurchaseNowActivity.this,PurchaseSelectActivity.class);
                    intentP.putExtra("shopId",shopId);
                    intentP.putExtra("goodsIds",goodId);
                    startActivity(intentP);
                }
                break;
        }
    }

    /**
     * 立即付款获取订单编号
     */
    private void UploadData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("goodsId", goodId);
        params.put("userId", SP.get(PurchaseNowActivity.this, SpContent.UserId, "") + "");
        params.put("cpMethod", "");
        params.put("cpId","");
        params.put("usePoints","");
        params.put("platform","3");
        params.put("purchaseNumber","1");
        HttpUtils.doPost(ACTION.PAYNOWINPAY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.PAYNOWINPAY:
                PurchaseNowBean purchaseNowBean = GsonUtil.toObj(res,PurchaseNowBean.class);
                if(purchaseNowBean.getErrorCode().equals("0")){
                    Intent intent = new Intent(PurchaseNowActivity.this, SubmitActivity.class);
                    intent.putExtra("businessIds", purchaseNowBean.getBody().getOrderId());
                    intent.putExtra("amount", goodPrice.substring(1,goodPrice.length()));
                    startActivity(intent);
                    finish();
                }else{

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
