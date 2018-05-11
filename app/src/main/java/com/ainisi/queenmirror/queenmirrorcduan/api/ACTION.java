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

    int ALLOFMYORDER = 0x005;//获取我的全部订单
    int ADVERTISING=0x006;//首页banner广告
    int HEADLINES=0x007;//首页的女王头条
    int INDUSTRY=0x008;//首页的行业分类
    int MESSAGE=0x009;//首页的消息类型列表


}
