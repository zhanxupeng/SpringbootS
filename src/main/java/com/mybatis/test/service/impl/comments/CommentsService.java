package com.mybatis.test.service.impl.comments;


import com.mybatis.test.domain.DynamicComments;
import com.mybatis.test.domain.HomeComments;
import com.mybatis.test.model.Comments;
import com.mybatis.test.repo.CommentsMapper;
import com.mybatis.test.service.api.comments.ICommentsService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService extends BaseDBService<CommentsMapper, Comments> implements ICommentsService {
    private final static int DEFAULT_COUNT = 4;

    @Override
    public List<Comments> getDynamicComments(String dynamicId) {
        return getRepo().getByDynamic(dynamicId);
    }

    @Override
    public List<HomeComments> getCustomerLatest(String customerId) {
        return getRepo().getHomeCommentsByCount(customerId, DEFAULT_COUNT);
    }

    @Override
    public List<DynamicComments> getMyComments(String customerId) {
        List<DynamicComments> dynamicCommentsList = getRepo().getCustomerComments(customerId);
        return dynamicCommentsList.stream().map(x -> {
            if (!x.getDynamicCustomerId().equals(customerId)) {
                x.setDynamicCommentsFlag(false);
            }
            return x;
        }).collect(Collectors.toList());
    }
}
