package com.mybatis.test.service.impl.question;

import com.mybatis.test.model.Question;
import com.mybatis.test.repo.QuestionMapper;
import com.mybatis.test.service.api.question.IQuestionService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;


@Service
public class QuestionService extends BaseDBService<QuestionMapper,Question> implements IQuestionService {
}
