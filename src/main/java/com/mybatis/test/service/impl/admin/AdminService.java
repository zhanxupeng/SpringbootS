package com.mybatis.test.service.impl.admin;

import com.mybatis.test.common.enumeration.IdentifyStatusEnum;
import com.mybatis.test.common.login.AdminCache;
import com.mybatis.test.domain.IdentifyCustomer;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.UnIdentifyCustomer;
import com.mybatis.test.repo.CustomerMapper;
import com.mybatis.test.service.api.admin.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public String login(String userName, String password) {
        if (!(userName.equals("admin") && password.equals("111111"))) {
            throw new RuntimeException("用户名或密码错误");
        }
        return AdminCache.getIdentify("admin");
    }

    @Override
    public List<UnIdentifyCustomer> getUnIdentifyCustomer() {
        List<Customer> customerList = customerMapper.getByIdentifyStatus(IdentifyStatusEnum.NO.getValue());
        return customerList.stream().map(UnIdentifyCustomer::new).collect(Collectors.toList());
    }

    @Override
    public void refuseIdentify(String customerId) {
        customerMapper.changeIdentifyStatus(customerId, IdentifyStatusEnum.REFUSE.getValue());
    }

    @Override
    public void agreeIdentify(String customerId) {
        customerMapper.changeIdentifyStatus(customerId, IdentifyStatusEnum.YES.getValue());
    }

    @Override
    public List<IdentifyCustomer> rightIdentifyCustomer() {
        List<Customer> customerList = customerMapper.getByIdentifyStatus(IdentifyStatusEnum.YES.getValue());
        return customerList.stream().map(IdentifyCustomer::new).collect(Collectors.toList());
    }

    @Override
    public List<IdentifyCustomer> denyIdentifyCustomer() {
        List<Customer> customerList = customerMapper.getByIdentifyStatus(IdentifyStatusEnum.REFUSE.getValue());
        return customerList.stream().map(IdentifyCustomer::new).collect(Collectors.toList());
    }
}
