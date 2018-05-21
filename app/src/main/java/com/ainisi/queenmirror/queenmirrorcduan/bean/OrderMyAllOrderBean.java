package com.ainisi.queenmirror.queenmirrorcduan.bean;


import java.io.Serializable;
import java.util.List;

public class OrderMyAllOrderBean implements Serializable{


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pageSum":1,"apiOrderList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"2222","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"11285916","shopId":"1111","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"consumeQrcode":null,"qrcodeSource":null,"verifyTime":null,"finishTime":null,"confirmTime":null,"orderAmount":666,"cpAmount":null,"afterAmount":null,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a8e43","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"2222","goodsId":"333","goodsName":"mimi","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-16 13:20:40","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"4","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":null,"detailsStatusLabel":null}]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}]}
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
         * pageSum : 1
         * apiOrderList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrder":{"id":"2222","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"11285916","shopId":"1111","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"consumeQrcode":null,"qrcodeSource":null,"verifyTime":null,"finishTime":null,"confirmTime":null,"orderAmount":666,"cpAmount":null,"afterAmount":null,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a8e43","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"2222","goodsId":"333","goodsName":"mimi","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-16 13:20:40","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"4","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":null,"detailsStatusLabel":null}]},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":null,"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}]
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

        public static class ApiOrderListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansOrder : {"id":"2222","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderNo":"11285916","shopId":"1111","custId":"1111","orderTime":"2018-05-04 11:29:00","takeTime":null,"consumeQrcode":null,"qrcodeSource":null,"verifyTime":null,"finishTime":null,"confirmTime":null,"orderAmount":666,"cpAmount":null,"afterAmount":null,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"UP","custRemarks":null,"transId":null,"updatePgm":"ApiOrderService","apiOrderDetailsList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a8e43","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"2222","goodsId":"333","goodsName":"mimi","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-16 13:20:40","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"4","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":null,"detailsStatusLabel":null}]}
             * ansOrderDetails : null
             * ecGoodsBasic : null
             * ansShopBasic : null
             * ansCustBasic : null
             * paymentMethodLabel : null
             * orderStatusLabel : null
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * saleFlagLabel : null
             * shopCateLabel : null
             * industryCateLabel : null
             * businessFlagLabel : null
             * enableFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsOrderBean ansOrder;
            private Object ansOrderDetails;
            private Object ecGoodsBasic;
            private Object ansShopBasic;
            private Object ansCustBasic;
            private Object paymentMethodLabel;
            private Object orderStatusLabel;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private Object saleFlagLabel;
            private Object shopCateLabel;
            private Object industryCateLabel;
            private Object businessFlagLabel;
            private Object enableFlagLabel;

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

            public Object getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(Object ansShopBasic) {
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

            public Object getShopCateLabel() {
                return shopCateLabel;
            }

            public void setShopCateLabel(Object shopCateLabel) {
                this.shopCateLabel = shopCateLabel;
            }

            public Object getIndustryCateLabel() {
                return industryCateLabel;
            }

            public void setIndustryCateLabel(Object industryCateLabel) {
                this.industryCateLabel = industryCateLabel;
            }

            public Object getBusinessFlagLabel() {
                return businessFlagLabel;
            }

            public void setBusinessFlagLabel(Object businessFlagLabel) {
                this.businessFlagLabel = businessFlagLabel;
            }

            public Object getEnableFlagLabel() {
                return enableFlagLabel;
            }

            public void setEnableFlagLabel(Object enableFlagLabel) {
                this.enableFlagLabel = enableFlagLabel;
            }

            public static class AnsOrderBean {
                /**
                 * id : 2222
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-04 11:29:00
                 * updateDate : 2018-05-04 11:29:00
                 * orderNo : 11285916
                 * shopId : 1111
                 * custId : 1111
                 * orderTime : 2018-05-04 11:29:00
                 * takeTime : null
                 * consumeQrcode : null
                 * qrcodeSource : null
                 * verifyTime : null
                 * finishTime : null
                 * confirmTime : null
                 * orderAmount : 666.0
                 * cpAmount : null
                 * afterAmount : null
                 * paymentMethod : null
                 * paymentKeys : null
                 * paymentTime : null
                 * orderStatus : UP
                 * custRemarks : null
                 * transId : null
                 * updatePgm : ApiOrderService
                 * apiOrderDetailsList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansOrderDetails":{"id":"e372585868094b039ac24aaf541a8e43","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"2222","goodsId":"333","goodsName":"mimi","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"},"ecGoodsBasic":{"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-16 13:20:40","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"4","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":null,"detailsStatusLabel":null}]
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderNo;
                private String shopId;
                private String custId;
                private String orderTime;
                private Object takeTime;
                private Object consumeQrcode;
                private Object qrcodeSource;
                private Object verifyTime;
                private Object finishTime;
                private Object confirmTime;
                private double orderAmount;
                private Object cpAmount;
                private Object afterAmount;
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

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
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

                public Object getConsumeQrcode() {
                    return consumeQrcode;
                }

                public void setConsumeQrcode(Object consumeQrcode) {
                    this.consumeQrcode = consumeQrcode;
                }

                public Object getQrcodeSource() {
                    return qrcodeSource;
                }

                public void setQrcodeSource(Object qrcodeSource) {
                    this.qrcodeSource = qrcodeSource;
                }

                public Object getVerifyTime() {
                    return verifyTime;
                }

                public void setVerifyTime(Object verifyTime) {
                    this.verifyTime = verifyTime;
                }

                public Object getFinishTime() {
                    return finishTime;
                }

                public void setFinishTime(Object finishTime) {
                    this.finishTime = finishTime;
                }

                public Object getConfirmTime() {
                    return confirmTime;
                }

                public void setConfirmTime(Object confirmTime) {
                    this.confirmTime = confirmTime;
                }

                public double getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(double orderAmount) {
                    this.orderAmount = orderAmount;
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

                public static class ApiOrderDetailsListBean {
                    /**
                     * id : null
                     * isNewRecord : true
                     * remarks : null
                     * createDate : null
                     * updateDate : null
                     * ansOrderDetails : {"id":"e372585868094b039ac24aaf541a8e43","isNewRecord":false,"remarks":null,"createDate":"2018-05-04 11:29:00","updateDate":"2018-05-04 11:29:00","orderId":"2222","goodsId":"333","goodsName":"mimi","unitPrice":"111.00","purchaseNumber":"3","sumAmount":"333.00","cpAmount":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"UP","updatePgm":"ApiOrderService"}
                     * ecGoodsBasic : {"id":"333","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-16 13:20:40","goodsCate":"美容美体","goodsType":"2","goodsName":"测试119","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":null,"marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"4","approveBy":null,"approveDate":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"}
                     * ansShopBasic : null
                     * detailsStatusLabel : null
                     */

                    private Object id;
                    private boolean isNewRecord;
                    private Object remarks;
                    private Object createDate;
                    private Object updateDate;
                    private AnsOrderDetailsBean ansOrderDetails;
                    private EcGoodsBasicBean ecGoodsBasic;
                    private Object ansShopBasic;
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

                    public Object getAnsShopBasic() {
                        return ansShopBasic;
                    }

                    public void setAnsShopBasic(Object ansShopBasic) {
                        this.ansShopBasic = ansShopBasic;
                    }

                    public Object getDetailsStatusLabel() {
                        return detailsStatusLabel;
                    }

                    public void setDetailsStatusLabel(Object detailsStatusLabel) {
                        this.detailsStatusLabel = detailsStatusLabel;
                    }

                    public static class AnsOrderDetailsBean {
                        /**
                         * id : e372585868094b039ac24aaf541a8e43
                         * isNewRecord : false
                         * remarks : null
                         * createDate : 2018-05-04 11:29:00
                         * updateDate : 2018-05-04 11:29:00
                         * orderId : 2222
                         * goodsId : 333
                         * goodsName : mimi
                         * unitPrice : 111.00
                         * purchaseNumber : 3
                         * sumAmount : 333.00
                         * cpAmount : null
                         * afterAmount : null
                         * consumeQrcode : null
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
                        private String goodsName;
                        private String unitPrice;
                        private String purchaseNumber;
                        private String sumAmount;
                        private Object cpAmount;
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

                    public static class EcGoodsBasicBean {
                        /**
                         * id : 333
                         * isNewRecord : false
                         * remarks : null
                         * createDate : 2018-05-08 10:23:30
                         * updateDate : 2018-05-16 13:20:40
                         * goodsCate : 美容美体
                         * goodsType : 2
                         * goodsName : 测试119
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
                         * goodsBanner : null
                         * shopId : 111
                         * saleFlag : 4
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
                        private Object goodsBanner;
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

                        public Object getGoodsBanner() {
                            return goodsBanner;
                        }

                        public void setGoodsBanner(Object goodsBanner) {
                            this.goodsBanner = goodsBanner;
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
                }
            }
        }
    }
}
