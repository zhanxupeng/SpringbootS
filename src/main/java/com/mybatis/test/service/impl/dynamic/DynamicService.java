package com.mybatis.test.service.impl.dynamic;

import com.mybatis.test.model.Dynamic;
import com.mybatis.test.repo.DynamicMapper;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

@Service
public class DynamicService extends BaseDBService<DynamicMapper, Dynamic> implements IDynamicService {
    @Override
    public int getCountByAppointCategory(String firstTitle, String secondTitle) {
        return 0;
    }
}
