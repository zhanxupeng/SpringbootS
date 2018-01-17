package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

public class MyFriend extends BaseModel{

    private String customerId;

    private String friendCustomerId;

    private Integer familiarity;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFriendCustomerId() {
        return friendCustomerId;
    }

    public void setFriendCustomerId(String friendCustomerId) {
        this.friendCustomerId = friendCustomerId;
    }

    public Integer getFamiliarity() {
        return familiarity;
    }

    public void setFamiliarity(Integer familiarity) {
        this.familiarity = familiarity;
    }
}