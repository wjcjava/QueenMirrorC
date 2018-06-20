package com.ainisi.queenmirror.queenmirrorcduan.bean;

import java.util.List;

public class FightaloneBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 操作成功
     * body : {"gpOrderList":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"intfAnsShopBasic":null,"intfAnsOrder":null,"intfAnsCustBasic":null,"intfCpCreateInfo":null,"orderStatusList":null,"gpOrder":{"id":"b86f821e4da94724b99d63677d6c4ac4","isNewRecord":false,"remarks":null,"createDate":"2018-06-16 10:55:22","updateDate":"2018-06-16 10:55:22","orderNo":"1806100006105500","custId":"56b5afab46eb4b72ae1e1dd022fb1473","groupId":"1529117722291","groupType":"2","orderTime":"2018-06-16 10:56:35","orderAmount":1,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"PT","ifRefund":"1","refundTime":null,"custRemarks":null,"transId":null,"qrcode":null,"updatePgm":"ApiOrderService","isOwner":0,"gpactId":"f24cb4d9c9df48bc85260fa6e91b6f48","endDate":"2018-06-22 11:55:22","joinNums":1},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"灰太狼的替身","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"intfAnsShopBasic":null,"intfAnsOrder":null,"intfAnsCustBasic":null,"intfCpCreateInfo":null,"orderStatusList":null,"gpOrder":{"id":"ef8972f094f14076aff3636f65dce1b3","isNewRecord":false,"remarks":null,"createDate":"2018-06-15 16:51:58","updateDate":"2018-06-15 16:51:58","orderNo":"1806100005165100","custId":"56b5afab46eb4b72ae1e1dd022fb1473","groupId":"1529052718290","groupType":"2","orderTime":"2018-06-15 16:53:11","orderAmount":1,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"PT","ifRefund":"1","refundTime":null,"custRemarks":null,"transId":null,"qrcode":null,"updatePgm":"ApiOrderService","isOwner":0,"gpactId":"f24cb4d9c9df48bc85260fa6e91b6f48","endDate":"2018-06-23 16:51:58","joinNums":1},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"灰太狼的替身","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}],"groupNums":2,"joinSums":2,"activity":{"id":"f24cb4d9c9df48bc85260fa6e91b6f48","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 18:11:39","updateDate":"2018-06-14 18:11:39","goodsId":"396636108b214507a0bdcb91731704c5","shopId":"32c9080d24e4484c95ebb10ac07cc28e","groupName":"节日大放送","groupBrief":"","serviceTime":"60","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":1,"groupPrice":1,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":null,"approveDate":null,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":"AESDGFVBN,"},"ecGoodsBrowses":{"id":"ac7d91c470fa4f1b8070ca97d2865c6e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"goodsId":"396636108b214507a0bdcb91731704c5","browseCounts":21,"enableFlag":"0"},"ecGoodsBasic":{"id":"396636108b214507a0bdcb91731704c5","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 16:57:44","updateDate":"2018-06-14 16:57:56","goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"洗剪吹组合","goodsNo":"d6254566f","goodsBrief":"半永久就是好","serviceTime":"30分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"AESDGFVBN,","goodsStorage":0,"marketPrice":1,"salesPrice":1,"goodsActivity":null,"goodsBanner":null,"shopId":"32c9080d24e4484c95ebb10ac07cc28e","saleFlag":"2","ifPoint":"1","pointRule":"89e1f615834c4462874b57c44db0fbce","approveBy":null,"approveDate":1528966730000,"approveRemarks":"OK","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null}}
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
         * gpOrderList : [{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"intfAnsShopBasic":null,"intfAnsOrder":null,"intfAnsCustBasic":null,"intfCpCreateInfo":null,"orderStatusList":null,"gpOrder":{"id":"b86f821e4da94724b99d63677d6c4ac4","isNewRecord":false,"remarks":null,"createDate":"2018-06-16 10:55:22","updateDate":"2018-06-16 10:55:22","orderNo":"1806100006105500","custId":"56b5afab46eb4b72ae1e1dd022fb1473","groupId":"1529117722291","groupType":"2","orderTime":"2018-06-16 10:56:35","orderAmount":1,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"PT","ifRefund":"1","refundTime":null,"custRemarks":null,"transId":null,"qrcode":null,"updatePgm":"ApiOrderService","isOwner":0,"gpactId":"f24cb4d9c9df48bc85260fa6e91b6f48","endDate":"2018-06-22 11:55:22","joinNums":1},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"灰太狼的替身","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"intfAnsShopBasic":null,"intfAnsOrder":null,"intfAnsCustBasic":null,"intfCpCreateInfo":null,"orderStatusList":null,"gpOrder":{"id":"ef8972f094f14076aff3636f65dce1b3","isNewRecord":false,"remarks":null,"createDate":"2018-06-15 16:51:58","updateDate":"2018-06-15 16:51:58","orderNo":"1806100005165100","custId":"56b5afab46eb4b72ae1e1dd022fb1473","groupId":"1529052718290","groupType":"2","orderTime":"2018-06-15 16:53:11","orderAmount":1,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"PT","ifRefund":"1","refundTime":null,"custRemarks":null,"transId":null,"qrcode":null,"updatePgm":"ApiOrderService","isOwner":0,"gpactId":"f24cb4d9c9df48bc85260fa6e91b6f48","endDate":"2018-06-23 16:51:58","joinNums":1},"ansOrderDetails":null,"ecGoodsBasic":null,"ansShopBasic":null,"ansCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"灰太狼的替身","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null},"paymentMethodLabel":null,"orderStatusLabel":null,"goodsCateLabel":null,"goodsTypeLabel":null,"saleFlagLabel":null,"shopCateLabel":null,"industryCateLabel":null,"businessFlagLabel":null,"enableFlagLabel":null}]
         * groupNums : 2
         * joinSums : 2
         * activity : {"id":"f24cb4d9c9df48bc85260fa6e91b6f48","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 18:11:39","updateDate":"2018-06-14 18:11:39","goodsId":"396636108b214507a0bdcb91731704c5","shopId":"32c9080d24e4484c95ebb10ac07cc28e","groupName":"节日大放送","groupBrief":"","serviceTime":"60","groupDetails":"","groupThumb":"","groupPic":"","groupShow":"","singlePrice":1,"groupPrice":1,"groupStart":"2018-06-13 00:00:00","groupEnd":"2018-06-30 00:00:00","groupPeriod":408,"groupNumber":2,"currentNumber":0,"groupStorage":1,"groupStatus":"3","approveBy":null,"approveDate":null,"approveRemarks":null,"groupSort":1,"groupRemarks":"","updatePgm":"","saleNums":0,"contentTitle":"AESDGFVBN,"}
         * ecGoodsBrowses : {"id":"ac7d91c470fa4f1b8070ca97d2865c6e","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"goodsId":"396636108b214507a0bdcb91731704c5","browseCounts":21,"enableFlag":"0"}
         * ecGoodsBasic : {"id":"396636108b214507a0bdcb91731704c5","isNewRecord":false,"remarks":null,"createDate":"2018-06-14 16:57:44","updateDate":"2018-06-14 16:57:56","goodsCate":"27a7d133a8f94cb9b9bce03365cf6a48","goodsType":"2","goodsName":"洗剪吹组合","goodsNo":"d6254566f","goodsBrief":"半永久就是好","serviceTime":"30分钟","goodsDetails":null,"goodsThumb":null,"goodsPic":null,"goodsShow":null,"goodsTab":"AESDGFVBN,","goodsStorage":0,"marketPrice":1,"salesPrice":1,"goodsActivity":null,"goodsBanner":null,"shopId":"32c9080d24e4484c95ebb10ac07cc28e","saleFlag":"2","ifPoint":"1","pointRule":"89e1f615834c4462874b57c44db0fbce","approveBy":null,"approveDate":1528966730000,"approveRemarks":"OK","startTime":1525400918000,"endTime":1525400923000,"goodsRemarks":null,"updatePgm":"ApiGoodsController","shopName":null,"saleFlagName":null,"goodsTypeName":null,"goodsCateName":null,"ecPointsRule":null}
         */

        private int groupNums;
        private int joinSums;
        private ActivityBean activity;
        private EcGoodsBrowsesBean ecGoodsBrowses;
        private EcGoodsBasicBean ecGoodsBasic;
        private List<GpOrderListBean> gpOrderList;

        public int getGroupNums() {
            return groupNums;
        }

        public void setGroupNums(int groupNums) {
            this.groupNums = groupNums;
        }

        public int getJoinSums() {
            return joinSums;
        }

        public void setJoinSums(int joinSums) {
            this.joinSums = joinSums;
        }

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public EcGoodsBrowsesBean getEcGoodsBrowses() {
            return ecGoodsBrowses;
        }

        public void setEcGoodsBrowses(EcGoodsBrowsesBean ecGoodsBrowses) {
            this.ecGoodsBrowses = ecGoodsBrowses;
        }

        public EcGoodsBasicBean getEcGoodsBasic() {
            return ecGoodsBasic;
        }

        public void setEcGoodsBasic(EcGoodsBasicBean ecGoodsBasic) {
            this.ecGoodsBasic = ecGoodsBasic;
        }

        public List<GpOrderListBean> getGpOrderList() {
            return gpOrderList;
        }

        public void setGpOrderList(List<GpOrderListBean> gpOrderList) {
            this.gpOrderList = gpOrderList;
        }

        public static class ActivityBean {
            /**
             * id : f24cb4d9c9df48bc85260fa6e91b6f48
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-06-14 18:11:39
             * updateDate : 2018-06-14 18:11:39
             * goodsId : 396636108b214507a0bdcb91731704c5
             * shopId : 32c9080d24e4484c95ebb10ac07cc28e
             * groupName : 节日大放送
             * groupBrief :
             * serviceTime : 60
             * groupDetails :
             * groupThumb :
             * groupPic :
             * groupShow :
             * singlePrice : 1
             * groupPrice : 1
             * groupStart : 2018-06-13 00:00:00
             * groupEnd : 2018-06-30 00:00:00
             * groupPeriod : 408
             * groupNumber : 2
             * currentNumber : 0
             * groupStorage : 1
             * groupStatus : 3
             * approveBy : null
             * approveDate : null
             * approveRemarks : null
             * groupSort : 1
             * groupRemarks :
             * updatePgm :
             * saleNums : 0
             * contentTitle : AESDGFVBN,
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private String createDate;
            private String updateDate;
            private String goodsId;
            private String shopId;
            private String groupName;
            private String groupBrief;
            private String serviceTime;
            private String groupDetails;
            private String groupThumb;
            private String groupPic;
            private String groupShow;
            private int singlePrice;
            private int groupPrice;
            private String groupStart;
            private String groupEnd;
            private int groupPeriod;
            private int groupNumber;
            private int currentNumber;
            private int groupStorage;
            private String groupStatus;
            private Object approveBy;
            private Object approveDate;
            private Object approveRemarks;
            private int groupSort;
            private String groupRemarks;
            private String updatePgm;
            private int saleNums;
            private String contentTitle;

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

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public String getGroupBrief() {
                return groupBrief;
            }

            public void setGroupBrief(String groupBrief) {
                this.groupBrief = groupBrief;
            }

            public String getServiceTime() {
                return serviceTime;
            }

            public void setServiceTime(String serviceTime) {
                this.serviceTime = serviceTime;
            }

            public String getGroupDetails() {
                return groupDetails;
            }

            public void setGroupDetails(String groupDetails) {
                this.groupDetails = groupDetails;
            }

            public String getGroupThumb() {
                return groupThumb;
            }

            public void setGroupThumb(String groupThumb) {
                this.groupThumb = groupThumb;
            }

            public String getGroupPic() {
                return groupPic;
            }

            public void setGroupPic(String groupPic) {
                this.groupPic = groupPic;
            }

            public String getGroupShow() {
                return groupShow;
            }

            public void setGroupShow(String groupShow) {
                this.groupShow = groupShow;
            }

            public int getSinglePrice() {
                return singlePrice;
            }

            public void setSinglePrice(int singlePrice) {
                this.singlePrice = singlePrice;
            }

            public int getGroupPrice() {
                return groupPrice;
            }

            public void setGroupPrice(int groupPrice) {
                this.groupPrice = groupPrice;
            }

            public String getGroupStart() {
                return groupStart;
            }

            public void setGroupStart(String groupStart) {
                this.groupStart = groupStart;
            }

            public String getGroupEnd() {
                return groupEnd;
            }

            public void setGroupEnd(String groupEnd) {
                this.groupEnd = groupEnd;
            }

            public int getGroupPeriod() {
                return groupPeriod;
            }

            public void setGroupPeriod(int groupPeriod) {
                this.groupPeriod = groupPeriod;
            }

            public int getGroupNumber() {
                return groupNumber;
            }

            public void setGroupNumber(int groupNumber) {
                this.groupNumber = groupNumber;
            }

            public int getCurrentNumber() {
                return currentNumber;
            }

            public void setCurrentNumber(int currentNumber) {
                this.currentNumber = currentNumber;
            }

            public int getGroupStorage() {
                return groupStorage;
            }

            public void setGroupStorage(int groupStorage) {
                this.groupStorage = groupStorage;
            }

            public String getGroupStatus() {
                return groupStatus;
            }

            public void setGroupStatus(String groupStatus) {
                this.groupStatus = groupStatus;
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

            public int getGroupSort() {
                return groupSort;
            }

            public void setGroupSort(int groupSort) {
                this.groupSort = groupSort;
            }

            public String getGroupRemarks() {
                return groupRemarks;
            }

            public void setGroupRemarks(String groupRemarks) {
                this.groupRemarks = groupRemarks;
            }

            public String getUpdatePgm() {
                return updatePgm;
            }

            public void setUpdatePgm(String updatePgm) {
                this.updatePgm = updatePgm;
            }

            public int getSaleNums() {
                return saleNums;
            }

            public void setSaleNums(int saleNums) {
                this.saleNums = saleNums;
            }

            public String getContentTitle() {
                return contentTitle;
            }

            public void setContentTitle(String contentTitle) {
                this.contentTitle = contentTitle;
            }
        }

        public static class EcGoodsBrowsesBean {
            /**
             * id : ac7d91c470fa4f1b8070ca97d2865c6e
             * isNewRecord : false
             * remarks : null
             * createDate : null
             * updateDate : null
             * goodsId : 396636108b214507a0bdcb91731704c5
             * browseCounts : 21
             * enableFlag : 0
             */

            private String id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private String goodsId;
            private int browseCounts;
            private String enableFlag;

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

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public int getBrowseCounts() {
                return browseCounts;
            }

            public void setBrowseCounts(int browseCounts) {
                this.browseCounts = browseCounts;
            }

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }
        }

        public static class EcGoodsBasicBean {
            /**
             * id : 396636108b214507a0bdcb91731704c5
             * isNewRecord : false
             * remarks : null
             * createDate : 2018-06-14 16:57:44
             * updateDate : 2018-06-14 16:57:56
             * goodsCate : 27a7d133a8f94cb9b9bce03365cf6a48
             * goodsType : 2
             * goodsName : 洗剪吹组合
             * goodsNo : d6254566f
             * goodsBrief : 半永久就是好
             * serviceTime : 30分钟
             * goodsDetails : null
             * goodsThumb : null
             * goodsPic : null
             * goodsShow : null
             * goodsTab : AESDGFVBN,
             * goodsStorage : 0
             * marketPrice : 1
             * salesPrice : 1
             * goodsActivity : null
             * goodsBanner : null
             * shopId : 32c9080d24e4484c95ebb10ac07cc28e
             * saleFlag : 2
             * ifPoint : 1
             * pointRule : 89e1f615834c4462874b57c44db0fbce
             * approveBy : null
             * approveDate : 1528966730000
             * approveRemarks : OK
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
            private String goodsNo;
            private String goodsBrief;
            private String serviceTime;
            private Object goodsDetails;
            private Object goodsThumb;
            private Object goodsPic;
            private Object goodsShow;
            private String goodsTab;
            private int goodsStorage;
            private int marketPrice;
            private int salesPrice;
            private Object goodsActivity;
            private Object goodsBanner;
            private String shopId;
            private String saleFlag;
            private String ifPoint;
            private String pointRule;
            private Object approveBy;
            private long approveDate;
            private String approveRemarks;
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

            public String getGoodsNo() {
                return goodsNo;
            }

            public void setGoodsNo(String goodsNo) {
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

            public int getGoodsStorage() {
                return goodsStorage;
            }

            public void setGoodsStorage(int goodsStorage) {
                this.goodsStorage = goodsStorage;
            }

            public int getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(int marketPrice) {
                this.marketPrice = marketPrice;
            }

            public int getSalesPrice() {
                return salesPrice;
            }

            public void setSalesPrice(int salesPrice) {
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

            public String getPointRule() {
                return pointRule;
            }

            public void setPointRule(String pointRule) {
                this.pointRule = pointRule;
            }

            public Object getApproveBy() {
                return approveBy;
            }

            public void setApproveBy(Object approveBy) {
                this.approveBy = approveBy;
            }

            public long getApproveDate() {
                return approveDate;
            }

            public void setApproveDate(long approveDate) {
                this.approveDate = approveDate;
            }

            public String getApproveRemarks() {
                return approveRemarks;
            }

            public void setApproveRemarks(String approveRemarks) {
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

        public static class GpOrderListBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * intfAnsShopBasic : null
             * intfAnsOrder : null
             * intfAnsCustBasic : null
             * intfCpCreateInfo : null
             * orderStatusList : null
             * gpOrder : {"id":"b86f821e4da94724b99d63677d6c4ac4","isNewRecord":false,"remarks":null,"createDate":"2018-06-16 10:55:22","updateDate":"2018-06-16 10:55:22","orderNo":"1806100006105500","custId":"56b5afab46eb4b72ae1e1dd022fb1473","groupId":"1529117722291","groupType":"2","orderTime":"2018-06-16 10:56:35","orderAmount":1,"paymentMethod":null,"paymentKeys":null,"paymentTime":null,"orderStatus":"PT","ifRefund":"1","refundTime":null,"custRemarks":null,"transId":null,"qrcode":null,"updatePgm":"ApiOrderService","isOwner":0,"gpactId":"f24cb4d9c9df48bc85260fa6e91b6f48","endDate":"2018-06-22 11:55:22","joinNums":1}
             * ansOrderDetails : null
             * ecGoodsBasic : null
             * ansShopBasic : null
             * ansCustBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"contractConfirm":null,"cellPhone":null,"deviceToken":null,"userName":"灰太狼的替身","userPass":null,"wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"completeFlag":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":null,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":null,"recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":null}
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
            private Object intfAnsShopBasic;
            private Object intfAnsOrder;
            private Object intfAnsCustBasic;
            private Object intfCpCreateInfo;
            private Object orderStatusList;
            private GpOrderBean gpOrder;
            private Object ansOrderDetails;
            private Object ecGoodsBasic;
            private Object ansShopBasic;
            private AnsCustBasicBean ansCustBasic;
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

            public Object getIntfAnsShopBasic() {
                return intfAnsShopBasic;
            }

            public void setIntfAnsShopBasic(Object intfAnsShopBasic) {
                this.intfAnsShopBasic = intfAnsShopBasic;
            }

            public Object getIntfAnsOrder() {
                return intfAnsOrder;
            }

            public void setIntfAnsOrder(Object intfAnsOrder) {
                this.intfAnsOrder = intfAnsOrder;
            }

            public Object getIntfAnsCustBasic() {
                return intfAnsCustBasic;
            }

            public void setIntfAnsCustBasic(Object intfAnsCustBasic) {
                this.intfAnsCustBasic = intfAnsCustBasic;
            }

            public Object getIntfCpCreateInfo() {
                return intfCpCreateInfo;
            }

            public void setIntfCpCreateInfo(Object intfCpCreateInfo) {
                this.intfCpCreateInfo = intfCpCreateInfo;
            }

            public Object getOrderStatusList() {
                return orderStatusList;
            }

            public void setOrderStatusList(Object orderStatusList) {
                this.orderStatusList = orderStatusList;
            }

            public GpOrderBean getGpOrder() {
                return gpOrder;
            }

            public void setGpOrder(GpOrderBean gpOrder) {
                this.gpOrder = gpOrder;
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

            public AnsCustBasicBean getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(AnsCustBasicBean ansCustBasic) {
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

            public static class GpOrderBean {
                /**
                 * id : b86f821e4da94724b99d63677d6c4ac4
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-06-16 10:55:22
                 * updateDate : 2018-06-16 10:55:22
                 * orderNo : 1806100006105500
                 * custId : 56b5afab46eb4b72ae1e1dd022fb1473
                 * groupId : 1529117722291
                 * groupType : 2
                 * orderTime : 2018-06-16 10:56:35
                 * orderAmount : 1
                 * paymentMethod : null
                 * paymentKeys : null
                 * paymentTime : null
                 * orderStatus : PT
                 * ifRefund : 1
                 * refundTime : null
                 * custRemarks : null
                 * transId : null
                 * qrcode : null
                 * updatePgm : ApiOrderService
                 * isOwner : 0
                 * gpactId : f24cb4d9c9df48bc85260fa6e91b6f48
                 * endDate : 2018-06-22 11:55:22
                 * joinNums : 1
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String orderNo;
                private String custId;
                private String groupId;
                private String groupType;
                private String orderTime;
                private int orderAmount;
                private Object paymentMethod;
                private Object paymentKeys;
                private Object paymentTime;
                private String orderStatus;
                private String ifRefund;
                private Object refundTime;
                private Object custRemarks;
                private Object transId;
                private Object qrcode;
                private String updatePgm;
                private int isOwner;
                private String gpactId;
                private String endDate;
                private int joinNums;

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

                public String getCustId() {
                    return custId;
                }

                public void setCustId(String custId) {
                    this.custId = custId;
                }

                public String getGroupId() {
                    return groupId;
                }

                public void setGroupId(String groupId) {
                    this.groupId = groupId;
                }

                public String getGroupType() {
                    return groupType;
                }

                public void setGroupType(String groupType) {
                    this.groupType = groupType;
                }

                public String getOrderTime() {
                    return orderTime;
                }

                public void setOrderTime(String orderTime) {
                    this.orderTime = orderTime;
                }

                public int getOrderAmount() {
                    return orderAmount;
                }

                public void setOrderAmount(int orderAmount) {
                    this.orderAmount = orderAmount;
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

                public String getIfRefund() {
                    return ifRefund;
                }

                public void setIfRefund(String ifRefund) {
                    this.ifRefund = ifRefund;
                }

                public Object getRefundTime() {
                    return refundTime;
                }

                public void setRefundTime(Object refundTime) {
                    this.refundTime = refundTime;
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

                public Object getQrcode() {
                    return qrcode;
                }

                public void setQrcode(Object qrcode) {
                    this.qrcode = qrcode;
                }

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }

                public int getIsOwner() {
                    return isOwner;
                }

                public void setIsOwner(int isOwner) {
                    this.isOwner = isOwner;
                }

                public String getGpactId() {
                    return gpactId;
                }

                public void setGpactId(String gpactId) {
                    this.gpactId = gpactId;
                }

                public String getEndDate() {
                    return endDate;
                }

                public void setEndDate(String endDate) {
                    this.endDate = endDate;
                }

                public int getJoinNums() {
                    return joinNums;
                }

                public void setJoinNums(int joinNums) {
                    this.joinNums = joinNums;
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
                 * userName : 灰太狼的替身
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
        }
    }
}
