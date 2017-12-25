package com.mybatis.test.domain;

public class Sign {
    /**
     * 签到是否成功
     */
    private boolean signFlag = false;

    /**
     * 提示信息
     */
    private String signMessage;

    public boolean isSignFlag() {
        return signFlag;
    }

    public void setSignFlag(boolean signFlag) {
        this.signFlag = signFlag;
    }

    public String getSignMessage() {
        return signMessage;
    }

    public void setSignMessage(String signMessage) {
        this.signMessage = signMessage;
    }
}
