package com.mybatis.test.common.exception;

public class ServiceException extends RuntimeException {

    private String code;

    public ServiceException(Info info) {
        super(info.getMessage());
        this.code = info.getCode();
    }

    public String getCode() {
        return code;
    }

    public enum Info {
        ILLEGAL_PARAM("100", "参数非法");

        protected String code;

        protected String message;

        Info(String code, String message) {
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
}
