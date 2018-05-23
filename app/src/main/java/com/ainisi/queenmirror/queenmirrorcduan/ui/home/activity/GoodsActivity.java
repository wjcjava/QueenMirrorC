package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;
/**
 * 搜索后的活动商品
 */
public class GoodsActivity extends BaseNewActivity implements HttpCallBack {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        inithttp();
    }

    private void inithttp() {
        HashMap<String, String> params = new HashMap<>();
        params.put("activityId", "");
        HttpUtils.doPost(ACTION.ACTIVITYGOODS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.ACTIVITYGOODS:
                GoodsBean goodsBean = GsonUtil.toObj(res, GoodsBean.class);
                if(goodsBean.isSuccess()){
                    List<GoodsBean.BodyBean.ActivityListDataBean> goodsList = goodsBean.getBody().getActivityListData();
                    //写操作
                }else {
                    T.show(goodsBean.getMsg());
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
