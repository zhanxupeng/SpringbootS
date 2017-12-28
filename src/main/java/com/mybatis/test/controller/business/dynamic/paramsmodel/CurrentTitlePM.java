package com.mybatis.test.controller.business.dynamic.paramsmodel;

public class CurrentTitlePM {
    /**
     * 一级标题
     */
    private String firstTitle;
    /**
     * 二级标题
     */
    private String secondTitle;

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
}
