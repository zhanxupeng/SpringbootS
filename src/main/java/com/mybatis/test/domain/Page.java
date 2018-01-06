package com.mybatis.test.domain;

/**
 * Created by 占大帅 on 2018/1/6.
 */
public class Page {
    private int curr;               //当前页码
    private int limit;              //限制数量

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
