package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.domain.HomeComments;

public class HomeCommentsVM {
    private HomeComments homeComments;

    public HomeCommentsVM(HomeComments homeComments) {
        this.homeComments = homeComments;
    }

    /**
     * 评论时间
     */
    public String getCreateDate() {
        return DateUtil.convertDateToString(homeComments.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    /**
     * 动态id
     */
    public String getDynamicId() {
        return homeComments.getDynamicId();
    }

    /**
     * 动态标题
     */
    public String getTitle() {
        return homeComments.getTitle();
    }

    /**
     * 评论内容
     */
    public String getContent() {
        return homeComments.getContent();
    }
}
