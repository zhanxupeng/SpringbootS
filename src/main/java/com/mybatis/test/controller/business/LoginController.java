package com.mybatis.test.controller.business;

import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.model.User;
import com.mybatis.test.repo.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by 占大帅 on 2017/11/26.
 */
@Controller
public class LoginController {

    @Resource
    private UserMapper userMapper;

    //跳转到登录页面
    @RequestMapping(value = "/login")
    public String toLogin() {
        return "login";
    }

    //实现用户登录
    @RequestMapping(value = "/toLogin")
    public ModelAndView Login(String username, String password) {
        ModelAndView mav = new ModelAndView();
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            mav.setViewName("toLogin");
            mav.addObject("msg", "用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            mav.setViewName("toLogin");
            mav.addObject("msg", "账号密码错误");
            return mav;
        }
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//如果原来有的话，就退出
        //登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        //登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接
        mav.setViewName("redirect:/index");
        return mav;
    }

    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("index:" + CustomerUtils.getCustomer());
        return "index";
    }

    @RequestMapping(value = "logout")
    public String logout() {
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//退出
        return "login";
    }
}
