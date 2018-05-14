package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.ShopStoreActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.DetailsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class HomepageGridViewAdapter extends BaseAdapter{
    private Context context;
    List<ClassificationBean.BodyBean.ShopListDataBean> ShopListData = new ArrayList<>();

    public HomepageGridViewAdapter(Context context,List<ClassificationBean.BodyBean.ShopListDataBean> ShopListData) {
        this.context = context;
        this.ShopListData = ShopListData;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.item_recycler_waterfall, parent, false);
            holder.tv_shopName = convertView.findViewById(R.id.tv_shopName);
            holder.tv_shop_time = convertView.findViewById(R.id.tv_shop_time);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ShopStoreActivity.class);
                    context.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv_shopName.setText(ShopListData.get(position).getAnsShopBasic().getShopName());
        holder.tv_shop_time.setText("营业时间："+ShopListData.get(position).getAnsShopBasic().getOpenTime()+"-"+ShopListData.get(position).getAnsShopBasic().getCloseTime());

        return convertView;

    }
    //就是View的持有
    public final class ViewHolder{
        TextView tv_shopName;
        TextView tv_shop_time;
    }






}