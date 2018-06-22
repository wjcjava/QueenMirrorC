package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ConfirmRefundAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PurchaseListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RateGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ConfirmRefundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.DateUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSRespContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;
import com.ufo.imageselector.DWImages;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 申请退款
 */
public class ConfirmRefundActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.re_arefund)
    RecyclerView recyclerView;
    @Bind(R.id.title_title)
    TextView areTitle;
    /**
     * 退款金额
     */
    @Bind(R.id.tv_confirm_amount)
    TextView tv_confirm_amount;

    @Bind(R.id.gv_refund_gridView)
    NoScrollGridView gv_refund_gridView;
    /**
     * 退款说明
     */
    @Bind(R.id.et_confirm_backresuion)
    EditText et_confirm_backresuion;

    @Bind(R.id.tv_arefund_select)
    public TextView tv_arefund_select;
    List<AreFundBean> areFundCheckList = new ArrayList<>();
    public static ConfirmRefundActivity instance = null;
    double amount = 0;
    String outTradeNo="",shopId,orderId,type_reson;
    List<ConfirmRefundBean> list;

    private Bitmap bmp; // 导入临时图片
    private ArrayList<HashMap<String, Object>> imageItem;
    private ArrayList<HashMap<String, String>> imageItem1;
    private SimpleAdapter simpleAdapter; // 适配器

    String head_pic="";

    List<String> head_images = new ArrayList<>();

    RateGridViewAdapter rateGridViewAdapter;

    int needNumber = 6;

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_confirm_refund;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = this.getIntent();
        outTradeNo = intent.getStringExtra("orderNo");
        areFundCheckList = (List<AreFundBean>) intent.getSerializableExtra("lstBean");
        shopId = intent.getStringExtra("shopId");
        orderId = intent.getStringExtra("orderId");

        getOSSToken();

        areTitle.setText(R.string.arefund);

        for(int i=0;i<areFundCheckList.size();i++){
            amount = amount + Double.parseDouble(areFundCheckList.get(i).getIntfAnsOrderDetails().getAfterAmount());
        }
        tv_confirm_amount.setText("￥" + amount);

        ConfirmRefundAdapter confirmRefundAdapter = new ConfirmRefundAdapter(R.layout.confirmrefund_re_listitem,areFundCheckList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(confirmRefundAdapter);
    }
    @Override
    protected void initData() {
        super.initData();
        rateGridViewAdapter = new RateGridViewAdapter(ConfirmRefundActivity.this, head_images);
        gv_refund_gridView.setAdapter(rateGridViewAdapter);
        rateGridViewAdapter.notifyDataSetChanged();

        rateGridViewAdapter.setOnItemClickListen(new RateGridViewAdapter.OnItemClickListen() {
            @Override
            public void OnItemClickAdd() {
                DWImages.getImages(ConfirmRefundActivity.this, DWImages.ACTION_ALBUM, needNumber);
            }

            @Override
            public void OnItemClickDel(int position) {

            }
        });
    }

    @OnClick({R.id.title_back, R.id.layout_arefund_reason,R.id.bt_confirm_refund})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //退款原因
            case R.id.layout_arefund_reason:
                startActivity(new Intent(this,RefundReasonActivity.class));
                break;
            /**
             * 提交
             */
            case R.id.bt_confirm_refund:
                if(tv_arefund_select.getText().toString().equals("")||tv_arefund_select.getText().toString().equals("请选择")){
                    T.show("请选择退款原因");
                }else{
                    DoOutData();
                }
                break;
        }
    }
    /**
     * 退款
     */
    private void DoOutData() {
        if(tv_arefund_select.getText().toString().equals("不喜欢/效果不好")){
            type_reson = "1";
        }else if(tv_arefund_select.getText().toString().equals("拍错了")){
            type_reson = "2";
        }else if(tv_arefund_select.getText().toString().equals("不想去了")){
            type_reson = "3";
        }else if(tv_arefund_select.getText().toString().equals("重拍")){
            type_reson = "4";
        }else if(tv_arefund_select.getText().toString().equals("太远了")){
            type_reson = "5";
        }else if(tv_arefund_select.getText().toString().equals("其他")){
            type_reson = "9";
        }


        for(int i=0;i<head_images.size();i++){

            final String objectKey = DateUtil.getCurrentDateTime("yyyyMMddhhmmssSSS") + ((int) ((Math.random() * 9 + 1) * 10000) + "") + ".jpg";
            OSSUtil.getInstance().setBucket("nwptest").asyncPutImage(objectKey, head_images.get(i), new OSSProgressCallback<PutObjectRequest>() {
                @Override
                public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                }
            }, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                @Override
                public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                    head_pic = head_pic+("https://" + SpContent.BUCKET + "." + SpContent.ENDPOINTS + "/" + objectKey+",");
                }
                @Override
                public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
                }
            });
        }


        list = new ArrayList<>();
        for(int i=0;i<areFundCheckList.size();i++){
            ConfirmRefundBean confirmRefundBean = new ConfirmRefundBean();
            confirmRefundBean.setOrderId(orderId);//订单ID
            confirmRefundBean.setDetailsId(areFundCheckList.get(i).getIntfAnsOrderDetails().getId());//
            confirmRefundBean.setShopId(shopId);
            confirmRefundBean.setCustId(SP.get(ConfirmRefundActivity.this,SpContent.UserId,"")+"");
            confirmRefundBean.setGoodsId(areFundCheckList.get(i).getIntfAnsOrderDetails().getGoodsId());
            confirmRefundBean.setRefundReason(type_reson);
            confirmRefundBean.setRefundAmount(areFundCheckList.get(i).getIntfAnsOrderDetails().getSumAmount());
            confirmRefundBean.setActualAmount(areFundCheckList.get(i).getIntfAnsOrderDetails().getAfterAmount());
            confirmRefundBean.setRefundDetails(et_confirm_backresuion.getText().toString());
            confirmRefundBean.setRefundEvidence(head_pic);
            list.add(confirmRefundBean);
        }
        Gson gson = new Gson();
        String toGson = gson.toJson(list);

        HashMap<String, String> params = new HashMap<>();
        params.put("refundInfo", toGson);
        params.put("userId", SP.get(ConfirmRefundActivity.this,SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.DOOUTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.DOOUTDATA:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.isSuccess()){
                    T.show("申请成功");
                    finish();
                }else{
                    T.show(successBean.getMsg());
                }
                break;
            /**
             * 获取Token
             */
            case ACTION.OSSGETTOKEN:
                OSSRespContent ossstsModel = GsonUtil.toObj(res,OSSRespContent.class);
                if(ossstsModel.isSuccess()){
                    OSSUtil.getInstance().initOSS(ConfirmRefundActivity.this, SpContent.ENDPOINT, ossstsModel);
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
     * 获取OSSToken
     */
    private void getOSSToken() {
        HashMap<String, String> params = new HashMap<>();
        HttpUtils.doPost(ACTION.OSSGETTOKEN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        DWImages.parserResult(requestCode, data, new DWImages.GetImagesCallback() {
            @Override
            public void onResult(final List<String> images) {
                // Log.d(TAG, "onResult:--> : images: " + images.size());

                for(int i =0;i<images.size();i++){
                    head_images.add(images.get(i));
                }
                needNumber = needNumber - images.size();
                rateGridViewAdapter = new RateGridViewAdapter(ConfirmRefundActivity.this, head_images);
                gv_refund_gridView.setAdapter(rateGridViewAdapter);
                rateGridViewAdapter.notifyDataSetChanged();

                rateGridViewAdapter.setOnItemClickListen(new RateGridViewAdapter.OnItemClickListen() {
                    @Override
                    public void OnItemClickAdd() {
                        DWImages.getImages(ConfirmRefundActivity.this, DWImages.ACTION_ALBUM, needNumber);
                    }

                    @Override
                    public void OnItemClickDel(int position) {
                        needNumber++;
                        head_images.remove(position);
                        rateGridViewAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

}
