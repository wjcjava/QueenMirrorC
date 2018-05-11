package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class ShopXinyongBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"apiShopScoreList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecShopScore":{"id":"112","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"shopId":"111","goodsAppraiseate":"1","shopAppraise":"2","goodsScore":"1.0","shopScore":"1.0","sumScore":"2.0","sumStart":"2018-04-09 09:54:46","sumEnd":"2018-04-25 09:54:51","sumTime":"2018-04-18 09:54:55","newFlag":"1"},"shopIdName":null,"goodsAppraiseateLabel":null,"shopAppraiseLabel":null,"newFlagLabel":"有标志"}]}
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
        private List<ApiShopScoreListBean> apiShopScoreList;

        public List<ApiShopScoreListBean> getApiShopScoreList() {
            return apiShopScoreList;
        }

        public void setApiShopScoreList(List<ApiShopScoreListBean> apiShopScoreList) {
            this.apiShopScoreList = apiShopScoreList;
        }

        public static class ApiShopScoreListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecShopScore : {"id":"112","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"shopId":"111","goodsAppraiseate":"1","shopAppraise":"2","goodsScore":"1.0","shopScore":"1.0","sumScore":"2.0","sumStart":"2018-04-09 09:54:46","sumEnd":"2018-04-25 09:54:51","sumTime":"2018-04-18 09:54:55","newFlag":"1"}
             * shopIdName : null
             * goodsAppraiseateLabel : null
             * shopAppraiseLabel : null
             * newFlagLabel : 有标志
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcShopScoreBean ecShopScore;
            private Object shopIdName;
            private Object goodsAppraiseateLabel;
            private Object shopAppraiseLabel;
            private String newFlagLabel;

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

            public EcShopScoreBean getEcShopScore() {
                return ecShopScore;
            }

            public void setEcShopScore(EcShopScoreBean ecShopScore) {
                this.ecShopScore = ecShopScore;
            }

            public Object getShopIdName() {
                return shopIdName;
            }

            public void setShopIdName(Object shopIdName) {
                this.shopIdName = shopIdName;
            }

            public Object getGoodsAppraiseateLabel() {
                return goodsAppraiseateLabel;
            }

            public void setGoodsAppraiseateLabel(Object goodsAppraiseateLabel) {
                this.goodsAppraiseateLabel = goodsAppraiseateLabel;
            }

            public Object getShopAppraiseLabel() {
                return shopAppraiseLabel;
            }

            public void setShopAppraiseLabel(Object shopAppraiseLabel) {
                this.shopAppraiseLabel = shopAppraiseLabel;
            }

            public String getNewFlagLabel() {
                return newFlagLabel;
            }

            public void setNewFlagLabel(String newFlagLabel) {
                this.newFlagLabel = newFlagLabel;
            }

            public static class EcShopScoreBean {
                /**
                 * id : 112
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * shopId : 111
                 * goodsAppraiseate : 1
                 * shopAppraise : 2
                 * goodsScore : 1.0
                 * shopScore : 1.0
                 * sumScore : 2.0
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
                private String goodsAppraiseate;
                private String shopAppraise;
                private String goodsScore;
                private String shopScore;
                private String sumScore;
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

                public String getGoodsAppraiseate() {
                    return goodsAppraiseate;
                }

                public void setGoodsAppraiseate(String goodsAppraiseate) {
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
