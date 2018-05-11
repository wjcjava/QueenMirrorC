package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 网络请求地址库
 * 作者： jl
 */

public interface UrlConstants {

    // String BASE_URL = "http://116.62.204.235:8080/";
    String BASE_URL = "http://192.168.50.194:8080/wg/a/";//测试路径
    String ADVERTISING = "api/ec/common/advertisementList";//首页banner广告

    String HEADLINES = "api/ec/common/topList";//首页的女王头条

    String INDUSTRY = "api/ec/common/categoryList";//首页的行业分类

    String MESSAGE = "api/ec/message/messageTypeList";//首页的消息类型列表

    String MESSAGELIST="api/ec/message/messageList";//首页的消息列表

    String REGIST = "api/ans/login/userRegister";//请求方法名(注册)

    String VERIFY = "api/ans/login/verifyCodeGet";//请求方法名(获取验证码)

    String LOGIN = "userinfoApi/userLogin";

    String LIST = "api/ans/refund/refundApplyList";//测试（listce测试）

    String ALLOFMYORDER = "api/ans/order/orderList";//获取我的全部订单

    String SHOPLIST = "api/ans/shop/list";//商城中商家列表

    String SHOPTUIJIANLIST = "api/ans/shop/recommendGoodsList";//商家推荐商品列表

    String SHOPSALEPRODUCT = "api/ans/shop/shopGoodsList";//商家所卖商品列表

    String SHOPXINYONG = "api/ans/shop/shopScoreGet";//获取门店信用数据

    String SHOPDETAILDATA = "api/ans/shop/details";//获取商家具体信息

    String MINECOLLECTION = "api/ans/cust/userCollectList";//获取我的收藏列表


    String MINEINSHOP = "api/ans/cust/userFollowList";//获取我关注的店铺

    String GUANZHUSHOP = "api/ans/shop/followShop";//关注店铺

    String CANCELGUANZHUSHOP = "api/ans/shop/unFollowShop";//取消关注店铺

    String JUBAOSHOP = "api/ans/shop/complainShop";//举报商家

}
