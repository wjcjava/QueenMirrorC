package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

import java.util.List;

/**
 * Created by john on 2018/5/26.
 */

public class ProblemListBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 获取常见问题分类列表成功
     * body : {"QaCateListData":[{"id":"3c84d6296fbc48cbb9142b78da1aab20","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:38:38","updateDate":"2018-04-17 14:38:38","value":"3","label":"优惠问题","type":"ans_qa_type","description":"问题分类","sort":21,"parentId":"0"},{"id":"9321fefe81d34427a417bcc9eff41da2","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:38:26","updateDate":"2018-04-17 14:38:26","value":"2","label":"订单问题","type":"ans_qa_type","description":"问题分类","sort":11,"parentId":"0"},{"id":"94903076b9ce443cb63667324147c5e3","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:38:50","updateDate":"2018-04-17 14:38:50","value":"4","label":"其他问题","type":"ans_qa_type","description":"问题分类","sort":31,"parentId":"0"},{"id":"d0e6046c93924699a2d9264995348e62","isNewRecord":false,"remarks":"","createDate":"2018-04-17 14:38:12","updateDate":"2018-04-17 14:38:12","value":"1","label":"支付问题","type":"ans_qa_type","description":"问题分类","sort":1,"parentId":"0"}]}
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
        private List<QaCateListDataBean> QaCateListData;

        public List<QaCateListDataBean> getQaCateListData() {
            return QaCateListData;
        }

        public void setQaCateListData(List<QaCateListDataBean> QaCateListData) {
            this.QaCateListData = QaCateListData;
        }

        public static class QaCateListDataBean {
            /**
             * id : 3c84d6296fbc48cbb9142b78da1aab20
             * isNewRecord : false
             * remarks :
             * createDate : 2018-04-17 14:38:38
             * updateDate : 2018-04-17 14:38:38
             * value : 3
             * label : 优惠问题
             * type : ans_qa_type
             * description : 问题分类
             * sort : 21
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String value;
            private String label;
            private String type;
            private String description;
            private int sort;
            private String parentId;

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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
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

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }
        }
    }
}
