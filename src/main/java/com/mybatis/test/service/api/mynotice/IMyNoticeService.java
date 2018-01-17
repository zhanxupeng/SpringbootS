package com.mybatis.test.service.api.mynotice;

import com.mybatis.test.model.MyNotice;
import com.mybatis.test.service.common.IBaseDBService;

public interface IMyNoticeService extends IBaseDBService<MyNotice> {

    /**
     * 是否已经发送申请
     */
    boolean isAlreadyApply(String sendCustomerId, String receiveCustomerId);
}
