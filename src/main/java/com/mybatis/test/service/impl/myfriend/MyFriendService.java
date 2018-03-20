package com.mybatis.test.service.impl.myfriend;

import com.mybatis.test.model.MyFriend;
import com.mybatis.test.repo.MyFriendMapper;
import com.mybatis.test.service.api.myfriend.IMyFriendService;
import com.mybatis.test.service.api.mynotice.IMyNoticeService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class MyFriendService extends BaseDBService<MyFriendMapper, MyFriend> implements IMyFriendService {

    @Resource
    private IMyNoticeService myNoticeService;

    @Override
    public boolean isAlreadyFriend(String myCustomerId, String friendCustomerId) {
        return getRepo().getMyFriendByFriendId(myCustomerId, friendCustomerId) != null;
    }

    @Transactional
    @Override
    public void addFriend(String myCustomerId, String friendCustomerId) {
        if (isAlreadyFriend(myCustomerId, friendCustomerId)) {
            return;
        }
        MyFriend myFriend = new MyFriend();
        myFriend.init();
        myFriend.setCustomerId(myCustomerId);
        myFriend.setFriendCustomerId(friendCustomerId);
        myFriend.setFamiliarity(0);
        insert(myFriend);
        MyFriend friendFriend = new MyFriend();
        friendFriend.init();
        friendFriend.setCustomerId(friendCustomerId);
        friendFriend.setFriendCustomerId(myCustomerId);
        friendFriend.setFamiliarity(0);
        insert(friendFriend);
        myNoticeService.agreeFriendApply(myCustomerId, friendCustomerId);
    }

    @Transactional
    @Override
    public void addAllFriend(String myCustomerId) {
        myNoticeService.getWaitDeal(myCustomerId).forEach(x -> addFriend(myCustomerId, x.getCustomerId()));
        myNoticeService.agreeAllFriendApply(myCustomerId);
    }
}