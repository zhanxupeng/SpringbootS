package com.mybatis.test.service.common;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.common.base.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;


public abstract class BaseDBService<R extends BaseMapper<T>, T extends BaseModel> implements IBaseDBService<T> {

    @Autowired
    private R repo;

    @Override
    public int insert(T entity) {
        return repo.insert(entity);
    }

    @Override
    public int update(T entity) {
        return repo.update(entity);
    }

    @Override
    public int delete(List<String> idList) {
        return repo.delete(idList);
    }

    @Override
    public int delete(String id) {
        return repo.delete(Collections.singletonList(id));
    }

    @Override
    public T selectById(String id) {
        return repo.selectById(id);
    }

    protected R getRepo() {
        return repo;
    }
}
