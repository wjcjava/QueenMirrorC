package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBeanOne;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的魔豆
 */
public class MineBeanActivity extends BaseActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView beantitle;
    @Bind(R.id.rc_mine_bean)
    RecyclerView rc_mine_bean;
    @Bind(R.id.tv_mine_bean_zhichu)
    TextView tv_mine_bean_zhichu;
    @Bind(R.id.tv_mine_bean_shouru)
    TextView tv_mine_bean_shouru;
    int pageNumber = 1;

    private List<SortBean> list = new ArrayList<>();

    List<MoDouListBean> moDouListBeans = new ArrayList<>();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineBeanActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_dean;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initText();
        initDate();

        getMineMoDouData();
        getMonthMoDouData();
    }

    /**
     * 按月获取魔豆
     */
    private void getMonthMoDouData() {

        String months = "";
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;

        if(month<10){
            months = "0" + month;
        }else{
            months = ""+ month;
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("searchMonth", year + months);
        params.put("custId",SP.get(MineBeanActivity.this,SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.GETMONTHMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取我的魔豆列表
     */
    private void getMineMoDouData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("searchDayFrom", "");
        params.put("searchDayTo", "");
        params.put("custId",SP.get(MineBeanActivity.this,SpContent.UserId,"0")+"");
        params.put("pageSize","10");
        params.put("pageNumber",pageNumber+"");
        HttpUtils.doPost(ACTION.GETMINEMODOUBEAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initText() {
        beantitle.setText(R.string.magic_bean);
        beantitle.setTextColor(Color.WHITE);
    }

    private void initDate() {
        for (int i = 0; i < 8; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("");
            sortBean.setTime("");
            sortBean.setDistance("");
            list.add(sortBean);
        }
        MyAdapter sortAdapter2 = new MyAdapter(R.layout.item_rcbean, list);
        rc_mine_bean.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc_mine_bean.setAdapter(sortAdapter2);
    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
//            case R.id.iv_date:
//                startActivity(new Intent(this,BeanstalkActivity.class));
//                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            //按月获取魔豆收入支出
            case ACTION.GETMONTHMODOU:
                L.e("res  "+res);

                MoDouBeanOne moDouBeanOne = GsonUtil.toObj(res,MoDouBeanOne.class);

                if(moDouBeanOne.isSuccess()){
                    tv_mine_bean_zhichu.setText(moDouBeanOne.getBody().getPointsChargeSumByMonth().get(1).getChargePoints()+"");

                    tv_mine_bean_shouru.setText(moDouBeanOne.getBody().getPointsChargeSumByMonth().get(0).getChargePoints()+"");
                }else{
                    T.show(moDouBeanOne.getMsg());
                }

                break;
            //获取魔豆列表
            case ACTION.GETMINEMODOUBEAN:
                L.e("$$$$$$$$$     " + res);




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
