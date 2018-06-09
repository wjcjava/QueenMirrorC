package com.ainisi.queenmirror.queenmirrorcduan.ui.home.util;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.MerchantsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.PreferentialAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;

import java.util.List;

/**
 * Created by john on 2018/6/4.
 */

public class ScreenPoputil extends PopupWindow{

    private View popview;
    private PopupWindow popWindow;
    private Context context;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private MerchantsAdapter merchantsAdapter;
    private String text;



    public ScreenPoputil(Context context) {
        this.context = context;
    }

    public void showscreenPop(View view, List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList, List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList, String text) {
        this.merchantsList = merchantsList;
        this.preferentialList = preferentialList;
        this.text = text;

        popview = View.inflate(context, R.layout.pop_screening, null);
        initoperation(popview);
        popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT);
        popWindow.setContentView(popview);
        popWindow.setOutsideTouchable(true);
        popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);
        popWindow.showAsDropDown(view, 0, 0);


    }



    private void initoperation(final View popview) {
        RecyclerView merchants = popview.findViewById(R.id.re_home_merchants);
        TextView cancel = popview.findViewById(R.id.tv_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dismiss();
            }
        });
        if (text.equals("home")) {
            initAdapter(merchants);
        } else if (text.equals("shop")) {
            initAdapter(merchants);
        } else if (text.equals("esthetics")) {
            initAdapter(merchants);
        } else if (text.equals("shopification")) {
            initAdapter(merchants);
        }
        popview.findViewById(R.id.pop_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dismiss();
            }
        });
    }
    private void initAdapter(RecyclerView merchants) {
        RecyclerView preferential = popview.findViewById(R.id.re_home_preferential);
        merchantsAdapter = new MerchantsAdapter(R.layout.item_adapter_merchants, merchantsList);
        merchants.setLayoutManager(new GridLayoutManager(context, 3));
        merchants.setAdapter(merchantsAdapter);

        PreferentialAdapter preferentialAdapter = new PreferentialAdapter(preferentialList);
        preferential.setLayoutManager(new GridLayoutManager(context, 2));
        preferential.setAdapter(preferentialAdapter);


    }


}