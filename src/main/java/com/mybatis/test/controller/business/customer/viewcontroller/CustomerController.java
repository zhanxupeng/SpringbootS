package com.mybatis.test.controller.business.customer.viewcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.customer.paramsmodel.BasicInformationPM;
import com.mybatis.test.controller.business.customer.paramsmodel.RegisterCustomerPM;
import com.mybatis.test.controller.business.customer.paramsmodel.SecurityQuestionPM;
import com.mybatis.test.controller.business.customer.viewmodel.BoolVM;
import com.mybatis.test.controller.business.customer.viewmodel.CustomerInformationVM;
import com.mybatis.test.controller.business.customer.viewmodel.SignInVM;
import com.mybatis.test.controller.business.customer.viewmodel.SignVM;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.Question;
import com.mybatis.test.service.api.question.IQuestionService;
import com.mybatis.test.service.api.customer.ICustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 获取签到信息
     */
    @GetMapping("signIn")
    @ResponseBody
    public SignInVM getSignIn() {
        return new SignInVM(customerService.getSignIn());
    }

    /**
     * 用户签到
     */
    @GetMapping("sign")
    @ResponseBody
    public SignVM sign() {
        return new SignVM(customerService.sign());
    }

    /**
     * 基本设置
     */
    @GetMapping("setView")
    public String setView(Model model) {
        Customer customer = customerService.selectById(CustomerUtils.getCustomer().getId());
        model.addAttribute("customerInformation", new CustomerInformationVM(customer));
        return "user/set";
    }

    /**
     * 修改我的资料
     */
    @PostMapping("setBasic")
    @ResponseBody
    public Map setBasic(BasicInformationPM basicInformationPM) {
        Customer customer = basicInformationPM.getCustomer();
        customer.setId(CustomerUtils.getCustomer().getId());
        customerService.update(customer);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "redirect:/customer/setView");
        map.put("msg", "修改成功");
        return map;
    }

    /**
     * 修改头像
     */
    @PostMapping("modifyHead")
    @ResponseBody
    public void modifyHead(BasicInformationPM basicInformationPM) {
        Customer customer = basicInformationPM.getCustomer();
        customer.setId(CustomerUtils.getCustomer().getId());
        customerService.update(customer);
    }

    /**
     * 我的消息
     */
    @GetMapping("messageView")
    public String messageView() {
        return "user/message";
    }

    /**
     * 我的主页
     */
    @GetMapping("home")
    public String home() {
        return "user/home";
    }

    /**
     * 用户中心
     */
    @GetMapping("indexView")
    public String indexView() {
        return "user/index";
    }


    /**
     * 登录页面
     */
    @GetMapping("loginView")
    public String loginView() {
        return "user/login";
    }

    /**
     * 登录接口
     */
    @PostMapping("login")
    @ResponseBody
    public Map login(String userName, String password) {
        Map<String, Object> map = new TreeMap<>();
        //map.put("status", 1);

        Customer customer = customerService.selectByUserName(userName);
        if (customer == null) {
            map.put("msg", "用户不存在");
            return map;
        }
        if (!customer.getPassword().equals(password)) {
            map.put("msg", "账号密码错误");
            return map;
        }
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//如果原来有的话，就退出
        //登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(customer.getUserName(), customer.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        map.put("status", 0);
        map.put("action", "/index");
        map.put("msg", "登录成功");
        return map;
    }

    /**
     * 注册页面
     */
    @GetMapping("registerView")
    public String registerView() {
        return "user/reg";
    }

    /**
     * 注册接口
     */
    @PostMapping("register")
    @ResponseBody
    public Map register(RegisterCustomerPM registerCustomerPM) {
        save(registerCustomerPM);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "/customer/loginView");
        map.put("msg", "注册成功，请登录");
        return map;
    }

    /**
     * 验证账号知否已经注册
     */
    @GetMapping("userNameCheck")
    @ResponseBody
    public Response checkUserName(String userName) {
        Customer customer = customerService.selectByUserName(userName);
        return result(getCheckResult(customer));
    }

    /**
     * 获取用户信息的接口
     */
    @GetMapping("information")
    @ResponseBody
    public Customer getCustomer() {
        Customer customer = customerService.selectById(CustomerUtils.getCustomer().getId());
        return customer;
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
        customer.setHeadPicture("\\image\\show?imagePath=G%3A%5Clunwen%5Cpicture%5C15140023287112.jpg");//默认头像
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
