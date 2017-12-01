package com.mybatis.test.service.api.customer;

import com.mybatis.test.model.Customer;
import com.mybatis.test.service.common.IBaseDBService;

public interface ICustomerService extends IBaseDBService<Customer> {
    /**
     * 根据用户名查找用户
     */
    Customer selectByUserName(String userName);
}
