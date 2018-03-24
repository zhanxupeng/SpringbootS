package com.mybatis.test.controller.business.dynamic.viewcontroller;

import com.mybatis.test.common.enumeration.RecommendTypeEnum;

public class RecommendPM {
    private Integer recommendType;

    public Integer getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType==null? RecommendTypeEnum.DATE.getValue():recommendType;
    }
}
