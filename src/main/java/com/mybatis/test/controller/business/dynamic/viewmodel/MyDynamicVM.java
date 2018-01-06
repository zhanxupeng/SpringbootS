package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.domain.MyDynamic;

public class MyDynamicVM {
    private MyDynamic myDynamic;

    public MyDynamicVM(MyDynamic myDynamic) {
        this.myDynamic = myDynamic;
    }

    public String getDynamicId() {
        return myDynamic.getDynamicId();
    }

    public String getTitle() {
        return myDynamic.getTitle();
    }

    public String getCreateDate() {
        return DateUtil.convertDateToString(myDynamic.getCreateDate(), DateUtil.YYYY_MM_DDHHMMSS);
    }

    public Integer getPopularity() {
        return myDynamic.getPopularity();
    }

    public Integer getCommentsNumber() {
        return myDynamic.getCommentsNumber();
    }
}
