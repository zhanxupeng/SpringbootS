package com.mybatis.test.common.enumeration;

public enum NoticeReceiveStatusEnum {
    //0待确认 1同意 2拒绝
    WAIT("0", "待确认"),
    AGREE("1", "同意"),
    REFUSE("2", "拒绝");

    private String value;
    private String description;

    NoticeReceiveStatusEnum(String value, String description) {
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
