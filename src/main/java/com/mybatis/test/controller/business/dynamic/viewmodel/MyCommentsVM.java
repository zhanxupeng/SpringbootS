package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.domain.DynamicComments;

public class MyCommentsVM {
    //动态id
    private String dynamicId;
    //动态名称
    private String dynamicName;
    //评论者id
    private String commentsCustomerId;
    //评论者name
    private String commentsCustomerName;
    //评论时间
    private String commentsDate;
    //是否是动态直接评论
    private boolean dynamicCommentsFlag = true;

    public MyCommentsVM(DynamicComments dynamicComments) {
        this.dynamicId = dynamicComments.getDynamicId();
        this.dynamicName = dynamicComments.getDynamicName();
        this.commentsCustomerId = dynamicComments.getCommentsCustomerId();
        this.commentsCustomerName = dynamicComments.getCommentsCustomerName();
        this.commentsDate = DateUtil.convertDateToString(dynamicComments.getCommentsDate(), DateUtil.YYYY_MM_DD);
        this.dynamicCommentsFlag = dynamicComments.isDynamicCommentsFlag();
    }

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

    public String getCommentsDate() {
        return commentsDate;
    }

    public void setCommentsDate(String commentsDate) {
        this.commentsDate = commentsDate;
    }

    public boolean isDynamicCommentsFlag() {
        return dynamicCommentsFlag;
    }

    public void setDynamicCommentsFlag(boolean dynamicCommentsFlag) {
        this.dynamicCommentsFlag = dynamicCommentsFlag;
    }
}
