package com.mybatis.test.controller.business.myfriend.viewmodel;

import com.mybatis.test.domain.MyFamiliarityFriendInfo;

public class MyFamiliarityFriendVM {
    private MyFamiliarityFriendInfo myFamiliarityFriendInfo;
    public MyFamiliarityFriendVM(MyFamiliarityFriendInfo myFamiliarityFriendInfo){
        this.myFamiliarityFriendInfo=myFamiliarityFriendInfo;
    }

    public String getCustomerId() {
        return myFamiliarityFriendInfo.getCustomerId();
    }

    public String getHeadPicture() {
        return myFamiliarityFriendInfo.getHeadPicture();
    }

    public String getNickName() {
        return myFamiliarityFriendInfo.getNickName();
    }

    public int getFamiliarity() {
        return myFamiliarityFriendInfo.getFamiliarity();
    }
}
