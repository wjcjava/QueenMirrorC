package com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean;

import java.util.List;

/**
 * Created by john on 2018/5/10.
 */

public class HomeIndustryBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"CategoryListData":[{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"27a7d133a8f94cb9b9bce03365cf6a48","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"2","tabName":"美容美体","tabKeyword":"MRMT","tabDesc":"美容美体","tabSorts":"3","fatherId":"0","allFathers":"","categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null},"tabTypeLabel":"美业商品","openFlagLabel":"开放"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"575a4f781e48405f860f0dc7a7be4b79","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"2","tabName":"美学汇","tabKeyword":"MXH","tabDesc":"美学汇","tabSorts":"1","fatherId":"0","allFathers":"","categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null},"tabTypeLabel":"美业商品","openFlagLabel":"开放"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"9003d18c17bd4bb98969a72a4ca553d5","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"2","tabName":"美甲美手","tabKeyword":"MJMS","tabDesc":"美甲美手","tabSorts":"2","fatherId":"0","allFathers":"","categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null},"tabTypeLabel":"美业商品","openFlagLabel":"开放"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"b718ade8a94f4b41993c0ecbcc2821d2","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"2","tabName":"美发定制","tabKeyword":"MFDZ","tabDesc":"美发定制","tabSorts":"4","fatherId":"0","allFathers":"","categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null},"tabTypeLabel":"美业商品","openFlagLabel":"开放"},{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ecCategory":{"id":"d93edbd7180246aca91c368b1d64b937","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"2","tabName":"半永久","tabKeyword":"BYJ","tabDesc":"半永久","tabSorts":"5","fatherId":"0","allFathers":"","categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null},"tabTypeLabel":"美业商品","openFlagLabel":"开放"}]}
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
        private List<CategoryListDataBean> CategoryListData;

        public List<CategoryListDataBean> getCategoryListData() {
            return CategoryListData;
        }

        public void setCategoryListData(List<CategoryListDataBean> CategoryListData) {
            this.CategoryListData = CategoryListData;
        }

        public static class CategoryListDataBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ecCategory : {"id":"27a7d133a8f94cb9b9bce03365cf6a48","isNewRecord":false,"remarks":null,"createDate":null,"updateDate":null,"tabType":"2","tabName":"美容美体","tabKeyword":"MRMT","tabDesc":"美容美体","tabSorts":"3","fatherId":"0","allFathers":"","categoryNo":null,"categoryBrief":null,"categoryRemarks":null,"openFlag":"0","list":null}
             * tabTypeLabel : 美业商品
             * openFlagLabel : 开放
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private EcCategoryBean ecCategory;
            private String tabTypeLabel;
            private String openFlagLabel;

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

            public EcCategoryBean getEcCategory() {
                return ecCategory;
            }

            public void setEcCategory(EcCategoryBean ecCategory) {
                this.ecCategory = ecCategory;
            }

            public String getTabTypeLabel() {
                return tabTypeLabel;
            }

            public void setTabTypeLabel(String tabTypeLabel) {
                this.tabTypeLabel = tabTypeLabel;
            }

            public String getOpenFlagLabel() {
                return openFlagLabel;
            }

            public void setOpenFlagLabel(String openFlagLabel) {
                this.openFlagLabel = openFlagLabel;
            }

            public static class EcCategoryBean {
                /**
                 * id : 27a7d133a8f94cb9b9bce03365cf6a48
                 * isNewRecord : false
                 * remarks : null
                 * createDate : null
                 * updateDate : null
                 * tabType : 2
                 * tabName : 美容美体
                 * tabKeyword : MRMT
                 * tabDesc : 美容美体
                 * tabSorts : 3
                 * fatherId : 0
                 * allFathers :
                 * categoryNo : null
                 * categoryBrief : null
                 * categoryRemarks : null
                 * openFlag : 0
                 * list : null
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private Object createDate;
                private Object updateDate;
                private String tabType;
                private String tabName;
                private String tabKeyword;
                private String tabDesc;
                private String tabSorts;
                private String fatherId;
                private String allFathers;
                private Object categoryNo;
                private Object categoryBrief;
                private Object categoryRemarks;
                private String openFlag;
                private Object list;

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

                public String getTabType() {
                    return tabType;
                }

                public void setTabType(String tabType) {
                    this.tabType = tabType;
                }

                public String getTabName() {
                    return tabName;
                }

                public void setTabName(String tabName) {
                    this.tabName = tabName;
                }

                public String getTabKeyword() {
                    return tabKeyword;
                }

                public void setTabKeyword(String tabKeyword) {
                    this.tabKeyword = tabKeyword;
                }

                public String getTabDesc() {
                    return tabDesc;
                }

                public void setTabDesc(String tabDesc) {
                    this.tabDesc = tabDesc;
                }

                public String getTabSorts() {
                    return tabSorts;
                }

                public void setTabSorts(String tabSorts) {
                    this.tabSorts = tabSorts;
                }

                public String getFatherId() {
                    return fatherId;
                }

                public void setFatherId(String fatherId) {
                    this.fatherId = fatherId;
                }

                public String getAllFathers() {
                    return allFathers;
                }

                public void setAllFathers(String allFathers) {
                    this.allFathers = allFathers;
                }

                public Object getCategoryNo() {
                    return categoryNo;
                }

                public void setCategoryNo(Object categoryNo) {
                    this.categoryNo = categoryNo;
                }

                public Object getCategoryBrief() {
                    return categoryBrief;
                }

                public void setCategoryBrief(Object categoryBrief) {
                    this.categoryBrief = categoryBrief;
                }

                public Object getCategoryRemarks() {
                    return categoryRemarks;
                }

                public void setCategoryRemarks(Object categoryRemarks) {
                    this.categoryRemarks = categoryRemarks;
                }

                public String getOpenFlag() {
                    return openFlag;
                }

                public void setOpenFlag(String openFlag) {
                    this.openFlag = openFlag;
                }

                public Object getList() {
                    return list;
                }

                public void setList(Object list) {
                    this.list = list;
                }
            }
        }
    }
}
