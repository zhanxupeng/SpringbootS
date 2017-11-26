package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 占大帅 on 2017/11/26.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查找用户信息
     */
    User selectByUsername(@Param("username") String username);
}
