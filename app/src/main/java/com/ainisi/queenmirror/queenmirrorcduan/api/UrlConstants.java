package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 网络请求地址库
 * 作者： jl
 */

public interface UrlConstants {

    // String BASE_URL = "http://116.62.204.235:8080/";

    //String BASE_URL = "http://192.168.50.145:8080/wg/a/";//测试路径     张作西

    //String BASE_URL = "http://192.168.50.137:8080/wg/a/";//测试路径    刘璇

    //String BASE_URL = "http://192.168.50.130:8080/wg/a/";//

    String BASE_URL = "http://192.168.50.32:8080/a/api/";//拼团测试

    //String BASE_URL = "http://192.168.30.155:7080/wg/a/api/";

    //String BASE_URL = "http://58.210.102.70:7080/wg/a/";

    String ADVERTISING = "ec/common/advertisementList";//首页banner广告

    String HEADLINES = "ec/common/topList";//首页的女王头条

    String INDUSTRY = "ec/common/categoryList";//首页的行业分类

    String MESSAGE = "ec/message/messageTypeList";//首页的消息类型列表

    String MESSAGELIST="ec/message/messageList";//首页的消息列表

    String REGIST = "ans/login/userRegister";//请求方法名(注册)

    String VERIFY = "ans/login/verifyCodeGet";//请求方法名(获取验证码)

    String LOGIN = "ans/login/userLogin";//登录

    String LIST = "ans/refund/refundApplyList";//测试（listce测试）

    String ALLOFMYORDER = "ans/order/orderListOnly";//获取我的全部订单

    String SHOPLIST = "ans/shop/list";//商城中商家列表

    String SHOPTUIJIANLIST = "ans/shop/recommendGoodsList";//商家推荐商品列表

    String SHOPSALEPRODUCT = "ans/shop/shopGoodsList";//商家所卖商品列表

    String SHOPXINYONG = "ans/shop/shopScoreGet";//获取门店信用数据

    String SHOPDETAILDATA = "ans/shop/details";//获取商家具体信息

    String MINECOLLECTION = "ans/cust/userCollectList";//获取我的收藏列表

    String MYFOOT="ans/cust/userViewList";//我的足迹

    String EVALUATION="ec/goods/goodsCommentsList";//商品的评价数据

    String MERCHANTS="ans/shop/shopCommentsList";//商家的评价数据

    String CLASSIFICATION="ans/shop/shoplistByCategory";//商家分类列表

    String MINEINSHOP = "ans/cust/userFollowList";//获取我关注的店铺

    String GUANZHUSHOP = "ans/shop/followShop";//关注店铺

    String CANCELGUANZHUSHOP = "ans/shop/unFollowShop";//取消关注店铺

    String JUBAOSHOP = "ans/shop/complainShop";//举报商家

    String REFUND="ans/refund/refundApplyList";//获取退款列表

    String COMMENDGOODS="ans/shop/recommendGoodsList";//商家推荐商品的数据

    String ADDLIULAN = "ec/goods/shopBrowsesChange";//商家浏览次数增加

    String ADDGOODSLIULAN = "ec/goods/goodsBrowsesChange";//商品浏览次数增加

    String COLLECTIONPRODUCT = "ec/goods/collectGoods";//收藏商品

    String CANCELCOLLECTION = "ec/goods/unCollectGoods";//取消收藏商品

    String LABEL="ec/common/tabList";//搜索标签信息

    String  MERCHANTSLIST="ans/shop/recommendListByCondition";//商家列表分类

    String ACTIVITYGOODS="ec/common/goodsListByActivity";//商品活动列表

    String ACTIVITYSHOPS="ec/common/shopListByActivity";//参与活动的商家列表

    String SHOPCARTADD="ans/cart/shopCartAdd";//加入购物车

    String ADDTOCAT = "ans/cart/shopCartAdd";//加入购物车

    String GETCITYLIST = "ec/city/cityList";//获取城市列表

    String GETPRODUCTDETAIL = "ec/goods/details";//获取商品详情

    String GETSHOPPINDCART = "ans/cart/shopCartGet";//搜索购物车

    String CHANGENUMBERCART = "ans/cart/shopCartNumEdit";//改变购物车数量

    String DELETESHOPCART = "ans/cart/shopCartDelete";//删除购物车

    String MYCOMMENTS="ans/cust/userCommentsList";//我的评论

    String CHANGEPASSWORD = "ans/login/userModifyPass";//修改密码

    String LOGINOUT = "ans/login/userlogout";//退出登录账号

    String CHANGENAME = "ans/cust/userNameModify";//用户修改用户名

    String GETNEWNEWS = "ec/message/newMessageAlert";//获取新消息提示

    String CHECKOPENID = "ans/login/snsShopOpenIdCheck";//第三方登录检验OpenId

    String THIRDLOGINONE = "ans/login/snsUserLogin";//第三方直接登录

    String SHOPDISCOUN="ans/coupon/couponList";//商家优惠券

    String RECEIVEDISCOUN="ans/coupon/custCouponList";//商家所领取优惠券

    String LISTFOEUSE="ans/coupon/couponListForUse";//可以优惠券列表（订单）

    String QUEENDETAILS="ans/queen/queenCardDetails";//女王卡详情

    String UPLOADORDER = "ans/order/orderSubmit";//提交订单

    String PHONECHECK="ans/login/phoneCheck";//确认手机号是否已注册

    String FORGOTPASSWORD="ans/login/userForgotPass";//忘记密码

    String COUPONGET="ans/coupon/couponGet";//优惠券领取

    String USERBIND="ans/login/snsUserBindingAccount";//客户端绑定第三方账号

    String PROBLEMLIST="ec/help/questionCategoryList";//常见问题分类

    String PROBLEMDATA="ec/help/questionListByCategory";//常见问题分类的数据

    String PayBefore = "util/alipay/orderAliPay";//支付之前调用数据

    String DOOUTDATA = "util/pay/aliPayRefund";//退款

    String GETUSEYOUHUIQUAN = "ans/coupon/couponListForUse";//获取可用的优惠券

    String SPELLDETAILS="ans/group/groupActivityDetails";//拼单详情

    String SPELLCOLLECTION="ans/group/collectGroup";//收藏拼单

    String CANCLEORDER = "ans/order/custOrderCancel";//取消订单

    String BEMEIYEREN = "ec/beauty/beautyApply";//申请成为美业人

    String AliPayAfterRefresh = "util/alipay/orderAliPayAfterRefresh";//订单支付宝支付后结果查询

    String MERCHANTACTIVITY="ec/common/activityList";//商家活动（首页筛选）

    String MERCHANTFEATURES="ec/common/featureList";//商家特色（首页筛选）

    String GETZXING = "ans/order/custOrderQrGet";//获取二维码内容

    String CONFIMSERVICE = "ans/order/custOrderConfirm";//完成服务

    String GETMINEMODOU = "ans/points/pointsNowGet";//获取我的魔豆余额

    String GETMINEMODOUBEAN = "ans/points/pointsChargeListByTime";//获取我的魔豆列表

    String GETMONTHMODOU = "ans/points/pointsChargeSumByMonth";//魔豆按月支出收入

    String COMMENTPRO ="ec/goods/goodsCommentsSubmit";//商品评价

    String PAYUSENVWANGCARD = "util/pay/orderQueenCardPay";//女王卡支付

    String WHETHERPASS="util/pay/payPassCheck"; //判断是否有支付密码

    String MYWALLIET="ans/cust/myWallet";//我的余额

    String TOUCHBALANCE="ans/cust/myWalletChargeList";//余额明细

    String FORGOTPAYPASS="ans/cust/forgotPayPass";//忘记支付密码

    String AMENTPAY="ans/cust/modifyPayPass";//修改支付密码

    String SETPAYPASS="ans/cust/setPayPass";//设置支付密码

    String QUEENCHARGE ="util/alipay/queenChargeAliPay";//女王卡支付宝充值

    String PAYAFTERREFRESH = "util/alipay/queenChargeAliPayAfterRefresh";//女王卡充值后查看结果

    String GOODLIST="ec/goods/list";//商品数据的列表

    String PAYNOWINPAY = "ans/order/purchaseNow";//立即付款获取订单编号

    String PAYPASSWORDCHECK = "util/pay/payPassCheck";//支付密码判断是否存在

    String PAYINYUEDATA = "util/pay/orderOwnAccountPay";//余额支付订单

    String CommentReplyList = "ec/goods/goodsCommentReplyList";//商品评价回复数据

    String INVITEPRIZE = "ans/login/inviteUrlGenForC";//(我的H5)邀请有奖

    String INVITEBDUAN="ans/login/inviteUrlGenForB";//邀请开店

    String REALNAME="ans/cust/userNameAuth";//实名认证

    String COMMENTINPUT = "ec/goods/goodsCommentsReply";//评论回复

    String OSSGETTOKEN = "ans/oss/securityTokenApply";

    String WEBVIEWAGREEMENT = "ans/protocal/query";//服务协议

    String TUANDUILISTDATA = "ans/group/groupActivityList";//我要拼团列表
}
