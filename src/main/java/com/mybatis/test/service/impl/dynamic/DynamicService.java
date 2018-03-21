package com.mybatis.test.service.impl.dynamic;

import com.github.pagehelper.PageHelper;
import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.common.enumeration.DynamicMoodEnum;
import com.mybatis.test.common.enumeration.DynamicTypeEnum;
import com.mybatis.test.domain.*;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.repo.DynamicMapper;
import com.mybatis.test.service.api.dictionary.IDictionaryService;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class DynamicService extends BaseDBService<DynamicMapper, Dynamic> implements IDynamicService {
    private final static int LATEST_DEFAULT_COUNT = 8;
    @Resource
    private IDictionaryService dictionaryService;

    @Override
    public int getCountByAppointCategory(String firstTitle, String secondTitle) {
        return getRepo().getCountByAppointCategory(firstTitle, secondTitle);
    }

    @Override
    public List<DynamicIntroduction> findDynamicIntroductionList(DynamicPage dynamicPage) {
        List<DynamicIntroduction> dynamicIntroductionList = new LinkedList<>();
        PageHelper.startPage(dynamicPage.getCurr(), dynamicPage.getLimit());
        if (DynamicTypeEnum.isDynamicTopic(dynamicPage.getFirstTitle())) {//话题
            dynamicIntroductionList = getRepo().findPage(dynamicPage.getFirstTitle(), dynamicPage.getSecondTitle());
        } else {
            switch (DynamicMoodEnum.getByType(dynamicPage.getSecondTitle())) {
                case FRIEND://朋友：看到好友的所有动态
                    dynamicIntroductionList = getRepo().findFriendPage(CustomerUtils.getCustomer().getId());
                    break;
                case NEARBY://附近:看到好友的好友发在附近或校园的动态
                    dynamicIntroductionList = getRepo().findNearbyPage(CustomerUtils.getCustomer().getId());
                    break;
                case SCHOOL://校园:读取所有校园的动态
                    dynamicIntroductionList = getRepo().findSchoolPage();
                    break;
            }
        }
        return dynamicIntroductionList;
    }

    @Override
    public List<MyDynamic> findMyDynamicList(String customerId, Page page) {
        PageHelper.startPage(page.getCurr(), page.getLimit());
        List<MyDynamic> myDynamicList = getRepo().findDynamicByCustomer(customerId);
        myDynamicList.forEach(x -> {
            String firstTitleType = DynamicTypeEnum.getLabelByValue(x.getFirstTitle());
            x.setSecondTitleLabel(dictionaryService.getLabel(firstTitleType, x.getSecondTitle()));
        });
        return myDynamicList;
    }

    @Override
    public int getMyDynamicCount(String customerId) {
        return getRepo().getCountByCustomerId(customerId);
    }

    @Override
    public List<LatestDynamic> getLatestDynamic(String customerId) {
        List<LatestDynamic> latestDynamicList = getRepo().getLatestDynamicByCount(customerId, LATEST_DEFAULT_COUNT);
        latestDynamicList.forEach(x -> {
            String firstTitleType = DynamicTypeEnum.getLabelByValue(x.getFirstTitle());
            x.setDynamicLabel(dictionaryService.getLabel(firstTitleType, x.getSecondTitle()));
        });
        return latestDynamicList;
    }
}
