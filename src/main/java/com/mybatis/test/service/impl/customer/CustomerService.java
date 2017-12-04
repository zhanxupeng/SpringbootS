package com.mybatis.test.service.impl.customer;

import com.mybatis.test.model.Customer;
import com.mybatis.test.repo.CustomerMapper;
import com.mybatis.test.service.api.customer.ICustomerService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseDBService<CustomerMapper, Customer> implements ICustomerService {
    @Override
    public Customer selectByUserName(String userName) {
        return getRepo().getByUserName(userName);
    }
}
