package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

import android.content.res.Resources;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.DisCountAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.Overduedapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.UseAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.lzy.okgo.cache.CacheMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 我的优惠券
 */

public class MinediscountFragment extends BaseFragment implements RefreshLoadMoreLayout.CallBack ,HttpCallBack{
    @Bind(R.id.rey_distance)
    RecyclerView disrecycler;
    @Bind(R.id.tab_mine_distance)
    TabLayout tabDistance;
    private List<String> tabList = new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private DisCountAdapter sortAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_distance;
    }

    @Override
    public void initPresenter() {
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()
                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
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
    protected void initView() {
        initDate();


        /**
         * 商品所领取优惠券
         */
        getReceiveDiscoun();

    }

    private void getReceiveDiscoun(){
        HashMap<String,String> params=new HashMap<>();
        params.put("userId","1");//用户ID
        HttpUtils.doPost(ACTION.RECEIVEDISCOUN,params, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.RECEIVEDISCOUN:
                ReceiveDiscounBean receiveBean=GsonUtil.toObj(res, ReceiveDiscounBean.class);
                if(receiveBean.isSuccess()){
                    List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> receiveList = receiveBean.getBody().getCustCouponListData();
                    sortAdapter = new DisCountAdapter(getActivity(),receiveList);
                    disrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    disrecycler.setAdapter(sortAdapter);
                }else {
                    T.show(receiveBean.getMsg());
                }
                break;
        }
    }

    private void initDate() {

        tabList.add("已领取优惠券");
        tabList.add("已使用优惠券");
        tabList.add("已过期优惠券");
        for (int i = 0; i < tabList.size(); i++) {
            tabDistance.addTab(tabDistance.newTab().setText(tabList.get(i)));
            TabLayout.Tab tab = tabDistance.getTabAt(i);
            if (tab == null) return;
            //这里使用到反射，拿到Tab对象后获取Class
            Class c = tab.getClass();
            try {

                Field field = c.getDeclaredField("mView");
                field.setAccessible(true);
                final View view = (View) field.get(tab);
                if (view == null) return;
                view.setTag(i);
                view.setOnClickListener(new View.OnClickListener() {

                    private int position;

                    @Override
                    public void onClick(View v) {
                        position = (int) view.getTag();
                        //这里就可以根据业务需求处理点击事件了。
                        if (position == 0) {

                            disrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                            disrecycler.setAdapter(sortAdapter);
                        } else if (position == 1) {
                            UseAdapter sortAdapter = new UseAdapter(getActivity());
                            disrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                            disrecycler.setAdapter(sortAdapter);
                        } else if(position==2){
                            Overduedapter sortAdapter = new Overduedapter(getActivity());
                            disrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                            disrecycler.setAdapter(sortAdapter);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


        setIndicator(tabDistance, 10, 10);
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }



    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
