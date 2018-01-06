package com.mybatis.test.domain;

public class SignIn {

    /**
     * 是否登录
     */
    private boolean loginFlag = false;

    /**
     * 今日是否签到
     */
    private boolean signInFlag;

    /**
     * 是否显示连续签到天数
     */
    private boolean showSignInCountFlag;

    /**
     * 连续签到天数
     */
    private int continueActiveCount;

    /**
     * 签到获得活跃值
     */
    private int activeValue;

    public boolean isLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    public boolean isSignInFlag() {
        return signInFlag;
    }

    public void setSignInFlag(boolean signInFlag) {
        this.signInFlag = signInFlag;
    }

    public boolean isShowSignInCountFlag() {
        return showSignInCountFlag;
    }

    public void setShowSignInCountFlag(boolean showSignInCountFlag) {
        this.showSignInCountFlag = showSignInCountFlag;
    }

    public int getContinueActiveCount() {
        return continueActiveCount;
    }

    public void setContinueActiveCount(int continueActiveCount) {
        this.continueActiveCount = continueActiveCount;
    }

    public int getActiveValue() {
        return activeValue;
    }

    public void setActiveValue(int activeValue) {
        this.activeValue = activeValue;
    }
}
