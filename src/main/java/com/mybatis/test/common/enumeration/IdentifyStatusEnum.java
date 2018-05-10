package com.mybatis.test.common.enumeration;

public enum IdentifyStatusEnum {
    //DEFAULT '0' COMMENT '是否认证 0未认证 1已认证' 2认证失败
    NO(0, "未认证"),
    YES(1, "已认证"),
    REFUSE(2, "认证失败");
    private int value;
    private String description;

    IdentifyStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
