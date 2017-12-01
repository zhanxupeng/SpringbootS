package com.mybatis.test.controller.business.customer.restcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.customer.parammodel.UserNamePM;
import com.mybatis.test.controller.business.customer.viewmodel.BoolVM;
import com.mybatis.test.model.Customer;
import com.mybatis.test.service.api.customer.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("rest/user")
public class RCustomerController extends BaseController {
    @Resource
    private ICustomerService customerService;

    /**
     * 判断用户名是否存在
     */
    @GetMapping("/checkUserName")
    public Response<BoolVM> checkExist(UserNamePM userNamePM) {
        Customer customer = customerService.selectByUserName(userNamePM.getUserName());
        return result(getCheckVM(customer));
    }

    private BoolVM getCheckVM(Customer customer) {
        BoolVM boolVM = new BoolVM();
        boolVM.setStatus(true);
        boolVM.setInfo("恭喜你，当前用户名可用！");
        if (null != customer) {
            boolVM.setStatus(false);
            boolVM.setInfo("非常抱歉，当前当前用户名已经存在！");
        }
        return boolVM;
    }
}
