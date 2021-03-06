package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 */

public class FullShortAdapter extends BaseQuickAdapter<ClassificationBean.BodyBean.ShopListDataBean, BaseViewHolder> {

    Context context;
    List<ClassificationBean.BodyBean.ShopListDataBean> data;

    public FullShortAdapter(Context context,int layoutResId, @Nullable List<ClassificationBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, final ClassificationBean.BodyBean.ShopListDataBean item) {

        helper.setText(R.id.tv_sort_name, item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_sort_time, item.getAnsShopBasic().getCloseTime());

        helper.setOnClickListener(R.id.li_home_short, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                intent.putExtra("shopName",item.getAnsShopBasic().getShopName());
                intent.putExtra("shopId",item.getAnsShopBasic().getId());
                context.startActivity(intent);
            }
        });
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ClassificationBean.BodyBean.ShopListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
