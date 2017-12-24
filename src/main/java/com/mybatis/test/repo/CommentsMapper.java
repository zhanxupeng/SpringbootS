package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
    /**
     * 根据动态id查找评论,按评论时间倒序，后期考虑分页
     */
    List<Comments> getByDynamic(@Param("dynamicId") String dynamicId);
}