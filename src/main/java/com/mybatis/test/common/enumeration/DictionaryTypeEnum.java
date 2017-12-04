package com.mybatis.test.common.enumeration;

/**
 * Created by 占大帅 on 2017/12/2.
 */
public enum DictionaryTypeEnum {
    SECURITY_QUESTION("security_question","密保问题"),
    HUMAN_CHECK("human_check","人类验证");
    private String value;
    private String description;
    DictionaryTypeEnum(String value,String description){
        this.value=value;
        this.description=description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
