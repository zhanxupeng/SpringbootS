package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.model.SecretQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecretQuestionMapper extends BaseMapper<SecretQuestion> {
}