package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean;

import java.util.List;

/**
 * Created by john on 2018/5/22.
 */

public class ShopDiscounBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CouponListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpCreateInfo":{"id":"1cf04904fa064c4294453ce39c506be1","isNewRecord":false,"remarks":null,"createDate":"2018-05-22 09:07:40","updateDate":"2018-05-22 09:07:40","cpCate":"1","cpScope":"1","cpDiscount":"2","cpAgeing":"2","cpLimit":"2","cpName":"ainisi","cpUsing":"qwertyui","cpRemark":"...","shopId":"12","exGoodsIds":"12","createTime":"2018-05-22 09:07:53","getFrom":"12","getTo":"16","createNums":"12","useDays":"12","useFrom":"20180520","useTo":"20180531","goodsId":"123","fullCondition":"qw","reduceAmount":11,"discountRate":12,"getNums":null,"cpStatus":"2","approveBy":null,"approveDate":null,"updatePgm":""},"cpGetRecord":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpId":null,"shopId":null,"goodsId":null,"custId":null,"getTime":null,"useQrcode":null,"getStatus":"1"},"cpNumsRecord":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpCreateInfo":{"id":"bc816138db6847b1a14c5ac2ffbda312","isNewRecord":false,"remarks":null,"createDate":"2018-05-22 09:06:21","updateDate":"2018-05-22 09:06:21","cpCate":"1","cpScope":"1","cpDiscount":"2","cpAgeing":"2","cpLimit":"2","cpName":"ainisi","cpUsing":"qwertyui","cpRemark":"...","shopId":"12","exGoodsIds":"12","createTime":"2018-05-22 09:06:33","getFrom":"12","getTo":"16","createNums":"12","useDays":"12","useFrom":"10","useTo":"14","goodsId":"123","fullCondition":"qw","reduceAmount":11,"discountRate":12,"getNums":null,"cpStatus":"3","approveBy":null,"approveDate":null,"updatePgm":"qweer"},"cpGetRecord":null,"cpNumsRecord":null}]}
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
        private List<CouponListDataBean> CouponListData;

        public List<CouponListDataBean> getCouponListData() {
            return CouponListData;
        }

        public void setCouponListData(List<CouponListDataBean> CouponListData) {
            this.CouponListData = CouponListData;
        }

        public static class CouponListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * cpCreateInfo : {"id":"1cf04904fa064c4294453ce39c506be1","isNewRecord":false,"remarks":null,"createDate":"2018-05-22 09:07:40","updateDate":"2018-05-22 09:07:40","cpCate":"1","cpScope":"1","cpDiscount":"2","cpAgeing":"2","cpLimit":"2","cpName":"ainisi","cpUsing":"qwertyui","cpRemark":"...","shopId":"12","exGoodsIds":"12","createTime":"2018-05-22 09:07:53","getFrom":"12","getTo":"16","createNums":"12","useDays":"12","useFrom":"20180520","useTo":"20180531","goodsId":"123","fullCondition":"qw","reduceAmount":11,"discountRate":12,"getNums":null,"cpStatus":"2","approveBy":null,"approveDate":null,"updatePgm":""}
             * cpGetRecord : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"cpId":null,"shopId":null,"goodsId":null,"custId":null,"getTime":null,"useQrcode":null,"getStatus":"1"}
             * cpNumsRecord : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private CpCreateInfoBean cpCreateInfo;
            private CpGetRecordBean cpGetRecord;
            private Object cpNumsRecord;

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

            public CpCreateInfoBean getCpCreateInfo() {
                return cpCreateInfo;
            }

            public void setCpCreateInfo(CpCreateInfoBean cpCreateInfo) {
                this.cpCreateInfo = cpCreateInfo;
            }

            public CpGetRecordBean getCpGetRecord() {
                return cpGetRecord;
            }

            public void setCpGetRecord(CpGetRecordBean cpGetRecord) {
                this.cpGetRecord = cpGetRecord;
            }

            public Object getCpNumsRecord() {
                return cpNumsRecord;
            }

            public void setCpNumsRecord(Object cpNumsRecord) {
                this.cpNumsRecord = cpNumsRecord;
            }

            public static class CpCreateInfoBean {
                /**
                 * id : 1cf04904fa064c4294453ce39c506be1
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-22 09:07:40
                 * updateDate : 2018-05-22 09:07:40
                 * cpCate : 1
                 * cpScope : 1
                 * cpDiscount : 2
                 * cpAgeing : 2
                 * cpLimit : 2
                 * cpName : ainisi
                 * cpUsing : qwertyui
                 * cpRemark : ...
                 * shopId : 12
                 * exGoodsIds : 12
                 * createTime : 2018-05-22 09:07:53
                 * getFrom : 12
                 * getTo : 16
                 * createNums : 12
                 * useDays : 12
                 * useFrom : 20180520
                 * useTo : 20180531
                 * goodsId : 123
                 * fullCondition : qw
                 * reduceAmount : 11
                 * discountRate : 12
                 * getNums : null
                 * cpStatus : 2
                 * approveBy : null
                 * approveDate : null
                 * updatePgm :
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String cpCate;
                private String cpScope;
                private String cpDiscount;
                private String cpAgeing;
                private String cpLimit;
                private String cpName;
                private String cpUsing;
                private String cpRemark;
                private String shopId;
                private String exGoodsIds;
                private String createTime;
                private String getFrom;
                private String getTo;
                private String createNums;
                private String useDays;
                private String useFrom;
                private String useTo;
                private String goodsId;
                private String fullCondition;
                private int reduceAmount;
                private int discountRate;
                private Object getNums;
                private String cpStatus;
                private Object approveBy;
                private Object approveDate;
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

                public String getCpCate() {
                    return cpCate;
                }

                public void setCpCate(String cpCate) {
                    this.cpCate = cpCate;
                }

                public String getCpScope() {
                    return cpScope;
                }

                public void setCpScope(String cpScope) {
                    this.cpScope = cpScope;
                }

                public String getCpDiscount() {
                    return cpDiscount;
                }

                public void setCpDiscount(String cpDiscount) {
                    this.cpDiscount = cpDiscount;
                }

                public String getCpAgeing() {
                    return cpAgeing;
                }

                public void setCpAgeing(String cpAgeing) {
                    this.cpAgeing = cpAgeing;
                }

                public String getCpLimit() {
                    return cpLimit;
                }

                public void setCpLimit(String cpLimit) {
                    this.cpLimit = cpLimit;
                }

                public String getCpName() {
                    return cpName;
                }

                public void setCpName(String cpName) {
                    this.cpName = cpName;
                }

                public String getCpUsing() {
                    return cpUsing;
                }

                public void setCpUsing(String cpUsing) {
                    this.cpUsing = cpUsing;
                }

                public String getCpRemark() {
                    return cpRemark;
                }

                public void setCpRemark(String cpRemark) {
                    this.cpRemark = cpRemark;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getExGoodsIds() {
                    return exGoodsIds;
                }

                public void setExGoodsIds(String exGoodsIds) {
                    this.exGoodsIds = exGoodsIds;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getGetFrom() {
                    return getFrom;
                }

                public void setGetFrom(String getFrom) {
                    this.getFrom = getFrom;
                }

                public String getGetTo() {
                    return getTo;
                }

                public void setGetTo(String getTo) {
                    this.getTo = getTo;
                }

                public String getCreateNums() {
                    return createNums;
                }

                public void setCreateNums(String createNums) {
                    this.createNums = createNums;
                }

                public String getUseDays() {
                    return useDays;
                }

                public void setUseDays(String useDays) {
                    this.useDays = useDays;
                }

                public String getUseFrom() {
                    return useFrom;
                }

                public void setUseFrom(String useFrom) {
                    this.useFrom = useFrom;
                }

                public String getUseTo() {
                    return useTo;
                }

                public void setUseTo(String useTo) {
                    this.useTo = useTo;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getFullCondition() {
                    return fullCondition;
                }

                public void setFullCondition(String fullCondition) {
                    this.fullCondition = fullCondition;
                }

                public int getReduceAmount() {
                    return reduceAmount;
                }

                public void setReduceAmount(int reduceAmount) {
                    this.reduceAmount = reduceAmount;
                }

                public int getDiscountRate() {
                    return discountRate;
                }

                public void setDiscountRate(int discountRate) {
                    this.discountRate = discountRate;
                }

                public Object getGetNums() {
                    return getNums;
                }

                public void setGetNums(Object getNums) {
                    this.getNums = getNums;
                }

                public String getCpStatus() {
                    return cpStatus;
                }

                public void setCpStatus(String cpStatus) {
                    this.cpStatus = cpStatus;
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

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }

            public static class CpGetRecordBean {
                /**
                 * id : null
                 * isNewRecord : true
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * cpId : null
                 * shopId : null
                 * goodsId : null
                 * custId : null
                 * getTime : null
                 * useQrcode : null
                 * getStatus : 1
                 */

                private Object id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private Object cpId;
                private Object shopId;
                private Object goodsId;
                private Object custId;
                private Object getTime;
                private Object useQrcode;
                private String getStatus;

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

                public Object getCpId() {
                    return cpId;
                }

                public void setCpId(Object cpId) {
                    this.cpId = cpId;
                }

                public Object getShopId() {
                    return shopId;
                }

                public void setShopId(Object shopId) {
                    this.shopId = shopId;
                }

                public Object getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(Object goodsId) {
                    this.goodsId = goodsId;
                }

                public Object getCustId() {
                    return custId;
                }

                public void setCustId(Object custId) {
                    this.custId = custId;
                }

                public Object getGetTime() {
                    return getTime;
                }

                public void setGetTime(Object getTime) {
                    this.getTime = getTime;
                }

                public Object getUseQrcode() {
                    return useQrcode;
                }

                public void setUseQrcode(Object useQrcode) {
                    this.useQrcode = useQrcode;
                }

                public String getGetStatus() {
                    return getStatus;
                }

                public void setGetStatus(String getStatus) {
                    this.getStatus = getStatus;
                }
            }
        }
    }
}