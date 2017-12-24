package com.mybatis.test.service.impl.dynamic;

import com.mybatis.test.model.Comments;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.repo.DynamicMapper;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicService extends BaseDBService<DynamicMapper, Dynamic> implements IDynamicService {
    private final static int DEFAULT_HOME_RECOMMEND_NUMBER = 12;//首页默认推荐数量

    @Override
    public List<Comments> getHomeRecommend() {
        return null;
    }
}
