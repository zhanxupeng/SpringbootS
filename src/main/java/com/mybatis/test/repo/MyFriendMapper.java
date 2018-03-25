package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.domain.MyFamiliarityFriendInfo;
import com.mybatis.test.model.MyFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyFriendMapper extends BaseMapper<MyFriend> {
    /**
     * 查询好友信息
     */
    MyFriend getMyFriendByFriendId(@Param("customerId") String customerId,
                                   @Param("friendCustomerId") String friendCustomerId);

    /**
     * 查询亲密好友
     */
    List<MyFamiliarityFriendInfo> findFamiliarityFriend(@Param("customerId") String customerId,
                                                        @Param("count") int count);

    /**
     * 增加亲密度
     */
    void addFamiliarity(@Param("customerId") String customerId,
                        @Param("friendCustomerId") String friendCustomerId,
                        @Param("increment") int increment);
}