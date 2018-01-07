package com.mybatis.test.common.enumeration;

public enum DictionaryTypeEnum {
    SECURITY_QUESTION("security_question", "密保问题"),
    HUMAN_CHECK("human_check", "人类验证"),
    DYNAMIC_MOOD("dynamic_mood", "动态心情"),
    DYNAMIC_TOPIC("dynamic_topic", "动态话题");
    private String value;
    private String description;

    DictionaryTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
