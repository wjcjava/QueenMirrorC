package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopXinyongBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkCreditAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShopXinyongBean.BodyBean.ApiShopScoreListBean> apiShopScoreList = new ArrayList<>();

    public WorkCreditAdapter(Context context,List<ShopXinyongBean.BodyBean.ApiShopScoreListBean> apiShopScoreList) {
        this.context = context;
        this.apiShopScoreList = apiShopScoreList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 1;
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

            convertView = inflater.inflate(R.layout.re_workroom_credit, parent, false);

            holder.tv_work_credit = convertView.findViewById(R.id.tv_work_credit);
            holder.tv_score_score = convertView.findViewById(R.id.tv_score_score);
            holder.tv_score_environment = convertView.findViewById(R.id.tv_score_environment);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv_work_credit.setText(apiShopScoreList.get(0).getEcShopScore().getSumScore());
        holder.tv_score_score.setText(apiShopScoreList.get(0).getEcShopScore().getGoodsScore());
        holder.tv_score_environment.setText(apiShopScoreList.get(0).getEcShopScore().getShopScore());

        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;
        private TextView tv_work_credit;
        private TextView tv_score_score;
        private TextView tv_score_environment;
    }
}
