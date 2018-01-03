package com.mybatis.test.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    /**
     * 主页
     */
    @GetMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 默认页面
     */
    @GetMapping("/")
    public String defaultPage() {
        return "index";
    }

    @GetMapping("404")
    public String error() {
        return "other/404";
    }

    /**
     * 分页测试
     */
    @GetMapping("page")
    public String page() {
        return "page";
    }
}
