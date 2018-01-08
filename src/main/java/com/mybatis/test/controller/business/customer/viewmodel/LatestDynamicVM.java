package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.domain.LatestDynamic;

public class LatestDynamicVM {
    private LatestDynamic latestDynamic;

    public LatestDynamicVM(LatestDynamic latestDynamic) {
        this.latestDynamic = latestDynamic;
    }

    /**
     * id
     */
    public String getDynamicId() {
        return latestDynamic.getDynamicId();
    }

    /**
     * 标签
     */
    public String getDynamicLabel() {
        return latestDynamic.getDynamicLabel();
    }

    /**
     * 标题
     */
    public String getTitle() {
        return latestDynamic.getTitle();
    }

    /**
     * 创建时间
     */
    public String getCreateDate() {
        return latestDynamic.getCreateDate();
    }

    /**
     * 人气
     */
    public int getPopularity() {
        return latestDynamic.getPopularity();
    }

    /**
     * 评论数
     */
    public int getCommentsNumber() {
        return latestDynamic.getCommentsNumber();
    }
}
