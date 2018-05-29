package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.ShopStoreActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class HomeListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShopListHomeBean.BodyBean.ShopListBean> ShopListData = new ArrayList<>();
    private String where;

    public HomeListViewAdapter(Context context,List<ShopListHomeBean.BodyBean.ShopListBean> ShopListData,String where) {
        this.context = context;
        this.ShopListData = ShopListData;
        inflater = LayoutInflater.from(context);
        this.where = where;
    }
    @Override
    public int getCount() {
        return ShopListData.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.item_shortrecycler, parent, false);
            holder.sort_time = convertView.findViewById(R.id.tv_sort_time);
            holder.sort_name = convertView.findViewById(R.id.tv_sort_name);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(where.equals("home")) {
                        Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                        intent.putExtra("shopName", ShopListData.get(position).getAnsShopBasic().getShopName());
                        intent.putExtra("shopId", ShopListData.get(position).getAnsShopBasic().getId());
                        context.startActivity(intent);
                    }else{
                        Intent intent = new Intent(context, ShopStoreActivity.class);
                        intent.putExtra("shopName", ShopListData.get(position).getAnsShopBasic().getShopName());
                        intent.putExtra("shopId", ShopListData.get(position).getAnsShopBasic().getId());
                        context.startActivity(intent);
                    }
                }
            });

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.sort_time.setText("营业时间："+ShopListData.get(position).getAnsShopBasic().getOpenTime()+"-"+ShopListData.get(position).getAnsShopBasic().getCloseTime());
        holder.sort_name.setText(ShopListData.get(position).getAnsShopBasic().getShopName());

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;
        private TextView sort_name;
        private TextView sort_time;
    }
}
