package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DynamicMapper extends BaseMapper<Dynamic> {

    /**
     * 获取某分类下动态的数目
     */
    int getCountByAppointCategory(@Param("firstTitle") String firstTitle,
                                  @Param("secondTitle") String secondTitle);
}