package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.enumeration.DistanceDateEnum;
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
        return DistanceDateEnum.getDistanceDate(myDynamic.getCreateDate());
    }

    public Integer getPopularity() {
        return myDynamic.getPopularity();
    }

    public Integer getCommentsNumber() {
        return myDynamic.getCommentsNumber();
    }

    public String getSecondTitleLabel() {
        return myDynamic.getSecondTitleLabel();
    }
}
