package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineCollectionAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineCollectionListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
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
 * 我的收藏
 */
public class MineCollectionActivity extends BaseNewActivity implements RefreshLoadMoreLayout.CallBack,HttpCallBack {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineCollectionActivity.class));
    }
    @Bind(R.id.recyler_collection)
    RecyclerView collrecycler;
    @Bind(R.id.title_title)
    TextView colltitle;
    private List<SortBean> list=new ArrayList<>();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;

    List<MineCollectionListBean.BodyBean.CollectListDataBean> CollectListData = new ArrayList<>();

    private Handler handler = new Handler();

    int pageNumber = 1;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_collection;
    }

    @Override
    protected void initView() {
        super.initView();
        initText();

    }

    @Override
    protected void doFirstRequest() {
        super.doFirstRequest();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("userId", SP.get(MineCollectionActivity.this,SpContent.UserId,"")+"");
        params.put("pageSize", "10");
        HttpUtils.doPost(ACTION.MINECOLLECTION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    protected void initData() {
        super.initData();
        /**
         * canRefresh 是否下拉刷新
         * canLoadMore 是否上拉加载更多
         * autoLoadMore 自动加载更多（默认不自动加载更多）
         * showLastRefreshTime 是否显示上次刷新时间（默认不显示）
         * multiTask 下拉刷新上拉加载更多可同时进行（默认下拉刷新和上拉加载更多不能同时进行）
         */
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
    }

    private void initText() {
        colltitle.setText(R.string.my_collection);

    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
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
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.MINECOLLECTION:

                MineCollectionListBean mineCollectionListBean = GsonUtil.toObj(res,MineCollectionListBean.class);
                CollectListData = mineCollectionListBean.getBody().getCollectListData();

                MineCollectionAdapter sortAdapter2=new MineCollectionAdapter(R.layout.item_collection,CollectListData);
                collrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                collrecycler.setAdapter(sortAdapter2);
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
