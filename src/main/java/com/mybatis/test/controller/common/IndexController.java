package com.mybatis.test.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 占大帅 on 2017/12/23.
 */
@Controller
public class IndexController {
    /**
     * 主页
     */
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("404")
    public String error() {
        return "other/404";
    }
}
