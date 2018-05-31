package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.orderadapter.ScoreAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

;

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
    private List<SortBean> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_score;
    }

    @Override
    protected void initView() {
        super.initView();

        initTitle();
        initDate();
    }


    private void initDate() {
        for (int i = 0; i <3 ; i++) {
            SortBean sortBean=new SortBean();
            list.add(sortBean);

        }
        ScoreAdapter myAdapter=new ScoreAdapter(R.layout.item_score,list);
        reScore.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        reScore.setAdapter(myAdapter);

    }



    private void initTitle() {
        scoreTitle.setText(R.string.published_order);
        scoreTitle.setTextColor(Color.BLACK);
        scoreRightTitle.setText(R.string.release);
        scoreRightTitle.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.title_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;


        }


    }
}
