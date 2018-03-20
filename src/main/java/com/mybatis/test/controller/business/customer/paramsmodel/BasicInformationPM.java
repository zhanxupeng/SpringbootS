package com.mybatis.test.controller.business.customer.paramsmodel;

import com.mybatis.test.model.Customer;

public class BasicInformationPM {
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
    public void setSex(Integer sex) {
        customer.setSex(sex);
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

    /**
     * 头像
     */
    public void setHeadPicture(String headPicture) {
        customer.setHeadPicture(headPicture);
    }

    /**
     * 学院
     */
    public void setAcademy(String academy){
        customer.setAcademy(academy);
    }

    /**
     * 年级
     */
    public void setClassRoom(String classRoom){
        customer.setClassRoom(classRoom);
    }

    /**
     * 寝室号
     */
    public void setBedroom(String bedRoom){
        customer.setBedroom(bedRoom);
    }

    public Customer getCustomer() {
        return customer;
    }

}
