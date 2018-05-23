package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class OrderPurchaseBean {

    String shopId;
    List<OrderDetailsListInfoBean> orderDetailsListInfo;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public List<OrderDetailsListInfoBean> getOrderDetailsListInfo() {
        return orderDetailsListInfo;
    }

    public void setOrderDetailsListInfo(List<OrderDetailsListInfoBean> orderDetailsListInfo) {
        this.orderDetailsListInfo = orderDetailsListInfo;
    }
}
