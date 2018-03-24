package com.mybatis.test.service.api.dynamic;

import com.mybatis.test.domain.*;
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

    /**
     * 分页查询我的动态
     */
    List<MyDynamic> findMyDynamicList(String customerId, Page page);

    /**
     * 查询我的动态数目
     */
    int getMyDynamicCount(String customerId);

    /**
     * 查询最近动态
     */
    List<LatestDynamic> getLatestDynamic(String customerId);

    /**
     * 获取首页推荐内容
     */
    List<DynamicIntroduction> recommend(int recommendType);
}
