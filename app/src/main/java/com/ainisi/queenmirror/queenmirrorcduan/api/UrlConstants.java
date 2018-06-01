package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 网络请求地址库
 * 作者： jl
 */

public interface UrlConstants {

 // String BASE_URL = "http://116.62.204.235:8080/";
// String BASE_URL = "http://192.168.50.145:8080/wg/a/";//测试路径     张作西

String BASE_URL = "http://192.168.30.155:7080/wg/a/";

 String ADVERTISING = "api/ec/common/advertisementList";//首页banner广告

 String HEADLINES = "api/ec/common/topList";//首页的女王头条

 String INDUSTRY = "api/ec/common/categoryList";//首页的行业分类

 String MESSAGE = "api/ec/message/messageTypeList";//首页的消息类型列表

 String MESSAGELIST="api/ec/message/messageList";//首页的消息列表

 String REGIST = "api/ans/login/userRegister";//请求方法名(注册)

 String VERIFY = "api/ans/login/verifyCodeGet";//请求方法名(获取验证码)

 String LOGIN = "api/ans/login/userLogin";//登录

 String LIST = "api/ans/refund/refundApplyList";//测试（listce测试）

 String ALLOFMYORDER = "api/ans/order/orderListOnly";//获取我的全部订单

 String SHOPLIST = "api/ans/shop/list";//商城中商家列表

 String SHOPTUIJIANLIST = "api/ans/shop/recommendGoodsList";//商家推荐商品列表

 String SHOPSALEPRODUCT = "api/ans/shop/shopGoodsList";//商家所卖商品列表

 String SHOPXINYONG = "api/ans/shop/shopScoreGet";//获取门店信用数据

 String SHOPDETAILDATA = "api/ans/shop/details";//获取商家具体信息

 String MINECOLLECTION = "api/ans/cust/userCollectList";//获取我的收藏列表

 String MYFOOT="api/ans/cust/userViewList";//我的足迹

 String EVALUATION="api/ec/goods/goodsCommentsList";//商品的评价数据

 String MERCHANTS="api/ans/shop/shopCommentsList";//商家的评价数据

 String CLASSIFICATION="api/ans/shop/shoplistByCategory";//商家分类列表

 String MINEINSHOP = "api/ans/cust/userFollowList";//获取我关注的店铺

 String GUANZHUSHOP = "api/ans/shop/followShop";//关注店铺

 String CANCELGUANZHUSHOP = "api/ans/shop/unFollowShop";//取消关注店铺

 String JUBAOSHOP = "api/ans/shop/complainShop";//举报商家

 String REFUND="api/ans/refund/refundApplyList";//获取退款列表

 String COMMENDGOODS="api/ans/shop/recommendGoodsList";//商家推荐商品的数据

 String ADDLIULAN = "api/ec/goods/shopBrowsesChange";//商家浏览次数增加

 String ADDGOODSLIULAN = "api/ec/goods/goodsBrowsesChange";//商品浏览次数增加

 String COLLECTIONPRODUCT = "api/ec/goods/collectGoods";//收藏商品

 String CANCELCOLLECTION = "api/ec/goods/unCollectGoods";//取消收藏商品

 String LABEL="api/ec/common/tabList";//搜索标签信息

 String  MERCHANTSLIST="api/ans/shop/recommendListByCondition";//商家列表分类

 String ACTIVITYGOODS="api/ec/common/goodsListByActivity";//商品活动列表

 String ACTIVITYSHOPS="api/ec/common/shopListByActivity";//参与活动的商家列表

 String SHOPCARTADD="api/ans/cart/shopCartAdd";//加入购物车

 String ADDTOCAT = "api/ans/cart/shopCartAdd";//加入购物车

 String GETCITYLIST = "api/ec/city/cityList";//获取城市列表

 String GETPRODUCTDETAIL = "api/ec/goods/details";//获取商品详情

 String GETSHOPPINDCART = "api/ans/cart/shopCartGet";//搜索购物车

 String CHANGENUMBERCART = "api/ans/cart/shopCartNumEdit";//改变购物车数量

 String DELETESHOPCART = "api/ans/cart/shopCartDelete";//删除购物车

 String MYCOMMENTS="api/ans/cust/userCommentsList";//我的评论

 String CHANGEPASSWORD = "api/ans/login/userModifyPass";//修改密码

 String LOGINOUT = "api/ans/login/userlogout";//退出登录账号

 String CHANGENAME = "api/ans/cust/userNameModify";//用户修改用户名

 String GETNEWNEWS = "api/ec/message/newMessageAlert";//获取新消息提示

 String CHECKOPENID = "api/ans/login/snsShopOpenIdCheck";//第三方登录检验OpenId

 String THIRDLOGINONE = "api/ans/login/snsUserLogin";//第三方直接登录

 String SHOPDISCOUN="api/ans/coupon/couponList";//商家优惠券

 String RECEIVEDISCOUN="api/ans/coupon/custCouponList";//商家所领取优惠券

 String LISTFOEUSE="api/ans/coupon/couponListForUse";//可以优惠券列表（订单）

 String QUEENDETAILS="api/ans/queen/queenCardDetails";//女王卡详情

 String UPLOADORDER = "api/ans/order/orderSubmit";//提交订单

 String PHONECHECK="api/ans/login/phoneCheck";//确认手机号是否已注册

 String FORGOTPASSWORD="api/ans/login/userForgotPass";//忘记密码

 String COUPONGET="api/ans/coupon/couponGet";//优惠券领取

 String USERBIND="api/ans/login/snsUserBindingAccount";//客户端绑定第三方账号

 String PROBLEMLIST="api/ec/help/questionCategoryList";//常见问题分类

 String PROBLEMDATA="api/ec/help/questionListByCategory";//常见问题分类的数据

 String PayBefore = "api/util/pay/aliPay";//支付之前调用数据

 String DOOUTDATA = "api/util/pay/aliPayRefund";//退款

 String GETUSEYOUHUIQUAN = "api/ans/coupon/couponListForUse";//获取可用的优惠券

 String CANCLEORDER = "api/ans/order/custOrderCancel";//取消订单
}
