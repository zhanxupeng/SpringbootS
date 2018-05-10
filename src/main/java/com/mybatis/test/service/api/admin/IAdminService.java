package com.mybatis.test.service.api.admin;

import com.mybatis.test.model.UnIdentifyCustomer;

import java.util.List;

public interface IAdminService {
    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    String login(String userName, String password);

    /**
     * 获取未认证用户信息
     *
     * @return
     */
    List<UnIdentifyCustomer> getUnIdentifyCustomer();

    /**
     * 拒绝认证
     *
     * @param customerId
     */
    void refuseIdentify(String customerId);

    /**
     * 通过认证
     */
    void agreeIdentify(String customerId);
}
