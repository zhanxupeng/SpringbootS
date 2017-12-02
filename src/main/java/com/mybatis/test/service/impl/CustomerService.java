package com.mybatis.test.service.impl;

import com.mybatis.test.model.Customer;
import com.mybatis.test.repo.CustomerMapper;
import com.mybatis.test.service.api.ICustomerService;
import com.mybatis.test.service.common.BaseDBService;
import org.springframework.stereotype.Service;

/**
 * Created by 占大帅 on 2017/12/2.
 */
@Service
public class CustomerService extends BaseDBService<CustomerMapper, Customer> implements ICustomerService {
}
