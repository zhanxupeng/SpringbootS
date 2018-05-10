package com.mybatis.test.common.config;

import com.mybatis.test.service.impl.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfiguration {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/static/**", "anon");//静态资源跳过

        //页面anon
        filterChainDefinitionMap.put("/customer/loginView", "anon");//登录页面
        filterChainDefinitionMap.put("/customer/registerView", "anon");//注册页面

        filterChainDefinitionMap.put("/dynamic/detailView", "anon");//动态详情页面
        filterChainDefinitionMap.put("/customer/home", "authc");//用户主页

        //接口anon
        filterChainDefinitionMap.put("/customer/login", "anon");//登录接口
        filterChainDefinitionMap.put("/customer/register", "anon");//注册接口
        filterChainDefinitionMap.put("/customer/userNameCheck", "anon");//验证账号知否已经注册

        filterChainDefinitionMap.put("/rest/dictionary/humanQuestion", "anon");//人类验证

        filterChainDefinitionMap.put("/image/show", "anon");//显示图片接口
        filterChainDefinitionMap.put("/image/upload", "anon");//上传图片

        filterChainDefinitionMap.put("/", "anon");//默认页面
        filterChainDefinitionMap.put("/index", "anon");//主页
        filterChainDefinitionMap.put("/customer/information", "anon");//用户信息

        filterChainDefinitionMap.put("/customer/signIn", "anon");//签到栏信息
        filterChainDefinitionMap.put("/customer/sign", "anon");//用户签到

        filterChainDefinitionMap.put("/dynamic/page", "anon");//分页查询动态
        filterChainDefinitionMap.put("/dynamic/recommend", "anon");//推荐动态

        filterChainDefinitionMap.put("/404", "anon");

        filterChainDefinitionMap.put("/rest/dictionary/dynamicSecondTopic", "anon");//动态二级标题

        //微信小程序接口
        filterChainDefinitionMap.put("/admin/login", "anon");
        filterChainDefinitionMap.put("/admin/unIdentify", "anon");
        filterChainDefinitionMap.put("/admin/refuseIdentify", "anon");
        filterChainDefinitionMap.put("/admin/agreeIdentify", "anon");


        //测试
        filterChainDefinitionMap.put("/dynamic/index", "anon");

        //authc接口
        filterChainDefinitionMap.put("/dynamic/reply", "authc");
        filterChainDefinitionMap.put("/dynamic/addView", "authc");//添加动态

        filterChainDefinitionMap.put("/customer/setBasic", "authc");//修改我的信息
        filterChainDefinitionMap.put("/customer/modifyHead", "authc");//修改用户头像
        filterChainDefinitionMap.put("/customer/modifyPassword", "authc");//修改密码
        filterChainDefinitionMap.put("/customer/savePhoto", "authc");//保存用户照片

        filterChainDefinitionMap.put("/dynamic/myDynamic", "authc");//分页查询我的动态

        filterChainDefinitionMap.put("/customer/friendRefuse", "authc");//拒绝好友申请
        filterChainDefinitionMap.put("/customer/friendRefuseAll", "authc");//拒绝所有好友申请
        filterChainDefinitionMap.put("/customer/friendAgree", "authc");//同意好友申请
        filterChainDefinitionMap.put("/customer/friendAgreeAll", "authc");//同意所有好友申请

        filterChainDefinitionMap.put("/friend/familiarityRank", "authc");//亲密度榜单

        //authc页面
        filterChainDefinitionMap.put("/customer/setView", "authc");//基本设置
        filterChainDefinitionMap.put("/customer/messageView", "authc");//我的消息
        filterChainDefinitionMap.put("/customer/indexView", "authc");//用户中心
        filterChainDefinitionMap.put("/customer/identityView", "authc");//好友验证
        filterChainDefinitionMap.put("/customer/logout", "authc");//退出登录

        filterChainDefinitionMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/customer/loginView");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/404");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
}
