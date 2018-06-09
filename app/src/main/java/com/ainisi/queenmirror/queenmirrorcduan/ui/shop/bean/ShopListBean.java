package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean;

import java.util.List;

/**
 * Created by john on 2018/6/8.
 */

public class ShopListBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"pageSum":2,"GoodsListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"f30dc270a0df4f21a6336c4874cc1cd5","isNewRecord":false,"remarks":null,"createDate":"2018-05-21 09:56:28","updateDate":"2018-05-21 09:56:28","goodsCate":"美甲美手","goodsType":"0","goodsName":"美手1111111","goodsNo":null,"goodsBrief":"美手了啊我","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"marketPrice":"20.00","salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"2","ifPoint":"1","pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"ecGoodsSocre":null,"ansShopBasic":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null},"ansCustCollection":null,"ecPointsRule":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"0","isNewRecord":false,"remarks":null,"createDate":"2018-05-21 09:56:28","updateDate":"2018-05-21 09:56:28","goodsCate":"001b2f5ba54041eaa2c18de791b99045","goodsType":"0","goodsName":"美手1111111","goodsNo":null,"goodsBrief":"美手了啊我","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"marketPrice":"20.00","salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"8997e0d39bdc44c0bbd7da58371d9385","saleFlag":"1","ifPoint":"1","pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"ecGoodsSocre":null,"ansShopBasic":null,"ecGoodsBrowses":null,"ansCustCollection":null,"ecPointsRule":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null}]}
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
         * pageSum : 2
         * GoodsListData : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"f30dc270a0df4f21a6336c4874cc1cd5","isNewRecord":false,"remarks":null,"createDate":"2018-05-21 09:56:28","updateDate":"2018-05-21 09:56:28","goodsCate":"美甲美手","goodsType":"0","goodsName":"美手1111111","goodsNo":null,"goodsBrief":"美手了啊我","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"marketPrice":"20.00","salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"2","ifPoint":"1","pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"ecGoodsSocre":null,"ansShopBasic":null,"ecGoodsBrowses":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null},"ansCustCollection":null,"ecPointsRule":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecGoodsBasic":{"id":"0","isNewRecord":false,"remarks":null,"createDate":"2018-05-21 09:56:28","updateDate":"2018-05-21 09:56:28","goodsCate":"001b2f5ba54041eaa2c18de791b99045","goodsType":"0","goodsName":"美手1111111","goodsNo":null,"goodsBrief":"美手了啊我","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"marketPrice":"20.00","salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"8997e0d39bdc44c0bbd7da58371d9385","saleFlag":"1","ifPoint":"1","pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null},"ecGoodsSocre":null,"ansShopBasic":null,"ecGoodsBrowses":null,"ansCustCollection":null,"ecPointsRule":null,"goodsCateName":null,"goodsTypeLabel":null,"shopIdName":null,"saleFlagLabel":null,"contentByTitle":null,"goodsAppraiseLabel":null,"newFlagLabel":null}]
         */

        private int pageSum;
        private List<GoodsListDataBean> GoodsListData;

        public int getPageSum() {
            return pageSum;
        }

        public void setPageSum(int pageSum) {
            this.pageSum = pageSum;
        }

        public List<GoodsListDataBean> getGoodsListData() {
            return GoodsListData;
        }

        public void setGoodsListData(List<GoodsListDataBean> GoodsListData) {
            this.GoodsListData = GoodsListData;
        }

        public static class GoodsListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecGoodsBasic : {"id":"f30dc270a0df4f21a6336c4874cc1cd5","isNewRecord":false,"remarks":null,"createDate":"2018-05-21 09:56:28","updateDate":"2018-05-21 09:56:28","goodsCate":"美甲美手","goodsType":"0","goodsName":"美手1111111","goodsNo":null,"goodsBrief":"美手了啊我","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美甲美手","goodsStorage":null,"marketPrice":"20.00","salesPrice":"0.01","goodsActivity":null,"goodsBanner":null,"shopId":"111","saleFlag":"2","ifPoint":"1","pointRule":null,"approveBy":null,"approveDate":null,"approveRemarks":null,"startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null}
             * ecGoodsSocre : null
             * ansShopBasic : null
             * ecGoodsBrowses : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"goodsId":null,"browseCounts":"0","enableFlag":null}
             * ansCustCollection : null
             * ecPointsRule : null
             * goodsCateName : null
             * goodsTypeLabel : null
             * shopIdName : null
             * saleFlagLabel : null
             * contentByTitle : null
             * goodsAppraiseLabel : null
             * newFlagLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcGoodsBasicBean ecGoodsBasic;
            private Object ecGoodsSocre;
            private Object ansShopBasic;
            private EcGoodsBrowsesBean ecGoodsBrowses;
            private Object ansCustCollection;
            private Object ecPointsRule;
            private Object goodsCateName;
            private Object goodsTypeLabel;
            private Object shopIdName;
            private Object saleFlagLabel;
            private Object contentByTitle;
            private Object goodsAppraiseLabel;
            private Object newFlagLabel;

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

            public EcGoodsBasicBean getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public Object getEcGoodsSocre() {
                return ecGoodsSocre;
            }

            public void setEcGoodsSocre(Object ecGoodsSocre) {
                this.ecGoodsSocre = ecGoodsSocre;
            }

            public Object getAnsShopBasic() {
                return ansShopBasic;
            }

            public void setAnsShopBasic(Object ansShopBasic) {
                this.ansShopBasic = ansShopBasic;
            }

            public EcGoodsBrowsesBean getEcGoodsBrowses() {
                return ecGoodsBrowses;
            }

            public void setEcGoodsBrowses(EcGoodsBrowsesBean ecGoodsBrowses) {
                this.ecGoodsBrowses = ecGoodsBrowses;
            }

            public Object getAnsCustCollection() {
                return ansCustCollection;
            }

            public void setAnsCustCollection(Object ansCustCollection) {
                this.ansCustCollection = ansCustCollection;
            }

            public Object getEcPointsRule() {
                return ecPointsRule;
            }

            public void setEcPointsRule(Object ecPointsRule) {
                this.ecPointsRule = ecPointsRule;
            }

            public Object getGoodsCateName() {
                return goodsCateName;
            }

            public void setGoodsCateName(Object goodsCateName) {
                this.goodsCateName = goodsCateName;
            }

            public Object getGoodsTypeLabel() {
                return goodsTypeLabel;
            }

            public void setGoodsTypeLabel(Object goodsTypeLabel) {
                this.goodsTypeLabel = goodsTypeLabel;
            }

            public Object getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(Object shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(Object saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public Object getContentByTitle() {
                return contentByTitle;
            }

            public void setContentByTitle(Object contentByTitle) {
                this.contentByTitle = contentByTitle;
            }

            public Object getGoodsAppraiseLabel() {
                return goodsAppraiseLabel;
            }

            public void setGoodsAppraiseLabel(Object goodsAppraiseLabel) {
                this.goodsAppraiseLabel = goodsAppraiseLabel;
            }

            public Object getNewFlagLabel() {
                return newFlagLabel;
            }

            public void setNewFlagLabel(Object newFlagLabel) {
                this.newFlagLabel = newFlagLabel;
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : f30dc270a0df4f21a6336c4874cc1cd5
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-21 09:56:28
                 * updateDate : 2018-05-21 09:56:28
                 * goodsCate : 美甲美手
                 * goodsType : 0
                 * goodsName : 美手1111111
                 * goodsNo : null
                 * goodsBrief : 美手了啊我
                 * serviceTime : 90分钟
                 * goodsDetails : null
                 * goodsThumb : null
                 * goodsPic : null
                 * goodsShow : null
                 * goodsTab : 美甲美手
                 * goodsStorage : null
                 * marketPrice : 20.00
                 * salesPrice : 0.01
                 * goodsActivity : null
                 * goodsBanner : null
                 * shopId : 111
                 * saleFlag : 2
                 * ifPoint : 1
                 * pointRule : null
                 * approveBy : null
                 * approveDate : null
                 * approveRemarks : null
                 * startTime : 1525400918000
                 * endTime : 1525400923000
                 * goodsRemarks : null
                 * updatePgm : ApiGoodsController
                 * shopName : null
                 * saleFlagName : null
                 * goodsTypeName : null
                 * goodsCateName : null
                 * ecPointsRule : null
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
                private String marketPrice;
                private String salesPrice;
                private Object goodsActivity;
                private Object goodsBanner;
                private String shopId;
                private String saleFlag;
                private String ifPoint;
                private Object pointRule;
                private Object approveBy;
                private Object approveDate;
                private Object approveRemarks;
                private long startTime;
                private long endTime;
                private Object goodsRemarks;
                private String updatePgm;
                private Object shopName;
                private Object saleFlagName;
                private Object goodsTypeName;
                private Object goodsCateName;
                private Object ecPointsRule;

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

                public String getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(String marketPrice) {
                    this.marketPrice = marketPrice;
                }

                public String getSalesPrice() {
                    return salesPrice;
                }

                public void setSalesPrice(String salesPrice) {
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

                public String getIfPoint() {
                    return ifPoint;
                }

                public void setIfPoint(String ifPoint) {
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

            public static class EcGoodsBrowsesBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * goodsId : null
                 * browseCounts : 0
                 * enableFlag : null
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object goodsId;
                private String browseCounts;
                private Object enableFlag;

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

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
                }

                public String getBrowseCounts() {
                    return browseCounts;
                }

                public void setBrowseCounts(String browseCounts) {
                    this.browseCounts = browseCounts;
                }

                public Object getEnableFlag() {
                    return enableFlag;
                }

                public void setEnableFlag(Object enableFlag) {
                    this.enableFlag = enableFlag;
                }
            }
        }
    }
}
