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
}
