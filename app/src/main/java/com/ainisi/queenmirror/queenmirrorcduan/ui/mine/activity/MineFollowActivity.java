package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineFollowAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineFollowBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *
 * 关注店铺
 */
public class MineFollowActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack,HttpCallBack{
    @Bind(R.id.mine_follow_recycler)
    RecyclerView recycler;
    @Bind(R.id.title_title)
    TextView folltitle;
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    @Bind(R.id.li_mine_follow_none)
    LinearLayout li_mine_follow_none;

    List<MineFollowBean.BodyBean.CommentsListDataBean> commentsListDataBeanList = new ArrayList<>();

    int pageNumber = 1;
    private Handler handler = new Handler();
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineFollowActivity.class));
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_follow;
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.MINEINSHOP:

                L.e("++++++++++++++++++++"+res);
                MineFollowBean mineFollowBean = GsonUtil.toObj(res,MineFollowBean.class);
                commentsListDataBeanList = mineFollowBean.getBody().getCommentsListData();

                if(commentsListDataBeanList.size()>0){
                    li_mine_follow_none.setVisibility(View.GONE);

                    L.e("......................");
                    MineFollowAdapter sortAdapter=new MineFollowAdapter(R.layout.item_fullshortrecycler,commentsListDataBeanList);
                    recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                    recycler.setAdapter(sortAdapter);
                }else{
                    li_mine_follow_none.setVisibility(View.VISIBLE);
                }

                break;
        }
    }
    @Override
    protected void doFirstRequest() {
        super.doFirstRequest();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("userId", "111");
        params.put("pageSize", "10");
        HttpUtils.doPost(ACTION.MINEINSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initView() {
        super.initView();
        folltitle.setText("关注店铺");
    }

    @Override
    protected void initData() {
        super.initData();
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
    }

    @OnClick({R.id.title_back
    })
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

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
