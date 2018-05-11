package com.ainisi.queenmirror.queenmirrorcduan.api;

/**
 * 网络请求地址库
 * 作者： jl
 */

public interface UrlConstants {

    // String BASE_URL = "http://116.62.204.235:8080/";

    String BASE_URL = "http://192.168.50.194:8080/wg/a";//测试路径
    String REGIST = "/api/ans/login/userRegister";//请求方法名(注册)
    String VERIFY = "/api/ans/login/verifyCodeGet";//请求方法名(获取验证码)
    String LOGIN = "userinfo/api/userLogin";
    String LIST = "/api/ans/refund/refundApplyList";//测试（listce测试）
    String ALLOFMYORDER = "/api/ans/order/orderList";//获取我的全部订单
    String ADVERTISING = "/api/ec/common/advertisementList";//首页banner广告
    String HEADLINES = "/api/ec/common/topList";//首页的女王头条
    String INDUSTRY = "/api/ec/common/categoryList";//首页的行业分类
    String MESSAGE="/api/ec/message/messageTypeList";//首页的消息类型列表
}
