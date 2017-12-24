package com.mybatis.test.controller.business.customer.parammodel;

import com.mybatis.test.model.Customer;

/**
 * Created by 占大帅 on 2017/12/24.
 */
public class BaseDataPM {
    private Customer customer = new Customer();

    /**
     * 昵称
     */
    public void setNickName(String nickName) {
        customer.setNickName(nickName);
    }

    /**
     * 性别
     */
    public void setSex(String sex) {
        customer.setSex(Integer.parseInt(sex));
    }

    /**
     * 城市
     */
    public void setCity(String city) {
        customer.setCity(city);
    }

    /**
     * 签名
     */
    public void setAutograph(String autograph) {
        customer.setAutograph(autograph);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
