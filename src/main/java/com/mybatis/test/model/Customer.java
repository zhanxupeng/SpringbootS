package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

import java.util.Date;

public class Customer extends BaseModel {

    private String userName;

    private String nickName;

    private String password;

    private String headPicture;

    private Integer sex;

    private Integer praise;

    private String city;

    private String autograph;

    private int popularity;

    private int activeValue;

    private Date latestActiveDate;

    private Integer continueActiveCount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getActiveValue() {
        return activeValue;
    }

    public void setActiveValue(int activeValue) {
        this.activeValue = activeValue;
    }

    public Date getLatestActiveDate() {
        return latestActiveDate;
    }

    public void setLatestActiveDate(Date latestActiveDate) {
        this.latestActiveDate = latestActiveDate;
    }

    public Integer getContinueActiveCount() {
        return continueActiveCount;
    }

    public void setContinueActiveCount(Integer continueActiveCount) {
        this.continueActiveCount = continueActiveCount;
    }
}