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
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *
 * 我的魔豆
 *
 */
public class MineBeanActivity extends BaseActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView beantitle;
    @Bind(R.id.rc_bean)
    RecyclerView beanrecycle;

    private List<SortBean> list=new ArrayList<>();
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,MineBeanActivity.class));
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
    }

    private void initText() {
        beantitle.setText(R.string.magic_bean);
        beantitle.setTextColor(Color.WHITE);

    }

    private void initDate() {
        for (int i = 0; i <8 ; i++) {
            SortBean sortBean=new SortBean();
            sortBean.setName("");
            sortBean.setTime("");
            sortBean.setDistance("");
            list.add(sortBean);
        }
        MyAdapter sortAdapter2=new MyAdapter(R.layout.item_rcbean,list);
        beanrecycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        beanrecycle.setAdapter(sortAdapter2);
    }

    @OnClick({R.id.title_back,R.id.iv_date
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.iv_date:
                startActivity(new Intent(this,BeanstalkActivity.class));
                break;

        }


    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
