package com.mybatis.test.common.enumeration;

import java.util.Arrays;

public enum DynamicTypeEnum {
    DYNAMIC_MOOD("1", "dynamic_mood", "动态心情"),
    DYNAMIC_TOPIC("2", "dynamic_topic", "动态话题");
    private String value;
    private String label;
    private String description;

    DynamicTypeEnum(String value, String label, String description) {
        this.value = value;
        this.label = label;
        this.description = description;
    }

    public static String getLabelByValue(String value) {
        return Arrays.stream(DynamicTypeEnum.values()).filter(x -> x.value.equals(value)).findFirst().orElse(DYNAMIC_MOOD).label;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public static boolean isNeedLogin(String firstTitle, String secondTitle) {
        if (DYNAMIC_MOOD.value.equals(firstTitle)) {
            if (secondTitle.equals("1") || secondTitle.equals("2")) {
                return true;
            }
        }
        return false;
    }
}
