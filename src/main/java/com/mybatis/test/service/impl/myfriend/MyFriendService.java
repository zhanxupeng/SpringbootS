package com.mybatis.test.service.impl.myfriend;

import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.domain.MyFamiliarityFriendInfo;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.MyFriend;
import com.mybatis.test.repo.MyFriendMapper;
import com.mybatis.test.service.api.myfriend.IMyFriendService;
import com.mybatis.test.service.api.mynotice.IMyNoticeService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyFriendService extends BaseDBService<MyFriendMapper, MyFriend> implements IMyFriendService {

    private final static int DEFAULT_FAMILIARITY_FRIEND_COUNT = 12;
    private final static int VIEW_ADD_FAMILIARITY = 2;
    private final static int REPLY_ADD_FAMILIARITY = 5;

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

    @Override
    public List<MyFamiliarityFriendInfo> getMyFamiliarityFriend() {
        return getRepo().findFamiliarityFriend(CustomerUtils.getCustomer().getId(), DEFAULT_FAMILIARITY_FRIEND_COUNT);
    }

    @Override
    public void viewAddFamiliarity(String dynamicCustomerId) {
        Customer customer = CustomerUtils.getCustomer();
        if (customer != null) {
            getRepo().addFamiliarity(customer.getId(), dynamicCustomerId, VIEW_ADD_FAMILIARITY);
            getRepo().addFamiliarity(dynamicCustomerId, customer.getId(), VIEW_ADD_FAMILIARITY);
        }
    }

    @Override
    public void replyAddFamiliarity(String dynamicCustomerId) {
        Customer customer = CustomerUtils.getCustomer();
        if (customer != null) {
            getRepo().addFamiliarity(customer.getId(), dynamicCustomerId, REPLY_ADD_FAMILIARITY);
            getRepo().addFamiliarity(dynamicCustomerId, customer.getId(), REPLY_ADD_FAMILIARITY);
        }
    }
}
