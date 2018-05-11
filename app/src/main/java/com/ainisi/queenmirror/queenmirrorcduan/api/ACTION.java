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

}
