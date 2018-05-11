package com.mybatis.test.domain;

import com.mybatis.test.common.enumeration.SexEnum;
import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.model.Customer;

public class IdentifyCustomer {
    private String customerId;
    private String createDate;
    private String sex;
    private String realName;
    private String academy;
    private String classroom;
    private String bedroom;
    private String autograph;

    public IdentifyCustomer(Customer customer) {
        this.customerId = customer.getId();
        this.createDate = DateUtil.convertDateToString(customer.getCreateDate(), DateUtil.YYYY_MM_DD);
        this.sex = SexEnum.getDescriptionByValue(customer.getSex());
        this.realName = customer.getRealName();
        this.academy = customer.getAcademy();
        this.classroom = customer.getClassRoom();
        this.bedroom = customer.getBedroom();
        this.autograph = customer.getAutograph();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
