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
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ShopMallAdapter extends BaseAdapter{

    private Context context;
    List<ShopBean> ShopListData = new ArrayList<>();

    public ShopMallAdapter(Context context,List<ShopBean> ShopListData) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.re_shopmall_shop, parent, false);
            holder.image_title = convertView.findViewById(R.id.image_title);
            holder.text_name = convertView.findViewById(R.id.text_name);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.text_name.setText(ShopListData.get(position).getTextName());

        Glide.with(context).load(ShopListData.get(position).getImageTitle()).into(holder.image_title);
        return convertView;

    }
    //就是View的持有
    public final class ViewHolder{
        ImageView image_title;
        TextView text_name;
    }
}
