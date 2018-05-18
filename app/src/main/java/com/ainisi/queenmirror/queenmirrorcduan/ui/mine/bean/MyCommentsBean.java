package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by john on 2018/5/17.
 */

public class MyCommentsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CommentsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecAppraiseGoods":{"id":"111","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","goodsId":"q'w'r","detailId":"05d10158c051415a9d6bea9d6ef1a3fd","ifMatch":"2","employeeAbility":"1","apprDetails":"aff","apprPic":"","ifAnon":"0","apprLevel":"1","apprTime":"2018-04-11 00:00:00"},"ecAppraiseShop":{"id":"0eae9689e7e84af5a120a5d28c604cb1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","orderId":"6352b0d7cbc347d5b3bd7d3d61969524","serviceAttitude":"2","shopEnvironment":"1","apprTime":"2018-04-27 16:36:15"},"ansOrderDetails":{"id":"05d10158c051415a9d6bea9d6ef1a3fd","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:01","updateDate":"2018-05-04 11:29:01","orderId":"6352b0d7cbc347d5b3bd7d3d61969524","goodsId":"666","unitPrice":"111.00","purchaseNumber":"6","sumAmount":"666.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"ApiOrderService"},"ecShopScore":{"id":"112","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"shopId":"0eae9689e7e84af5a120a5d28c604cb1","goodsAppraiseate":null,"shopAppraise":"2","goodsScore":"1.0","shopScore":"1.0","sumScore":"2.0","serviceAttitude":null,"shopEnvironment":null,"levelOne":null,"levelTwo":null,"levelThree":null,"levelFour":null,"levelFive":null,"sumStart":"2018-04-09 09:54:46","sumEnd":"2018-04-25 09:54:51","sumTime":"2018-04-18 09:54:55","newFlag":"1"},"goodsIdName":null,"custIdName":null,"shopIdName":"美美理发店","ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"goodsAppraiseLabel":null,"shopAppraiseLabel":null}]}
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

    public static class BodyBean {
        private List<CommentsListDataBean> CommentsListData;

        public List<CommentsListDataBean> getCommentsListData() {
            return CommentsListData;
        }

        public void setCommentsListData(List<CommentsListDataBean> CommentsListData) {
            this.CommentsListData = CommentsListData;
        }

        public static class CommentsListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecAppraiseGoods : {"id":"111","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","goodsId":"q'w'r","detailId":"05d10158c051415a9d6bea9d6ef1a3fd","ifMatch":"2","employeeAbility":"1","apprDetails":"aff","apprPic":"","ifAnon":"0","apprLevel":"1","apprTime":"2018-04-11 00:00:00"}
             * ecAppraiseShop : {"id":"0eae9689e7e84af5a120a5d28c604cb1","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","orderId":"6352b0d7cbc347d5b3bd7d3d61969524","serviceAttitude":"2","shopEnvironment":"1","apprTime":"2018-04-27 16:36:15"}
             * ansOrderDetails : {"id":"05d10158c051415a9d6bea9d6ef1a3fd","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:01","updateDate":"2018-05-04 11:29:01","orderId":"6352b0d7cbc347d5b3bd7d3d61969524","goodsId":"666","unitPrice":"111.00","purchaseNumber":"6","sumAmount":"666.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":null,"updatePgm":"ApiOrderService"}
             * ecShopScore : {"id":"112","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"shopId":"0eae9689e7e84af5a120a5d28c604cb1","goodsAppraiseate":null,"shopAppraise":"2","goodsScore":"1.0","shopScore":"1.0","sumScore":"2.0","serviceAttitude":null,"shopEnvironment":null,"levelOne":null,"levelTwo":null,"levelThree":null,"levelFour":null,"levelFive":null,"sumStart":"2018-04-09 09:54:46","sumEnd":"2018-04-25 09:54:51","sumTime":"2018-04-18 09:54:55","newFlag":"1"}
             * goodsIdName : null
             * custIdName : null
             * shopIdName : 美美理发店
             * ifMatchLabel : null
             * employeeAbilityLabel : null
             * ifAnonLabel : null
             * serviceAttitudeLabel : null
             * shopEnvironmentLabel : null
             * goodsAppraiseLabel : null
             * shopAppraiseLabel : null
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
            private Object goodsIdName;
            private Object custIdName;
            private String shopIdName;
            private Object ifMatchLabel;
            private Object employeeAbilityLabel;
            private Object ifAnonLabel;
            private Object serviceAttitudeLabel;
            private Object shopEnvironmentLabel;
            private Object goodsAppraiseLabel;
            private Object shopAppraiseLabel;

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

            public Object getGoodsIdName() {
                return goodsIdName;
            }

            public void setGoodsIdName(Object goodsIdName) {
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

            public static class EcAppraiseGoodsBean {
                /**
                 * id : 111
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 111
                 * shopId : 111
                 * goodsId : q'w'r
                 * detailId : 05d10158c051415a9d6bea9d6ef1a3fd
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

            public static class EcAppraiseShopBean {
                /**
                 * id : 0eae9689e7e84af5a120a5d28c604cb1
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 111
                 * shopId : 111
                 * orderId : 6352b0d7cbc347d5b3bd7d3d61969524
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

            public static class AnsOrderDetailsBean {
                /**
                 * id : 05d10158c051415a9d6bea9d6ef1a3fd
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-04 11:29:01
                 * updateDate : 2018-05-04 11:29:01
                 * orderId : 6352b0d7cbc347d5b3bd7d3d61969524
                 * goodsId : 666
                 * unitPrice : 111.00
                 * purchaseNumber : 6
                 * sumAmount : 666.00
                 * cpAmount : null
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
                private String unitPrice;
                private String purchaseNumber;
                private String sumAmount;
                private Object cpAmount;
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

            public static class EcShopScoreBean {
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
        }
    }
}
