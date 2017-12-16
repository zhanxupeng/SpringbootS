package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Dynamic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DynamicMapper extends BaseMapper<Dynamic>{
}