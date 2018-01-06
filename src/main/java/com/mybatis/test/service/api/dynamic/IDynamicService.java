package com.mybatis.test.service.api.dynamic;

import com.mybatis.test.domain.DynamicIntroduction;
import com.mybatis.test.domain.DynamicPage;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;

public interface IDynamicService extends IBaseDBService<Dynamic> {

    /**
     * 获取某分类下动态的数目
     */
    int getCountByAppointCategory(String firstTitle, String secondTitle);

    /**
     * 分页查询动态信息
     */
    List<DynamicIntroduction> findDynamicIntroductionList(DynamicPage dynamicPage);
}
