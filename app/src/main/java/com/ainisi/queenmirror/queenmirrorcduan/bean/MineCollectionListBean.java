package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class MineCollectionListBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CollectListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustCollection":{"id":"123","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","goodsId":null,"collectTime":"2018-04-18 09:14:59"},"ecGoodsBasic":{"id":"0b5e8db1e94b4c44b3075940bc67a2e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试41","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":"23.00","marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":"111","shopId":"111","saleFlag":"0","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"},"ansShopBasic":null,"custIdName":null,"goodsIdName":"测试41","goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":"待提交"}]}
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
        private List<CollectListDataBean> CollectListData;

        public List<CollectListDataBean> getCollectListData() {
            return CollectListData;
        }

        public void setCollectListData(List<CollectListDataBean> CollectListData) {
            this.CollectListData = CollectListData;
        }

        public static class CollectListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansCustCollection : {"id":"123","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"custId":"111","goodsId":null,"collectTime":"2018-04-18 09:14:59"}
             * ecGoodsBasic : {"id":"0b5e8db1e94b4c44b3075940bc67a2e9","isNewRecord":false,"remarks":null,"createDate":"2018-05-08 10:23:30","updateDate":"2018-05-08 10:23:30","goodsCate":"美容美体","goodsType":"0","goodsName":"测试41","goodsNo":null,"goodsBrief":"哦哦哦咯饿了","serviceTime":"90分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"美发定制","goodsStorage":null,"goodsPrice":"2.00","offlinePrice":"23.00","marketPrice":null,"salesPrice":null,"promotionPrice":null,"goodsActivity":"111","shopId":"111","saleFlag":"0","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController"}
             * ansShopBasic : null
             * custIdName : null
             * goodsIdName : 测试41
             * goodsCateLabel : null
             * goodsTypeLabel : null
             * saleFlagLabel : 待提交
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsCustCollectionBean ansCustCollection;
            private EcGoodsBasicBean ecGoodsBasic;
            private Object ansShopBasic;
            private Object custIdName;
            private String goodsIdName;
            private Object goodsCateLabel;
            private Object goodsTypeLabel;
            private String saleFlagLabel;

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

            public AnsCustCollectionBean getAnsCustCollection() {
                return ansCustCollection;
            }

            public void setAnsCustCollection(AnsCustCollectionBean ansCustCollection) {
                this.ansCustCollection = ansCustCollection;
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

            public Object getCustIdName() {
                return custIdName;
            }

            public void setCustIdName(Object custIdName) {
                this.custIdName = custIdName;
            }

            public String getGoodsIdName() {
                return goodsIdName;
            }

            public void setGoodsIdName(String goodsIdName) {
                this.goodsIdName = goodsIdName;
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

            public String getSaleFlagLabel() {
                return saleFlagLabel;
            }

            public void setSaleFlagLabel(String saleFlagLabel) {
                this.saleFlagLabel = saleFlagLabel;
            }

            public static class AnsCustCollectionBean {
                /**
                 * id : 123
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * custId : 111
                 * goodsId : null
                 * collectTime : 2018-04-18 09:14:59
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String custId;
                private Object goodsId;
                private String collectTime;

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

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
                }

                public String getCollectTime() {
                    return collectTime;
                }

                public void setCollectTime(String collectTime) {
                    this.collectTime = collectTime;
                }
            }

            public static class EcGoodsBasicBean {
                /**
                 * id : 0b5e8db1e94b4c44b3075940bc67a2e9
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-08 10:23:30
                 * updateDate : 2018-05-08 10:23:30
                 * goodsCate : 美容美体
                 * goodsType : 0
                 * goodsName : 测试41
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
                 * offlinePrice : 23.00
                 * marketPrice : null
                 * salesPrice : null
                 * promotionPrice : null
                 * goodsActivity : 111
                 * shopId : 111
                 * saleFlag : 0
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
                private String offlinePrice;
                private Object marketPrice;
                private Object salesPrice;
                private Object promotionPrice;
                private String goodsActivity;
                private String shopId;
                private String saleFlag;
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

                public String getOfflinePrice() {
                    return offlinePrice;
                }

                public void setOfflinePrice(String offlinePrice) {
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

                public String getGoodsActivity() {
                    return goodsActivity;
                }

                public void setGoodsActivity(String goodsActivity) {
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
