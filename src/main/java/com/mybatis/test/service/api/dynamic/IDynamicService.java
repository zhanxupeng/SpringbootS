package com.mybatis.test.service.api.dynamic;

import com.mybatis.test.model.Dynamic;
import com.mybatis.test.service.common.IBaseDBService;

public interface IDynamicService extends IBaseDBService<Dynamic> {

    /**
     * 获取某分类下动态的数目
     */
    int getCountByAppointCategory(String firstTitle, String secondTitle);
}
