package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_purchase, parent, false);

            holder.li_purchase_product = convertView.findViewById(R.id.li_purchase_product);
            holder.purchase_shop_name = convertView.findViewById(R.id.purchase_shop_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        L.e("####    "+shopList.get(position).getShopName());
        holder.purchase_shop_name.setText(shopList.get(position).getShopName());

        for(int i = 0;i<shopList.get(position).getApiAnsCustCartList().size();i++) {
            // 2、获取组件，设置组件属性
            View _view = LayoutInflater.from(context).inflate(R.layout.layout_upload_product, null);
            // 3、在布局中添加组件，设置组件属性
            holder.li_purchase_product.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            TextView tv_purchase_name = _view.findViewById(R.id.tv_purchase_name);
            tv_purchase_name.setText(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getGoodsName());

            TextView tv_purchase_presentprice = _view.findViewById(R.id.tv_purchase_presentprice);
            tv_purchase_presentprice.setText("￥"+shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getGoodsPrice());

            TextView tv_purchase_originalprice = _view.findViewById(R.id.tv_purchase_originalprice);
            tv_purchase_originalprice.setText("￥"+shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getOfflinePrice());
            tv_purchase_originalprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线

            TextView tv_purchase_adapter_number = _view.findViewById(R.id.tv_purchase_adapter_number);
            tv_purchase_adapter_number.setText("X"+shopList.get(position).getApiAnsCustCartList().get(i).getAnsCustCart().getPurchaseNumber());
        }
        return convertView;

    }


    //就是View的持有
    public final class ViewHolder {

        private LinearLayout li_purchase_product;
        private TextView purchase_shop_name;
    }
}
