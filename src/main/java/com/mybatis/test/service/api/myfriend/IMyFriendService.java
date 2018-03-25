package com.mybatis.test.service.api.myfriend;

import com.mybatis.test.domain.MyFamiliarityFriendInfo;
import com.mybatis.test.model.MyFriend;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;

public interface IMyFriendService extends IBaseDBService<MyFriend> {
    /**
     * 是否已经是好友
     */
    boolean isAlreadyFriend(String myCustomerId, String friendCustomerId);

    /**
     * 添加好友
     */
    void addFriend(String myCustomerId, String friendCustomerId);

    /**
     * 添加所有好友
     */
    void addAllFriend(String myCustomerId);

    List<MyFamiliarityFriendInfo> getMyFamiliarityFriend();
}
