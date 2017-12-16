package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.MyAlbum;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyAlbumMapper extends BaseMapper<MyAlbum>{
}