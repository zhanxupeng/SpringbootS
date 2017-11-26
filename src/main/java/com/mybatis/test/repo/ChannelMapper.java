package com.mybatis.test.repo;


import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Channel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ChannelMapper extends BaseMapper<Channel> {
}