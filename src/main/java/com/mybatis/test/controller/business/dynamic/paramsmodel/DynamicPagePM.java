package com.mybatis.test.controller.business.dynamic.paramsmodel;

import com.mybatis.test.domain.DynamicPage;

public class DynamicPagePM {
    private DynamicPage dynamicPage = new DynamicPage();
    private String firstTitle;
    private String secondTitle;
    private int curr;               //当前页码
    private int limit;              //限制数量

    public void setFirstTitle(String firstTitle) {
        dynamicPage.setFirstTitle(firstTitle);
    }

    public void setSecondTitle(String secondTitle) {
        dynamicPage.setSecondTitle(secondTitle);
    }

    public void setCurr(int curr) {
        dynamicPage.setCurr(curr);
    }

    public void setLimit(int limit) {
        dynamicPage.setLimit(limit);
    }

    public DynamicPage getDynamicPage() {
        return dynamicPage;
    }

    public void setDynamicPage(DynamicPage dynamicPage) {
        this.dynamicPage = dynamicPage;
    }
}
