package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.domain.Sign;

public class SignVM {
    private Sign sign;

    public SignVM(Sign sign) {
        this.sign = sign;
    }

    public boolean isSignFlag() {
        return sign.isSignFlag();
    }

    public String getSignMessage() {
        return sign.getSignMessage();
    }
}
