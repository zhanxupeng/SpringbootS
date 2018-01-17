package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.MyNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyNoticeMapper extends BaseMapper<MyNotice> {
    List<MyNotice> findList(MyNotice myNotice);
}