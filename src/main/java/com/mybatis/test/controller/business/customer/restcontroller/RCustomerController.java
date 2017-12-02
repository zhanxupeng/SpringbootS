package com.mybatis.test.controller.business.customer.restcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.customer.viewmodel.BoolVM;
import com.mybatis.test.model.Customer;
import com.mybatis.test.service.api.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 占大帅 on 2017/12/2.
 */
@RestController
@RequestMapping("rest/customer")
public class RCustomerController extends BaseController {

    @Resource
    private ICustomerService customerService;

    @GetMapping("userNameCheck")
    public Response checkUserName(String userName) {
        Customer customer = customerService.getByUserName(userName);
        return result(getCheckResult(customer));
    }

    private BoolVM getCheckResult(Customer customer) {
        BoolVM boolVM = new BoolVM();
        boolVM.setStatus(true);
        boolVM.setInfo("恭喜你，当前用户名可用！");
        if (null != customer) {
            boolVM.setStatus(false);
            boolVM.setInfo("非常抱歉，当前用户名已经被使用！");
        }
        return boolVM;
    }
}
