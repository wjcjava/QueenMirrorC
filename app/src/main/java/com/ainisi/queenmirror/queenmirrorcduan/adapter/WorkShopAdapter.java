package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopDiscounBean;

import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkShopAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<ShopDiscounBean.BodyBean.CouponListDataBean> list;
    private Context context;
    public WorkShopAdapter(Context context, List<ShopDiscounBean.BodyBean.CouponListDataBean> list) {
        this.context = context;
        this.list=list;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.re_workroom_coupon, parent, false);
            holder.counName=convertView.findViewById(R.id.tv_shop_discount);
            holder.couneMoney=convertView.findViewById(R.id.tv_shop_money);
            holder.couneConditions=convertView.findViewById(R.id.tv_coune_conditions);
            holder.couneTime=convertView.findViewById(R.id.tv_coune_time);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.counName.setText(list.get(position).getCpCreateInfo().getCpName());
        holder.couneMoney.setText(list.get(position).getCpCreateInfo().getReduceAmount()+"元");
        holder.couneConditions.setText(list.get(position).getCpCreateInfo().getCpUsing());
        holder.couneTime.setText(list.get(position).getCpCreateInfo().getCreateTime());

        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{
       TextView counName;
       TextView couneMoney;
       TextView couneConditions;
       TextView couneTime;


    }
}
