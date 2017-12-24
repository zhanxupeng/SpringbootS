package com.mybatis.test.service.impl.dictionary;

import com.mybatis.test.common.enumeration.DictionaryTypeEnum;
import com.mybatis.test.common.enumeration.DynamicTypeEnum;
import com.mybatis.test.model.Dictionary;
import com.mybatis.test.repo.DictionaryMapper;
import com.mybatis.test.service.api.dictionary.IDictionaryService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DictionaryService extends BaseDBService<DictionaryMapper, Dictionary> implements IDictionaryService {
    @Override
    public List<Dictionary> getSecurityQuestion() {
        return getRepo().getByType(DictionaryTypeEnum.SECURITY_QUESTION.getValue());
    }

    @Override
    public Dictionary getHumanCheckQuestion() {
        List<Dictionary> dictionaryList = getRepo().getByType(DictionaryTypeEnum.HUMAN_CHECK.getValue());
        return dictionaryList.get(new Random().nextInt(dictionaryList.size()));
    }

    @Override
    public List<Dictionary> getDynamicSecondTitle(String firstTitle) {
        return getRepo().getByType(DynamicTypeEnum.getLabelByValue(firstTitle));
    }

    @Override
    public String getLabel(String type, String key) {
        return getRepo().getByTypeAndKey(type, key).getLabel();
    }
}
