package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

/**
 * 搜索后的活动商家
 */
public class ShopsActivity extends BaseNewActivity implements HttpCallBack {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_shops;
    }

    @Override
    protected void initData() {
        super.initData();
        HashMap<String, String> params = new HashMap<>();
        params.put("activityId", "");
        HttpUtils.doPost(ACTION.ACTIVITYSHOPS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.ACTIVITYSHOPS:
                ShopsBean shopsBean=GsonUtil.toObj(res, ShopsBean.class);
                if(shopsBean.isSuccess()){
                    List<ShopsBean.BodyBean.ShopListDataBean> shopsList = shopsBean.getBody().getShopListData();
                    //写操作
                }else {
                    T.show(shopsBean.getMsg());
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
