package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopSalesProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkRoomAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList = new ArrayList<>();

    public WorkRoomAdapter(Context context,List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList ) {
        this.context = context;
        this.apiGoodsList = apiGoodsList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return apiGoodsList.size();
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

            convertView = inflater.inflate(R.layout.re_workroom_short, parent, false);

            holder.tv_weorkroom_title = convertView.findViewById(R.id.tv_weorkroom_title);
            holder.tv_weorkroom_name = convertView.findViewById(R.id.tv_weorkroom_name);
            holder.tv_workroom_service_time = convertView.findViewById(R.id.tv_workroom_service_time);
            holder.tv_browse = convertView.findViewById(R.id.tv_browse);
            holder.tv_price = convertView.findViewById(R.id.tv_price);
            holder.tv_workroom_service_price = convertView.findViewById(R.id.tv_workroom_service_price);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv_weorkroom_title.setText(apiGoodsList.get(position).getEcGoodsBasic().getGoodsName());
        holder.tv_weorkroom_name.setText(apiGoodsList.get(position).getEcGoodsBasic().getGoodsBrief());
        holder.tv_workroom_service_time.setText(apiGoodsList.get(position).getEcGoodsBasic().getServiceTime());

        if(apiGoodsList.get(position).getEcGoodsBrowses() == null){
            holder.tv_browse.setText("浏览0次");
        }else{
            if(apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() == null){
                holder.tv_browse.setText("浏览0次");
            }else {
                holder.tv_browse.setText("浏览" + apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() + "次");
            }
        }

        holder.tv_price.setText("￥"+apiGoodsList.get(position).getEcGoodsBasic().getGoodsPrice());
        holder.tv_workroom_service_price.setText("￥"+apiGoodsList.get(position).getEcGoodsBasic().getOfflinePrice());
        holder.tv_workroom_service_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);

        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;
        private TextView tv_weorkroom_title;
        private TextView tv_weorkroom_name;
        private TextView tv_workroom_service_time;
        private TextView tv_browse;
        private TextView tv_price;
        private TextView tv_workroom_service_price;
    }
}
