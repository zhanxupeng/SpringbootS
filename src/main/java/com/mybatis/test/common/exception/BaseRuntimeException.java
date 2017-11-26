package com.mybatis.test.common.exception;

public abstract class BaseRuntimeException extends RuntimeException {
    private String code;

    public BaseRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseRuntimeException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BaseRuntimeException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
