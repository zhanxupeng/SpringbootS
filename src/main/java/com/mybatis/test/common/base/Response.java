package com.mybatis.test.common.base;


import com.mybatis.test.common.enumeration.ResultEnum;

/**
 * @author liulp
 * @create 2017-07-14
 */
public class Response<T> {

    private String code;

    private String message;

    private T data;

    public Response() {
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }

    public Response(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }
}
