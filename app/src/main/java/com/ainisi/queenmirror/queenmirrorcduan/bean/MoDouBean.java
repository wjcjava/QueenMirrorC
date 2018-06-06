package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class MoDouBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 获取数据成功
     * body : {"ansMemberBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"custId":null,"cardNo":null,"cardIevel":"1","cardBalance":0,"cardPoints":null,"enableFlag":null,"updatePgm":null}}
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
         * ansMemberBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"custId":null,"cardNo":null,"cardIevel":"1","cardBalance":0,"cardPoints":null,"enableFlag":null,"updatePgm":null}
         */

        private AnsMemberBasicBean ansMemberBasic;

        public AnsMemberBasicBean getAnsMemberBasic() {
            return ansMemberBasic;
        }

        public void setAnsMemberBasic(AnsMemberBasicBean ansMemberBasic) {
            this.ansMemberBasic = ansMemberBasic;
        }

        public static class AnsMemberBasicBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * custId : null
             * cardNo : null
             * cardIevel : 1
             * cardBalance : 0
             * cardPoints : null
             * enableFlag : null
             * updatePgm : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private Object custId;
            private Object cardNo;
            private String cardIevel;
            private int cardBalance;
            private Object cardPoints;
            private Object enableFlag;
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

            public Object getCustId() {
                return custId;
            }

            public void setCustId(Object custId) {
                this.custId = custId;
            }

            public Object getCardNo() {
                return cardNo;
            }

            public void setCardNo(Object cardNo) {
                this.cardNo = cardNo;
            }

            public String getCardIevel() {
                return cardIevel;
            }

            public void setCardIevel(String cardIevel) {
                this.cardIevel = cardIevel;
            }

            public int getCardBalance() {
                return cardBalance;
            }

            public void setCardBalance(int cardBalance) {
                this.cardBalance = cardBalance;
            }

            public Object getCardPoints() {
                return cardPoints;
            }

            public void setCardPoints(Object cardPoints) {
                this.cardPoints = cardPoints;
            }

            public Object getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(Object enableFlag) {
                this.enableFlag = enableFlag;
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
