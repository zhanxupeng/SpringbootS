package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.domain.DynamicIntroduction;

public class DynamicIntroductionVM {
    private DynamicIntroduction dynamicIntroduction;

    public DynamicIntroductionVM(DynamicIntroduction dynamicIntroduction) {
        this.dynamicIntroduction = dynamicIntroduction;
    }

    public String getCustomerId() {
        return dynamicIntroduction.getCustomerId();
    }

    public String getHeadPicture() {
        return dynamicIntroduction.getHeadPicture();
    }

    public String getNickName() {
        return dynamicIntroduction.getNickName();
    }

    public String getDynamicId() {
        return dynamicIntroduction.getDynamicId();
    }

    public String getTitle() {
        return dynamicIntroduction.getTitle();
    }

    public String getCreateDate() {
        return DateUtil.convertDateToString(dynamicIntroduction.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    public int getPraise() {
        return dynamicIntroduction.getPraise();
    }

    public int getCommentsNumber() {
        return dynamicIntroduction.getCommentsNumber();
    }
}
