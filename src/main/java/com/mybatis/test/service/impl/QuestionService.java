package com.mybatis.test.service.impl;

import com.mybatis.test.model.Question;
import com.mybatis.test.repo.QuestionMapper;
import com.mybatis.test.service.api.IQuestionService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

/**
 * Created by 占大帅 on 2017/12/2.
 */
@Service
public class QuestionService extends BaseDBService<QuestionMapper,Question> implements IQuestionService {
}
