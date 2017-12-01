package com.mybatis.test.controller.business.customer.viewcontroller;

import com.mybatis.test.service.api.customer.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("view/user")
public class VCustomerController {
    @Resource
    private ICustomerService customerService;

    @GetMapping("login")
    public String toLoginView() {
        return "user/login";
    }
}
