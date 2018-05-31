package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;

import java.util.List;

/**
 * Created by john on 2018/5/22.
 */

public class DisCountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private final List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> list;
    private LayoutInflater myLayoutinflater;

    //建立枚举 4个item类型
    public enum ITEM_TYPE {
        ITEM1,
        ITEM2,
        ITEM3,
        ITEM4
    }

    public DisCountAdapter(Context context,List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> list) {
        this.context = context;
        this.list=list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        myLayoutinflater = LayoutInflater.from(parent.getContext());
        //itme1
        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
            return new Item1ViewHolder(myLayoutinflater.inflate(R.layout.item1_discount, parent, false));
        }
        //itme2
        else if (viewType == ITEM_TYPE.ITEM2.ordinal()) {
            return new Item2ViewHolder(myLayoutinflater.inflate(R.layout.item2_discount,  parent, false));
        }
        //itme3
        else if (viewType == ITEM_TYPE.ITEM3.ordinal()) {
            return new Item3ViewHolder(myLayoutinflater.inflate(R.layout.item3_discount,  parent, false));
        }
        //itme4
        else if (viewType == ITEM_TYPE.ITEM4.ordinal()) {
            return new Item4ViewHolder(myLayoutinflater.inflate(R.layout.item4_discount,  parent, false ));
        }
       return null;

    }
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE.ITEM1.ordinal();
        } else if (position == 1) {
            return ITEM_TYPE.ITEM2.ordinal();
        } else if(position==2){
            return ITEM_TYPE.ITEM3.ordinal();
        }else{
            return ITEM_TYPE.ITEM4.ordinal();
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //itme1的逻辑操作
        if(holder instanceof Item1ViewHolder){

        }
        //itme2的逻辑操作
        else if(holder instanceof Item2ViewHolder){
            ((Item2ViewHolder) holder).discount.setText(list.get(0).getCpCreateInfo().getCpName());
        }
        //itme3的逻辑操作
        else if(holder instanceof Item3ViewHolder){

        }
        //itme4的逻辑操作
        else if(holder instanceof Item4ViewHolder){

        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
    //item1 的ViewHolder
    public static class Item1ViewHolder extends RecyclerView.ViewHolder{

        public Item1ViewHolder(View itemView) {
            super(itemView);

        }
    }
    //item2 的ViewHolder
    public static class Item2ViewHolder extends RecyclerView.ViewHolder{

        private final TextView discount;

        public Item2ViewHolder(View itemView) {
            super(itemView);
            discount = itemView.findViewById(R.id.tv_discount);

        }
    }
    //item3 的ViewHolder
    public static class Item3ViewHolder extends RecyclerView.ViewHolder{
        public Item3ViewHolder(View itemView) {
            super(itemView);

        }
    }
    //item4 的ViewHolder
    public static class Item4ViewHolder extends RecyclerView.ViewHolder{

        public Item4ViewHolder(View itemView) {
            super(itemView);

        }
    }

}
