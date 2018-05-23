package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.HistorydiscountFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MinediscountFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.FragmentUtil;

import butterknife.Bind;
import butterknife.OnClick;

//优惠券
public class MineDiscountActivity extends BaseNewActivity {

    private MinediscountFragment minediscountFragment;
    private HistorydiscountFragment historydiscountFragment;
    @Bind(R.id.radio_preferential)
    RadioButton preferential;
    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_discount;
    }

    @Override
    public void initView() {

        initshowdiscountFragment();

    }

    private void initshowdiscountFragment() {
        preferential.setChecked(true);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.fr_mine_discount, new MinediscountFragment());
        transaction.commit();
    }

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineDiscountActivity.class));
    }

    @Override
    protected void initData() {


    }

    @OnClick({R.id.title_back, R.id.radio_preferential, R.id.radio_invincible})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.radio_preferential:
                if (minediscountFragment == null) {
            minediscountFragment = new MinediscountFragment();

        }
        FragmentUtil.showFragment(this, R.id.fr_mine_discount, minediscountFragment);
                break;
            case R.id.radio_invincible:
                if (historydiscountFragment == null) {
                    historydiscountFragment = new HistorydiscountFragment();
                }
                FragmentUtil.showFragment(this, R.id.fr_mine_discount, historydiscountFragment);
                break;
            default:
                break;
        }

    }
}