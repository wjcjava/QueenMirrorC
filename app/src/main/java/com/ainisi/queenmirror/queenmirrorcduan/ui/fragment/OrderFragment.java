package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.AssessedFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.RefundFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.WholeFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
/**
 * Created by EWorld on 2018/3/6.
 *
 */
public class OrderFragment extends BaseFragment {
    @Bind(R.id.or_tab)
    TabLayout otablayout;
    @Bind(R.id.or_mypager)
    NoScrollViewPager omypager;
    @Bind(R.id.title_photo)
    ImageView title_photo;
    private List<String> tablist = new ArrayList<>();
    private List<Fragment> pagerlist = new ArrayList<>();

    @Override
    protected int getLayoutResource()  {
        return R.layout.fragment_order;
    }

    @Override
    public void initPresenter() {

    }

    @OnClick({R.id.title_photo})
    public void onClick(View view){

        switch (view.getId()){
            case R.id.title_photo:
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void initView() {

        initDate();
    }
    private void initDate() {
        tablist.add("全部订单");
        tablist.add("待付款");
        tablist.add("待接单");
        tablist.add("服务中");
        tablist.add("待评价");
        tablist.add("已完成");
        tablist.add("退款");

        /**
         //全部订单
         //待评价
         //退款
         */
        pagerlist.add(new WholeFragment());
        pagerlist.add(new AssessedFragment());
        pagerlist.add(new RefundFragment());
        pagerlist.add(new WholeFragment());
        pagerlist.add(new WholeFragment());
        pagerlist.add(new WholeFragment());
        pagerlist.add(new WholeFragment());

        ViewPager viewPager = new ViewPager(getChildFragmentManager(), pagerlist, tablist);
        omypager.setAdapter(viewPager);
        omypager.setScanScroll(true);



        for (int i = 0; i < tablist.size(); i++) {
            otablayout.addTab(otablayout.newTab().setText(tablist.get(i)));
        }
        otablayout.setupWithViewPager(omypager);

    }





}
