package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 2018/5/17.
 */

public class MyCommentsBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CommentsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseGoods":{"id":"111","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","goodsId":"111","detailId":"04eaad7a66f64edd95f29815558f8cb9","ifMatch":"2","employeeAbility":"1","apprDetails":"aff","apprPic":"","ifAnon":"0","apprLevel":"1","apprTime":"2018-04-11 00:00:00"},"ecAppraiseShop":{"id":"0eae9689e7e84af5a120a5d28c604cb1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","orderId":"1a36396703d648f1abf0544c474d7288","serviceAttitude":"2","shopEnvironment":"1","apprTime":"2018-04-27 16:36:15"},"ansOrderDetails":{"id":"04eaad7a66f64edd95f29815558f8cb9","isNewRecord":false,"remarks":null,"createDate":"2018-05-29 13:39:32","updateDate":"2018-05-29 13:39:32","orderId":"1a36396703d648f1abf0544c474d7288","goodsId":"ef4f51753e1d43b2a39e3d15ba10dcca","goodsName":"修改测试1","unitPrice":"0.01","purchaseNumber":"4","sumAmount":"0.04","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"ApiOrderService"},"ecShopScore":{"id":"112","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"shopId":"0eae9689e7e84af5a120a5d28c604cb1","goodsAppraiseate":null,"shopAppraise":"2","goodsScore":"1.0","shopScore":"1.0","sumScore":"2.0","serviceAttitude":null,"shopEnvironment":null,"levelOne":null,"levelTwo":null,"levelThree":null,"levelFour":null,"levelFive":null,"sumStart":"2018-04-09 09:54:46","sumEnd":"2018-04-25 09:54:51","sumTime":"2018-04-18 09:54:55","newFlag":"1"},"goodsIdName":"测试3","custIdName":null,"shopIdName":"琳美甲","ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"goodsAppraiseLabel":null,"shopAppraiseLabel":null,"apiEcAppraiseReplyList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b4fd5edab31ba38f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"111","replyContent":"谢谢您","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":"琳美甲"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b8fd5edab31aa38f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"a34838a82fe74ec0b4fd5edab31ba38f","replyContent":"你们家商品要是不好我也不会说好的","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b8fd5edab31ba38e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"a34838a82fe74ec0b8fd5edab31aa38f","replyContent":"这个商品是verygood啊","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":null}]}]}
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
        private List<CommentsListDataBean> CommentsListData;

        public List<CommentsListDataBean> getCommentsListData() {
            return CommentsListData;
        }

        public void setCommentsListData(List<CommentsListDataBean> CommentsListData) {
            this.CommentsListData = CommentsListData;
        }

        public static class CommentsListDataBean implements Serializable{
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecAppraiseGoods : {"id":"111","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","goodsId":"111","detailId":"04eaad7a66f64edd95f29815558f8cb9","ifMatch":"2","employeeAbility":"1","apprDetails":"aff","apprPic":"","ifAnon":"0","apprLevel":"1","apprTime":"2018-04-11 00:00:00"}
             * ecAppraiseShop : {"id":"0eae9689e7e84af5a120a5d28c604cb1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","orderId":"1a36396703d648f1abf0544c474d7288","serviceAttitude":"2","shopEnvironment":"1","apprTime":"2018-04-27 16:36:15"}
             * ansOrderDetails : {"id":"04eaad7a66f64edd95f29815558f8cb9","isNewRecord":false,"remarks":null,"createDate":"2018-05-29 13:39:32","updateDate":"2018-05-29 13:39:32","orderId":"1a36396703d648f1abf0544c474d7288","goodsId":"ef4f51753e1d43b2a39e3d15ba10dcca","goodsName":"修改测试1","unitPrice":"0.01","purchaseNumber":"4","sumAmount":"0.04","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"ApiOrderService"}
             * ecShopScore : {"id":"112","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"shopId":"0eae9689e7e84af5a120a5d28c604cb1","goodsAppraiseate":null,"shopAppraise":"2","goodsScore":"1.0","shopScore":"1.0","sumScore":"2.0","serviceAttitude":null,"shopEnvironment":null,"levelOne":null,"levelTwo":null,"levelThree":null,"levelFour":null,"levelFive":null,"sumStart":"2018-04-09 09:54:46","sumEnd":"2018-04-25 09:54:51","sumTime":"2018-04-18 09:54:55","newFlag":"1"}
             * goodsIdName : 测试3
             * custIdName : null
             * shopIdName : 琳美甲
             * ifMatchLabel : null
             * employeeAbilityLabel : null
             * ifAnonLabel : null
             * serviceAttitudeLabel : null
             * shopEnvironmentLabel : null
             * goodsAppraiseLabel : null
             * shopAppraiseLabel : null
             * apiEcAppraiseReplyList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b4fd5edab31ba38f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"111","replyContent":"谢谢您","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":"琳美甲"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b8fd5edab31aa38f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"a34838a82fe74ec0b4fd5edab31ba38f","replyContent":"你们家商品要是不好我也不会说好的","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseReply":{"id":"a34838a82fe74ec0b8fd5edab31ba38e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"a34838a82fe74ec0b8fd5edab31aa38f","replyContent":"这个商品是verygood啊","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"},"replyUserName":null,"objectUserName":null}]
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcAppraiseGoodsBean ecAppraiseGoods;
            private EcAppraiseShopBean ecAppraiseShop;
            private AnsOrderDetailsBean ansOrderDetails;
            private EcShopScoreBean ecShopScore;
            private String goodsIdName;
            private Object custIdName;
            private String shopIdName;
            private Object ifMatchLabel;
            private Object employeeAbilityLabel;
            private Object ifAnonLabel;
            private Object serviceAttitudeLabel;
            private Object shopEnvironmentLabel;
            private Object goodsAppraiseLabel;
            private Object shopAppraiseLabel;
            private List<ApiEcAppraiseReplyListBean> apiEcAppraiseReplyList;

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

            public EcAppraiseGoodsBean getEcAppraiseGoods() {
                return ecAppraiseGoods;
            }

            public void setEcAppraiseGoods(EcAppraiseGoodsBean ecAppraiseGoods) {
                this.ecAppraiseGoods = ecAppraiseGoods;
            }

            public EcAppraiseShopBean getEcAppraiseShop() {
                return ecAppraiseShop;
            }

            public void setEcAppraiseShop(EcAppraiseShopBean ecAppraiseShop) {
                this.ecAppraiseShop = ecAppraiseShop;
            }

            public AnsOrderDetailsBean getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(AnsOrderDetailsBean ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public EcShopScoreBean getEcShopScore() {
                return ecShopScore;
            }

            public void setEcShopScore(EcShopScoreBean ecShopScore) {
                this.ecShopScore = ecShopScore;
            }

            public String getGoodsIdName() {
                return goodsIdName;
            }

            public void setGoodsIdName(String goodsIdName) {
                this.goodsIdName = goodsIdName;
            }

            public Object getCustIdName() {
                return custIdName;
            }

            public void setCustIdName(Object custIdName) {
                this.custIdName = custIdName;
            }

            public String getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(String shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getIfMatchLabel() {
                return ifMatchLabel;
            }

            public void setIfMatchLabel(Object ifMatchLabel) {
                this.ifMatchLabel = ifMatchLabel;
            }

            public Object getEmployeeAbilityLabel() {
                return employeeAbilityLabel;
            }

            public void setEmployeeAbilityLabel(Object employeeAbilityLabel) {
                this.employeeAbilityLabel = employeeAbilityLabel;
            }

            public Object getIfAnonLabel() {
                return ifAnonLabel;
            }

            public void setIfAnonLabel(Object ifAnonLabel) {
                this.ifAnonLabel = ifAnonLabel;
            }

            public Object getServiceAttitudeLabel() {
                return serviceAttitudeLabel;
            }

            public void setServiceAttitudeLabel(Object serviceAttitudeLabel) {
                this.serviceAttitudeLabel = serviceAttitudeLabel;
            }

            public Object getShopEnvironmentLabel() {
                return shopEnvironmentLabel;
            }

            public void setShopEnvironmentLabel(Object shopEnvironmentLabel) {
                this.shopEnvironmentLabel = shopEnvironmentLabel;
            }

            public Object getGoodsAppraiseLabel() {
                return goodsAppraiseLabel;
            }

            public void setGoodsAppraiseLabel(Object goodsAppraiseLabel) {
                this.goodsAppraiseLabel = goodsAppraiseLabel;
            }

            public Object getShopAppraiseLabel() {
                return shopAppraiseLabel;
            }

            public void setShopAppraiseLabel(Object shopAppraiseLabel) {
                this.shopAppraiseLabel = shopAppraiseLabel;
            }

            public List<ApiEcAppraiseReplyListBean> getApiEcAppraiseReplyList() {
                return apiEcAppraiseReplyList;
            }

            public void setApiEcAppraiseReplyList(List<ApiEcAppraiseReplyListBean> apiEcAppraiseReplyList) {
                this.apiEcAppraiseReplyList = apiEcAppraiseReplyList;
            }

            public static class EcAppraiseGoodsBean implements Serializable{
                /**
                 * id : 111
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 111
                 * shopId : 111
                 * goodsId : 111
                 * detailId : 04eaad7a66f64edd95f29815558f8cb9
                 * ifMatch : 2
                 * employeeAbility : 1
                 * apprDetails : aff
                 * apprPic :
                 * ifAnon : 0
                 * apprLevel : 1
                 * apprTime : 2018-04-11 00:00:00
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String custId;
                private String shopId;
                private String goodsId;
                private String detailId;
                private String ifMatch;
                private String employeeAbility;
                private String apprDetails;
                private String apprPic;
                private String ifAnon;
                private String apprLevel;
                private String apprTime;

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

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getDetailId() {
                    return detailId;
                }

                public void setDetailId(String detailId) {
                    this.detailId = detailId;
                }

                public String getIfMatch() {
                    return ifMatch;
                }

                public void setIfMatch(String ifMatch) {
                    this.ifMatch = ifMatch;
                }

                public String getEmployeeAbility() {
                    return employeeAbility;
                }

                public void setEmployeeAbility(String employeeAbility) {
                    this.employeeAbility = employeeAbility;
                }

                public String getApprDetails() {
                    return apprDetails;
                }

                public void setApprDetails(String apprDetails) {
                    this.apprDetails = apprDetails;
                }

                public String getApprPic() {
                    return apprPic;
                }

                public void setApprPic(String apprPic) {
                    this.apprPic = apprPic;
                }

                public String getIfAnon() {
                    return ifAnon;
                }

                public void setIfAnon(String ifAnon) {
                    this.ifAnon = ifAnon;
                }

                public String getApprLevel() {
                    return apprLevel;
                }

                public void setApprLevel(String apprLevel) {
                    this.apprLevel = apprLevel;
                }

                public String getApprTime() {
                    return apprTime;
                }

                public void setApprTime(String apprTime) {
                    this.apprTime = apprTime;
                }
            }

            public static class EcAppraiseShopBean implements Serializable{
                /**
                 * id : 0eae9689e7e84af5a120a5d28c604cb1
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 111
                 * shopId : 111
                 * orderId : 1a36396703d648f1abf0544c474d7288
                 * serviceAttitude : 2
                 * shopEnvironment : 1
                 * apprTime : 2018-04-27 16:36:15
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String custId;
                private String shopId;
                private String orderId;
                private String serviceAttitude;
                private String shopEnvironment;
                private String apprTime;

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

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public String getServiceAttitude() {
                    return serviceAttitude;
                }

                public void setServiceAttitude(String serviceAttitude) {
                    this.serviceAttitude = serviceAttitude;
                }

                public String getShopEnvironment() {
                    return shopEnvironment;
                }

                public void setShopEnvironment(String shopEnvironment) {
                    this.shopEnvironment = shopEnvironment;
                }

                public String getApprTime() {
                    return apprTime;
                }

                public void setApprTime(String apprTime) {
                    this.apprTime = apprTime;
                }
            }

            public static class AnsOrderDetailsBean implements Serializable{
                /**
                 * id : 04eaad7a66f64edd95f29815558f8cb9
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-29 13:39:32
                 * updateDate : 2018-05-29 13:39:32
                 * orderId : 1a36396703d648f1abf0544c474d7288
                 * goodsId : ef4f51753e1d43b2a39e3d15ba10dcca
                 * goodsName : 修改测试1
                 * unitPrice : 0.01
                 * purchaseNumber : 4
                 * sumAmount : 0.04
                 * cpAmount : null
                 * discountAmount : null
                 * usePoints : null
                 * afterAmount : null
                 * consumeQrcode : null
                 * detailsRemarks : null
                 * detailsStatus : null
                 * updatePgm : ApiOrderService
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderId;
                private String goodsId;
                private String goodsName;
                private String unitPrice;
                private String purchaseNumber;
                private String sumAmount;
                private Object cpAmount;
                private Object discountAmount;
                private Object usePoints;
                private Object afterAmount;
                private Object consumeQrcode;
                private Object detailsRemarks;
                private Object detailsStatus;
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

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
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

                public Object getCpAmount() {
                    return cpAmount;
                }

                public void setCpAmount(Object cpAmount) {
                    this.cpAmount = cpAmount;
                }

                public Object getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(Object discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public Object getUsePoints() {
                    return usePoints;
                }

                public void setUsePoints(Object usePoints) {
                    this.usePoints = usePoints;
                }

                public Object getAfterAmount() {
                    return afterAmount;
                }

                public void setAfterAmount(Object afterAmount) {
                    this.afterAmount = afterAmount;
                }

                public Object getConsumeQrcode() {
                    return consumeQrcode;
                }

                public void setConsumeQrcode(Object consumeQrcode) {
                    this.consumeQrcode = consumeQrcode;
                }

                public Object getDetailsRemarks() {
                    return detailsRemarks;
                }

                public void setDetailsRemarks(Object detailsRemarks) {
                    this.detailsRemarks = detailsRemarks;
                }

                public Object getDetailsStatus() {
                    return detailsStatus;
                }

                public void setDetailsStatus(Object detailsStatus) {
                    this.detailsStatus = detailsStatus;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class EcShopScoreBean implements Serializable{
                /**
                 * id : 112
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * shopId : 0eae9689e7e84af5a120a5d28c604cb1
                 * goodsAppraiseate : null
                 * shopAppraise : 2
                 * goodsScore : 1.0
                 * shopScore : 1.0
                 * sumScore : 2.0
                 * serviceAttitude : null
                 * shopEnvironment : null
                 * levelOne : null
                 * levelTwo : null
                 * levelThree : null
                 * levelFour : null
                 * levelFive : null
                 * sumStart : 2018-04-09 09:54:46
                 * sumEnd : 2018-04-25 09:54:51
                 * sumTime : 2018-04-18 09:54:55
                 * newFlag : 1
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String shopId;
                private Object goodsAppraiseate;
                private String shopAppraise;
                private String goodsScore;
                private String shopScore;
                private String sumScore;
                private Object serviceAttitude;
                private Object shopEnvironment;
                private Object levelOne;
                private Object levelTwo;
                private Object levelThree;
                private Object levelFour;
                private Object levelFive;
                private String sumStart;
                private String sumEnd;
                private String sumTime;
                private String newFlag;

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

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public Object getGoodsAppraiseate() {
                    return goodsAppraiseate;
                }

                public void setGoodsAppraiseate(Object goodsAppraiseate) {
                    this.goodsAppraiseate = goodsAppraiseate;
                }

                public String getShopAppraise() {
                    return shopAppraise;
                }

                public void setShopAppraise(String shopAppraise) {
                    this.shopAppraise = shopAppraise;
                }

                public String getGoodsScore() {
                    return goodsScore;
                }

                public void setGoodsScore(String goodsScore) {
                    this.goodsScore = goodsScore;
                }

                public String getShopScore() {
                    return shopScore;
                }

                public void setShopScore(String shopScore) {
                    this.shopScore = shopScore;
                }

                public String getSumScore() {
                    return sumScore;
                }

                public void setSumScore(String sumScore) {
                    this.sumScore = sumScore;
                }

                public Object getServiceAttitude() {
                    return serviceAttitude;
                }

                public void setServiceAttitude(Object serviceAttitude) {
                    this.serviceAttitude = serviceAttitude;
                }

                public Object getShopEnvironment() {
                    return shopEnvironment;
                }

                public void setShopEnvironment(Object shopEnvironment) {
                    this.shopEnvironment = shopEnvironment;
                }

                public Object getLevelOne() {
                    return levelOne;
                }

                public void setLevelOne(Object levelOne) {
                    this.levelOne = levelOne;
                }

                public Object getLevelTwo() {
                    return levelTwo;
                }

                public void setLevelTwo(Object levelTwo) {
                    this.levelTwo = levelTwo;
                }

                public Object getLevelThree() {
                    return levelThree;
                }

                public void setLevelThree(Object levelThree) {
                    this.levelThree = levelThree;
                }

                public Object getLevelFour() {
                    return levelFour;
                }

                public void setLevelFour(Object levelFour) {
                    this.levelFour = levelFour;
                }

                public Object getLevelFive() {
                    return levelFive;
                }

                public void setLevelFive(Object levelFive) {
                    this.levelFive = levelFive;
                }

                public String getSumStart() {
                    return sumStart;
                }

                public void setSumStart(String sumStart) {
                    this.sumStart = sumStart;
                }

                public String getSumEnd() {
                    return sumEnd;
                }

                public void setSumEnd(String sumEnd) {
                    this.sumEnd = sumEnd;
                }

                public String getSumTime() {
                    return sumTime;
                }

                public void setSumTime(String sumTime) {
                    this.sumTime = sumTime;
                }

                public String getNewFlag() {
                    return newFlag;
                }

                public void setNewFlag(String newFlag) {
                    this.newFlag = newFlag;
                }
            }

            public static class ApiEcAppraiseReplyListBean implements Serializable{
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * ecAppraiseReply : {"id":"a34838a82fe74ec0b4fd5edab31ba38f","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"appraiseId":"111","objectId":"111","replyContent":"谢谢您","replyFrom":"1","replyUser":"3523","objectUser":"2352","replyTime":"2018-04-25 00:00:00"}
                 * replyUserName : null
                 * objectUserName : 琳美甲
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private EcAppraiseReplyBean ecAppraiseReply;
                private Object replyUserName;
                private String objectUserName;

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

                public EcAppraiseReplyBean getEcAppraiseReply() {
                    return ecAppraiseReply;
                }

                public void setEcAppraiseReply(EcAppraiseReplyBean ecAppraiseReply) {
                    this.ecAppraiseReply = ecAppraiseReply;
                }

                public Object getReplyUserName() {
                    return replyUserName;
                }

                public void setReplyUserName(Object replyUserName) {
                    this.replyUserName = replyUserName;
                }

                public String getObjectUserName() {
                    return objectUserName;
                }

                public void setObjectUserName(String objectUserName) {
                    this.objectUserName = objectUserName;
                }

                public static class EcAppraiseReplyBean implements Serializable{
                    /**
                     * id : a34838a82fe74ec0b4fd5edab31ba38f
                     * isNewRecord : false
                     * remarks : null
                     * createDate : null
                     * updateDate : null
                     * appraiseId : 111
                     * objectId : 111
                     * replyContent : 谢谢您
                     * replyFrom : 1
                     * replyUser : 3523
                     * objectUser : 2352
                     * replyTime : 2018-04-25 00:00:00
                     */

                    private String id;
                    private boolean isNewRecord;
                    private Object remarks;
                    private Object createDate;
                    private Object updateDate;
                    private String appraiseId;
                    private String objectId;
                    private String replyContent;
                    private String replyFrom;
                    private String replyUser;
                    private String objectUser;
                    private String replyTime;

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

                    public String getAppraiseId() {
                        return appraiseId;
                    }

                    public void setAppraiseId(String appraiseId) {
                        this.appraiseId = appraiseId;
                    }

                    public String getObjectId() {
                        return objectId;
                    }

                    public void setObjectId(String objectId) {
                        this.objectId = objectId;
                    }

                    public String getReplyContent() {
                        return replyContent;
                    }

                    public void setReplyContent(String replyContent) {
                        this.replyContent = replyContent;
                    }

                    public String getReplyFrom() {
                        return replyFrom;
                    }

                    public void setReplyFrom(String replyFrom) {
                        this.replyFrom = replyFrom;
                    }

                    public String getReplyUser() {
                        return replyUser;
                    }

                    public void setReplyUser(String replyUser) {
                        this.replyUser = replyUser;
                    }

                    public String getObjectUser() {
                        return objectUser;
                    }

                    public void setObjectUser(String objectUser) {
                        this.objectUser = objectUser;
                    }

                    public String getReplyTime() {
                        return replyTime;
                    }

                    public void setReplyTime(String replyTime) {
                        this.replyTime = replyTime;
                    }
                }
            }
        }
    }
}
