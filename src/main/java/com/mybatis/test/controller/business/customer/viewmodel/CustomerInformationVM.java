package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.model.Customer;

public class CustomerInformationVM {
    private Customer customer;

    public CustomerInformationVM(Customer customer) {
        this.customer = customer;
    }

    public String getId() {
        return customer.getId();
    }

    public String getCreateDate() {
        return DateUtil.convertDateToString(customer.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    public String getUserName() {
        return customer.getUserName();
    }

    public String getNickName() {
        return customer.getNickName();
    }

    public String getHeadPicture() {
        return customer.getHeadPicture();
    }

    public int getSex() {
        return customer.getSex();
    }

    public Integer getPraise() {
        return customer.getPraise();
    }

    public String getCity() {
        return customer.getCity();
    }

    public String getAutograph() {
        return customer.getAutograph();
    }

    public int getPopularity() {
        return customer.getPopularity();
    }

    public int getActiveValue() {
        return customer.getActiveValue();
    }

    public String getLatestActiveDate() {
        return DateUtil.convertDateToString(customer.getLatestActiveDate(), DateUtil.YYYY_MM_DD);
    }

    public Integer getContinueActiveCount() {
        return customer.getContinueActiveCount();
    }

    public String getAcademy() {
        return customer.getAcademy();
    }

    public String getClassRoom() {
        return customer.getClassRoom();
    }

    public String getBedroom() {
        return customer.getBedroom();
    }

    public String getRealName() {
        return customer.getRealName();
    }
}
