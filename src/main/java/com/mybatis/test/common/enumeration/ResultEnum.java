package com.mybatis.test.common.enumeration;

public enum ResultEnum {
    SUCCESS("0", "成功"),
    FAIL("-1", "调用失败");

    private String code;

    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
