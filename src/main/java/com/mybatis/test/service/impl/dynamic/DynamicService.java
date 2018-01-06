package com.mybatis.test.service.impl.dynamic;

import com.github.pagehelper.PageHelper;
import com.mybatis.test.domain.DynamicIntroduction;
import com.mybatis.test.domain.DynamicPage;
import com.mybatis.test.domain.MyDynamic;
import com.mybatis.test.domain.Page;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.repo.DynamicMapper;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicService extends BaseDBService<DynamicMapper, Dynamic> implements IDynamicService {
    @Override
    public int getCountByAppointCategory(String firstTitle, String secondTitle) {
        return getRepo().getCountByAppointCategory(firstTitle, secondTitle);
    }

    @Override
    public List<DynamicIntroduction> findDynamicIntroductionList(DynamicPage dynamicPage) {
        PageHelper.startPage(dynamicPage.getCurr(), dynamicPage.getLimit());
        return getRepo().findPage(dynamicPage.getFirstTitle(), dynamicPage.getSecondTitle());
    }

    @Override
    public List<MyDynamic> findMyDynamicList(String customerId, Page page) {
        PageHelper.startPage(page.getCurr(), page.getLimit());
        return getRepo().findDynamicByCustomer(customerId);
    }

    @Override
    public int getMyDynamicCount(String customerId) {
        return getRepo().getCountByCustomerId(customerId);
    }
}
