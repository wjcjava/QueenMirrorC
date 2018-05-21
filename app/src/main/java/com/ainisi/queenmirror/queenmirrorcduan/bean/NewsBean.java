package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class NewsBean {


    /**
     * success : false
     * errorCode : 1
     * msg : 否
     * body : {"isRead":"0"}
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
         * isRead : 0
         */

        private String isRead;

        public String getIsRead() {
            return isRead;
        }

        public void setIsRead(String isRead) {
            this.isRead = isRead;
        }
    }
}
