package com.mybatis.test.service.api.mynotice;

import com.mybatis.test.domain.FriendIdentity;
import com.mybatis.test.model.MyNotice;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;

public interface IMyNoticeService extends IBaseDBService<MyNotice> {

    /**
     * 是否已经发送申请
     */
    boolean isAlreadyApply(String sendCustomerId, String receiveCustomerId);

    /**
     * 获取未处理好友申请
     */
    List<FriendIdentity> getWaitDeal(String customerId);

    /**
     * 拒绝好友申请
     */
    void refuseFriendApply(String myCustomerId, String friendCustomerId);

    /**
     * 拒绝所有好友申请
     */
    void refuseAllFriendApply(String myCustomerId);

    /**
     * 同意好友申请
     */
    void agreeFriendApply(String myCustomerId, String friendCustomerId);

    /**
     * 同意所有好友申请
     */
    void agreeAllFriendApply(String myCustomerId);
}
