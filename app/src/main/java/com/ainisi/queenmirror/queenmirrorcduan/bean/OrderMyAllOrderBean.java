package com.ainisi.queenmirror.queenmirrorcduan.bean;


import java.io.Serializable;
import java.util.List;

public class OrderMyAllOrderBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pageSum":6,"apiOrderList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"1111","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"53f4f9379e814445882590e3686d33d0","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"444","unitPrice":"111.00","purchaseNumber":"4","sumAmount":"444.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"7e09c1ffabe549e4885407ff220f45e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"222","unitPrice":"111.00","purchaseNumber":"2","sumAmount":"222.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"222","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 09:49:48","goodsCate":"美容美体","goodsType":"0","goodsName":"测试46","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"9","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"97e3fa580e5b44799639372a29ab30d7","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:01","updateDate":"2018-05-04 11:29:01","orderId":"1111","goodsId":"555","unitPrice":"111.00","purchaseNumber":"5","sumAmount":"555.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"555","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试412","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"33.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a9e47","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"333","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:14:46","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null}]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":"美业","industryCateLabel":"美业","businessFlagLabel":"正常","enableFlagLabel":"无效"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"2222","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11285916","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":666,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"3333","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"OC","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"4444","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"FN","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"5555","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"RF","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"6666","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"OR","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}]}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyBean body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean implements Serializable{
        /**
         * pageSum : 6
         * apiOrderList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"1111","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"53f4f9379e814445882590e3686d33d0","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"444","unitPrice":"111.00","purchaseNumber":"4","sumAmount":"444.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"7e09c1ffabe549e4885407ff220f45e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"222","unitPrice":"111.00","purchaseNumber":"2","sumAmount":"222.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"222","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 09:49:48","goodsCate":"美容美体","goodsType":"0","goodsName":"测试46","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"9","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"97e3fa580e5b44799639372a29ab30d7","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:01","updateDate":"2018-05-04 11:29:01","orderId":"1111","goodsId":"555","unitPrice":"111.00","purchaseNumber":"5","sumAmount":"555.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"555","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试412","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"33.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a9e47","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"333","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:14:46","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null}]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":"美业","industryCateLabel":"美业","businessFlagLabel":"正常","enableFlagLabel":"无效"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"2222","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11285916","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":666,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"3333","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"OC","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"4444","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"FN","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"5555","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"RF","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"6666","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"OR","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}]
         */

        private int pageSum;
        private List<ApiOrderListBean> apiOrderList;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<ApiOrderListBean> getApiOrderList() {
            return apiOrderList;
        }

        public void setApiOrderList(List<ApiOrderListBean> apiOrderList) {
            this.apiOrderList = apiOrderList;
        }

        public static class ApiOrderListBean implements Serializable{
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansOrder : {"id":"1111","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"nullnull11290052","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"orderAmount":1665,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"53f4f9379e814445882590e3686d33d0","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"444","unitPrice":"111.00","purchaseNumber":"4","sumAmount":"444.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"7e09c1ffabe549e4885407ff220f45e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"222","unitPrice":"111.00","purchaseNumber":"2","sumAmount":"222.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"222","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 09:49:48","goodsCate":"美容美体","goodsType":"0","goodsName":"测试46","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"9","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"97e3fa580e5b44799639372a29ab30d7","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:01","updateDate":"2018-05-04 11:29:01","orderId":"1111","goodsId":"555","unitPrice":"111.00","purchaseNumber":"5","sumAmount":"555.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"555","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试412","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"33.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a9e47","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"333","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:14:46","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null}]}
             * ansOrderDetails : null
             * ecGoodsBasic : null
             * ansShopBasic : {"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"}
             * ansCustBasic : null
             * paymentMethodLabel : null
             * orderStatusLabel : null
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * saleFlagLabel : null
             * shopCateLabel : 美业
             * industryCateLabel : 美业
             * businessFlagLabel : 正常
             * enableFlagLabel : 无效
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsOrderBean ansOrder;
            private Object ansOrderDetails;
            private Object ecGoodsBasic;
            private AnsShopBasicBeanX ansShopBasic;
            private Object ansCustBasic;
            private Object paymentMethodLabel;
            private Object orderStatusLabel;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private Object saleFlagLabel;
            private String shopCateLabel;
            private String industryCateLabel;
            private String businessFlagLabel;
            private String enableFlagLabel;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
            }

            public Object getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(Object updateDate) {
                this.updateDate = updateDate;
            }

            public AnsOrderBean getAnsOrder() {
                return ansOrder;
            }

            public void setAnsOrder(AnsOrderBean ansOrder) {
                this.ansOrder = ansOrder;
            }

            public Object getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(Object ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public Object getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(Object ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public AnsShopBasicBeanX getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBeanX ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public Object getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(Object ansCustBasic) {
                this.ansCustBasic = ansCustBasic;
            }

            public Object getPaymentMethodLabel() {
                return paymentMethodLabel;
            }

            public void setPaymentMethodLabel(Object paymentMethodLabel) {
                this.paymentMethodLabel = paymentMethodLabel;
            }

            public Object getOrderStatusLabel() {
                return orderStatusLabel;
            }

            public void setOrderStatusLabel(Object orderStatusLabel) {
                this.orderStatusLabel = orderStatusLabel;
            }

            public Object getGoodsCateLabel() {
                return goodsCateLabel;
            }

            public void setGoodsCateLabel(Object goodsCateLabel) {
                this.goodsCateLabel = goodsCateLabel;
            }

            public Object getGoodsTypeLabel() {
                return goodsTypeLabel;
            }

            public void setGoodsTypeLabel(Object goodsTypeLabel) {
                this.goodsTypeLabel = goodsTypeLabel;
            }

            public Object getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(Object saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public String getShopCateLabel() {
                return shopCateLabel;
            }

            public void setShopCateLabel(String shopCateLabel) {
                this.shopCateLabel = shopCateLabel;
            }

            public String getIndustryCateLabel() {
                return industryCateLabel;
            }

            public void setIndustryCateLabel(String industryCateLabel) {
                this.industryCateLabel = industryCateLabel;
            }

            public String getBusinessFlagLabel() {
                return businessFlagLabel;
            }

            public void setBusinessFlagLabel(String businessFlagLabel) {
                this.businessFlagLabel = businessFlagLabel;
            }

            public String getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(String enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class AnsOrderBean  implements Serializable{
                /**
                 * id : 1111
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-04 11:29:00
                 * updateDate : 2018-05-04 11:29:00
                 * orderNo : nullnull11290052
                 * custId : 1111
                 * orderTime : 2018-05-04 11:29:00
                 * takeTime : null
                 * orderAmount : 1665
                 * paymentMethod : null
                 * paymentKeys : null
                 * paymentTime : null
                 * orderStatus : UP
                 * custRemarks : null
                 * transId : null
                 * updatePgm : ApiOrderService
                 * apiOrderDetailsList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"53f4f9379e814445882590e3686d33d0","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"444","unitPrice":"111.00","purchaseNumber":"4","sumAmount":"444.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"7e09c1ffabe549e4885407ff220f45e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"222","unitPrice":"111.00","purchaseNumber":"2","sumAmount":"222.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"222","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 09:49:48","goodsCate":"美容美体","goodsType":"0","goodsName":"测试46","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"9","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"97e3fa580e5b44799639372a29ab30d7","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:01","updateDate":"2018-05-04 11:29:01","orderId":"1111","goodsId":"555","unitPrice":"111.00","purchaseNumber":"5","sumAmount":"555.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"555","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试412","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:21:05","updateDate":"2018-05-08 10:21:05","goodsCate":"美发定制","goodsType":"0","goodsName":"测试3","goodsNo":null,"goodsBrief":"啊啊啊啊","serviceTime":"60分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"33.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a9e47","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"333","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:14:46","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"0","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":{"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"detailsStatusLabel":null}]
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderNo;
                private String custId;
                private String orderTime;
                private Object takeTime;
                private int orderAmount;
                private Object paymentMethod;
                private Object paymentKeys;
                private Object paymentTime;
                private String orderStatus;
                private Object custRemarks;
                private Object transId;
                private String updatePgm;
                private List<ApiOrderDetailsListBean> apiOrderDetailsList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public Object getRemarks() {
                    return remarks;
                }

                public void setRemarks(Object remarks) {
                    this.remarks = remarks;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate) {
                    this.updateDate = updateDate;
                }

                public String getOrderNo() {
                    return orderNo;
                }

                public void setOrderNo(String orderNo) {
                    this.orderNo = orderNo;
                }

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getOrderTime() {
                    return orderTime;
                }

                public void setOrderTime(String orderTime) {
                    this.orderTime = orderTime;
                }

                public Object getTakeTime() {
                    return takeTime;
                }

                public void setTakeTime(Object takeTime) {
                    this.takeTime = takeTime;
                }

                public int getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(int orderAmount) {
                    this.orderAmount = orderAmount;
                }

                public Object getPaymentMethod() {
                    return paymentMethod;
                }

                public void setPaymentMethod(Object paymentMethod) {
                    this.paymentMethod = paymentMethod;
                }

                public Object getPaymentKeys() {
                    return paymentKeys;
                }

                public void setPaymentKeys(Object paymentKeys) {
                    this.paymentKeys = paymentKeys;
                }

                public Object getPaymentTime() {
                    return paymentTime;
                }

                public void setPaymentTime(Object paymentTime) {
                    this.paymentTime = paymentTime;
                }

                public String getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(String orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public Object getCustRemarks() {
                    return custRemarks;
                }

                public void setCustRemarks(Object custRemarks) {
                    this.custRemarks = custRemarks;
                }

                public Object getTransId() {
                    return transId;
                }

                public void setTransId(Object transId) {
                    this.transId = transId;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public List<ApiOrderDetailsListBean> getApiOrderDetailsList() {
                    return apiOrderDetailsList;
                }

                public void setApiOrderDetailsList(List<ApiOrderDetailsListBean> apiOrderDetailsList) {
                    this.apiOrderDetailsList = apiOrderDetailsList;
                }

                public static class ApiOrderDetailsListBean implements Serializable{
                    /**
                     * id : null
                     * isNewRecord : true
                     * remarks : null
                     * createDate : null
                     * updateDate : null
                     * ansOrderDetails : {"id":"53f4f9379e814445882590e3686d33d0","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"444","unitPrice":"111.00","purchaseNumber":"4","sumAmount":"444.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"}
                     * ecGoodsBasic : {"id":"444","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-09 13:50:31","goodsCate":"美容美体","goodsType":"0","goodsName":"测试411","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"shopId":"111","saleFlag":"2","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"}
                     * ansShopBasic : {"id":"111","isNewRecord":false,"remarks":null,"createDate":"2018-05-07 14:24:02","updateDate":"2018-05-11 14:54:01","contractConfirm":null,"ifContract":null,"shopName":"美美理发店","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"1","belongCity":"17e8e72326574a0ea94b15d6eeddbb6d","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"雨花路1000号","openTime":"10:00:00","closeTime":"22:00:00","serviceTel":"15852855888","shopContacts":"姜超","contactsTel":"15852855880","ifLicence":null,"shopLegal":"","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-07 14:24:02","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"}
                     * detailsStatusLabel : null
                     */

                    private Object id;
                    private boolean isNewRecord;
                    private Object remarks;
                    private Object createDate;
                    private Object updateDate;
                    private AnsOrderDetailsBean ansOrderDetails;
                    private EcGoodsBasicBean ecGoodsBasic;
                    private AnsShopBasicBean ansShopBasic;
                    private Object detailsStatusLabel;

                    public Object getId() {
                        return id;
                    }

                    public void setId(Object id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public Object getRemarks() {
                        return remarks;
                    }

                    public void setRemarks(Object remarks) {
                        this.remarks = remarks;
                    }

                    public Object getCreateDate() {
                        return createDate;
                    }

                    public void setCreateDate(Object createDate) {
                        this.createDate = createDate;
                    }

                    public Object getUpdateDate() {
                        return updateDate;
                    }

                    public void setUpdateDate(Object updateDate) {
                        this.updateDate = updateDate;
                    }

                    public AnsOrderDetailsBean getAnsOrderDetails() {
                        return ansOrderDetails;
                    }

                    public void setAnsOrderDetails(AnsOrderDetailsBean ansOrderDetails) {
                        this.ansOrderDetails = ansOrderDetails;
                    }

                    public EcGoodsBasicBean getEcGoodsBasic() {
                        return ecGoodsBasic;
                    }

                    public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                        this.ecGoodsBasic = ecGoodsBasic;
                    }

                    public AnsShopBasicBean getAnsShopBasic() {
                        return ansShopBasic;
                    }

                    public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                        this.ansShopBasic = ansShopBasic;
                    }

                    public Object getDetailsStatusLabel() {
                        return detailsStatusLabel;
                    }

                    public void setDetailsStatusLabel(Object detailsStatusLabel) {
                        this.detailsStatusLabel = detailsStatusLabel;
                    }

                    public static class AnsOrderDetailsBean implements Serializable{
                        /**
                         * id : 53f4f9379e814445882590e3686d33d0
                         * isNewRecord : false
                         * remarks : null
                         * createDate : 2018-05-04 11:29:00
                         * updateDate : 2018-05-04 11:29:00
                         * orderId : 1111
                         * goodsId : 444
                         * unitPrice : 111.00
                         * purchaseNumber : 4
                         * sumAmount : 444.00
                         * detailsRemarks : null
                         * detailsStatus : UP
                         * updatePgm : ApiOrderService
                         */

                        private String id;
                        private boolean isNewRecord;
                        private Object remarks;
                        private String createDate;
                        private String updateDate;
                        private String orderId;
                        private String goodsId;
                        private String unitPrice;
                        private String purchaseNumber;
                        private String sumAmount;
                        private Object detailsRemarks;
                        private String detailsStatus;
                        private String updatePgm;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
                        }

                        public Object getRemarks() {
                            return remarks;
                        }

                        public void setRemarks(Object remarks) {
                            this.remarks = remarks;
                        }

                        public String getCreateDate() {
                            return createDate;
                        }

                        public void setCreateDate(String createDate) {
                            this.createDate = createDate;
                        }

                        public String getUpdateDate() {
                            return updateDate;
                        }

                        public void setUpdateDate(String updateDate) {
                            this.updateDate = updateDate;
                        }

                        public String getOrderId() {
                            return orderId;
                        }

                        public void setOrderId(String orderId) {
                            this.orderId = orderId;
                        }

                        public String getGoodsId() {
                            return goodsId;
                        }

                        public void setGoodsId(String goodsId) {
                            this.goodsId = goodsId;
                        }

                        public String getUnitPrice() {
                            return unitPrice;
                        }

                        public void setUnitPrice(String unitPrice) {
                            this.unitPrice = unitPrice;
                        }

                        public String getPurchaseNumber() {
                            return purchaseNumber;
                        }

                        public void setPurchaseNumber(String purchaseNumber) {
                            this.purchaseNumber = purchaseNumber;
                        }

                        public String getSumAmount() {
                            return sumAmount;
                        }

                        public void setSumAmount(String sumAmount) {
                            this.sumAmount = sumAmount;
                        }

                        public Object getDetailsRemarks() {
                            return detailsRemarks;
                        }

                        public void setDetailsRemarks(Object detailsRemarks) {
                            this.detailsRemarks = detailsRemarks;
                        }

                        public String getDetailsStatus() {
                            return detailsStatus;
                        }

                        public void setDetailsStatus(String detailsStatus) {
                            this.detailsStatus = detailsStatus;
                        }

                        public String getUpdatePgm() {
                            return updatePgm;
                        }

                        public void setUpdatePgm(String updatePgm) {
                            this.updatePgm = updatePgm;
                        }
                    }

                    public static class EcGoodsBasicBean implements Serializable{
                        /**
                         * id : 444
                         * isNewRecord : false
                         * remarks : null
                         * createDate : 2018-05-08 10:23:30
                         * updateDate : 2018-05-09 13:50:31
                         * goodsCate : 美容美体
                         * goodsType : 0
                         * goodsName : 测试411
                         * goodsNo : null
                         * goodsBrief : 哦哦哦咯饿了
                         * serviceTime : 90分钟
                         * goodsDetails : null
                         * goodsThumb : null
                         * goodsPic : null
                         * goodsShow : null
                         * goodsTab : 美发定制
                         * goodsStorage : null
                         * goodsPrice : 2.00
                         * offlinePrice : null
                         * marketPrice : null
                         * salesPrice : null
                         * promotionPrice : null
                         * goodsActivity : null
                         * shopId : 111
                         * saleFlag : 2
                         * approveBy : null
                         * approveDate : null
                         * startTime : 1525400918000
                         * endTime : 1525400923000
                         * goodsRemarks : null
                         * updatePgm : ApiGoodsController
                         */

                        private String id;
                        private boolean isNewRecord;
                        private Object remarks;
                        private String createDate;
                        private String updateDate;
                        private String goodsCate;
                        private String goodsType;
                        private String goodsName;
                        private Object goodsNo;
                        private String goodsBrief;
                        private String serviceTime;
                        private Object goodsDetails;
                        private Object goodsThumb;
                        private Object goodsPic;
                        private Object goodsShow;
                        private String goodsTab;
                        private Object goodsStorage;
                        private String goodsPrice;
                        private Object offlinePrice;
                        private Object marketPrice;
                        private Object salesPrice;
                        private Object promotionPrice;
                        private Object goodsActivity;
                        private String shopId;
                        private String saleFlag;
                        private Object approveBy;
                        private Object approveDate;
                        private long startTime;
                        private long endTime;
                        private Object goodsRemarks;
                        private String updatePgm;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
                        }

                        public Object getRemarks() {
                            return remarks;
                        }

                        public void setRemarks(Object remarks) {
                            this.remarks = remarks;
                        }

                        public String getCreateDate() {
                            return createDate;
                        }

                        public void setCreateDate(String createDate) {
                            this.createDate = createDate;
                        }

                        public String getUpdateDate() {
                            return updateDate;
                        }

                        public void setUpdateDate(String updateDate) {
                            this.updateDate = updateDate;
                        }

                        public String getGoodsCate() {
                            return goodsCate;
                        }

                        public void setGoodsCate(String goodsCate) {
                            this.goodsCate = goodsCate;
                        }

                        public String getGoodsType() {
                            return goodsType;
                        }

                        public void setGoodsType(String goodsType) {
                            this.goodsType = goodsType;
                        }

                        public String getGoodsName() {
                            return goodsName;
                        }

                        public void setGoodsName(String goodsName) {
                            this.goodsName = goodsName;
                        }

                        public Object getGoodsNo() {
                            return goodsNo;
                        }

                        public void setGoodsNo(Object goodsNo) {
                            this.goodsNo = goodsNo;
                        }

                        public String getGoodsBrief() {
                            return goodsBrief;
                        }

                        public void setGoodsBrief(String goodsBrief) {
                            this.goodsBrief = goodsBrief;
                        }

                        public String getServiceTime() {
                            return serviceTime;
                        }

                        public void setServiceTime(String serviceTime) {
                            this.serviceTime = serviceTime;
                        }

                        public Object getGoodsDetails() {
                            return goodsDetails;
                        }

                        public void setGoodsDetails(Object goodsDetails) {
                            this.goodsDetails = goodsDetails;
                        }

                        public Object getGoodsThumb() {
                            return goodsThumb;
                        }

                        public void setGoodsThumb(Object goodsThumb) {
                            this.goodsThumb = goodsThumb;
                        }

                        public Object getGoodsPic() {
                            return goodsPic;
                        }

                        public void setGoodsPic(Object goodsPic) {
                            this.goodsPic = goodsPic;
                        }

                        public Object getGoodsShow() {
                            return goodsShow;
                        }

                        public void setGoodsShow(Object goodsShow) {
                            this.goodsShow = goodsShow;
                        }

                        public String getGoodsTab() {
                            return goodsTab;
                        }

                        public void setGoodsTab(String goodsTab) {
                            this.goodsTab = goodsTab;
                        }

                        public Object getGoodsStorage() {
                            return goodsStorage;
                        }

                        public void setGoodsStorage(Object goodsStorage) {
                            this.goodsStorage = goodsStorage;
                        }

                        public String getGoodsPrice() {
                            return goodsPrice;
                        }

                        public void setGoodsPrice(String goodsPrice) {
                            this.goodsPrice = goodsPrice;
                        }

                        public Object getOfflinePrice() {
                            return offlinePrice;
                        }

                        public void setOfflinePrice(Object offlinePrice) {
                            this.offlinePrice = offlinePrice;
                        }

                        public Object getMarketPrice() {
                            return marketPrice;
                        }

                        public void setMarketPrice(Object marketPrice) {
                            this.marketPrice = marketPrice;
                        }

                        public Object getSalesPrice() {
                            return salesPrice;
                        }

                        public void setSalesPrice(Object salesPrice) {
                            this.salesPrice = salesPrice;
                        }

                        public Object getPromotionPrice() {
                            return promotionPrice;
                        }

                        public void setPromotionPrice(Object promotionPrice) {
                            this.promotionPrice = promotionPrice;
                        }

                        public Object getGoodsActivity() {
                            return goodsActivity;
                        }

                        public void setGoodsActivity(Object goodsActivity) {
                            this.goodsActivity = goodsActivity;
                        }

                        public String getShopId() {
                            return shopId;
                        }

                        public void setShopId(String shopId) {
                            this.shopId = shopId;
                        }

                        public String getSaleFlag() {
                            return saleFlag;
                        }

                        public void setSaleFlag(String saleFlag) {
                            this.saleFlag = saleFlag;
                        }

                        public Object getApproveBy() {
                            return approveBy;
                        }

                        public void setApproveBy(Object approveBy) {
                            this.approveBy = approveBy;
                        }

                        public Object getApproveDate() {
                            return approveDate;
                        }

                        public void setApproveDate(Object approveDate) {
                            this.approveDate = approveDate;
                        }

                        public long getStartTime() {
                            return startTime;
                        }

                        public void setStartTime(long startTime) {
                            this.startTime = startTime;
                        }

                        public long getEndTime() {
                            return endTime;
                        }

                        public void setEndTime(long endTime) {
                            this.endTime = endTime;
                        }

                        public Object getGoodsRemarks() {
                            return goodsRemarks;
                        }

                        public void setGoodsRemarks(Object goodsRemarks) {
                            this.goodsRemarks = goodsRemarks;
                        }

                        public String getUpdatePgm() {
                            return updatePgm;
                        }

                        public void setUpdatePgm(String updatePgm) {
                            this.updatePgm = updatePgm;
                        }
                    }

                    public static class AnsShopBasicBean implements Serializable{
                        /**
                         * id : 111
                         * isNewRecord : false
                         * remarks : null
                         * createDate : 2018-05-07 14:24:02
                         * updateDate : 2018-05-11 14:54:01
                         * contractConfirm : null
                         * ifContract : null
                         * shopName : 美美理发店
                         * shortName : null
                         * shopNo : null
                         * marketAssistant : null
                         * shopBrief : null
                         * shopAccounce : null
                         * shopActivity : null
                         * shopFeature : null
                         * queenCard : 0
                         * shopTab : null
                         * shopCate : 1
                         * industryCate : 1
                         * belongCity : 17e8e72326574a0ea94b15d6eeddbb6d
                         * addrProvince : null
                         * addrCity : null
                         * addrDistrict : null
                         * shopAddr : 雨花路1000号
                         * openTime : 10:00:00
                         * closeTime : 22:00:00
                         * serviceTel : 15852855888
                         * shopContacts : 姜超
                         * contactsTel : 15852855880
                         * ifLicence : null
                         * shopLegal :
                         * legalIdc : null
                         * legalAddress : null
                         * taxNumber : null
                         * businessLicence :
                         * shopCharge : null
                         * chargeIdc : null
                         * chargeIdp : null
                         * shopLogo : null
                         * shopPhoto : null
                         * shopEnvPhoto : null
                         * joinTime : 2018-05-07 14:24:02
                         * businessFlag : 1
                         * enableFlag : 1
                         * signFlag : null
                         * geoX : null
                         * geoY : null
                         * updatePgm : ApiLoginController
                         */

                        private String id;
                        private boolean isNewRecord;
                        private Object remarks;
                        private String createDate;
                        private String updateDate;
                        private Object contractConfirm;
                        private Object ifContract;
                        private String shopName;
                        private Object shortName;
                        private Object shopNo;
                        private Object marketAssistant;
                        private Object shopBrief;
                        private Object shopAccounce;
                        private Object shopActivity;
                        private Object shopFeature;
                        private String queenCard;
                        private Object shopTab;
                        private String shopCate;
                        private String industryCate;
                        private String belongCity;
                        private Object addrProvince;
                        private Object addrCity;
                        private Object addrDistrict;
                        private String shopAddr;
                        private String openTime;
                        private String closeTime;
                        private String serviceTel;
                        private String shopContacts;
                        private String contactsTel;
                        private Object ifLicence;
                        private String shopLegal;
                        private Object legalIdc;
                        private Object legalAddress;
                        private Object taxNumber;
                        private String businessLicence;
                        private Object shopCharge;
                        private Object chargeIdc;
                        private Object chargeIdp;
                        private Object shopLogo;
                        private Object shopPhoto;
                        private Object shopEnvPhoto;
                        private String joinTime;
                        private String businessFlag;
                        private String enableFlag;
                        private Object signFlag;
                        private Object geoX;
                        private Object geoY;
                        private String updatePgm;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
                        }

                        public Object getRemarks() {
                            return remarks;
                        }

                        public void setRemarks(Object remarks) {
                            this.remarks = remarks;
                        }

                        public String getCreateDate() {
                            return createDate;
                        }

                        public void setCreateDate(String createDate) {
                            this.createDate = createDate;
                        }

                        public String getUpdateDate() {
                            return updateDate;
                        }

                        public void setUpdateDate(String updateDate) {
                            this.updateDate = updateDate;
                        }

                        public Object getContractConfirm() {
                            return contractConfirm;
                        }

                        public void setContractConfirm(Object contractConfirm) {
                            this.contractConfirm = contractConfirm;
                        }

                        public Object getIfContract() {
                            return ifContract;
                        }

                        public void setIfContract(Object ifContract) {
                            this.ifContract = ifContract;
                        }

                        public String getShopName() {
                            return shopName;
                        }

                        public void setShopName(String shopName) {
                            this.shopName = shopName;
                        }

                        public Object getShortName() {
                            return shortName;
                        }

                        public void setShortName(Object shortName) {
                            this.shortName = shortName;
                        }

                        public Object getShopNo() {
                            return shopNo;
                        }

                        public void setShopNo(Object shopNo) {
                            this.shopNo = shopNo;
                        }

                        public Object getMarketAssistant() {
                            return marketAssistant;
                        }

                        public void setMarketAssistant(Object marketAssistant) {
                            this.marketAssistant = marketAssistant;
                        }

                        public Object getShopBrief() {
                            return shopBrief;
                        }

                        public void setShopBrief(Object shopBrief) {
                            this.shopBrief = shopBrief;
                        }

                        public Object getShopAccounce() {
                            return shopAccounce;
                        }

                        public void setShopAccounce(Object shopAccounce) {
                            this.shopAccounce = shopAccounce;
                        }

                        public Object getShopActivity() {
                            return shopActivity;
                        }

                        public void setShopActivity(Object shopActivity) {
                            this.shopActivity = shopActivity;
                        }

                        public Object getShopFeature() {
                            return shopFeature;
                        }

                        public void setShopFeature(Object shopFeature) {
                            this.shopFeature = shopFeature;
                        }

                        public String getQueenCard() {
                            return queenCard;
                        }

                        public void setQueenCard(String queenCard) {
                            this.queenCard = queenCard;
                        }

                        public Object getShopTab() {
                            return shopTab;
                        }

                        public void setShopTab(Object shopTab) {
                            this.shopTab = shopTab;
                        }

                        public String getShopCate() {
                            return shopCate;
                        }

                        public void setShopCate(String shopCate) {
                            this.shopCate = shopCate;
                        }

                        public String getIndustryCate() {
                            return industryCate;
                        }

                        public void setIndustryCate(String industryCate) {
                            this.industryCate = industryCate;
                        }

                        public String getBelongCity() {
                            return belongCity;
                        }

                        public void setBelongCity(String belongCity) {
                            this.belongCity = belongCity;
                        }

                        public Object getAddrProvince() {
                            return addrProvince;
                        }

                        public void setAddrProvince(Object addrProvince) {
                            this.addrProvince = addrProvince;
                        }

                        public Object getAddrCity() {
                            return addrCity;
                        }

                        public void setAddrCity(Object addrCity) {
                            this.addrCity = addrCity;
                        }

                        public Object getAddrDistrict() {
                            return addrDistrict;
                        }

                        public void setAddrDistrict(Object addrDistrict) {
                            this.addrDistrict = addrDistrict;
                        }

                        public String getShopAddr() {
                            return shopAddr;
                        }

                        public void setShopAddr(String shopAddr) {
                            this.shopAddr = shopAddr;
                        }

                        public String getOpenTime() {
                            return openTime;
                        }

                        public void setOpenTime(String openTime) {
                            this.openTime = openTime;
                        }

                        public String getCloseTime() {
                            return closeTime;
                        }

                        public void setCloseTime(String closeTime) {
                            this.closeTime = closeTime;
                        }

                        public String getServiceTel() {
                            return serviceTel;
                        }

                        public void setServiceTel(String serviceTel) {
                            this.serviceTel = serviceTel;
                        }

                        public String getShopContacts() {
                            return shopContacts;
                        }

                        public void setShopContacts(String shopContacts) {
                            this.shopContacts = shopContacts;
                        }

                        public String getContactsTel() {
                            return contactsTel;
                        }

                        public void setContactsTel(String contactsTel) {
                            this.contactsTel = contactsTel;
                        }

                        public Object getIfLicence() {
                            return ifLicence;
                        }

                        public void setIfLicence(Object ifLicence) {
                            this.ifLicence = ifLicence;
                        }

                        public String getShopLegal() {
                            return shopLegal;
                        }

                        public void setShopLegal(String shopLegal) {
                            this.shopLegal = shopLegal;
                        }

                        public Object getLegalIdc() {
                            return legalIdc;
                        }

                        public void setLegalIdc(Object legalIdc) {
                            this.legalIdc = legalIdc;
                        }

                        public Object getLegalAddress() {
                            return legalAddress;
                        }

                        public void setLegalAddress(Object legalAddress) {
                            this.legalAddress = legalAddress;
                        }

                        public Object getTaxNumber() {
                            return taxNumber;
                        }

                        public void setTaxNumber(Object taxNumber) {
                            this.taxNumber = taxNumber;
                        }

                        public String getBusinessLicence() {
                            return businessLicence;
                        }

                        public void setBusinessLicence(String businessLicence) {
                            this.businessLicence = businessLicence;
                        }

                        public Object getShopCharge() {
                            return shopCharge;
                        }

                        public void setShopCharge(Object shopCharge) {
                            this.shopCharge = shopCharge;
                        }

                        public Object getChargeIdc() {
                            return chargeIdc;
                        }

                        public void setChargeIdc(Object chargeIdc) {
                            this.chargeIdc = chargeIdc;
                        }

                        public Object getChargeIdp() {
                            return chargeIdp;
                        }

                        public void setChargeIdp(Object chargeIdp) {
                            this.chargeIdp = chargeIdp;
                        }

                        public Object getShopLogo() {
                            return shopLogo;
                        }

                        public void setShopLogo(Object shopLogo) {
                            this.shopLogo = shopLogo;
                        }

                        public Object getShopPhoto() {
                            return shopPhoto;
                        }

                        public void setShopPhoto(Object shopPhoto) {
                            this.shopPhoto = shopPhoto;
                        }

                        public Object getShopEnvPhoto() {
                            return shopEnvPhoto;
                        }

                        public void setShopEnvPhoto(Object shopEnvPhoto) {
                            this.shopEnvPhoto = shopEnvPhoto;
                        }

                        public String getJoinTime() {
                            return joinTime;
                        }

                        public void setJoinTime(String joinTime) {
                            this.joinTime = joinTime;
                        }

                        public String getBusinessFlag() {
                            return businessFlag;
                        }

                        public void setBusinessFlag(String businessFlag) {
                            this.businessFlag = businessFlag;
                        }

                        public String getEnableFlag() {
                            return enableFlag;
                        }

                        public void setEnableFlag(String enableFlag) {
                            this.enableFlag = enableFlag;
                        }

                        public Object getSignFlag() {
                            return signFlag;
                        }

                        public void setSignFlag(Object signFlag) {
                            this.signFlag = signFlag;
                        }

                        public Object getGeoX() {
                            return geoX;
                        }

                        public void setGeoX(Object geoX) {
                            this.geoX = geoX;
                        }

                        public Object getGeoY() {
                            return geoY;
                        }

                        public void setGeoY(Object geoY) {
                            this.geoY = geoY;
                        }

                        public String getUpdatePgm() {
                            return updatePgm;
                        }

                        public void setUpdatePgm(String updatePgm) {
                            this.updatePgm = updatePgm;
                        }
                    }
                }
            }

            public static class AnsShopBasicBeanX implements Serializable{
                /**
                 * id : 111
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-07 14:24:02
                 * updateDate : 2018-05-11 14:54:01
                 * contractConfirm : null
                 * ifContract : null
                 * shopName : 美美理发店
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
                 * shopActivity : null
                 * shopFeature : null
                 * queenCard : 0
                 * shopTab : null
                 * shopCate : 1
                 * industryCate : 1
                 * belongCity : 17e8e72326574a0ea94b15d6eeddbb6d
                 * addrProvince : null
                 * addrCity : null
                 * addrDistrict : null
                 * shopAddr : 雨花路1000号
                 * openTime : 10:00:00
                 * closeTime : 22:00:00
                 * serviceTel : 15852855888
                 * shopContacts : 姜超
                 * contactsTel : 15852855880
                 * ifLicence : null
                 * shopLegal :
                 * legalIdc : null
                 * legalAddress : null
                 * taxNumber : null
                 * businessLicence :
                 * shopCharge : null
                 * chargeIdc : null
                 * chargeIdp : null
                 * shopLogo : null
                 * shopPhoto : null
                 * shopEnvPhoto : null
                 * joinTime : 2018-05-07 14:24:02
                 * businessFlag : 1
                 * enableFlag : 1
                 * signFlag : null
                 * geoX : null
                 * geoY : null
                 * updatePgm : ApiLoginController
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private Object contractConfirm;
                private Object ifContract;
                private String shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
                private Object shopActivity;
                private Object shopFeature;
                private String queenCard;
                private Object shopTab;
                private String shopCate;
                private String industryCate;
                private String belongCity;
                private Object addrProvince;
                private Object addrCity;
                private Object addrDistrict;
                private String shopAddr;
                private String openTime;
                private String closeTime;
                private String serviceTel;
                private String shopContacts;
                private String contactsTel;
                private Object ifLicence;
                private String shopLegal;
                private Object legalIdc;
                private Object legalAddress;
                private Object taxNumber;
                private String businessLicence;
                private Object shopCharge;
                private Object chargeIdc;
                private Object chargeIdp;
                private Object shopLogo;
                private Object shopPhoto;
                private Object shopEnvPhoto;
                private String joinTime;
                private String businessFlag;
                private String enableFlag;
                private Object signFlag;
                private Object geoX;
                private Object geoY;
                private String updatePgm;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public Object getRemarks() {
                    return remarks;
                }

                public void setRemarks(Object remarks) {
                    this.remarks = remarks;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate) {
                    this.updateDate = updateDate;
                }

                public Object getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(Object contractConfirm) {
                    this.contractConfirm = contractConfirm;
                }

                public Object getIfContract() {
                    return ifContract;
                }

                public void setIfContract(Object ifContract) {
                    this.ifContract = ifContract;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }

                public Object getShortName() {
                    return shortName;
                }

                public void setShortName(Object shortName) {
                    this.shortName = shortName;
                }

                public Object getShopNo() {
                    return shopNo;
                }

                public void setShopNo(Object shopNo) {
                    this.shopNo = shopNo;
                }

                public Object getMarketAssistant() {
                    return marketAssistant;
                }

                public void setMarketAssistant(Object marketAssistant) {
                    this.marketAssistant = marketAssistant;
                }

                public Object getShopBrief() {
                    return shopBrief;
                }

                public void setShopBrief(Object shopBrief) {
                    this.shopBrief = shopBrief;
                }

                public Object getShopAccounce() {
                    return shopAccounce;
                }

                public void setShopAccounce(Object shopAccounce) {
                    this.shopAccounce = shopAccounce;
                }

                public Object getShopActivity() {
                    return shopActivity;
                }

                public void setShopActivity(Object shopActivity) {
                    this.shopActivity = shopActivity;
                }

                public Object getShopFeature() {
                    return shopFeature;
                }

                public void setShopFeature(Object shopFeature) {
                    this.shopFeature = shopFeature;
                }

                public String getQueenCard() {
                    return queenCard;
                }

                public void setQueenCard(String queenCard) {
                    this.queenCard = queenCard;
                }

                public Object getShopTab() {
                    return shopTab;
                }

                public void setShopTab(Object shopTab) {
                    this.shopTab = shopTab;
                }

                public String getShopCate() {
                    return shopCate;
                }

                public void setShopCate(String shopCate) {
                    this.shopCate = shopCate;
                }

                public String getIndustryCate() {
                    return industryCate;
                }

                public void setIndustryCate(String industryCate) {
                    this.industryCate = industryCate;
                }

                public String getBelongCity() {
                    return belongCity;
                }

                public void setBelongCity(String belongCity) {
                    this.belongCity = belongCity;
                }

                public Object getAddrProvince() {
                    return addrProvince;
                }

                public void setAddrProvince(Object addrProvince) {
                    this.addrProvince = addrProvince;
                }

                public Object getAddrCity() {
                    return addrCity;
                }

                public void setAddrCity(Object addrCity) {
                    this.addrCity = addrCity;
                }

                public Object getAddrDistrict() {
                    return addrDistrict;
                }

                public void setAddrDistrict(Object addrDistrict) {
                    this.addrDistrict = addrDistrict;
                }

                public String getShopAddr() {
                    return shopAddr;
                }

                public void setShopAddr(String shopAddr) {
                    this.shopAddr = shopAddr;
                }

                public String getOpenTime() {
                    return openTime;
                }

                public void setOpenTime(String openTime) {
                    this.openTime = openTime;
                }

                public String getCloseTime() {
                    return closeTime;
                }

                public void setCloseTime(String closeTime) {
                    this.closeTime = closeTime;
                }

                public String getServiceTel() {
                    return serviceTel;
                }

                public void setServiceTel(String serviceTel) {
                    this.serviceTel = serviceTel;
                }

                public String getShopContacts() {
                    return shopContacts;
                }

                public void setShopContacts(String shopContacts) {
                    this.shopContacts = shopContacts;
                }

                public String getContactsTel() {
                    return contactsTel;
                }

                public void setContactsTel(String contactsTel) {
                    this.contactsTel = contactsTel;
                }

                public Object getIfLicence() {
                    return ifLicence;
                }

                public void setIfLicence(Object ifLicence) {
                    this.ifLicence = ifLicence;
                }

                public String getShopLegal() {
                    return shopLegal;
                }

                public void setShopLegal(String shopLegal) {
                    this.shopLegal = shopLegal;
                }

                public Object getLegalIdc() {
                    return legalIdc;
                }

                public void setLegalIdc(Object legalIdc) {
                    this.legalIdc = legalIdc;
                }

                public Object getLegalAddress() {
                    return legalAddress;
                }

                public void setLegalAddress(Object legalAddress) {
                    this.legalAddress = legalAddress;
                }

                public Object getTaxNumber() {
                    return taxNumber;
                }

                public void setTaxNumber(Object taxNumber) {
                    this.taxNumber = taxNumber;
                }

                public String getBusinessLicence() {
                    return businessLicence;
                }

                public void setBusinessLicence(String businessLicence) {
                    this.businessLicence = businessLicence;
                }

                public Object getShopCharge() {
                    return shopCharge;
                }

                public void setShopCharge(Object shopCharge) {
                    this.shopCharge = shopCharge;
                }

                public Object getChargeIdc() {
                    return chargeIdc;
                }

                public void setChargeIdc(Object chargeIdc) {
                    this.chargeIdc = chargeIdc;
                }

                public Object getChargeIdp() {
                    return chargeIdp;
                }

                public void setChargeIdp(Object chargeIdp) {
                    this.chargeIdp = chargeIdp;
                }

                public Object getShopLogo() {
                    return shopLogo;
                }

                public void setShopLogo(Object shopLogo) {
                    this.shopLogo = shopLogo;
                }

                public Object getShopPhoto() {
                    return shopPhoto;
                }

                public void setShopPhoto(Object shopPhoto) {
                    this.shopPhoto = shopPhoto;
                }

                public Object getShopEnvPhoto() {
                    return shopEnvPhoto;
                }

                public void setShopEnvPhoto(Object shopEnvPhoto) {
                    this.shopEnvPhoto = shopEnvPhoto;
                }

                public String getJoinTime() {
                    return joinTime;
                }

                public void setJoinTime(String joinTime) {
                    this.joinTime = joinTime;
                }

                public String getBusinessFlag() {
                    return businessFlag;
                }

                public void setBusinessFlag(String businessFlag) {
                    this.businessFlag = businessFlag;
                }

                public String getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(String enableFlag) {
                    this.enableFlag = enableFlag;
                }

                public Object getSignFlag() {
                    return signFlag;
                }

                public void setSignFlag(Object signFlag) {
                    this.signFlag = signFlag;
                }

                public Object getGeoX() {
                    return geoX;
                }

                public void setGeoX(Object geoX) {
                    this.geoX = geoX;
                }

                public Object getGeoY() {
                    return geoY;
                }

                public void setGeoY(Object geoY) {
                    this.geoY = geoY;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }
        }
    }
}
