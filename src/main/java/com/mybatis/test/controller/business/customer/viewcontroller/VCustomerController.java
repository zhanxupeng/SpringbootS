package com.mybatis.test.controller.business.customer.viewcontroller;

import com.mybatis.test.controller.business.customer.paramsmodel.RegisterCustomerPM;
import com.mybatis.test.controller.business.customer.paramsmodel.SecurityQuestionPM;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.Question;
import com.mybatis.test.service.api.IQuestionService;
import com.mybatis.test.service.api.customer.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 占大帅 on 2017/12/2.
 */
@Controller
@RequestMapping("view/customer")
public class VCustomerController {
    @Resource
    private ICustomerService customerService;
    @Resource
    private IQuestionService questionService;

    @GetMapping("/registerView")
    public String registerView() {
        return "user/reg";
    }

    @PostMapping("/register")
    public String register(RegisterCustomerPM registerCustomerPM, Model model) {
        save(registerCustomerPM);
        model.addAttribute("message", "注册成功，请登录~");
        return "user/login";
    }

    private void save(RegisterCustomerPM registerCustomerPM) {
        Customer customer = new Customer();
        customer.init();
        customer.setUserName(registerCustomerPM.getUserName());
        customer.setNickName(registerCustomerPM.getNickName());
        customer.setPassword(registerCustomerPM.getPassword());
        customer.setSex(registerCustomerPM.getSex());
        customerService.insert(customer);
        if (registerCustomerPM.isSecurity()) {
            for (SecurityQuestionPM securityQuestionPM : registerCustomerPM.getSecurityQuestionPMList()) {
                Question question = new Question();
                question.init();
                question.setQuestion(securityQuestionPM.getQuestion());
                question.setAnswer(securityQuestionPM.getAnswer());
                question.setCustomerId(customer.getId());
                questionService.insert(question);
            }
        }
    }
}
