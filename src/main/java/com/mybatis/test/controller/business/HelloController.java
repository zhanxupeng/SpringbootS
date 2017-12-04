package com.mybatis.test.controller.business;

import com.mybatis.test.common.config.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 占大帅 on 2017/11/28.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/{index}")
    public String getUrl(@PathVariable("index") String index) {
        System.out.println("index:" + UserUtils.getUser());
        return index;
    }

    @RequestMapping("/user/{index}")
    public String getUser(@PathVariable("index") String index) {
        return "user/" + index;
    }

    @RequestMapping("/jie/{index}")
    public String getJie(@PathVariable("index") String index) {
        return "jie/" + index;
    }

    @RequestMapping("/test/{index}")
    public String getTest(@PathVariable("index") String index) {
        return "test/" + index;
    }
}
