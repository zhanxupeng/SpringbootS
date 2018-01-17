package com.mybatis.test.service.api.myfriend;

import com.mybatis.test.model.MyFriend;
import com.mybatis.test.service.common.IBaseDBService;

public interface IMyFriendService extends IBaseDBService<MyFriend> {
    /**
     * 是否已经是好友
     */
    boolean isAlreadyFriend(String myCustomerId, String friendCustomerId);
}
