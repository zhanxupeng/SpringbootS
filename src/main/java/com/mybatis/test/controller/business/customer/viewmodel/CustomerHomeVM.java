package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.model.Customer;

public class CustomerHomeVM {
    private Customer customer;

    public CustomerHomeVM(Customer customer) {
        this.customer = customer;
    }

    /**
     * 头像
     */
    public String getHeadPicture() {
        return customer.getHeadPicture();
    }

    /**
     * 昵称
     */
    public String getNickName() {
        return customer.getNickName();
    }

    /**
     * 性别
     */
    public Integer getSex() {
        return customer.getSex();
    }

    /**
     * 活跃值
     */
    public Integer getActiveValue() {
        return customer.getActiveValue();
    }

    /**
     * 创建时间
     */
    public String getCreateDate() {
        return DateUtil.convertDateToString(customer.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    /**
     * 城市
     */
    public String getCity() {
        return customer.getCity();
    }

    /**
     * 签名
     */
    public String getAutograph() {
        return customer.getAutograph();
    }

}
