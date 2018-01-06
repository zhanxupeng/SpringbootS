package com.mybatis.test.controller.business.dynamic.paramsmodel;

import com.mybatis.test.domain.Page;

/**
 * Created by 占大帅 on 2018/1/6.
 */
public class PagePM {
    private Page page = new Page();

    public void setCurr(int curr) {
        page.setCurr(curr);
    }

    public void setLimit(int limit) {
        page.setLimit(limit);
    }

    public Page getPage() {
        return page;
    }
}
