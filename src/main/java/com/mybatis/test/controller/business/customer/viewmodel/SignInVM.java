package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.domain.SignIn;

public class SignInVM {
    private SignIn signIn;

    public SignInVM(SignIn signIn) {
        this.signIn = signIn;
    }
    public boolean isLoginFlag() {
        return signIn.isLoginFlag();
    }


    public boolean isSignInFlag() {
        return signIn.isSignInFlag();
    }

    public boolean isShowSignInCountFlag() {
        return signIn.isShowSignInCountFlag();
    }

    public int getContinueActiveCount() {
        return signIn.getContinueActiveCount();
    }

    public int getActiveValue() {
        return signIn.getActiveValue();
    }

}
