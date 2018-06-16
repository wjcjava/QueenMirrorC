package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/6/16.
 */

public class GoodsBannerBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"BannerListData":[{"ecGoodsBasic":{"updateBy":{"id":"1094c9cdd90a42e8b7407642283c7dd2"},"saleFlag":"2","salesPrice":0.01,"marketPrice":0.01,"goodsBrief":"非常完美","approveRemarks":"","endTime":1525400923000,"goodsNo":"a0d8160ea","createBy":{"id":"1094c9cdd90a42e8b7407642283c7dd2"},"goodsCate":"9003d18c17bd4bb98969a72a4ca553d5","updateDate":1528962777000,"startTime":1525400918000,"id":"c3958e7a06a5470994bb625bf186e7ce","ifPoint":"1","shopId":"d429e772e94241518496417bc38b3145","serviceTime":"120分钟","updatePgm":"ApiGoodsController","approveDate":1528962805000,"goodsTab":"美甲,","approveBy":{"id":"1"},"pointRule":"bb82ad476e7d485e8f364cc91ecdd7a9","createDate":1528962764000,"goodsName":"赤木晴子指甲油","goodsType":"2"},"ecGoodsBrowses":{"browseCounts":5}}]}
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
        private List<BannerListDataBean> BannerListData;

        public List<BannerListDataBean> getBannerListData() {
            return BannerListData;
        }

        public void setBannerListData(List<BannerListDataBean> BannerListData) {
            this.BannerListData = BannerListData;
        }

        public static class BannerListDataBean {
            /**
             * ecGoodsBasic : {"updateBy":{"id":"1094c9cdd90a42e8b7407642283c7dd2"},"saleFlag":"2","salesPrice":0.01,"marketPrice":0.01,"goodsBrief":"非常完美","approveRemarks":"","endTime":1525400923000,"goodsNo":"a0d8160ea","createBy":{"id":"1094c9cdd90a42e8b7407642283c7dd2"},"goodsCate":"9003d18c17bd4bb98969a72a4ca553d5","updateDate":1528962777000,"startTime":1525400918000,"id":"c3958e7a06a5470994bb625bf186e7ce","ifPoint":"1","shopId":"d429e772e94241518496417bc38b3145","serviceTime":"120分钟","updatePgm":"ApiGoodsController","approveDate":1528962805000,"goodsTab":"美甲,","approveBy":{"id":"1"},"pointRule":"bb82ad476e7d485e8f364cc91ecdd7a9","createDate":1528962764000,"goodsName":"赤木晴子指甲油","goodsType":"2"}
             * ecGoodsBrowses : {"browseCounts":5}
             */

            private EcGoodsBasicBean ecGoodsBasic;
            private EcGoodsBrowsesBean ecGoodsBrowses;

            public EcGoodsBasicBean getEcGoodsBasic() {
                return ecGoodsBasic;
            }

            public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
                this.ecGoodsBasic = ecGoodsBasic;
            }

            public EcGoodsBrowsesBean getEcGoodsBrowses() {
                return ecGoodsBrowses;
            }

            public void setEcGoodsBrowses(EcGoodsBrowsesBean ecGoodsBrowses) {
                this.ecGoodsBrowses = ecGoodsBrowses;
            }

            public static class EcGoodsBasicBean {
                /**
                 * updateBy : {"id":"1094c9cdd90a42e8b7407642283c7dd2"}
                 * saleFlag : 2
                 * salesPrice : 0.01
                 * marketPrice : 0.01
                 * goodsBrief : 非常完美
                 * approveRemarks :
                 * endTime : 1525400923000
                 * goodsNo : a0d8160ea
                 * createBy : {"id":"1094c9cdd90a42e8b7407642283c7dd2"}
                 * goodsCate : 9003d18c17bd4bb98969a72a4ca553d5
                 * updateDate : 1528962777000
                 * startTime : 1525400918000
                 * id : c3958e7a06a5470994bb625bf186e7ce
                 * ifPoint : 1
                 * shopId : d429e772e94241518496417bc38b3145
                 * serviceTime : 120分钟
                 * updatePgm : ApiGoodsController
                 * approveDate : 1528962805000
                 * goodsTab : 美甲,
                 * approveBy : {"id":"1"}
                 * pointRule : bb82ad476e7d485e8f364cc91ecdd7a9
                 * createDate : 1528962764000
                 * goodsName : 赤木晴子指甲油
                 * goodsType : 2
                 */

                private UpdateByBean updateBy;
                private String saleFlag;
                private double salesPrice;
                private double marketPrice;
                private String goodsBrief;
                private String approveRemarks;
                private long endTime;
                private String goodsNo;
                private CreateByBean createBy;
                private String goodsCate;
                private long updateDate;
                private long startTime;
                private String id;
                private String ifPoint;
                private String shopId;
                private String serviceTime;
                private String updatePgm;
                private long approveDate;
                private String goodsTab;
                private ApproveByBean approveBy;
                private String pointRule;
                private long createDate;
                private String goodsName;
                private String goodsType;

                public UpdateByBean getUpdateBy() {
                    return updateBy;
                }

                public void setUpdateBy(UpdateByBean updateBy) {
                    this.updateBy = updateBy;
                }

                public String getSaleFlag() {
                    return saleFlag;
                }

                public void setSaleFlag(String saleFlag) {
                    this.saleFlag = saleFlag;
                }

                public double getSalesPrice() {
                    return salesPrice;
                }

                public void setSalesPrice(double salesPrice) {
                    this.salesPrice = salesPrice;
                }

                public double getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(double marketPrice) {
                    this.marketPrice = marketPrice;
                }

                public String getGoodsBrief() {
                    return goodsBrief;
                }

                public void setGoodsBrief(String goodsBrief) {
                    this.goodsBrief = goodsBrief;
                }

                public String getApproveRemarks() {
                    return approveRemarks;
                }

                public void setApproveRemarks(String approveRemarks) {
                    this.approveRemarks = approveRemarks;
                }

                public long getEndTime() {
                    return endTime;
                }

                public void setEndTime(long endTime) {
                    this.endTime = endTime;
                }

                public String getGoodsNo() {
                    return goodsNo;
                }

                public void setGoodsNo(String goodsNo) {
                    this.goodsNo = goodsNo;
                }

                public CreateByBean getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(CreateByBean createBy) {
                    this.createBy = createBy;
                }

                public String getGoodsCate() {
                    return goodsCate;
                }

                public void setGoodsCate(String goodsCate) {
                    this.goodsCate = goodsCate;
                }

                public long getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(long updateDate) {
                    this.updateDate = updateDate;
                }

                public long getStartTime() {
                    return startTime;
                }

                public void setStartTime(long startTime) {
                    this.startTime = startTime;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getIfPoint() {
                    return ifPoint;
                }

                public void setIfPoint(String ifPoint) {
                    this.ifPoint = ifPoint;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getServiceTime() {
                    return serviceTime;
                }

                public void setServiceTime(String serviceTime) {
                    this.serviceTime = serviceTime;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public long getApproveDate() {
                    return approveDate;
                }

                public void setApproveDate(long approveDate) {
                    this.approveDate = approveDate;
                }

                public String getGoodsTab() {
                    return goodsTab;
                }

                public void setGoodsTab(String goodsTab) {
                    this.goodsTab = goodsTab;
                }

                public ApproveByBean getApproveBy() {
                    return approveBy;
                }

                public void setApproveBy(ApproveByBean approveBy) {
                    this.approveBy = approveBy;
                }

                public String getPointRule() {
                    return pointRule;
                }

                public void setPointRule(String pointRule) {
                    this.pointRule = pointRule;
                }

                public long getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(long createDate) {
                    this.createDate = createDate;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getGoodsType() {
                    return goodsType;
                }

                public void setGoodsType(String goodsType) {
                    this.goodsType = goodsType;
                }

                public static class UpdateByBean {
                    /**
                     * id : 1094c9cdd90a42e8b7407642283c7dd2
                     */

                    private String id;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }

                public static class CreateByBean {
                    /**
                     * id : 1094c9cdd90a42e8b7407642283c7dd2
                     */

                    private String id;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }

                public static class ApproveByBean {
                    /**
                     * id : 1
                     */

                    private String id;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }
            }

            public static class EcGoodsBrowsesBean {
                /**
                 * browseCounts : 5
                 */

                private int browseCounts;

                public int getBrowseCounts() {
                    return browseCounts;
                }

                public void setBrowseCounts(int browseCounts) {
                    this.browseCounts = browseCounts;
                }
            }
        }
    }
}
