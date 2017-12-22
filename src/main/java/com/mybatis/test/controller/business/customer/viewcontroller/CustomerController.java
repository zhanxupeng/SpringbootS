package com.mybatis.test.controller.business.customer.viewcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.customer.paramsmodel.RegisterCustomerPM;
import com.mybatis.test.controller.business.customer.paramsmodel.SecurityQuestionPM;
import com.mybatis.test.controller.business.customer.viewmodel.BoolVM;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.Question;
import com.mybatis.test.model.User;
import com.mybatis.test.service.api.IQuestionService;
import com.mybatis.test.service.api.customer.ICustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
    @Resource
    private ICustomerService customerService;
    @Resource
    private IQuestionService questionService;

    @GetMapping("loginView")
    public String loginView() {
        return "user/login";
    }

    @PostMapping("login")
    @ResponseBody
    public Map login(String userName, String password) {
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 1);

        Customer customer = customerService.selectByUserName(userName);
        if (customer == null) {
            map.put("msg", "用户不存在");
            return map;
        }
        if (!customer.getPassword().equals(password)) {
            map.put("msg", "账号密码错误");
            return map;
        }
/*        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//如果原来有的话，就退出
        //登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(customer.getUserName(), customer.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);*/

        map.put("status", 0);
        map.put("action", "indexView");
        map.put("msg", "登录成功");
        return map;
    }

    @GetMapping("indexView")
    public String indexView() {
        return "user/index";
    }

    @GetMapping("registerView")
    public String registerView() {
        return "user/reg";
    }

    @PostMapping("register")
    @ResponseBody
    public Map register(RegisterCustomerPM registerCustomerPM) {
        save(registerCustomerPM);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "loginView");
        map.put("msg", "注册成功，请登录");
        return map;
    }

    @GetMapping("userNameCheck")
    @ResponseBody
    public Response checkUserName(String userName) {
        Customer customer = customerService.selectByUserName(userName);
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
