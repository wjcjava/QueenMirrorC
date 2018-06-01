package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
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
    @Override
    protected int getLayoutId() {
        return R.layout.activity_spell_orderlist;
    }

    @Override
    protected void initData() {
        super.initData();
        spellTitle.setText("更多拼单");
        for (int i = 0; i < 3; i++) {
            SortBean sortBean = new SortBean();
            list.add(sortBean);
        }
        MyAdapter myAdapter = new MyAdapter(R.layout.item_spellorder_list, list);
        reSpellOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reSpellOrder.setAdapter(myAdapter);
    }
}
