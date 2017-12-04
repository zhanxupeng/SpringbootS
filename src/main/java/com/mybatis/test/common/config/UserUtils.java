package com.mybatis.test.common.config;

import com.mybatis.test.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class UserUtils {
    /**
     * 获取当前登录用户
     */
    public static User getUser() {
        Subject subject = getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            System.out.println(principal);
            return (User) principal;
        }
        return new User();
    }

    /**
     * 获取授权主要对象
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

}
