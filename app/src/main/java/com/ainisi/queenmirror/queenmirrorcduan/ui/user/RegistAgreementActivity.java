package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AgreementBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class RegistAgreementActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.wb_regist_aggrement)
    WebView wb_regist_aggrement;
    @Bind(R.id.tv_agreement_web)
            TextView tv_agreement_web;

    String content="";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist_agreement;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("商家入驻协议");

        getAgreementData();
    }

    /**
     * 获取用户协议
     */
    private void getAgreementData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("title", "商家入驻协议");
        HttpUtils.doPost(ACTION.WEBVIEWAGREEMENT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res){
        switch (action){
            case ACTION.WEBVIEWAGREEMENT:
                AgreementBean agreementBean = GsonUtil.toObj(res,AgreementBean.class);
                if(agreementBean.isSuccess()){
                  //  wb_regist_aggrement.setVisibility(View.GONE);
                    tv_agreement_web.setVisibility(View.GONE);
                    content = agreementBean.getBody().getProtocal().getContent();

                  /*  wb_regist_aggrement.loadDataWithBaseURL("", Html.fromHtml(content).toString(),
                            "text/html", "UTF-8", "about:blank");*/

                    new WebService(this,Html.fromHtml(content).toString(),wb_regist_aggrement);

                    //硬件加速
                    wb_regist_aggrement.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

                }else{
                    T.show(agreementBean.getMsg());
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