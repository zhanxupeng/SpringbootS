package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {
    /**
     * 根据类型查找
     */
    List<Dictionary> getByType(@Param("type")String type);
}