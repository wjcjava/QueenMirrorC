package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class AreFundAdapter  extends BaseQuickAdapter<AreFundBean,BaseViewHolder> {

    public AreFundAdapter(int layoutResId, @Nullable List<AreFundBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final AreFundBean item) {
        helper.setText(R.id.tv_shop_name,item.getIntfAnsOrderDetails().getGoodsName())
                .setText(R.id.tv_arefund_number,"X"+item.getIntfAnsOrderDetails().getPurchaseNumber())
                .setText(R.id.tv_arefund_price,item.getIntfAnsOrderDetails().getUnitPrice());

        CheckBox box_goods = helper.getView(R.id.box_goods);
        box_goods.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    item.setCheck(true);
                }else{
                    item.setCheck(false);
                }
            }
        });

    }
}
