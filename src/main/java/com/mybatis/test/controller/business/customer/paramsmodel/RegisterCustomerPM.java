package com.mybatis.test.controller.business.customer.paramsmodel;

import java.util.List;

/**
 * Created by 占大帅 on 2017/12/2.
 */
public class RegisterCustomerPM {
    private String userName;                                    //用户名
    private String nickName;                                    //昵称
    private String password;                                    //密码
    private int sex;                                            //姓名 1:男 2：女 0:未知
    private boolean security;                                   //是否设置密保问题，true;设置 false:不设置
    private List<SecurityQuestionPM> securityQuestionPMList;    //密保问题，一共三个[0][1][2]

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isSecurity() {
        return security;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public List<SecurityQuestionPM> getSecurityQuestionPMList() {
        return securityQuestionPMList;
    }

    public void setSecurityQuestionPMList(List<SecurityQuestionPM> securityQuestionPMList) {
        this.securityQuestionPMList = securityQuestionPMList;
    }
}
