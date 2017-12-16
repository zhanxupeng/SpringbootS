package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

public class FriendGroup extends BaseModel{
    private String customerId;

    private String groupName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}