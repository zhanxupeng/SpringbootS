package com.mybatis.test.domain;

import java.util.Date;

public class DynamicComments {
    /**
     * 如果动态是登录用户发的 dynamicCustomerId=用户id，commentsCustomerName在您的动态dynamicName中添加了评论
     * 否则 commentsCustomerName在动态dynamicName中回复了您。
     */
    //动态id
    private String dynamicId;
    //动态名称
    private String dynamicName;
    //动态发布者
    private String dynamicCustomerId;
    //评论者id
    private String commentsCustomerId;
    //评论者name
    private String commentsCustomerName;
    //评论时间
    private Date commentsDate;
    //是否是动态直接评论
    private boolean dynamicCommentsFlag = true;

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getDynamicName() {
        return dynamicName;
    }

    public void setDynamicName(String dynamicName) {
        this.dynamicName = dynamicName;
    }

    public String getDynamicCustomerId() {
        return dynamicCustomerId;
    }

    public void setDynamicCustomerId(String dynamicCustomerId) {
        this.dynamicCustomerId = dynamicCustomerId;
    }

    public String getCommentsCustomerId() {
        return commentsCustomerId;
    }

    public void setCommentsCustomerId(String commentsCustomerId) {
        this.commentsCustomerId = commentsCustomerId;
    }

    public String getCommentsCustomerName() {
        return commentsCustomerName;
    }

    public void setCommentsCustomerName(String commentsCustomerName) {
        this.commentsCustomerName = commentsCustomerName;
    }

    public boolean isDynamicCommentsFlag() {
        return dynamicCommentsFlag;
    }

    public void setDynamicCommentsFlag(boolean dynamicCommentsFlag) {
        this.dynamicCommentsFlag = dynamicCommentsFlag;
    }

    public Date getCommentsDate() {
        return commentsDate;
    }

    public void setCommentsDate(Date commentsDate) {
        this.commentsDate = commentsDate;
    }
}
