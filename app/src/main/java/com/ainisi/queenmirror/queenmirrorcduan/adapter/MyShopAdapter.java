package com.ainisi.queenmirror.queenmirrorcduan.adapter;


import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 *
 *
 *贾亮测试提交消息，王军超提交测试信息
 * lp
 *
 * jl
 */

public class MyShopAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {

    Context context;

    public MyShopAdapter(Context context,int layoutResId, @Nullable List<ShopBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        ImageView image_title = helper.getView(R.id.image_title);
        if(item.getImageTitle() == null || item.getImageTitle().equals("")){

        }else{
            Glide.with(context).load(item.getImageTitle()).into(image_title);
        }
        helper.setText(R.id.text_name,item.getTextName());
    }
}
