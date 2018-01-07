package com.mybatis.test.domain;

import java.util.Date;

public class MyDynamic {
    private String firstTitle;
    private String secondTitle;
    private String dynamicId;
    private String title;
    private Date createDate;
    private Integer popularity;
    private Integer commentsNumber;
    private String secondTitleLabel;

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(Integer commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public String getSecondTitleLabel() {
        return secondTitleLabel;
    }

    public void setSecondTitleLabel(String secondTitleLabel) {
        this.secondTitleLabel = secondTitleLabel;
    }
}
