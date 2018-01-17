package com.mybatis.test.service.impl.myfriend;

import com.mybatis.test.model.MyFriend;
import com.mybatis.test.repo.MyFriendMapper;
import com.mybatis.test.service.api.myfriend.IMyFriendService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

@Service
public class MyFriendService extends BaseDBService<MyFriendMapper, MyFriend> implements IMyFriendService {
    @Override
    public boolean isAlreadyFriend(String myCustomerId, String friendCustomerId) {
        return getRepo().getMyFriendByFriendId(myCustomerId, friendCustomerId) != null;
    }
}
