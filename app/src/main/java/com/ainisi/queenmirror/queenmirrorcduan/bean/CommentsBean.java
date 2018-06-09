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
     * body : {"pageSum":7,"CommentsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","goodsName":"自然堂","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"RF","updatePgm":"ApiOrderService"},"ecAppraiseShop":{"id":"25d2f4cc4a154cd0aaffecb225b4eb07","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"1111","orderId":"1111","serviceAttitude":"1","shopEnvironment":"1","apprTime":"2018-04-27 15:10:06"},"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"cdcf9fb926e7482f9a3f24f9d1ed46e5","isNewRecord":false,"remarks":null,"createDate":"2018-05-29 09:26:07","updateDate":"2018-05-29 09:26:07","orderId":"b619986b5e194b9db01085d41cacafe0","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UT","updatePgm":"ApiOrderService"},"ecAppraiseShop":{"id":"63191e139d0e424f9ca23745d437cd42","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","orderId":"b619986b5e194b9db01085d41cacafe0","serviceAttitude":"1","shopEnvironment":"2","apprTime":"2018-04-27 16:19:39"},"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"233a959dde884abc9b8ea35d7f82474a","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 19:00:22","updateDate":"2018-05-28 19:00:22","orderId":"236dfbb862fc47fa8a56c83543347433","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"4a166a4d0c474dc5a90b663bf874b0d6","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 19:00:22","updateDate":"2018-05-28 19:00:22","orderId":"282bb7007a8047efb415a4e6626da90e","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"4ca85e3438f44f5ab137b789d588b5e5","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 18:51:37","updateDate":"2018-05-28 18:51:37","orderId":"2d0f91c5713d4e14a4fd7250c8adbdaf","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"5e0f9dd4a4b742059645c89b9e8e7ca6","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 19:00:22","updateDate":"2018-05-28 19:00:22","orderId":"6270ce6befc24012906223c332d21499","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"7626a08fbf11442f93aea544798c0049","isNewRecord":false,"remarks":null,"createDate":"2018-05-29 09:28:41","updateDate":"2018-05-29 09:28:41","orderId":"f0bbbb920d6242bb8e31858de214ff02","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"2","sumAmount":"0.02","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UT","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null}]}
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
        /**
         * pageSum : 7
         * CommentsListData : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","goodsName":"自然堂","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"RF","updatePgm":"ApiOrderService"},"ecAppraiseShop":{"id":"25d2f4cc4a154cd0aaffecb225b4eb07","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"1111","orderId":"1111","serviceAttitude":"1","shopEnvironment":"1","apprTime":"2018-04-27 15:10:06"},"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"cdcf9fb926e7482f9a3f24f9d1ed46e5","isNewRecord":false,"remarks":null,"createDate":"2018-05-29 09:26:07","updateDate":"2018-05-29 09:26:07","orderId":"b619986b5e194b9db01085d41cacafe0","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UT","updatePgm":"ApiOrderService"},"ecAppraiseShop":{"id":"63191e139d0e424f9ca23745d437cd42","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"111","orderId":"b619986b5e194b9db01085d41cacafe0","serviceAttitude":"1","shopEnvironment":"2","apprTime":"2018-04-27 16:19:39"},"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"233a959dde884abc9b8ea35d7f82474a","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 19:00:22","updateDate":"2018-05-28 19:00:22","orderId":"236dfbb862fc47fa8a56c83543347433","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"4a166a4d0c474dc5a90b663bf874b0d6","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 19:00:22","updateDate":"2018-05-28 19:00:22","orderId":"282bb7007a8047efb415a4e6626da90e","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"4ca85e3438f44f5ab137b789d588b5e5","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 18:51:37","updateDate":"2018-05-28 18:51:37","orderId":"2d0f91c5713d4e14a4fd7250c8adbdaf","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"5e0f9dd4a4b742059645c89b9e8e7ca6","isNewRecord":false,"remarks":null,"createDate":"2018-05-28 19:00:22","updateDate":"2018-05-28 19:00:22","orderId":"6270ce6befc24012906223c332d21499","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"1","sumAmount":"0.01","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"7626a08fbf11442f93aea544798c0049","isNewRecord":false,"remarks":null,"createDate":"2018-05-29 09:28:41","updateDate":"2018-05-29 09:28:41","orderId":"f0bbbb920d6242bb8e31858de214ff02","goodsId":"111","goodsName":"测试3","unitPrice":"0.01","purchaseNumber":"2","sumAmount":"0.02","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UT","updatePgm":"ApiOrderService"},"ecAppraiseShop":null,"ecAppraiseGoods":null,"goodsIdName":"测试3","custIdName":null,"shopIdName":null,"detailsStatusLabel":null,"ifMatchLabel":null,"employeeAbilityLabel":null,"ifAnonLabel":null,"serviceAttitudeLabel":null,"shopEnvironmentLabel":null,"map":null}]
         */

        private int pageSum;
        private List<CommentsListDataBean> CommentsListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

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
             * ansOrderDetails : {"id":"9c1ab6728e534231b233964be44fd585","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"1111","goodsId":"111","goodsName":"自然堂","unitPrice":"111.00","purchaseNumber":"1","sumAmount":"111.00","cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"RF","updatePgm":"ApiOrderService"}
             * ecAppraiseShop : {"id":"25d2f4cc4a154cd0aaffecb225b4eb07","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","shopId":"1111","orderId":"1111","serviceAttitude":"1","shopEnvironment":"1","apprTime":"2018-04-27 15:10:06"}
             * ecAppraiseGoods : null
             * goodsIdName : 测试3
             * custIdName : null
             * shopIdName : null
             * detailsStatusLabel : null
             * ifMatchLabel : null
             * employeeAbilityLabel : null
             * ifAnonLabel : null
             * serviceAttitudeLabel : null
             * shopEnvironmentLabel : null
             * map : null
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
            private Object serviceAttitudeLabel;
            private Object shopEnvironmentLabel;
            private Object map;

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

            public Object getMap() {
                return map;
            }

            public void setMap(Object map) {
                this.map = map;
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
                 * goodsName : 自然堂
                 * unitPrice : 111.00
                 * purchaseNumber : 1
                 * sumAmount : 111.00
                 * cpAmount : null
                 * discountAmount : null
                 * usePoints : null
                 * afterAmount : null
                 * consumeQrcode : null
                 * detailsRemarks : null
                 * detailsStatus : RF
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
