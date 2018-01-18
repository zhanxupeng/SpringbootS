package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.domain.FriendIdentity;

public class FriendIdentityVM {
    private FriendIdentity friendIdentity;

    public FriendIdentityVM(FriendIdentity friendIdentity) {
        this.friendIdentity = friendIdentity;
    }

    public String getCustomerId() {
        return friendIdentity.getCustomerId();
    }

    public String getNickName() {
        return friendIdentity.getNickName();
    }

    public String getCreateDate() {
        return DateUtil.convertDateToString(friendIdentity.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

}
