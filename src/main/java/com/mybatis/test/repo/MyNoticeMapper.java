package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.domain.FriendIdentity;
import com.mybatis.test.model.MyNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyNoticeMapper extends BaseMapper<MyNotice> {
    List<MyNotice> findList(MyNotice myNotice);

    /**
     * 根据接收者和接收状态查询
     */
    List<FriendIdentity> getByReceiveCustomerAndStatus(@Param("customerId") String customerId,
                                                       @Param("status") String status);
}