package com.mybatis.test.service.impl.customer;

import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.common.enumeration.ActiveValueTypeEnum;
import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.domain.Sign;
import com.mybatis.test.domain.SignIn;
import com.mybatis.test.model.Customer;
import com.mybatis.test.repo.CustomerMapper;
import com.mybatis.test.service.api.customer.ICustomerService;
import com.mybatis.test.service.common.BaseDBService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseDBService<CustomerMapper, Customer> implements ICustomerService {
    @Override
    public Customer selectByUserName(String userName) {
        return getRepo().getByUserName(userName);
    }

    @Override
    public SignIn getSignIn() {
        SignIn signIn = new SignIn();
        Customer customer = CustomerUtils.getCustomer();
        if (StringUtils.isNotBlank(customer.getId())) {
            customer = getRepo().selectById(customer.getId());
            setSignMessage(signIn, customer);
        }
        return signIn;
    }

    @Override
    public Sign sign() {
        Sign sign = new Sign();
        try {
            Customer customer = CustomerUtils.getCustomer();
            checkSign(customer);
            setSignResult(sign, customer);
        } catch (RuntimeException e) {
            sign.setSignMessage(e.getMessage());
        }
        return sign;
    }

    private void setSignResult(Sign sign, Customer customer) {
        customer = getRepo().selectById(customer.getId());
        if (customer.getLatestActiveDate() == null || DateUtil.getBetweenDays(customer.getLatestActiveDate(), DateUtil.getCurrentDate()) > 1) {
            customer.setLatestActiveDate(DateUtil.getCurrentDate());
            customer.setActiveValue(customer.getActiveValue() + ActiveValueTypeEnum.LESS_FIVE.getValue());
            customer.setContinueActiveCount(1);
            customer.preUpdate();
            update(customer);
            sign.setSignFlag(true);
            sign.setSignMessage(String.format("签到成功，获得%s活跃值", ActiveValueTypeEnum.LESS_FIVE.getValue()));
        } else {
            if (DateUtil.getBetweenDays(customer.getLatestActiveDate(), DateUtil.getCurrentDate()) == 0) {
                throw new RuntimeException("您今天已经签到过了哦");
            } else {
                customer.setLatestActiveDate(DateUtil.getCurrentDate());
                customer.setActiveValue(customer.getActiveValue() + ActiveValueTypeEnum.getValueByDay(customer.getContinueActiveCount()));
                customer.setContinueActiveCount(customer.getContinueActiveCount() + 1);
                customer.preUpdate();
                update(customer);
                sign.setSignFlag(true);
                sign.setSignMessage(String.format("签到成功，获得%s活跃值", ActiveValueTypeEnum.getValueByDay(customer.getContinueActiveCount())));
            }
        }
    }

    private void checkSign(Customer customer) {
        if (StringUtils.isBlank(customer.getId()))
            throw new RuntimeException("必须登录才能签到哦");
    }

    private void setSignMessage(SignIn signIn, Customer customer) {
        signIn.setLoginFlag(true);
        if (customer.getLatestActiveDate() == null || DateUtil.getBetweenDays(customer.getLatestActiveDate(), DateUtil.getCurrentDate()) > 1) {
            //说明已经断签
            signIn.setShowSignInCountFlag(false);
            signIn.setSignInFlag(false);
            signIn.setContinueActiveCount(0);
            signIn.setActiveValue(ActiveValueTypeEnum.LESS_FIVE.getValue());
        } else {
            signIn.setShowSignInCountFlag(true);
            if (DateUtil.getBetweenDays(customer.getLatestActiveDate(), DateUtil.getCurrentDate()) == 0) {
                //今日已经签到
                signIn.setSignInFlag(true);
                signIn.setContinueActiveCount(customer.getContinueActiveCount());
                signIn.setActiveValue(ActiveValueTypeEnum.getValueByDay(customer.getContinueActiveCount() - 1));
            } else {
                //今日未签到
                signIn.setSignInFlag(false);
                signIn.setContinueActiveCount(customer.getContinueActiveCount());
                signIn.setActiveValue(ActiveValueTypeEnum.getValueByDay(customer.getContinueActiveCount()));
            }
        }
    }
}
