package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
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
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.LabelBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.FlowLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2017/11/12.
 * 搜索
 */

public class SearchActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.titleimg_right)
    ImageView imgright;
    @Bind(R.id.title_search)
    TextView search;
    @Bind(R.id.layout_title)
    LinearLayout layouttitle;
    @Bind(R.id.root_title)
    RelativeLayout poplayout;
    @Bind(R.id.title_layout)
    LinearLayout titlelayout;
    @Bind(R.id.et_title)
    TextView etTitle;
    @Bind(R.id.his_flowLayout)
    FlowLayout his_flowLayout;
    public static void startActivity(Context context) {
        Intent in = new Intent(context, SearchActivity.class);
        context.startActivity(in);
    }

    @Override
    public int getLayoutId() {
        StatusBarUtil.getStatusBarLightMode(getWindow());
        return R.layout.activity_search;
    }

    @Override
    public void initView(){
        showpopid();
        initHot();
        initHistory();
        initHotTag();
        inithttp();
    }


    private void initHot() {

    }
    private void initHistory() {

    }


    private void showpopid() {
        title.setVisibility(View.GONE);
        imgright.setVisibility(View.GONE);
        titlelayout.setVisibility(View.VISIBLE);
        poplayout.setBackgroundColor(ContextCompat.getColor(this,R.color.alpha_05_black));
    }


    @OnClick({R.id.title_back,R.id.title_search
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_search:

                break;
            default:
                break;

        }
    }
    /**
     * 热门搜索
     */
    private void initHotTag() {

    }
    private void inithttp() {
        HashMap<String,String> params=new HashMap<>();
        params.put("tabCategory","2");
        params.put("belongCate","");
        HttpUtils.doPost(ACTION.LABEL,params, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }


    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.LABEL:
                LabelBean labelBean=GsonUtil.toObj(res, LabelBean.class);
                if(labelBean.isSuccess()){
                    String[] mStrings=new String[labelBean.getBody().getTabListData().size()];
                    for (int i = 0; i <labelBean.getBody().getTabListData().size() ; i++) {
                        mStrings[i]=labelBean.getBody().getTabListData().get(i).getEcTab().getTabName();
                    }
                    his_flowLayout.setColorful(false);//设置是否是多彩的颜色
                    his_flowLayout.setData(mStrings);
                    his_flowLayout.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
                        @Override
                        public void TagClick(String text) {
                            etTitle.setText(text);
                        }
                    });
                }else {
                    T.show(labelBean.getMsg());
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
