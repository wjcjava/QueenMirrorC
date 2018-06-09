package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyCommentsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的评价
 */
public class MineEvaluateActivity extends BaseActivity implements RefreshLoadMoreLayout.CallBack, HttpCallBack {

    @Bind(R.id.rc_evaluate)
    RecyclerView rcevaluate;
    private List<SortBean> list = new ArrayList<>();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private Handler handler = new Handler();
    private View evaluateView;
    @Bind(R.id.tv_name)
    TextView evalueteName;
    @Bind(R.id.tv_evaluate_number)
    TextView numeber;
    int pagenumer=1;
    private List<MyCommentsBean.BodyBean.CommentsListDataBean> commentList;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineEvaluateActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_evaluate;
    }

    @Override
    public void initPresenter() {
        inithttp();
    }


    @Override
    public void initView() {
        initReply();
    }

    private void initReply() {
        evalueteName.setText(SP.get(this, SpContent.UserName,"")+"");

    }

    public void initData() {
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());

    }

    @OnClick({R.id.title_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;


        }

    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("下拉成功");
                mRefreshLoadMoreLayout.stopRefresh();
            }
        }, 200);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("上拉成功");
                mRefreshLoadMoreLayout.stopLoadMore();
            }
        }, 1000);
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("userId", "111");
        parames.put("pageNumber", pagenumer+"");
        parames.put("pageSize","10");
        HttpUtils.doPost(ACTION.MYCOMMENTS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.MYCOMMENTS:
                MyCommentsBean commentsBean = GsonUtil.toObj(res, MyCommentsBean.class);
                evaluateView = LayoutInflater.from(this).inflate(R.layout.item_evaluate, null);
                commentList = commentsBean.getBody().getCommentsListData();
                if(commentList.size()>0){
                    numeber.setText("共有"+commentList.size()+"条数据");
                }else {
                    numeber.setText("共有0条数据");
                }
                if (commentsBean.isSuccess()) {
                    MyCommentsAdapter sortAdapter2 = new MyCommentsAdapter(R.layout.item_evaluate, commentList,this);
                    rcevaluate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    rcevaluate.setAdapter(sortAdapter2);
                } else {
                    T.show(commentsBean.getMsg());
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
