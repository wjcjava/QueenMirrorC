package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean;

/**
 * Created by john on 2018/6/5.
 */

public class MyWalletBean {

    /**
     * success : true
     * errorCode : -1
     * msg : 操作成功
     * body : {"accountBalance":0}
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
         * accountBalance : 0
         */

        private int accountBalance;

        public int getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(int accountBalance) {
            this.accountBalance = accountBalance;
        }
    }
}
