package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.CouponGetBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkShopAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<ShopDiscounBean.BodyBean.CouponListDataBean> list;
    private Context context;
    private CouponGetBean couponGetBean;


    public WorkShopAdapter(Context context, List<ShopDiscounBean.BodyBean.CouponListDataBean> list) {
        this.context = context;
        this.list = list;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.re_workroom_coupon, parent, false);
            holder.counName = convertView.findViewById(R.id.tv_shop_discount);
            holder.couneMoney = convertView.findViewById(R.id.tv_shop_money);
            holder.couneConditions = convertView.findViewById(R.id.tv_coune_conditions);
            holder.couneTime = convertView.findViewById(R.id.tv_coune_time);
            holder.img_overdue = convertView.findViewById(R.id.img_overdue);
            holder.re_workroom = convertView.findViewById(R.id.re_workroom);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.counName.setText(list.get(position).getCpCreateInfo().getCpName());
        holder.couneMoney.setText(list.get(position).getCpCreateInfo().getReduceAmount() + "元");
        holder.couneConditions.setText(list.get(position).getCpCreateInfo().getCpUsing());
        holder.couneTime.setText(list.get(position).getCpCreateInfo().getCreateTime());
        holder.img_overdue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               holder.inithttp(position);
            }
        });

        return convertView;
    }
    //就是View的持有
    public final class ViewHolder implements HttpCallBack {
        TextView counName;
        TextView couneMoney;
        TextView couneConditions;
        TextView couneTime;
        ImageView img_overdue;
        RelativeLayout re_workroom;

        public void inithttp(int position) {
            HashMap<String, String> params = new HashMap<>();
            params.put("cpId", list.get(position).getCpCreateInfo().getId());//优惠券ID
            params.put("userId", SP.get(context, SpContent.UserId,"")+"");//用户ID
            params.put("shopId", list.get(position).getCpCreateInfo().getShopId());//商品ID
            HttpUtils.doPost(ACTION.COUPONGET, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        }

        @Override
        public void onSuccess(int action, String res) throws WriterException {
            switch (action) {
                case ACTION.COUPONGET:
                    couponGetBean = GsonUtil.toObj(res, CouponGetBean.class);
                    if (couponGetBean.isSuccess()) {
                        couponGetBean.getErrorCode();
                        if(couponGetBean.getErrorCode().equals("1")){

                            img_overdue.setImageResource(R.drawable.icon_shop_receive);
                            re_workroom.setBackgroundResource(R.color.alpha_55_black);
                        }else {
                            T.show("您已成功领取优惠券");
                            img_overdue.setImageResource(R.drawable.icon_shop_receive);
                            re_workroom.setBackgroundResource(R.drawable.button_shap_queen);
                        }

                    } else {
                        T.show(couponGetBean.getMsg());
                    }
                    break;
            }
        }

        @Override
        public void showLoadingDialog() {

        }

        @Override
        public void showErrorMessage(String s) {

        }

    }
}
