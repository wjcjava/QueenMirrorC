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
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkCreditAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    ShopXinyongBean.BodyBean.ApiShopScoreGetBean apiShopScoreGet = new ShopXinyongBean.BodyBean.ApiShopScoreGetBean();

    public WorkCreditAdapter(Context context,ShopXinyongBean.BodyBean.ApiShopScoreGetBean apiShopScoreGet) {
        this.context = context;
        this.apiShopScoreGet = apiShopScoreGet;
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
            holder.tv_work_order_time = convertView.findViewById(R.id.tv_work_order_time);
            holder.tv_score_attitude = convertView.findViewById(R.id.tv_score_attitude);
            holder.tv_score_environment = convertView.findViewById(R.id.tv_score_environment);
            holder.score_work_evaluate = convertView.findViewById(R.id.score_work_evaluate);
            holder.score_work_evaluate_two = convertView.findViewById(R.id.score_work_evaluate_two);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv_work_credit.setText(apiShopScoreGet.getComScore());
        holder.tv_work_order_time.setText("接单时间"+apiShopScoreGet.getAvgTakeMinutes()+"单");
        holder.tv_score_attitude.setText(apiShopScoreGet.getAvgService());
        holder.tv_score_environment.setText(apiShopScoreGet.getAvgEnvironment());

        holder.score_work_evaluate.setRating(Float.parseFloat(apiShopScoreGet.getAvgEnvironment()));
        holder.score_work_evaluate_two.setRating(Float.parseFloat(apiShopScoreGet.getAvgService()));
        return convertView;
    }

    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;
        private TextView tv_work_credit;
        private TextView tv_score_score;
        private TextView tv_score_environment;
        private TextView tv_work_order_time;
        private TextView tv_score_attitude;
        private CustomRatingBar score_work_evaluate,score_work_evaluate_two;
    }
}
