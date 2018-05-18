package com.ainisi.queenmirror.queenmirrorcduan.bean;

public class LoginBean {


    /**
     * success : true
     * errorCode : 0
     * msg : 登录成功
     * body : {"apiAnsCustBasic":{"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustBasic":{"id":"a80cda1d69b8498493ec345ceda5efa6","isNewRecord":false,"remarks":null,"createDate":"2018-05-18 08:55:09","updateDate":"2018-05-18 08:55:09","contractConfirm":"1","cellPhone":"13405024815","deviceToken":null,"userName":"13405024815","userPass":"e10adc3949ba59abbe56e057f20f883e","wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":1526604909000,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":"1","recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":"ApiUserRegisterController"},"nameIdentifyLabel":null,"sexLabel":null,"loginFlagLabel":null,"delFlagLabel":null,"contractConfirmLabel":null}}
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
         * apiAnsCustBasic : {"id":null,"isNewRecord":true,"remarks":null,"createDate":null,"updateDate":null,"ansCustBasic":{"id":"a80cda1d69b8498493ec345ceda5efa6","isNewRecord":false,"remarks":null,"createDate":"2018-05-18 08:55:09","updateDate":"2018-05-18 08:55:09","contractConfirm":"1","cellPhone":"13405024815","deviceToken":null,"userName":"13405024815","userPass":"e10adc3949ba59abbe56e057f20f883e","wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":1526604909000,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":"1","recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":"ApiUserRegisterController"},"nameIdentifyLabel":null,"sexLabel":null,"loginFlagLabel":null,"delFlagLabel":null,"contractConfirmLabel":null}
         */

        private ApiAnsCustBasicBean apiAnsCustBasic;

        public ApiAnsCustBasicBean getApiAnsCustBasic() {
            return apiAnsCustBasic;
        }

        public void setApiAnsCustBasic(ApiAnsCustBasicBean apiAnsCustBasic) {
            this.apiAnsCustBasic = apiAnsCustBasic;
        }

        public static class ApiAnsCustBasicBean {
            /**
             * id : null
             * isNewRecord : true
             * remarks : null
             * createDate : null
             * updateDate : null
             * ansCustBasic : {"id":"a80cda1d69b8498493ec345ceda5efa6","isNewRecord":false,"remarks":null,"createDate":"2018-05-18 08:55:09","updateDate":"2018-05-18 08:55:09","contractConfirm":"1","cellPhone":"13405024815","deviceToken":null,"userName":"13405024815","userPass":"e10adc3949ba59abbe56e057f20f883e","wechatId":null,"wechatToken":null,"qqId":null,"qqToken":null,"headPic":null,"lastName":null,"firstName":null,"idCard":null,"nameIdentify":null,"sex":null,"birthday":null,"registerDate":1526604909000,"nickName":null,"loginIp":null,"logininTime":null,"loginoutTime":null,"loginFlag":"1","recommendUser":null,"recommendCode":null,"updatBy":null,"updatePgm":"ApiUserRegisterController"}
             * nameIdentifyLabel : null
             * sexLabel : null
             * loginFlagLabel : null
             * delFlagLabel : null
             * contractConfirmLabel : null
             */

            private Object id;
            private boolean isNewRecord;
            private Object remarks;
            private Object createDate;
            private Object updateDate;
            private AnsCustBasicBean ansCustBasic;
            private Object nameIdentifyLabel;
            private Object sexLabel;
            private Object loginFlagLabel;
            private Object delFlagLabel;
            private Object contractConfirmLabel;

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

            public AnsCustBasicBean getAnsCustBasic() {
                return ansCustBasic;
            }

            public void setAnsCustBasic(AnsCustBasicBean ansCustBasic) {
                this.ansCustBasic = ansCustBasic;
            }

            public Object getNameIdentifyLabel() {
                return nameIdentifyLabel;
            }

            public void setNameIdentifyLabel(Object nameIdentifyLabel) {
                this.nameIdentifyLabel = nameIdentifyLabel;
            }

            public Object getSexLabel() {
                return sexLabel;
            }

            public void setSexLabel(Object sexLabel) {
                this.sexLabel = sexLabel;
            }

            public Object getLoginFlagLabel() {
                return loginFlagLabel;
            }

            public void setLoginFlagLabel(Object loginFlagLabel) {
                this.loginFlagLabel = loginFlagLabel;
            }

            public Object getDelFlagLabel() {
                return delFlagLabel;
            }

            public void setDelFlagLabel(Object delFlagLabel) {
                this.delFlagLabel = delFlagLabel;
            }

            public Object getContractConfirmLabel() {
                return contractConfirmLabel;
            }

            public void setContractConfirmLabel(Object contractConfirmLabel) {
                this.contractConfirmLabel = contractConfirmLabel;
            }

            public static class AnsCustBasicBean {
                /**
                 * id : a80cda1d69b8498493ec345ceda5efa6
                 * isNewRecord : false
                 * remarks : null
                 * createDate : 2018-05-18 08:55:09
                 * updateDate : 2018-05-18 08:55:09
                 * contractConfirm : 1
                 * cellPhone : 13405024815
                 * deviceToken : null
                 * userName : 13405024815
                 * userPass : e10adc3949ba59abbe56e057f20f883e
                 * wechatId : null
                 * wechatToken : null
                 * qqId : null
                 * qqToken : null
                 * headPic : null
                 * lastName : null
                 * firstName : null
                 * idCard : null
                 * nameIdentify : null
                 * sex : null
                 * birthday : null
                 * registerDate : 1526604909000
                 * nickName : null
                 * loginIp : null
                 * logininTime : null
                 * loginoutTime : null
                 * loginFlag : 1
                 * recommendUser : null
                 * recommendCode : null
                 * updatBy : null
                 * updatePgm : ApiUserRegisterController
                 */

                private String id;
                private boolean isNewRecord;
                private Object remarks;
                private String createDate;
                private String updateDate;
                private String contractConfirm;
                private String cellPhone;
                private Object deviceToken;
                private String userName;
                private String userPass;
                private Object wechatId;
                private Object wechatToken;
                private Object qqId;
                private Object qqToken;
                private Object headPic;
                private Object lastName;
                private Object firstName;
                private Object idCard;
                private Object nameIdentify;
                private Object sex;
                private Object birthday;
                private long registerDate;
                private Object nickName;
                private Object loginIp;
                private Object logininTime;
                private Object loginoutTime;
                private String loginFlag;           //判断用户是否可以登录（后台进行设置）
                private Object recommendUser;
                private Object recommendCode;
                private Object updatBy;
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

                public String getContractConfirm() {
                    return contractConfirm;
                }

                public void setContractConfirm(String contractConfirm) {
                    this.contractConfirm = contractConfirm;
                }

                public String getCellPhone() {
                    return cellPhone;
                }

                public void setCellPhone(String cellPhone) {
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

                public String getUserPass() {
                    return userPass;
                }

                public void setUserPass(String userPass) {
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

                public long getRegisterDate() {
                    return registerDate;
                }

                public void setRegisterDate(long registerDate) {
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

                public String getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(String loginFlag) {
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

                public String getUpdatePgm() {
                    return updatePgm;
                }

                public void setUpdatePgm(String updatePgm) {
                    this.updatePgm = updatePgm;
                }
            }
        }
    }
}
