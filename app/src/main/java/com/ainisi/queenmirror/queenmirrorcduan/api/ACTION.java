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

    int MYCOMMENTS=0x022;//我的评论

    int SHOPDISCOUN=0x023;//商家优惠券

    int RECEIVEDISCOUN=0X024;//商家所领取优惠券

    int QUEENDETAILS=0x026;//女王卡详情

    int FORGOTPASSWORD=0x027;//忘记密码

    int PHONECHECK=0x028;//确认手机号是否已注册

    int COUPONGET=0x029;//优惠券领取

    int USERBIND=0x030;//客户端绑定第三方账号

    int PROBLEMLIST=0x031;//常见问题分类

    int PROBLEMDATA=0X032;

    int SPELLDETAILS=0x033;//拼单详情

    int SPELLCOLLECTION=0x034;//收藏拼单

    int MERCHANTACTIVITY=0x035;//商家活动（首页筛选）

    int MERCHANTFEATURES=0x036;//商家特色（首页筛选）

    int SETPAYPASS=0x37;//设置支付密码（我的余额）

    int AMENTPAY=0x38;//修改支付密码（我的余额）

    int FORGOTPAYPASS = 0x39;//忘记支付密码（我的余额）

    int TOUCHBALANCE=0X40;//余额明细

    int MYWALLIET=0x041;//我的余额

    int WHETHERPASS=0x042;//判断是否有支付密码

    int GOODLIST=0x43;//商品数据的列表

    int INVITEPRIZE=0x44;//(我的H5)邀请好友

    int INVITEBDUAN=0x45;//邀请开店

    int REALNAME=0x046;//实名认证

    int GETSHAPE=0X047;//获取图形验证码

    int NEWSHOPlIST=0x048;//获取今日新店列表

    int PAGEBANNER=0x049;//获取Banner信息数据

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

    int DOOUTDATA = 0x134;//退款

    int GETUSEYOUHUIQUAN = 0x135;//获取可用的优惠券

    int CANCLEORDER = 0x136;//取消订单

    int BEMEIYEREN = 0x137;//申请成为美业人

    int AliPayAfterRefresh = 0x138;//支付宝支付后调用

    int GETZXING = 0x139;//获取二维码内容

    int CONFIMSERVICE = 0x140;//完成服务

    int GETMINEMODOU = 0x141;//获取我的魔豆余额

    int GETMINEMODOUBEAN = 0x142;//获取我的魔豆列表

    int GETMONTHMODOU = 0x143;//魔豆按月支出收入

    int COMMENTPRO = 0x144;//商品评价

    int PAYUSENVWANGCARD = 0x145;//女王卡支付

    int QUEENCHARGE = 0x146;//女王卡支付宝充值

    int PAYAFTERREFRESH = 0x147;//女王卡充值后查看结果

    int PAYNOWINPAY = 0x148;//立即购买获取订单编号

    int PAYPASSWORDCHECK = 0x149;//支付密码判断是否存在

    int LISTFOEUSE=0x150;//可以优惠券列表（订单）

    int PAYINYUEDATA = 0x151;//余额支付

    int CommentReplyList = 0x152;//评价回复数据

    int COMMENTINPUT = 0x153;//评论回复

    int OSSGETTOKEN = 0x154;//获取OSStoken

    int WEBVIEWAGREEMENT = 0x155;//服务协议

    int TUANDUILISTDATA = 0x156;//我要拼团列表

}
