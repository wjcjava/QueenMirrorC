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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseSelectActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class  PurchaseListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShoppingCartBean.BodyBean.ShopListBean> shopList = new ArrayList<>();

    int flag = 0;

    private boolean moudou = false;

    public PurchaseListViewAdapter(Context context,List<ShoppingCartBean.BodyBean.ShopListBean> shopList) {
        this.context = context;
        this.shopList = shopList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return shopList.size();
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
            convertView = inflater.inflate(R.layout.item_purchase, parent, false);
            holder.li_purchase_product = convertView.findViewById(R.id.li_purchase_product);
            holder.purchase_shop_name = convertView.findViewById(R.id.purchase_shop_name);
            holder.rl_purchase_select = convertView.findViewById(R.id.rl_purchase_select);
            holder.tv_pur_youhui = convertView.findViewById(R.id.tv_pur_youhui);
            holder.tv_pur_modou = convertView.findViewById(R.id.tv_pur_modou);
            holder.tv_pur_selectname = convertView.findViewById(R.id.tv_pur_selectname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(flag < shopList.size()){
            for(int i = 0;i<shopList.get(position).getApiAnsCustCartList().size();i++) {
                // 2、获取组件，设置组件属性
                View _view = LayoutInflater.from(context).inflate(R.layout.layout_upload_product, null);
                // 3、在布局中添加组件，设置组件属性
                holder.li_purchase_product.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                TextView tv_purchase_name = _view.findViewById(R.id.tv_purchase_name);
                tv_purchase_name.setText(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getGoodsName());
                TextView tv_purchase_presentprice = _view.findViewById(R.id.tv_purchase_presentprice);
                tv_purchase_presentprice.setText("￥"+shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getSalesPrice());
                TextView tv_purchase_originalprice = _view.findViewById(R.id.tv_purchase_originalprice);
                tv_purchase_originalprice.setText("￥"+shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getMarketPrice());
                tv_purchase_originalprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
                TextView tv_purchase_adapter_number = _view.findViewById(R.id.tv_purchase_adapter_number);
                tv_purchase_adapter_number.setText("X"+shopList.get(position).getApiAnsCustCartList().get(i).getAnsCustCart().getPurchaseNumber());
            }
            flag++;
        }else{

        }

        holder.purchase_shop_name.setText(shopList.get(position).getShopName());
        holder.tv_pur_youhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 这里是点击优惠券
                 */
                if(moudou){
                    //true代表现在是在魔豆
                    holder.tv_pur_selectname.setText("请选择优惠券");
                    moudou = false;
                    holder.tv_pur_youhui.setBackground(context.getResources().getDrawable(R.drawable.back_pur_right_select));
                    holder.tv_pur_youhui.setTextColor(context.getResources().getColor(R.color.alpha_85_black));
                    holder.tv_pur_modou.setBackground(context.getResources().getDrawable(R.drawable.back_pur_select));
                    holder.tv_pur_modou.setTextColor(context.getResources().getColor(R.color.white));
                }else{
                    //flase代表现在在优惠券
                }
            }
        });
        holder.tv_pur_modou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 这里是点击魔豆
                 */
                if(moudou){
                    //true代表现在是在魔豆
                }else{
                    //flase代表现在在优惠券
                    holder.tv_pur_selectname.setText("请选择抵扣商品");
                    moudou = true;
                    holder.tv_pur_youhui.setTextColor(context.getResources().getColor(R.color.white));
                    holder.tv_pur_modou.setTextColor(context.getResources().getColor(R.color.alpha_85_black));
                    holder.tv_pur_youhui.setBackground(context.getResources().getDrawable(R.drawable.back_pur_select));
                    holder.tv_pur_modou.setBackground(context.getResources().getDrawable(R.drawable.back_pur_right_select));
                }
            }
        });
        holder.rl_purchase_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 这里是去跳转选择优惠券或魔豆的页面
                 */
                if(moudou){
                    /**
                     * 代表选择的是魔豆
                     */
                    String goodsIds = "";

                    for(int i=0;i<shopList.get(position).getApiAnsCustCartList().size();i++){
                        goodsIds = goodsIds + shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getId() + ",";
                    }
                    Intent intent = new Intent(context,PurchaseSelectActivity.class);
                    intent.putExtra("shopId",shopList.get(position).getId());
                    intent.putExtra("goodsIds",goodsIds);
                    context.startActivity(intent);
                }else{
                    /**
                     * 代表选择的是优惠券
                     */
                    String goodsIds = "";
                    for(int i=0;i<shopList.get(position).getApiAnsCustCartList().size();i++){
                        goodsIds = goodsIds + shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getId() + ",";
                    }
                    Intent intentP = new Intent(context,PurchaseSelectActivity.class);
                    intentP.putExtra("shopId",shopList.get(position).getId().toString()+"");
                    intentP.putExtra("goodsIds",goodsIds.substring(0,goodsIds.length()-1)+"");
                    context.startActivity(intentP);
                }
            }
        });
        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {

        private LinearLayout li_purchase_product;
        private TextView purchase_shop_name;
        private RelativeLayout rl_purchase_select;//选择优惠券
        private TextView tv_pur_youhui;
        private TextView tv_pur_modou;
        private TextView tv_pur_selectname;
    }
}
