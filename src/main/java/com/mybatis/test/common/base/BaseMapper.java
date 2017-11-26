package com.mybatis.test.common.base;


import java.util.List;

public interface BaseMapper<T> {

    /**
     * 按ID获取
     */
    T selectById(String id);

    /**
     * 新增
     */
    int insert(T entity);

    /**
     * 更新
     */
    int update(T entity);

    /**
     * 删除
     */
    int delete(List<String> idList);

    /**
     * 逻辑删除
     */
    int deleteByLogic(List<String> idList);


}
