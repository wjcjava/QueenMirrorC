package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 作者： jl
 *
 */
public interface ACTION {
    int REGIST = 0x001;//注册

    int LOGIN = 0x002;//登陆

    int VERIFY=0x003;//获取验证码

    int LIST=0x004;//测试

    int ADVERTISING=0x005;//首页banner广告

    int HEADLINES=0x006;//首页的女王头条

    int INDUSTRY=0x007;//首页的行业分类

    int MESSAGE=0x008;//首页的消息类型列表

    int  MESSAGELIST=0x009;//首页消息列表

    int MYFOOT=0X010;//我的足迹

    int EVALUATION=0x011;//商品的评价数据

    int MERCHANTS=0x012;//商家的评价数据

    int REFUND=0x013;//获取退款列表

    int COMMENDGOODS=0x014;//商家推荐商品的数据

    int CLASSIFICATION=0x016;//商家分类列表

    int LABEL=0x017;//搜索标签信息

    int MERCHANTSLIST=0x018;//商家列表分类(接口失败)

    int ACTIVITYGOODS=0x019;//参与活动的商品列表

    int ACTIVITYSHOPS=0x020;//参与活动的商家列表

    int SHOPCARTADD=0x021;//加入购物车

    int MYCOMMENTS=0x22;//我的评论

    int SHOPDISCOUN=0x23;//商家优惠券

    int RECEIVEDISCOUN=0X24;//商家所领取优惠券

    int LISTFOEUSE=0x25;//可以优惠券列表（订单）

    int QUEENDETAILS=0x26;//女王卡详情

    int FORGOTPASSWORD=0x27;//忘记密码

    int PHONECHECK=0x28;//确认手机号是否已注册

    int COUPONGET=0x29;//优惠券领取

    int USERBIND=0x30;//客户端绑定第三方账号

    int PROBLEMLIST=0x31;//常见问题分类

    int PROBLEMDATA=0X32;

    int ALLOFMYORDER = 0x105;//获取我的全部订单

    int SHOPLIST = 0x106;//商城中商家列表

    int SHOPTUIJIANLIST = 0x107;//商家推荐商品列表

    int SHOPSALEPRODUCT = 0x108;//商家所卖商品列表

    int SHOPXINYONG = 0x109;//获取门店信用数据

    int SHOPDETAILDATA = 0x110;//获取商家具体信息

    int MINECOLLECTION = 0x111;//获取我的收藏

    int MINEINSHOP = 0x112;//获取我关注的店铺

    int GUANZHUSHOP = 0x113;//关注店铺

    int CANCELGUANZHUSHOP = 0x114;//取消关注店铺

    int JUBAOSHOP = 0x115;//举报商家

    int ADDLIULAN = 0x116;//商家浏览次数

    int ADDGOODSLIULAN = 0x117;//商品浏览次数增加

    int COLLECTIONPRODUCT = 0x118;//收藏商品

    int CANCELCOLLECTION = 0x119;//取消收藏商品

    int ADDTOCAT = 0x120;//加入购物车

    int GETCITYLIST = 0x121;//获取开通城市列表

    int GETPRODUCTDETAIL = 0x122;//商品详情

    int GETSHOPPINDCART = 0x123;//搜索购物车

    int CHANGENUMBERCART = 0x124;//改变购物车数量问题

    int DELETESHOPCART = 0x125;//删除购物车

    int CHANGEPASSWORD = 0x126;//修改密码

    int LOGINOUT = 0x127;//退出登录账号

    int CHANGENAME = 0x128;//用户修改用户名

    int GETNEWNEWS = 0x129;//获取新消息提示

    int CHECKOPENID = 0x130;//第三方登录检验openID

    int THIRDLOGINONE = 0x131;//第三方直接登录

    int UPLOADORDER = 0x132;//提交订单

    int PayBefore = 0x133;//支付之前调用

}
