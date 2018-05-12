package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 根据用户名查找用户
     */
    Customer getByUserName(@Param("userName") String userName);

    /**
     * 根据认证状态获取用户信息
     */
    List<Customer> getByIdentifyStatus(@Param("identify") int identify);

    /**
     * 修改用户认证状态
     */
    void changeIdentifyStatus(@Param("customerId") String customerId,
                              @Param("identify") int identify);

    /**
     * 某天注册用户数
     */
    int dayRegister(@Param("registerDate") Date registerDate);

    /**
     * 某天活跃用户数
     */
    int dayActive(@Param("activeDate") Date activeDate);

    /**
     * 获取某认证状态的用户数
     */
    int getCountByIdentifyStatus(@Param("identify") int identify);
}