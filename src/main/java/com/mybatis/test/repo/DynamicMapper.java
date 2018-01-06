package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.domain.DynamicIntroduction;
import com.mybatis.test.model.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DynamicMapper extends BaseMapper<Dynamic> {

    /**
     * 获取某分类下动态的数目
     */
    int getCountByAppointCategory(@Param("firstTitle") String firstTitle,
                                  @Param("secondTitle") String secondTitle);

    /**
     * 获取某分类下的动态
     */
    List<DynamicIntroduction> findPage(@Param("firstTitle") String firstTitle,
                                       @Param("secondTitle") String secondTitle);
}