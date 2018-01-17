package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

public class MyNotice extends BaseModel {

    private String sendCustomerId;

    private String receiveCustomerId;

    private String receiveStatus;

    public String getSendCustomerId() {
        return sendCustomerId;
    }

    public void setSendCustomerId(String sendCustomerId) {
        this.sendCustomerId = sendCustomerId;
    }

    public String getReceiveCustomerId() {
        return receiveCustomerId;
    }

    public void setReceiveCustomerId(String receiveCustomerId) {
        this.receiveCustomerId = receiveCustomerId;
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus;
    }
}