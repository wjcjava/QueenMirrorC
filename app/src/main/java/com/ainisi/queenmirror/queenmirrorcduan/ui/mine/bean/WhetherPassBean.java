package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by john on 2018/6/9.
 */

public class WhetherPassBean {

    /**
     * success : true
     * errorCode : 0
     * msg : 不存在
     * body : {"isExists":0}
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
         * isExists : 0
         */

        private int isExists;

        public int getIsExists() {
            return isExists;
        }

        public void setIsExists(int isExists) {
            this.isExists = isExists;
        }
    }
}
