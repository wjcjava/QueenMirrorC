package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

/**
 * Created by john on 2018/5/11.
 */

public class CommentsBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiGoodsCommentsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":{"id":"25d2f4cc4a154cd0aaffecb225b4eb07","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"1111","orderId":"1111","serviceAttitude":"1","shopEnvironment":"1","apprTime":"2018-04-27 15:10:06"},"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":"差","shopEnvironmentLabel":"差"}]}
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
        private List<ApiGoodsCommentsListBean> apiGoodsCommentsList;

        public List<ApiGoodsCommentsListBean> getApiGoodsCommentsList() {
            return apiGoodsCommentsList;
        }

        public void setApiGoodsCommentsList(List<ApiGoodsCommentsListBean> apiGoodsCommentsList) {
            this.apiGoodsCommentsList = apiGoodsCommentsList;
        }

        public static class ApiGoodsCommentsListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansOrderDetails : {"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"}
             * ecAppraiseShop : {"id":"25d2f4cc4a154cd0aaffecb225b4eb07","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"1111","orderId":"1111","serviceAttitude":"1","shopEnvironment":"1","apprTime":"2018-04-27 15:10:06"}
             * ecAppraiseGoods : null
             * goodsIdName : 测试3
             * custIdName : null
             * shopIdName : null
             * detailsStatusLabel : null
             * ifMatchLabel : null
             * employeeAbilityLabel : null
             * ifAnonLabel : null
             * serviceAttitudeLabel : 差
             * shopEnvironmentLabel : 差
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsOrderDetailsBean ansOrderDetails;
            private EcAppraiseShopBean ecAppraiseShop;
            private Object ecAppraiseGoods;
            private String goodsIdName;
            private Object custIdName;
            private Object shopIdName;
            private Object detailsStatusLabel;
            private Object ifMatchLabel;
            private Object employeeAbilityLabel;
            private Object ifAnonLabel;
            private String serviceAttitudeLabel;
            private String shopEnvironmentLabel;

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

            public EcAppraiseShopBean getEcAppraiseShop() {
                return ecAppraiseShop;
            }

            public void setEcAppraiseShop(EcAppraiseShopBean ecAppraiseShop) {
                this.ecAppraiseShop = ecAppraiseShop;
            }

            public Object getEcAppraiseGoods() {
                return ecAppraiseGoods;
            }

            public void setEcAppraiseGoods(Object ecAppraiseGoods) {
                this.ecAppraiseGoods = ecAppraiseGoods;
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

            public Object getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(Object shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getDetailsStatusLabel() {
                return detailsStatusLabel;
            }

            public void setDetailsStatusLabel(Object detailsStatusLabel) {
                this.detailsStatusLabel = detailsStatusLabel;
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

            public String getServiceAttitudeLabel() {
                return serviceAttitudeLabel;
            }

            public void setServiceAttitudeLabel(String serviceAttitudeLabel) {
                this.serviceAttitudeLabel = serviceAttitudeLabel;
            }

            public String getShopEnvironmentLabel() {
                return shopEnvironmentLabel;
            }

            public void setShopEnvironmentLabel(String shopEnvironmentLabel) {
                this.shopEnvironmentLabel = shopEnvironmentLabel;
            }

            public static class AnsOrderDetailsBean {
                /**
                 * id : 9c1ab6728e534231b233964be44fd585
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-04 11:29:00
                 * updateDate : 2018-05-04 11:29:00
                 * orderId : 1111
                 * goodsId : 111
                 * unitPrice : 111.00
                 * purchaseNumber : 1
                 * sumAmount : 111.00
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

            public static class EcAppraiseShopBean {
                /**
                 * id : 25d2f4cc4a154cd0aaffecb225b4eb07
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 111
                 * shopId : 1111
                 * orderId : 1111
                 * serviceAttitude : 1
                 * shopEnvironment : 1
                 * apprTime : 2018-04-27 15:10:06
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
        }
    }
}
