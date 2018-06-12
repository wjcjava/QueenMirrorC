package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderDetailListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GetZxingBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 订单详情
 */

public class OrderDetailActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;
    @Bind(R.id.rv_orderdetail_order)
    RecyclerView rv_orderdetail_order;
    @Bind(R.id.tv_order_detail_ordernum)
    TextView tv_order_detail_ordernum;
    @Bind(R.id.tv_order_detail_tel)
    TextView tv_order_detail_tel;
    @Bind(R.id.tv_order_detail_ordertime)
    TextView tv_order_detail_ordertime;
    @Bind(R.id.tv_orderdetail_heji)
    TextView tv_orderdetail_heji;
    @Bind(R.id.iv_order_detail_zxing)
    ImageView iv_order_detail_zxing;
    @Bind(R.id.re_order_refund)
    RelativeLayout re_order_refund;

    String orderNo,orderTel,orderTime,OrderHeji,orderId,orderState,shopId;

    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> getApiOrderDetailsList = new ArrayList();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intentGet = getIntent();
        getApiOrderDetailsList = (List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean>) intentGet.getSerializableExtra("lstBean");
        orderNo = intentGet.getStringExtra("orderNo");
        orderTel = intentGet.getStringExtra("orderTel");
        orderTime = intentGet.getStringExtra("orderTime");
        OrderHeji = intentGet.getStringExtra("OrderHeji");
        orderId = intentGet.getStringExtra("orderId");
        orderState = intentGet.getStringExtra("orderState");
        shopId = intentGet.getStringExtra("shopId");

        tv_common_title.setText("订单详情页");

        tv_order_detail_ordernum.setText("订单号码："+orderNo);
        tv_order_detail_tel.setText("手机号码："+orderTel);
        tv_order_detail_ordertime.setText("下单时间："+orderTime);

        tv_orderdetail_heji.setText("￥"+OrderHeji);

        OrderDetailListAdapter sbmitWholeAdapter=new OrderDetailListAdapter(R.layout.order_detail_listitem,getApiOrderDetailsList);
        rv_orderdetail_order.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        rv_orderdetail_order.setAdapter(sbmitWholeAdapter);

        if(orderState.equals("UT")||orderState.equals("FT")){
            re_order_refund.setVisibility(View.VISIBLE);
        }else{
            re_order_refund.setVisibility(View.GONE);
        }

        if(orderState.equals("UT")||orderState.equals("UP")){
            iv_order_detail_zxing.setVisibility(View.GONE);
        }else{
            iv_order_detail_zxing.setVisibility(View.VISIBLE);
            getZxingData();
        }
    }

    /**
     * 获取二维码数据内容
     */
    private void getZxingData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("custId", SP.get(OrderDetailActivity.this, SpContent.UserId, "") + "");
        HttpUtils.doPost(ACTION.GETZXING, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.iv_common_back,R.id.re_order_refund})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_common_back:
                finish();
                break;
            case R.id.re_order_refund:
                //退款
                Intent intent = new Intent(this,ArefundActivity.class);
                intent.putExtra("lstBean", (Serializable)getApiOrderDetailsList);
                intent.putExtra("orderNo",orderNo);
                intent.putExtra("orderId",orderId);
                intent.putExtra("shopId",shopId);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETZXING:
                GetZxingBean getZxingBean = GsonUtil.toObj(res,GetZxingBean.class);
                if(getZxingBean.isSuccess()){
                    Bitmap bitmap = makeQRImage(getZxingBean.getBody().getCustOrderQrGet()+","+orderId , iv_order_detail_zxing.getWidth(),iv_order_detail_zxing.getHeight());
                    iv_order_detail_zxing.setImageBitmap(bitmap);
                }else{
                    T.show(getZxingBean.getMsg());
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
     * 根据指定内容生成自定义宽高的二维码图片
     *
     * @param content 需要生成二维码的内容
     * @param width   二维码宽度
     * @param height  二维码高度
     *
     * @throws
     */
    public static Bitmap makeQRImage(String content, int width, int height) throws WriterException {
        // 判断URL合法性
        if (content == null || "".equals(content) || content.length() < 1)
            return null;

        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 图像数据转换，使用了矩阵转换
        BitMatrix bitMatrix = new QRCodeWriter().encode(
                content, BarcodeFormat.QR_CODE, width, height, hints
        );
        int[] pixels = new int[width * height];
        // 按照二维码的算法，逐个生成二维码的图片，两个for循环是图片横列扫描的结果
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (bitMatrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                } else {
                    pixels[y * width + x] = 0xffffffff;
                }
            }
        }
        // 生成二维码图片的格式，使用ARGB_8888
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

        return bitmap;
    }
}
