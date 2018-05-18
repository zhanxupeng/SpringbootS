package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.enumeration.DistanceDateEnum;
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
        return  DistanceDateEnum.getDistanceDate(dynamicIntroduction.getCreateDate());
    }

    public int getPraise() {
        return dynamicIntroduction.getPraise();
    }

    public int getCommentsNumber() {
        return dynamicIntroduction.getCommentsNumber();
    }
}
