package com.mybatis.test.service.api.dictionary;

import com.mybatis.test.model.Dictionary;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;

public interface IDictionaryService extends IBaseDBService<Dictionary> {
    /**
     * 获取密保问题
     */
    List<Dictionary> getSecurityQuestion();

    /**
     * 获取单个人类验证问题
     */
    Dictionary getHumanCheckQuestion();

    /**
     * 获取动态二级标题列表
     */
    List<Dictionary> getDynamicSecondTitle(String firstTitle);

    /**
     * 根据类型和键值获取标签
     */
    String getLabel(String type, String key);

}
