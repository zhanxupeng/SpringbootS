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

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * <p>
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */


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

        //接口anon
        filterChainDefinitionMap.put("/customer/login", "anon");//登录接口
        filterChainDefinitionMap.put("/customer/register", "anon");//注册接口
        filterChainDefinitionMap.put("/customer/userNameCheck", "anon");//验证账号知否已经注册

        filterChainDefinitionMap.put("/rest/dictionary/humanQuestion", "anon");//人类验证

        filterChainDefinitionMap.put("/image/show", "anon");//显示图片接口
        filterChainDefinitionMap.put("/image/upload", "anon");//上传图片

        filterChainDefinitionMap.put("/index", "anon");//主页
        filterChainDefinitionMap.put("/customer/information", "anon");//用户信息

        filterChainDefinitionMap.put("/customer/signIn", "anon");//签到栏信息
        filterChainDefinitionMap.put("/customer/sign", "anon");//用户签到

        filterChainDefinitionMap.put("/404", "anon");

        //发动态接口，暂时匿名，方便调试
        filterChainDefinitionMap.put("/dynamic/addView", "anon");
        filterChainDefinitionMap.put("/rest/dictionary/dynamicSecondTopic", "anon");


        //测试
        filterChainDefinitionMap.put("/test", "anon");
        filterChainDefinitionMap.put("/test/upload", "anon");
        filterChainDefinitionMap.put("/page", "anon");
        filterChainDefinitionMap.put("/dynamic/index", "anon");

        //authc接口
        filterChainDefinitionMap.put("/dynamic/reply", "authc");

        //authc页面
        filterChainDefinitionMap.put("/customer/setView", "anon");//基本设置
        filterChainDefinitionMap.put("/customer/messageView", "anon");//我的消息
        filterChainDefinitionMap.put("/customer/home", "anon");//我的主页
        filterChainDefinitionMap.put("/customer/indexView", "anon");//用户中心

/*        filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/user/reg", "anon");
        //rest接口
        filterChainDefinitionMap.put("/rest/customer/userNameCheck", "anon");
        filterChainDefinitionMap.put("/rest/dictionary/securityQuestion", "anon");
        filterChainDefinitionMap.put("/rest/dictionary/humanQuestion", "anon");
        filterChainDefinitionMap.put("/rest/customer/register", "anon");

        //view页面
        filterChainDefinitionMap.put("/view/customer/register", "anon");
        filterChainDefinitionMap.put("/view/customer/registerView", "anon");
        filterChainDefinitionMap.put("/user/index", "anon");

        filterChainDefinitionMap.put("/user/upload", "anon");
        filterChainDefinitionMap.put("/upload", "anon");*/

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
