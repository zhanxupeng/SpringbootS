package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.MyFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyFriendMapper extends BaseMapper<MyFriend> {
    /**
     * 查询好友信息
     */
    MyFriend getMyFriendByFriendId(@Param("customerId") String customerId,
                                   @Param("friendCustomerId") String friendCustomerId);
}