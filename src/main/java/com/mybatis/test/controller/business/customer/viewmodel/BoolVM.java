package com.mybatis.test.controller.business.customer.viewmodel;

public class BoolVM {

    public BoolVM() {
        this.status = false;
    }

    public BoolVM(boolean status) {
        this.status = status;
    }

    /**
     * 返回客户端状态
     */
    private boolean status;


    /**
     * 返回信息
     */
    private String info;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}