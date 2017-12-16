package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

public class MyNotice extends BaseModel{

    private String sendCustomerId;

    private String receiveCustomerId;

    private String sendStatus;

    private String receiveStatus;

    private String content;

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

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}