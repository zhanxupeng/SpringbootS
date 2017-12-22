package com.mybatis.test.common.config;

import com.mybatis.test.model.Customer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class CustomerUtils {
    /**
     * 获取当前登录用户
     */
    public static Customer getCustomer() {
        Subject subject = getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            System.out.println(principal);
            return (Customer) principal;
        }
        return new Customer();
    }

    /**
     * 获取授权主要对象
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

}
