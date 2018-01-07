package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.MyAlbum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyAlbumMapper extends BaseMapper<MyAlbum> {
    /**
     * 根据customerId查询相册
     */
    List<MyAlbum> getListByCustomer(@Param("customerId") String customerId);
}