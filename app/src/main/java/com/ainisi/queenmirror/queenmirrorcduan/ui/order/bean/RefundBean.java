package com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 */

public class RefundBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiRefundList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustRefund":{"id":"562b2b3f8c5344a6a0bb64b9f21f4f3b","isNewRecord":false,"remarks":null,"createDate":"2018-06-11 19:09:40","updateDate":"2018-06-11 19:09:40","orderId":"df0d11e2adf14116a50a5992641089da","detailsId":"70656a3e2b204079a22f6231f00d364f","custId":"6f2f98dc426646f7adf978637e3e077a","shopId":"784c86c5a355436b9e169ac3b40651d4","goodsId":"92c246c0a64e49ea82a90f50a2968fbe","refundReason":"2","otherReason":null,"refundAmount":0.01,"actualAmount":0.01,"refundDetails":"空","refundEvidence":"","refundStatus":"1","updatePgm":null},"ansOrderDetails":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"orderId":null,"goodsId":null,"goodsName":null,"unitPrice":null,"purchaseNumber":null,"sumAmount":null,"cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"RA","updatePgm":null},"ansOrder":null,"ansShopBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"流川枫美发沙龙","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":0,"signStart":null,"signEnd":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null},"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"13405024815","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"ecGoodsBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsCate":null,"goodsType":null,"goodsName":"买不起啊","goodsNo":null,"goodsBrief":null,"serviceTime":null,"goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":null,"goodsStorage":null,"marketPrice":null,"salesPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":null,"saleFlag":null,"ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":null,"shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"refundReasonLabel":null,"refundStatusLabel":null}]}
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
        private List<ApiRefundListBean> apiRefundList;

        public List<ApiRefundListBean> getApiRefundList() {
            return apiRefundList;
        }

        public void setApiRefundList(List<ApiRefundListBean> apiRefundList) {
            this.apiRefundList = apiRefundList;
        }

        public static class ApiRefundListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansCustRefund : {"id":"562b2b3f8c5344a6a0bb64b9f21f4f3b","isNewRecord":false,"remarks":null,"createDate":"2018-06-11 19:09:40","updateDate":"2018-06-11 19:09:40","orderId":"df0d11e2adf14116a50a5992641089da","detailsId":"70656a3e2b204079a22f6231f00d364f","custId":"6f2f98dc426646f7adf978637e3e077a","shopId":"784c86c5a355436b9e169ac3b40651d4","goodsId":"92c246c0a64e49ea82a90f50a2968fbe","refundReason":"2","otherReason":null,"refundAmount":0.01,"actualAmount":0.01,"refundDetails":"空","refundEvidence":"","refundStatus":"1","updatePgm":null}
             * ansOrderDetails : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"orderId":null,"goodsId":null,"goodsName":null,"unitPrice":null,"purchaseNumber":null,"sumAmount":null,"cpAmount":null,"discountAmount":null,"usePoints":null,"afterAmount":null,"consumeQrcode":null,"detailsRemarks":null,"detailsStatus":"RA","updatePgm":null}
             * ansOrder : null
             * ansShopBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"merchantId":null,"contractConfirm":null,"ifContract":null,"shopName":"流川枫美发沙龙","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"ifNew":null,"shopBanner":null,"shopActivity":null,"shopFeature":null,"queenCard":null,"shopTab":null,"shopCate":null,"industryCate":null,"belongCity":null,"addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":null,"openTime":null,"closeTime":null,"serviceTel":null,"shopContacts":null,"contactsTel":null,"contactsMail":null,"ifLicence":null,"shopProperty":null,"shopLegal":null,"legalIdc":null,"legalIdp":null,"legalProvince":null,"legalCity":null,"legalDistrict":null,"legalAddress":null,"taxNumber":null,"businessLicence":null,"shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":null,"businessFlag":null,"enableFlag":null,"signFlag":null,"geoX":null,"geoY":null,"updatePgm":null,"belongCityName":null,"apiAnsCustCartList":null,"goodsCounts":0,"approveBy":null,"openFee":0,"serviceFee":0,"servicePeriod":0,"signStart":null,"signEnd":null,"ansSnsType":null,"snsId":null,"snsName":null,"serviceAgreement":null,"adAgreement":null,"otherAgreement":null}
             * ansCustBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"13405024815","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null}
             * ecGoodsBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsCate":null,"goodsType":null,"goodsName":"买不起啊","goodsNo":null,"goodsBrief":null,"serviceTime":null,"goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":null,"goodsStorage":null,"marketPrice":null,"salesPrice":null,"goodsActivity":null,"goodsBanner":null,"shopId":null,"saleFlag":null,"ifPoint":null,"pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":null,"endTime":null,"goodsRemarks":null,"updatePgm":null,"shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null}
             * refundReasonLabel : null
             * refundStatusLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsCustRefundBean ansCustRefund;
            private AnsOrderDetailsBean ansOrderDetails;
            private Object ansOrder;
            private AnsShopBasicBean ansShopBasic;
            private AnsCustBasicBean ansCustBasic;
            private EcGoodsBasicBean ecGoodsBasic;
            private Object refundReasonLabel;
            private Object refundStatusLabel;

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

            public AnsCustRefundBean getAnsCustRefund() {
                return ansCustRefund;
            }

            public void setAnsCustRefund(AnsCustRefundBean ansCustRefund) {
                this.ansCustRefund = ansCustRefund;
            }

            public AnsOrderDetailsBean getAnsOrderDetails() {
                return ansOrderDetails;
            }

            public void setAnsOrderDetails(AnsOrderDetailsBean ansOrderDetails) {
                this.ansOrderDetails = ansOrderDetails;
            }

            public Object getAnsOrder() {
                return ansOrder;
            }

            public void setAnsOrder(Object ansOrder) {
                this.ansOrder = ansOrder;
            }

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public AnsCustBasicBean getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(AnsCustBasicBean ansCustBasic) {
                this.ansCustBasic = ansCustBasic;
            }

            public EcGoodsBasicBean getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public Object getRefundReasonLabel() {
                return refundReasonLabel;
            }

            public void setRefundReasonLabel(Object refundReasonLabel) {
                this.refundReasonLabel = refundReasonLabel;
            }

            public Object getRefundStatusLabel() {
                return refundStatusLabel;
            }

            public void setRefundStatusLabel(Object refundStatusLabel) {
                this.refundStatusLabel = refundStatusLabel;
            }

            public static class AnsCustRefundBean {
                /**
                 * id : 562b2b3f8c5344a6a0bb64b9f21f4f3b
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-11 19:09:40
                 * updateDate : 2018-06-11 19:09:40
                 * orderId : df0d11e2adf14116a50a5992641089da
                 * detailsId : 70656a3e2b204079a22f6231f00d364f
                 * custId : 6f2f98dc426646f7adf978637e3e077a
                 * shopId : 784c86c5a355436b9e169ac3b40651d4
                 * goodsId : 92c246c0a64e49ea82a90f50a2968fbe
                 * refundReason : 2
                 * otherReason : null
                 * refundAmount : 0.01
                 * actualAmount : 0.01
                 * refundDetails : 空
                 * refundEvidence :
                 * refundStatus : 1
                 * updatePgm : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderId;
                private String detailsId;
                private String custId;
                private String shopId;
                private String goodsId;
                private String refundReason;
                private Object otherReason;
                private double refundAmount;
                private double actualAmount;
                private String refundDetails;
                private String refundEvidence;
                private String refundStatus;
                private Object updatePgm;

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

                public String getDetailsId() {
                    return detailsId;
                }

                public void setDetailsId(String detailsId) {
                    this.detailsId = detailsId;
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

                public String getRefundReason() {
                    return refundReason;
                }

                public void setRefundReason(String refundReason) {
                    this.refundReason = refundReason;
                }

                public Object getOtherReason() {
                    return otherReason;
                }

                public void setOtherReason(Object otherReason) {
                    this.otherReason = otherReason;
                }

                public double getRefundAmount() {
                    return refundAmount;
                }

                public void setRefundAmount(double refundAmount) {
                    this.refundAmount = refundAmount;
                }

                public double getActualAmount() {
                    return actualAmount;
                }

                public void setActualAmount(double actualAmount) {
                    this.actualAmount = actualAmount;
                }

                public String getRefundDetails() {
                    return refundDetails;
                }

                public void setRefundDetails(String refundDetails) {
                    this.refundDetails = refundDetails;
                }

                public String getRefundEvidence() {
                    return refundEvidence;
                }

                public void setRefundEvidence(String refundEvidence) {
                    this.refundEvidence = refundEvidence;
                }

                public String getRefundStatus() {
                    return refundStatus;
                }

                public void setRefundStatus(String refundStatus) {
                    this.refundStatus = refundStatus;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class AnsOrderDetailsBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * orderId : null
                 * goodsId : null
                 * goodsName : null
                 * unitPrice : null
                 * purchaseNumber : null
                 * sumAmount : null
                 * cpAmount : null
                 * discountAmount : null
                 * usePoints : null
                 * afterAmount : null
                 * consumeQrcode : null
                 * detailsRemarks : null
                 * detailsStatus : RA
                 * updatePgm : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object orderId;
                private Object goodsId;
                private Object goodsName;
                private Object unitPrice;
                private Object purchaseNumber;
                private Object sumAmount;
                private Object cpAmount;
                private Object discountAmount;
                private Object usePoints;
                private Object afterAmount;
                private Object consumeQrcode;
                private Object detailsRemarks;
                private String detailsStatus;
                private Object updatePgm;

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

                public Object getOrderId() {
                    return orderId;
                }

                public void setOrderId(Object orderId) {
                    this.orderId = orderId;
                }

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
                }

                public Object getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(Object goodsName) {
                    this.goodsName = goodsName;
                }

                public Object getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(Object unitPrice) {
                    this.unitPrice = unitPrice;
                }

                public Object getPurchaseNumber() {
                    return purchaseNumber;
                }

                public void setPurchaseNumber(Object purchaseNumber) {
                    this.purchaseNumber = purchaseNumber;
                }

                public Object getSumAmount() {
                    return sumAmount;
                }

                public void setSumAmount(Object sumAmount) {
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

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class AnsShopBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * merchantId : null
                 * contractConfirm : null
                 * ifContract : null
                 * shopName : 流川枫美发沙龙
                 * shortName : null
                 * shopNo : null
                 * marketAssistant : null
                 * shopBrief : null
                 * shopAccounce : null
                 * ifNew : null
                 * shopBanner : null
                 * shopActivity : null
                 * shopFeature : null
                 * queenCard : null
                 * shopTab : null
                 * shopCate : null
                 * industryCate : null
                 * belongCity : null
                 * addrProvince : null
                 * addrCity : null
                 * addrDistrict : null
                 * shopAddr : null
                 * openTime : null
                 * closeTime : null
                 * serviceTel : null
                 * shopContacts : null
                 * contactsTel : null
                 * contactsMail : null
                 * ifLicence : null
                 * shopProperty : null
                 * shopLegal : null
                 * legalIdc : null
                 * legalIdp : null
                 * legalProvince : null
                 * legalCity : null
                 * legalDistrict : null
                 * legalAddress : null
                 * taxNumber : null
                 * businessLicence : null
                 * shopCharge : null
                 * chargeIdc : null
                 * chargeIdp : null
                 * shopLogo : null
                 * shopPhoto : null
                 * shopEnvPhoto : null
                 * joinTime : null
                 * businessFlag : null
                 * enableFlag : null
                 * signFlag : null
                 * geoX : null
                 * geoY : null
                 * updatePgm : null
                 * belongCityName : null
                 * apiAnsCustCartList : null
                 * goodsCounts : 0
                 * approveBy : null
                 * openFee : 0.0
                 * serviceFee : 0.0
                 * servicePeriod : 0.0
                 * signStart : null
                 * signEnd : null
                 * ansSnsType : null
                 * snsId : null
                 * snsName : null
                 * serviceAgreement : null
                 * adAgreement : null
                 * otherAgreement : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object merchantId;
                private Object contractConfirm;
                private Object ifContract;
                private String shopName;
                private Object shortName;
                private Object shopNo;
                private Object marketAssistant;
                private Object shopBrief;
                private Object shopAccounce;
                private Object ifNew;
                private Object shopBanner;
                private Object shopActivity;
                private Object shopFeature;
                private Object queenCard;
                private Object shopTab;
                private Object shopCate;
                private Object industryCate;
                private Object belongCity;
                private Object addrProvince;
                private Object addrCity;
                private Object addrDistrict;
                private Object shopAddr;
                private Object openTime;
                private Object closeTime;
                private Object serviceTel;
                private Object shopContacts;
                private Object contactsTel;
                private Object contactsMail;
                private Object ifLicence;
                private Object shopProperty;
                private Object shopLegal;
                private Object legalIdc;
                private Object legalIdp;
                private Object legalProvince;
                private Object legalCity;
                private Object legalDistrict;
                private Object legalAddress;
                private Object taxNumber;
                private Object businessLicence;
                private Object shopCharge;
                private Object chargeIdc;
                private Object chargeIdp;
                private Object shopLogo;
                private Object shopPhoto;
                private Object shopEnvPhoto;
                private Object joinTime;
                private Object businessFlag;
                private Object enableFlag;
                private Object signFlag;
                private Object geoX;
                private Object geoY;
                private Object updatePgm;
                private Object belongCityName;
                private Object apiAnsCustCartList;
                private int goodsCounts;
                private Object approveBy;
                private double openFee;
                private double serviceFee;
                private double servicePeriod;
                private Object signStart;
                private Object signEnd;
                private Object ansSnsType;
                private Object snsId;
                private Object snsName;
                private Object serviceAgreement;
                private Object adAgreement;
                private Object otherAgreement;

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

                public Object getMerchantId() {
                    return merchantId;
                }

                public void setMerchantId(Object merchantId) {
                    this.merchantId = merchantId;
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

                public Object getIfNew() {
                    return ifNew;
                }

                public void setIfNew(Object ifNew) {
                    this.ifNew = ifNew;
                }

                public Object getShopBanner() {
                    return shopBanner;
                }

                public void setShopBanner(Object shopBanner) {
                    this.shopBanner = shopBanner;
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

                public Object getQueenCard() {
                    return queenCard;
                }

                public void setQueenCard(Object queenCard) {
                    this.queenCard = queenCard;
                }

                public Object getShopTab() {
                    return shopTab;
                }

                public void setShopTab(Object shopTab) {
                    this.shopTab = shopTab;
                }

                public Object getShopCate() {
                    return shopCate;
                }

                public void setShopCate(Object shopCate) {
                    this.shopCate = shopCate;
                }

                public Object getIndustryCate() {
                    return industryCate;
                }

                public void setIndustryCate(Object industryCate) {
                    this.industryCate = industryCate;
                }

                public Object getBelongCity() {
                    return belongCity;
                }

                public void setBelongCity(Object belongCity) {
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

                public Object getShopAddr() {
                    return shopAddr;
                }

                public void setShopAddr(Object shopAddr) {
                    this.shopAddr = shopAddr;
                }

                public Object getOpenTime() {
                    return openTime;
                }

                public void setOpenTime(Object openTime) {
                    this.openTime = openTime;
                }

                public Object getCloseTime() {
                    return closeTime;
                }

                public void setCloseTime(Object closeTime) {
                    this.closeTime = closeTime;
                }

                public Object getServiceTel() {
                    return serviceTel;
                }

                public void setServiceTel(Object serviceTel) {
                    this.serviceTel = serviceTel;
                }

                public Object getShopContacts() {
                    return shopContacts;
                }

                public void setShopContacts(Object shopContacts) {
                    this.shopContacts = shopContacts;
                }

                public Object getContactsTel() {
                    return contactsTel;
                }

                public void setContactsTel(Object contactsTel) {
                    this.contactsTel = contactsTel;
                }

                public Object getContactsMail() {
                    return contactsMail;
                }

                public void setContactsMail(Object contactsMail) {
                    this.contactsMail = contactsMail;
                }

                public Object getIfLicence() {
                    return ifLicence;
                }

                public void setIfLicence(Object ifLicence) {
                    this.ifLicence = ifLicence;
                }

                public Object getShopProperty() {
                    return shopProperty;
                }

                public void setShopProperty(Object shopProperty) {
                    this.shopProperty = shopProperty;
                }

                public Object getShopLegal() {
                    return shopLegal;
                }

                public void setShopLegal(Object shopLegal) {
                    this.shopLegal = shopLegal;
                }

                public Object getLegalIdc() {
                    return legalIdc;
                }

                public void setLegalIdc(Object legalIdc) {
                    this.legalIdc = legalIdc;
                }

                public Object getLegalIdp() {
                    return legalIdp;
                }

                public void setLegalIdp(Object legalIdp) {
                    this.legalIdp = legalIdp;
                }

                public Object getLegalProvince() {
                    return legalProvince;
                }

                public void setLegalProvince(Object legalProvince) {
                    this.legalProvince = legalProvince;
                }

                public Object getLegalCity() {
                    return legalCity;
                }

                public void setLegalCity(Object legalCity) {
                    this.legalCity = legalCity;
                }

                public Object getLegalDistrict() {
                    return legalDistrict;
                }

                public void setLegalDistrict(Object legalDistrict) {
                    this.legalDistrict = legalDistrict;
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

                public Object getBusinessLicence() {
                    return businessLicence;
                }

                public void setBusinessLicence(Object businessLicence) {
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

                public Object getJoinTime() {
                    return joinTime;
                }

                public void setJoinTime(Object joinTime) {
                    this.joinTime = joinTime;
                }

                public Object getBusinessFlag() {
                    return businessFlag;
                }

                public void setBusinessFlag(Object businessFlag) {
                    this.businessFlag = businessFlag;
                }

                public Object getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(Object enableFlag) {
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

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public Object getBelongCityName() {
                    return belongCityName;
                }

                public void setBelongCityName(Object belongCityName) {
                    this.belongCityName = belongCityName;
                }

                public Object getApiAnsCustCartList() {
                    return apiAnsCustCartList;
                }

                public void setApiAnsCustCartList(Object apiAnsCustCartList) {
                    this.apiAnsCustCartList = apiAnsCustCartList;
                }

                public int getGoodsCounts() {
                    return goodsCounts;
                }

                public void setGoodsCounts(int goodsCounts) {
                    this.goodsCounts = goodsCounts;
                }

                public Object getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(Object approveBy) {
                    this.approveBy = approveBy;
                }

                public double getOpenFee() {
                    return openFee;
                }

                public void setOpenFee(double openFee) {
                    this.openFee = openFee;
                }

                public double getServiceFee() {
                    return serviceFee;
                }

                public void setServiceFee(double serviceFee) {
                    this.serviceFee = serviceFee;
                }

                public double getServicePeriod() {
                    return servicePeriod;
                }

                public void setServicePeriod(double servicePeriod) {
                    this.servicePeriod = servicePeriod;
                }

                public Object getSignStart() {
                    return signStart;
                }

                public void setSignStart(Object signStart) {
                    this.signStart = signStart;
                }

                public Object getSignEnd() {
                    return signEnd;
                }

                public void setSignEnd(Object signEnd) {
                    this.signEnd = signEnd;
                }

                public Object getAnsSnsType() {
                    return ansSnsType;
                }

                public void setAnsSnsType(Object ansSnsType) {
                    this.ansSnsType = ansSnsType;
                }

                public Object getSnsId() {
                    return snsId;
                }

                public void setSnsId(Object snsId) {
                    this.snsId = snsId;
                }

                public Object getSnsName() {
                    return snsName;
                }

                public void setSnsName(Object snsName) {
                    this.snsName = snsName;
                }

                public Object getServiceAgreement() {
                    return serviceAgreement;
                }

                public void setServiceAgreement(Object serviceAgreement) {
                    this.serviceAgreement = serviceAgreement;
                }

                public Object getAdAgreement() {
                    return adAgreement;
                }

                public void setAdAgreement(Object adAgreement) {
                    this.adAgreement = adAgreement;
                }

                public Object getOtherAgreement() {
                    return otherAgreement;
                }

                public void setOtherAgreement(Object otherAgreement) {
                    this.otherAgreement = otherAgreement;
                }
            }

            public static class AnsCustBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * contractConfirm : null
                 * cellPhone : null
                 * deviceToken : null
                 * userName : 13405024815
                 * userPass : null
                 * wechatId : null
                 * wechatToken : null
                 * qqId : null
                 * qqToken : null
                 * completeFlag : null
                 * headPic : null
                 * lastName : null
                 * firstName : null
                 * idCard : null
                 * nameIdentify : null
                 * sex : null
                 * birthday : null
                 * registerDate : null
                 * nickName : null
                 * loginIp : null
                 * logininTime : null
                 * loginoutTime : null
                 * loginFlag : null
                 * recommendUser : null
                 * recommendCode : null
                 * updatBy : null
                 * updatePgm : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object contractConfirm;
                private Object cellPhone;
                private Object deviceToken;
                private String userName;
                private Object userPass;
                private Object wechatId;
                private Object wechatToken;
                private Object qqId;
                private Object qqToken;
                private Object completeFlag;
                private Object headPic;
                private Object lastName;
                private Object firstName;
                private Object idCard;
                private Object nameIdentify;
                private Object sex;
                private Object birthday;
                private Object registerDate;
                private Object nickName;
                private Object loginIp;
                private Object logininTime;
                private Object loginoutTime;
                private Object loginFlag;
                private Object recommendUser;
                private Object recommendCode;
                private Object updatBy;
                private Object updatePgm;

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

                public Object getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(Object contractConfirm) {
                    this.contractConfirm = contractConfirm;
                }

                public Object getCellPhone() {
                    return cellPhone;
                }

                public void setCellPhone(Object cellPhone) {
                    this.cellPhone = cellPhone;
                }

                public Object getDeviceToken() {
                    return deviceToken;
                }

                public void setDeviceToken(Object deviceToken) {
                    this.deviceToken = deviceToken;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public Object getUserPass() {
                    return userPass;
                }

                public void setUserPass(Object userPass) {
                    this.userPass = userPass;
                }

                public Object getWechatId() {
                    return wechatId;
                }

                public void setWechatId(Object wechatId) {
                    this.wechatId = wechatId;
                }

                public Object getWechatToken() {
                    return wechatToken;
                }

                public void setWechatToken(Object wechatToken) {
                    this.wechatToken = wechatToken;
                }

                public Object getQqId() {
                    return qqId;
                }

                public void setQqId(Object qqId) {
                    this.qqId = qqId;
                }

                public Object getQqToken() {
                    return qqToken;
                }

                public void setQqToken(Object qqToken) {
                    this.qqToken = qqToken;
                }

                public Object getCompleteFlag() {
                    return completeFlag;
                }

                public void setCompleteFlag(Object completeFlag) {
                    this.completeFlag = completeFlag;
                }

                public Object getHeadPic() {
                    return headPic;
                }

                public void setHeadPic(Object headPic) {
                    this.headPic = headPic;
                }

                public Object getLastName() {
                    return lastName;
                }

                public void setLastName(Object lastName) {
                    this.lastName = lastName;
                }

                public Object getFirstName() {
                    return firstName;
                }

                public void setFirstName(Object firstName) {
                    this.firstName = firstName;
                }

                public Object getIdCard() {
                    return idCard;
                }

                public void setIdCard(Object idCard) {
                    this.idCard = idCard;
                }

                public Object getNameIdentify() {
                    return nameIdentify;
                }

                public void setNameIdentify(Object nameIdentify) {
                    this.nameIdentify = nameIdentify;
                }

                public Object getSex() {
                    return sex;
                }

                public void setSex(Object sex) {
                    this.sex = sex;
                }

                public Object getBirthday() {
                    return birthday;
                }

                public void setBirthday(Object birthday) {
                    this.birthday = birthday;
                }

                public Object getRegisterDate() {
                    return registerDate;
                }

                public void setRegisterDate(Object registerDate) {
                    this.registerDate = registerDate;
                }

                public Object getNickName() {
                    return nickName;
                }

                public void setNickName(Object nickName) {
                    this.nickName = nickName;
                }

                public Object getLoginIp() {
                    return loginIp;
                }

                public void setLoginIp(Object loginIp) {
                    this.loginIp = loginIp;
                }

                public Object getLogininTime() {
                    return logininTime;
                }

                public void setLogininTime(Object logininTime) {
                    this.logininTime = logininTime;
                }

                public Object getLoginoutTime() {
                    return loginoutTime;
                }

                public void setLoginoutTime(Object loginoutTime) {
                    this.loginoutTime = loginoutTime;
                }

                public Object getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(Object loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public Object getRecommendUser() {
                    return recommendUser;
                }

                public void setRecommendUser(Object recommendUser) {
                    this.recommendUser = recommendUser;
                }

                public Object getRecommendCode() {
                    return recommendCode;
                }

                public void setRecommendCode(Object recommendCode) {
                    this.recommendCode = recommendCode;
                }

                public Object getUpdatBy() {
                    return updatBy;
                }

                public void setUpdatBy(Object updatBy) {
                    this.updatBy = updatBy;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * goodsCate : null
                 * goodsType : null
                 * goodsName : 买不起啊
                 * goodsNo : null
                 * goodsBrief : null
                 * serviceTime : null
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : null
                 * goodsStorage : null
                 * marketPrice : null
                 * salesPrice : null
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : null
                 * saleFlag : null
                 * ifPoint : null
                 * pointRule : null
                 * approveBy : null
                 * approveDate : null
                 * approveRemarks : null
                 * startTime : null
                 * endTime : null
                 * goodsRemarks : null
                 * updatePgm : null
                 * shopName : null
                 * saleFlagName : null
                 * goodsTypeName : null
                 * goodsCateName : null
                 * ecPointsRule : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object goodsCate;
                private Object goodsType;
                private String goodsName;
                private Object goodsNo;
                private String goodsBrief;
                private Object serviceTime;
                private Object goodsDetails;
                private Object goodsThumb;
                private Object goodsPic;
                private Object goodsShow;
                private Object goodsTab;
                private Object goodsStorage;
                private Object marketPrice;
                private Object salesPrice;
                private Object goodsActivity;
                private Object goodsBanner;
                private Object shopId;
                private Object saleFlag;
                private Object ifPoint;
                private Object pointRule;
                private Object approveBy;
                private Object approveDate;
                private Object approveRemarks;
                private Object startTime;
                private Object endTime;
                private Object goodsRemarks;
                private Object updatePgm;
                private Object shopName;
                private Object saleFlagName;
                private Object goodsTypeName;
                private Object goodsCateName;
                private Object ecPointsRule;

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

                public Object getGoodsCate() {
                    return goodsCate;
                }

                public void setGoodsCate(Object goodsCate) {
                    this.goodsCate = goodsCate;
                }

                public Object getGoodsType() {
                    return goodsType;
                }

                public void setGoodsType(Object goodsType) {
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

                public Object getServiceTime() {
                    return serviceTime;
                }

                public void setServiceTime(Object serviceTime) {
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

                public Object getGoodsTab() {
                    return goodsTab;
                }

                public void setGoodsTab(Object goodsTab) {
                    this.goodsTab = goodsTab;
                }

                public Object getGoodsStorage() {
                    return goodsStorage;
                }

                public void setGoodsStorage(Object goodsStorage) {
                    this.goodsStorage = goodsStorage;
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

                public Object getShopId() {
                    return shopId;
                }

                public void setShopId(Object shopId) {
                    this.shopId = shopId;
                }

                public Object getSaleFlag() {
                    return saleFlag;
                }

                public void setSaleFlag(Object saleFlag) {
                    this.saleFlag = saleFlag;
                }

                public Object getIfPoint() {
                    return ifPoint;
                }

                public void setIfPoint(Object ifPoint) {
                    this.ifPoint = ifPoint;
                }

                public Object getPointRule() {
                    return pointRule;
                }

                public void setPointRule(Object pointRule) {
                    this.pointRule = pointRule;
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

                public Object getApproveRemarks() {
                    return approveRemarks;
                }

                public void setApproveRemarks(Object approveRemarks) {
                    this.approveRemarks = approveRemarks;
                }

                public Object getStartTime() {
                    return startTime;
                }

                public void setStartTime(Object startTime) {
                    this.startTime = startTime;
                }

                public Object getEndTime() {
                    return endTime;
                }

                public void setEndTime(Object endTime) {
                    this.endTime = endTime;
                }

                public Object getGoodsRemarks() {
                    return goodsRemarks;
                }

                public void setGoodsRemarks(Object goodsRemarks) {
                    this.goodsRemarks = goodsRemarks;
                }

                public Object getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(Object updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public Object getShopName() {
                    return shopName;
                }

                public void setShopName(Object shopName) {
                    this.shopName = shopName;
                }

                public Object getSaleFlagName() {
                    return saleFlagName;
                }

                public void setSaleFlagName(Object saleFlagName) {
                    this.saleFlagName = saleFlagName;
                }

                public Object getGoodsTypeName() {
                    return goodsTypeName;
                }

                public void setGoodsTypeName(Object goodsTypeName) {
                    this.goodsTypeName = goodsTypeName;
                }

                public Object getGoodsCateName() {
                    return goodsCateName;
                }

                public void setGoodsCateName(Object goodsCateName) {
                    this.goodsCateName = goodsCateName;
                }

                public Object getEcPointsRule() {
                    return ecPointsRule;
                }

                public void setEcPointsRule(Object ecPointsRule) {
                    this.ecPointsRule = ecPointsRule;
                }
            }
        }
    }
}
