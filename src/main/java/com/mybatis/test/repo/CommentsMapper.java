package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments>{
}