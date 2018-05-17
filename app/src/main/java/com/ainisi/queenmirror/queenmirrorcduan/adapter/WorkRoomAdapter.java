package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopSalesProduct;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkRoomAdapter extends BaseAdapter implements HttpCallBack{
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
    public View getView(final int position, View convertView, ViewGroup parent) {

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
            holder.iv_workroom_add_cat = convertView.findViewById(R.id.iv_workroom_add_cat);
            holder.rl_workroom_list = convertView.findViewById(R.id.rl_workroom_list);

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

        holder.iv_workroom_add_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCatData();
            }
        });

        holder.rl_workroom_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullActivity.class);
                L.e("!@@@@@@@@@@@@@@"+apiGoodsList.get(position).getId()+"");

                intent.putExtra("goodsId",apiGoodsList.get(position).getEcGoodsBasic().getId()+"");
                intent.putExtra("shopId",apiGoodsList.get(position).getEcGoodsBasic().getShopId()+"");
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    /**
     * 添加购物车
     */
    private void AddCatData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", "111");//
        params.put("goodsId", "0b5e8db1e94b4c44b3075940bc67a2e9");
        params.put("unitPrice","20");
        params.put("purchaseNumber","1");
        HttpUtils.doPost(ACTION.ADDTOCAT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.ADDTOCAT:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.isSuccess()){
                    T.show(successBean.getMsg());
                }else{
                    T.show(successBean.getMsg());
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


    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;
        private TextView tv_weorkroom_title;
        private TextView tv_weorkroom_name;
        private TextView tv_workroom_service_time;
        private TextView tv_browse;
        private TextView tv_price;
        private TextView tv_workroom_service_price;
        private ImageView iv_workroom_add_cat;
        private RelativeLayout rl_workroom_list;
    }
}
