package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class MineFollowBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CommentsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustFollow":null,"ecGoodsBasic":null,"ansShopBasic":{"id":"8ce86e581ecb4a39910f943758321656","isNewRecord":false,"remarks":null,"createDate":"2018-05-09 17:26:23","updateDate":"2018-05-09 17:26:23","contractConfirm":null,"ifContract":null,"shopName":"琳美甲","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"美甲","belongCity":"337289fd68bb4af980141cae1446869f","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"艾尼斯","openTime":"10:00","closeTime":"22:00","serviceTel":"18260178836","shopContacts":"杨","contactsTel":"18260178836","ifLicence":null,"shopLegal":"杨","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"123456","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-09 17:26:23","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"custIdName":null,"shopIdName":null,"shopFeatureLabel":null,"queenCardLabel":"否","shopCateLabel":"美业","businessFlagLabel":"正常"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustFollow":null,"ecGoodsBasic":null,"ansShopBasic":{"id":"8ce86e581ecb4a39910f943758321656","isNewRecord":false,"remarks":null,"createDate":"2018-05-09 17:26:23","updateDate":"2018-05-09 17:26:23","contractConfirm":null,"ifContract":null,"shopName":"琳美甲","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"美甲","belongCity":"337289fd68bb4af980141cae1446869f","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"艾尼斯","openTime":"10:00","closeTime":"22:00","serviceTel":"18260178836","shopContacts":"杨","contactsTel":"18260178836","ifLicence":null,"shopLegal":"杨","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"123456","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-09 17:26:23","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"},"custIdName":null,"shopIdName":null,"shopFeatureLabel":null,"queenCardLabel":"否","shopCateLabel":"美业","businessFlagLabel":"正常"}]}
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
             * ansCustFollow : null
             * ecGoodsBasic : null
             * ansShopBasic : {"id":"8ce86e581ecb4a39910f943758321656","isNewRecord":false,"remarks":null,"createDate":"2018-05-09 17:26:23","updateDate":"2018-05-09 17:26:23","contractConfirm":null,"ifContract":null,"shopName":"琳美甲","shortName":null,"shopNo":null,"marketAssistant":null,"shopBrief":null,"shopAccounce":null,"shopActivity":null,"shopFeature":null,"queenCard":"0","shopTab":null,"shopCate":"1","industryCate":"美甲","belongCity":"337289fd68bb4af980141cae1446869f","addrProvince":null,"addrCity":null,"addrDistrict":null,"shopAddr":"艾尼斯","openTime":"10:00","closeTime":"22:00","serviceTel":"18260178836","shopContacts":"杨","contactsTel":"18260178836","ifLicence":null,"shopLegal":"杨","legalIdc":null,"legalAddress":null,"taxNumber":null,"businessLicence":"123456","shopCharge":null,"chargeIdc":null,"chargeIdp":null,"shopLogo":null,"shopPhoto":null,"shopEnvPhoto":null,"joinTime":"2018-05-09 17:26:23","businessFlag":"1","enableFlag":"1","signFlag":null,"geoX":null,"geoY":null,"updatePgm":"ApiLoginController"}
             * custIdName : null
             * shopIdName : null
             * shopFeatureLabel : null
             * queenCardLabel : 否
             * shopCateLabel : 美业
             * businessFlagLabel : 正常
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object ansCustFollow;
            private Object ecGoodsBasic;
            private AnsShopBasicBean ansShopBasic;
            private Object custIdName;
            private Object shopIdName;
            private Object shopFeatureLabel;
            private String queenCardLabel;
            private String shopCateLabel;
            private String businessFlagLabel;

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

            public Object getAnsCustFollow() {
                return ansCustFollow;
            }

            public void setAnsCustFollow(Object ansCustFollow) {
                this.ansCustFollow = ansCustFollow;
            }

            public Object getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(Object ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public AnsShopBasicBean getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(AnsShopBasicBean ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
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

            public Object getShopFeatureLabel() {
                return shopFeatureLabel;
            }

            public void setShopFeatureLabel(Object shopFeatureLabel) {
                this.shopFeatureLabel = shopFeatureLabel;
            }

            public String getQueenCardLabel() {
                return queenCardLabel;
            }

            public void setQueenCardLabel(String queenCardLabel) {
                this.queenCardLabel = queenCardLabel;
            }

            public String getShopCateLabel() {
                return shopCateLabel;
            }

            public void setShopCateLabel(String shopCateLabel) {
                this.shopCateLabel = shopCateLabel;
            }

            public String getBusinessFlagLabel() {
                return businessFlagLabel;
            }

            public void setBusinessFlagLabel(String businessFlagLabel) {
                this.businessFlagLabel = businessFlagLabel;
            }

            public static class AnsShopBasicBean {
                /**
                 * id : 8ce86e581ecb4a39910f943758321656
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-09 17:26:23
                 * updateDate : 2018-05-09 17:26:23
                 * contractConfirm : null
                 * ifContract : null
                 * shopName : 琳美甲
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
                 * industryCate : 美甲
                 * belongCity : 337289fd68bb4af980141cae1446869f
                 * addrProvince : null
                 * addrCity : null
                 * addrDistrict : null
                 * shopAddr : 艾尼斯
                 * openTime : 10:00
                 * closeTime : 22:00
                 * serviceTel : 18260178836
                 * shopContacts : 杨
                 * contactsTel : 18260178836
                 * ifLicence : null
                 * shopLegal : 杨
                 * legalIdc : null
                 * legalAddress : null
                 * taxNumber : null
                 * businessLicence : 123456
                 * shopCharge : null
                 * chargeIdc : null
                 * chargeIdp : null
                 * shopLogo : null
                 * shopPhoto : null
                 * shopEnvPhoto : null
                 * joinTime : 2018-05-09 17:26:23
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
