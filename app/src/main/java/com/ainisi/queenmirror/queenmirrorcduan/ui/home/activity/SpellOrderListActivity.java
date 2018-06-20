package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SpellOrderAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SpellOrderListActivity extends BaseNewActivity{

    private List<SortBean> list=new ArrayList<>();
    @Bind(R.id.re_spellorder)
    RecyclerView reSpellOrder;
    @Bind(R.id.title_title)
    TextView spellTitle;

    FightaloneBean fightaloneBean = null;

    List<FightaloneBean.BodyBean.GpOrderListBean> gpOrderList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_spell_orderlist;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = this.getIntent();
        fightaloneBean = (FightaloneBean) intent.getSerializableExtra("bean");

        spellTitle.setText("更多拼单");

        for (int i = 0; i < 3; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }
        gpOrderList = fightaloneBean.getBody().getGpOrderList();

        SpellOrderAdapter myAdapter = new SpellOrderAdapter(R.layout.item_spellorder_list, gpOrderList,fightaloneBean.getBody().getGroupNums());
        reSpellOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reSpellOrder.setAdapter(myAdapter);
    }
}
