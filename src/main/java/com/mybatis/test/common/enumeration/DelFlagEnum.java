package com.mybatis.test.common.enumeration;

public enum DelFlagEnum {
    NO("0", "未删除"),
    YES("1", "已删除");

    private String value;
    private String description;

    DelFlagEnum(String value, String description) {
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
