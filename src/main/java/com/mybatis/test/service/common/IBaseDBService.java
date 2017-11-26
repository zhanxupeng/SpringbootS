package com.mybatis.test.service.common;


import com.mybatis.test.common.base.BaseModel;

import java.util.List;

public interface IBaseDBService<T extends BaseModel> {

    /**
     * 根据ID查询对象
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
     * 批量删除
     */
    int delete(List<String> idList);

    /**
     * 删除（单个）
     */
    int delete(String id);

}
