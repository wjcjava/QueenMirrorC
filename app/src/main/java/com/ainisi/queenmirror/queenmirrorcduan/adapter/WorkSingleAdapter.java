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

public class WorkSingleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final List<ShopDiscounBean.BodyBean.CouponListDataItemBean> list1;
    private Context context;

    public WorkSingleAdapter(Context context, List<ShopDiscounBean.BodyBean.CouponListDataItemBean> list1) {
        this.context = context;
        this.list1=list1;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
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
            convertView = inflater.inflate(R.layout.re_workroom_single, parent, false);
            holder.tv_discount=convertView.findViewById(R.id.tv_discount);
            holder.tv_youxiao=convertView.findViewById(R.id.tv_youxiao);
            holder.tv_price=convertView.findViewById(R.id.tv_price);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv_discount.setText(list1.get(position).getCpCreateInfo().getDiscountRate());
        holder.tv_price.setText(list1.get(position).getCpCreateInfo().getReduceAmount());
        holder.tv_youxiao.setText(list1.get(position).getCpCreateInfo().getCreateTime());

        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{
        TextView tv_discount;
        TextView tv_youxiao;
        TextView tv_price;
    }
}
