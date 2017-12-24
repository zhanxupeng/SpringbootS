package com.mybatis.test.service.api.dynamic;

import com.mybatis.test.model.Comments;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;

public interface IDynamicService extends IBaseDBService<Dynamic> {
    /**
     * 获取首页推荐数据
     */
    List<Comments> getHomeRecommend();
}
