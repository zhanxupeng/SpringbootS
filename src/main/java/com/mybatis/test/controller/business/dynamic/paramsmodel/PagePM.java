package com.mybatis.test.controller.business.dynamic.paramsmodel;

import com.mybatis.test.domain.Page;

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
