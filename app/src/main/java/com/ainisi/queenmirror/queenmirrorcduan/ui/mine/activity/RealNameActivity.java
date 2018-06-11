package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.RealNameBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class RealNameActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.et_real_surnames)
    EditText tv_surnames;
    @Bind(R.id.et_real_name)
    EditText tv_name;
    @Bind(R.id.et_real_card)
    EditText tv_card;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_real_name;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    private void inithttp() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("lastName",tv_surnames.getText().toString());
        parames.put("firstName",tv_name.getText().toString());
        parames.put("idCard",tv_card.getText().toString());
        parames.put("userId", SP.get(this, SpContent.UserId,"")+"");
        HttpUtils.doPost(ACTION.REALNAME,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @OnClick({R.id.title_back,R.id.tv_real_ok})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_real_ok:
                if(TextUtils.isEmpty(tv_surnames.getText())||TextUtils.isEmpty(tv_name.getText())||TextUtils.isEmpty(tv_card.getText())){
                    T.show("请您将个人信息补充完整");
                }else {
                    inithttp();
                }

                break;

        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.REALNAME:
             RealNameBean realNameBean=GsonUtil.toObj(res, RealNameBean.class);
             if(realNameBean.isSuccess()){

             }else {
                 T.show(realNameBean.getMsg());
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
