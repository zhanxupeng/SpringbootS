package com.mybatis.test.common.enumeration;

import java.util.Arrays;

public enum SexEnum {
    UN_KNOW(0, "未知"),
    MEN(1, "男"),
    WOMEN(2, "女");
    private int value;
    private String description;

    SexEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescriptionByValue(final Integer value) {
        return Arrays.stream(SexEnum.values()).filter(x -> x.value == value).findFirst().orElse(UN_KNOW).description;
    }
}
