package com.mybatis.test.service.impl.mynotice;

import com.mybatis.test.common.enumeration.NoticeReceiveStatusEnum;
import com.mybatis.test.domain.FriendIdentity;
import com.mybatis.test.model.MyNotice;
import com.mybatis.test.repo.MyNoticeMapper;
import com.mybatis.test.service.api.mynotice.IMyNoticeService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyNoticeService extends BaseDBService<MyNoticeMapper, MyNotice> implements IMyNoticeService {
    @Override
    public boolean isAlreadyApply(String sendCustomerId, String receiveCustomerId) {
        MyNotice myNotice = new MyNotice();
        myNotice.setSendCustomerId(sendCustomerId);
        myNotice.setReceiveCustomerId(receiveCustomerId);
        myNotice.setReceiveStatus(NoticeReceiveStatusEnum.WAIT.getValue());
        return getRepo().findList(myNotice).size() != 0;
    }

    @Override
    public List<FriendIdentity> getWaitDeal(String customerId) {
        return getRepo().getByReceiveCustomerAndStatus(customerId, NoticeReceiveStatusEnum.WAIT.getValue());
    }
}
