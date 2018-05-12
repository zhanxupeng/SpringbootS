package com.mybatis.test.domain;

public class AdminCountData {
    private int todayRegister;
    private int todayActive;
    private int identifyCount;
    private int unIdentifyCount;
    private int todayDynamic;

    public int getTodayRegister() {
        return todayRegister;
    }

    public void setTodayRegister(int todayRegister) {
        this.todayRegister = todayRegister;
    }

    public int getTodayActive() {
        return todayActive;
    }

    public void setTodayActive(int todayActive) {
        this.todayActive = todayActive;
    }

    public int getIdentifyCount() {
        return identifyCount;
    }

    public void setIdentifyCount(int identifyCount) {
        this.identifyCount = identifyCount;
    }

    public int getUnIdentifyCount() {
        return unIdentifyCount;
    }

    public void setUnIdentifyCount(int unIdentifyCount) {
        this.unIdentifyCount = unIdentifyCount;
    }

    public int getTodayDynamic() {
        return todayDynamic;
    }

    public void setTodayDynamic(int todayDynamic) {
        this.todayDynamic = todayDynamic;
    }
}
