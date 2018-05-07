package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioButton;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.HistorydiscountFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MinediscountFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

//优惠券
public class MineDiscountActivity extends BaseActivity {

//    @Bind(R.id.mine_tab)
//    TabLayout minetab;
    @Bind(R.id.mine_pager)
    NoScrollViewPager minepager;
    @Bind(R.id.radio_preferential)
    RadioButton coupon;
    //    @Bind(R.id.radio_preferential)
//    RadioButton preFerential;
//    @Bind(R.id.radio_invincible)
//    RadioButton inVincible;
    private List<Fragment> minefrlist = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private ViewPager viewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_discount;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        initDate();

        viewPager = new ViewPager(getSupportFragmentManager(), minefrlist,null);
        minepager.setAdapter(viewPager);
        minepager.setScanScroll(false);
       // minetab.setupWithViewPager(minepager);
        coupon.setChecked(true);

    }

    private void initDate() {
        //我的优惠券
        minefrlist.add(new MinediscountFragment());
        //历史优惠券
        minefrlist.add(new HistorydiscountFragment());
//        list.add("我的优惠券");
//        list.add("历史优惠券");
//        minetab.addTab(minetab.newTab().setText(list.get(0).toString().trim()));
//        minetab.addTab(minetab.newTab().setText(list.get(1).toString().trim()));
    }

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineDiscountActivity.class));
    }

    @OnClick({R.id.title_back, R.id.radio_preferential, R.id.radio_invincible})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.radio_preferential:
                viewPager.getItem(0);
                break;
            case R.id.radio_invincible:
                viewPager.getItem(1);
                break;
            default:
                break;
        }

    }
}