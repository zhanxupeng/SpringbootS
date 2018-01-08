package com.mybatis.test.service.api.comments;

import com.mybatis.test.domain.HomeComments;
import com.mybatis.test.model.Comments;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;


public interface ICommentsService extends IBaseDBService<Comments> {
    /**
     * 获取一个动态的评论
     */
    List<Comments> getDynamicComments(String dynamicId);

    /**
     * 获取用户最近回复
     */
    List<HomeComments> getCustomerLatest(String customerId);
}
