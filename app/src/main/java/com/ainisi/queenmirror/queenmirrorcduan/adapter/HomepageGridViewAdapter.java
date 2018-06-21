package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.MapUtil;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.ShopStoreActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class HomepageGridViewAdapter extends BaseAdapter {
    private Context context;
    List<ShopListHomeBean.BodyBean.ShopListBean> ShopListData = new ArrayList<>();
    private String where;
    double distance;
    String mine_lon, mine_lat, shop_lon, shop_lat;

    public HomepageGridViewAdapter(Context context, List<ShopListHomeBean.BodyBean.ShopListBean> ShopListData, String where) {
        this.context = context;
        this.ShopListData = ShopListData;
        this.where = where;
    }

    public void Clear() {
        ShopListData.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ShopListHomeBean.BodyBean.ShopListBean> ShopListData) {
        this.ShopListData = ShopListData;
        this.notifyDataSetChanged();
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.item_recycler_waterfall, parent, false);
            holder.tv_shopName = convertView.findViewById(R.id.tv_shopName);
            holder.tv_shop_time = convertView.findViewById(R.id.tv_shop_time);

            holder.iv_homepage_shop = convertView.findViewById(R.id.iv_homepage_shop);
            holder.tv_homepage_distance = convertView.findViewById(R.id.tv_homepage_distance);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (where.equals("home")) {

                        Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                        intent.putExtra("shopName", ShopListData.get(position).getAnsShopBasic().getShopName());
                        intent.putExtra("shopId", ShopListData.get(position).getAnsShopBasic().getId());
                        context.startActivity(intent);
                    } else {
                        Intent intent = new Intent(context, ShopStoreActivity.class);
                        intent.putExtra("shopName", ShopListData.get(position).getAnsShopBasic().getShopName());
                        intent.putExtra("shopId", ShopListData.get(position).getAnsShopBasic().getId());

                        context.startActivity(intent);
                    }
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_shopName.setText(ShopListData.get(position).getAnsShopBasic().getShopName());
        holder.tv_shop_time.setText("营业时间：" + ShopListData.get(position).getAnsShopBasic().getOpenTime() + "-" + ShopListData.get(position).getAnsShopBasic().getCloseTime());

        if (ShopListData.get(position).getAnsShopBasic().getShopLogo() == null || ShopListData.get(position).getAnsShopBasic().getShopLogo().equals("")) {
        } else {
            Glide.with(context).load(ShopListData.get(position).getAnsShopBasic().getShopLogo()).into(holder.iv_homepage_shop);
        }

        if (ShopListData.get(position).getAnsShopBasic().getGeoX() == null || ShopListData.get(position).getAnsShopBasic().getGeoY() == null ||

                ShopListData.get(position).getAnsShopBasic().getGeoX().equals("") || ShopListData.get(position).getAnsShopBasic().getGeoY().equals("")) {
            shop_lon = "0";
            shop_lat = "0";
            mine_lon = SP.get(context, SpContent.UserLon, "0") + "";
            mine_lat = SP.get(context, SpContent.UserLat, "0") + "";
        } else {

            mine_lon = SP.get(context, SpContent.UserLon, "0") + "";
            mine_lat = SP.get(context, SpContent.UserLat, "0") + "";
            shop_lon = ShopListData.get(position).getAnsShopBasic().getGeoX();
            shop_lat = ShopListData.get(position).getAnsShopBasic().getGeoY();
        }
        if (mine_lat.equals("0") || mine_lon.equals("0")) {
            holder.tv_homepage_distance.setVisibility(View.INVISIBLE);
        } else {
//        distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
//        holder.tv_homepage_distance.setText("相距 " + MD5.doubleToString(String.valueOf(distance)) + "km");
            //double d = Math.acos(Math.sin(Double.parseDouble(mine_lat)) * Math.sin(Double.parseDouble(shop_lat)) + Math.cos(Double.parseDouble(mine_lat)) * Math.cos(Double.parseDouble(shop_lat)) * Math.cos(Double.parseDouble(shop_lon) - Double.parseDouble(mine_lon)));

            double d=MapUtil.GetDistance(Double.parseDouble(mine_lat),Double.parseDouble(mine_lon),Double.parseDouble(shop_lat),Double.parseDouble(shop_lon));
            holder.tv_homepage_distance.setText("相距 " + MD5.doubleToString(String.valueOf(d)) + "km");
        }

        return convertView;

    }


    //就是View的持有
    public final class ViewHolder {
        TextView tv_shopName;
        TextView tv_shop_time;
        ImageView iv_homepage_shop;
        TextView tv_homepage_distance;
    }
}
