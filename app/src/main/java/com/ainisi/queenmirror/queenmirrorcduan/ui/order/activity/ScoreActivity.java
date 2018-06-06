package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopProductListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.orderadapter.ScoreAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 发表评价
 */
public class ScoreActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView scoreTitle;
    @Bind(R.id.title_right)
    TextView scoreRightTitle;
    @Bind(R.id.re_score)
    RecyclerView reScore;

    /**
     * 门店服务
     */
    @Bind(R.id.service_custom)
    CustomRatingBar service_custom;
    /**
     * 门店环境
     */
    @Bind(R.id.store_custom)
    CustomRatingBar store_custom;

    CommentShopBean commentShopBean = new CommentShopBean();

    String shopName;
    String shopId,orderId;
    private List<SortBean> list=new ArrayList<>();
    int new_list_score = 0;
    String et_score_order_list;

    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderListBeanList = new ArrayList<>();


    List<ShopProductListBean> shopProductListBeans = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_score;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = this.getIntent();

        apiOrderListBeanList = (List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean>) intent.getSerializableExtra("apiOrderListBeanList");
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        orderId = intent.getStringExtra("orderId");

        initTitle();
        initDate();

    }

    private void initDate() {
        ScoreAdapter myAdapter=new ScoreAdapter(R.layout.item_score,apiOrderListBeanList);
        reScore.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        reScore.setAdapter(myAdapter);
    }

    private void initTitle() {
        scoreTitle.setText(R.string.published_order);
        scoreTitle.setTextColor(Color.BLACK);
        scoreRightTitle.setText(R.string.release);
        scoreRightTitle.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.title_back,R.id.title_right})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            /**
             * 提交
             */
            case R.id.title_right:
                int mendian_service = (int)service_custom.getRating();
                int mendian_huanjing = (int)store_custom.getRating();

                commentShopBean.setOrderId(orderId);
                commentShopBean.setServiceAttitude(mendian_service+"");
                commentShopBean.setShopEnvironment(mendian_huanjing+"");

                shopProductListBeans = new ArrayList<>();
                for(int i=0;i<reScore.getChildCount();i++){

                    ShopProductListBean shopProductListBean = new ShopProductListBean();

                    android.widget.RelativeLayout layout = (android.widget.RelativeLayout)reScore.getChildAt(i);// 获得子item的layout
                    CustomRatingBar score_custom_list = layout.findViewById(R.id.score_custom_list);
                    EditText et_score_order = layout.findViewById(R.id.et_score_order);
                    CheckBox cb_order_checked = layout.findViewById(R.id.cb_order_checked);

                    new_list_score =  (int)score_custom_list.getRating();
                    et_score_order_list = et_score_order.getText().toString();
                    String isCheck = "1";
                    if(cb_order_checked.isChecked()){
                        isCheck = "1";
                    }else{
                        isCheck = "0";
                    }
                    shopProductListBean.setGoodsId(apiOrderListBeanList.get(i).getIntfAnsOrderDetails().getGoodsId());
                    shopProductListBean.setDetailId(apiOrderListBeanList.get(i).getIntfAnsOrderDetails().getId());
                    shopProductListBean.setIfMatch("");
                    shopProductListBean.setEmployeeAbility("");
                    shopProductListBean.setApprDetails(et_score_order_list);
                    shopProductListBean.setApprPic("");
                    shopProductListBean.setIfAnon(isCheck);
                    shopProductListBean.setApprLevel(new_list_score+"");

                    shopProductListBeans.add(shopProductListBean);
                }
                com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L.e("%%%%%%%%     "+et_score_order_list+"    "+new_list_score);
                Gson gson = new Gson();
                String str = gson.toJson(shopProductListBeans);
                String str1 = gson.toJson(commentShopBean);
                HashMap<String, String> params = new HashMap<>();
                params.put("shopId", shopId);
                params.put("goodsInfo", str);
                params.put("userId", SP.get(ScoreActivity.this, SpContent.UserId, "") + "");
                params.put("appraiseShopInfo", str1);
                HttpUtils.doPost(ACTION.COMMENTPRO, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.COMMENTPRO:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.isSuccess()){
                    T.show("已完成评价");
                }else{
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
