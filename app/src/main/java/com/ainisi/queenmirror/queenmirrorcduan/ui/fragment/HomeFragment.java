package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyRecyclerCardviewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.barlibrary.ImmersionBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2018/3/6.
 * 首页
 */

public class HomeFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.rv_home_fragment)
    public RecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.iv_uspension_surface)
    public ImageView surface;
    @Bind(R.id.layout_stick_header_main)
    public LinearLayout layout_stick_header_main;
    @Bind(R.id.home_refresh)
    MaterialRefreshLayout home_refresh;
    @Bind(R.id.iv_sort)
    ImageView ivsort;
    @Bind(R.id.iv_sort1)
    ImageView ivsort1;
    @Bind(R.id.tv_home_comprehensive)
    public TextView hSort;
    @Bind(R.id.li_sort_bottom)
    public LinearLayout sortHeard;

    private int type = 0;

    List<SortBean> data;
    LinearLayoutManager layoutManager;
    int itemNum;
    private List<ProblemBean> list = new ArrayList<>();
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};
    public PopupWindow pop;
    public View popview1;
    public PopupWindow popWindow;
    private MyRecyclerCardviewAdapter myRecyclerCardviewAdapter1;
    private MyRecyclerCardviewAdapter myRecyclerCardviewAdapter;

    public static HomeFragment instance = null;
    public boolean onclick;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), mToolbar);

        instance = this;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.home_fragment_new;

    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        super.initData();
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            data.add(sortBean);
        }

        pop = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
        popview1 = View.inflate(getActivity(), R.layout.pop_myitem, null);
        initpop(popview1);
        pop.setContentView(popview1);
        pop.setBackgroundDrawable(new ColorDrawable(0));
        pop.setOutsideTouchable(true);
        pop.setAnimationStyle(R.style.CustomPopWindowStyle);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ivsort.setVisibility(View.VISIBLE);
                ivsort1.setVisibility(View.GONE);
            }
        });
        pop.dismiss();

        View popview = View.inflate(getActivity(), R.layout.pop_right, null);
        initview(popview);
        popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);

        popWindow.setContentView(popview);
        popWindow.setBackgroundDrawable(new ColorDrawable(0));
        popWindow.setOutsideTouchable(true);
        popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);
    }

    private void initpop(View popview1) {
        final RecyclerView ce = popview1.findViewById(R.id.rc_popview);
        for (int i = 0; i < problem.length; i++) {
            ProblemBean problemBean = new ProblemBean();
            problemBean.setName(problem[i]);
            list.add(problemBean);
        }
        ProblemAdapter problemAdapter = new ProblemAdapter(R.layout.item_pop_sort, list);
        ce.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ce.setAdapter(problemAdapter);
        problemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                hSort.setText(problem[position]);
                pop.dismiss();

            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
        //创建布局管理
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myRecyclerCardviewAdapter = new MyRecyclerCardviewAdapter(getContext(), type);
        recyclerView.setAdapter(myRecyclerCardviewAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int currentposition = layoutManager.getPosition(layoutManager.getChildAt(0));
                if (currentposition >= 1) {
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                } else {
                    layout_stick_header_main.setVisibility(View.GONE);
                }
            }
        });
        home_refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                T.show("下拉刷新");
                // 结束上拉刷新...
                home_refresh.finishRefreshLoadMore();

                home_refresh.finishRefresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                //上拉加载更多...
                T.show("已经加载完了");
                // 结束下拉刷新...
                home_refresh.finishRefresh();
            }
        });
     /*
      // 结束下拉刷新...
        home_refresh.finishRefresh();
        // 结束上拉刷新...
        home_refresh.finishRefreshLoadMore();*/

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

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarColorTransformEnable(false)
                .navigationBarColor(R.color.alpha_95_black)
                .init();
    }

    @OnClick({R.id.tv_home_bustling, R.id.iv_home_search, R.id.iv_uspension_surface, R.id.iv_sort, R.id.iv_sort1, R.id.rb_screen, R.id.img_information})
    public void click(View view) {
        switch (view.getId()) {
            //我的位置
            case R.id.tv_home_bustling:
                //startProgressDialog();
                break;
            //搜索
            case R.id.iv_home_search:
                SearchActivity.startActivity(getContext());
                break;
            //消息
            case R.id.img_information:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            //瀑布流和流式切换
            case R.id.iv_uspension_surface:
                GridLayoutManager layoutManage = new GridLayoutManager(getActivity(), 2);

                if(onclick){
                    myRecyclerCardviewAdapter1 = new MyRecyclerCardviewAdapter(getActivity(), 0);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                    recyclerView.setAdapter(myRecyclerCardviewAdapter1);
                    surface.setImageResource(R.drawable.icon_home_list);
                    recyclerView.smoothScrollToPosition(2);
                    onclick=false;

                }else {
                    recyclerView.smoothScrollToPosition(2);
                    surface.setImageResource(R.drawable.icon_home_recycler);
                    layoutManage.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                        @Override
                        public int getSpanSize(int position) {
                            if (position == 0 || position == 1) {
                                return 2;
                            } else {
                                return 1;
                            }
                        }
                    });

                    myRecyclerCardviewAdapter1 = new MyRecyclerCardviewAdapter(getActivity(), 2);
                    recyclerView.setLayoutManager(layoutManage);
                    recyclerView.setAdapter(myRecyclerCardviewAdapter1);
                    onclick=true;
                }
                break;

            case R.id.iv_sort:
                ivsort.setVisibility(View.GONE);
                ivsort1.setVisibility(View.VISIBLE);
                pop.showAsDropDown(hSort);
                inititem();
                break;

            case R.id.iv_sort1:
                pop.dismiss();
                ivsort.setVisibility(View.VISIBLE);
                ivsort1.setVisibility(View.GONE);
                inititem();
                break;
            case R.id.rb_screen:

//                popWindow = new CustomPopWindow.PopupWindowBuilder(getActivity())
//                        .setView(popview)
//                        .setFocusable(true)
//                        .size(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT)
//                        .setOutsideTouchable(true)
//                        .setAnimationStyle(R.style.CustomPopWindowStyle)
//                        .create()
//                        .showAsDropDown(sortHeard);

                popWindow.showAsDropDown(hSort);
                break;
        }

    }
    private void initview(final View popview) {
        TextView eliminateTv = popview.findViewById(R.id.tv_eliminate);
        eliminateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dismiss();

            }
        });
    }
    public void inititem() {
        if (itemNum > myRecyclerCardviewAdapter.getItemCount()) {
            recyclerView.smoothScrollToPosition(2);
        }
    }

}
