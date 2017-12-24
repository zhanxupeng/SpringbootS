package com.mybatis.test.service.impl.comments;


import com.mybatis.test.model.Comments;
import com.mybatis.test.repo.CommentsMapper;
import com.mybatis.test.service.api.comments.ICommentsService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

@Service
public class CommentsService extends BaseDBService<CommentsMapper, Comments> implements ICommentsService {
}
