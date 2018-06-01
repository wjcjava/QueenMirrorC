package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MondelActivity extends BaseNewActivity {
    @Bind(R.id.banner_model)
    Banner modelBanner;
    @Bind(R.id.re_mondel)
    RecyclerView reMondel;
    @Bind(R.id.re_mondel_exchange)
    RecyclerView reExchange;
    private List<SortBean> mondelList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_mondel;
    }


    @Override
    public void initView() {
        initDate();
    }

    private void initDate() {
        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add(R.drawable.icon_mondel_banner);
        }
        modelBanner.setImageLoader(new GlideImageLoader());
        modelBanner.setImages(images);
        modelBanner.setIndicatorGravity(BannerConfig.LEFT);
        modelBanner.start();

        for (int i = 0; i < 4; i++) {
            SortBean sortBean = new SortBean();
            mondelList.add(sortBean);
        }

        MyAdapter myAdapter = new MyAdapter(R.layout.re_mondel_service, mondelList);
        reMondel.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reMondel.setAdapter(myAdapter);
        MyAdapter myAdaptertwo = new MyAdapter(R.layout.re_mondel_exchange, mondelList);
        reExchange.setLayoutManager(new GridLayoutManager(this, 2));
        reExchange.setAdapter(myAdaptertwo);
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

}
