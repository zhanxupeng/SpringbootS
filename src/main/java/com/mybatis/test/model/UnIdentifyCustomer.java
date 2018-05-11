package com.mybatis.test.model;

import com.mybatis.test.common.enumeration.SexEnum;

public class UnIdentifyCustomer {
    private String customerId;
    private String realName;
    private String headPicture;
    private String description;

    public UnIdentifyCustomer(Customer customer) {
        this.customerId = customer.getId();
        this.realName = customer.getRealName();
        this.description = String.format("性别%s,来自%s%s,寝室号%s", SexEnum.getDescriptionByValue(customer.getSex()),
                customer.getAcademy(), customer.getClassRoom(), customer.getBedroom());
        this.headPicture = customer.getHeadPicture();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
