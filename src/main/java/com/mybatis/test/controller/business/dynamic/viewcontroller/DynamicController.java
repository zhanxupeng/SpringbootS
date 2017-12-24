package com.mybatis.test.controller.business.dynamic.viewcontroller;

import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.controller.business.dynamic.paramsmodel.DynamicPM;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("dynamic")
public class DynamicController {

    @Resource
    private IDynamicService dynamicService;

    @GetMapping("addView")
    public String addView() {
        return "jie/add";
    }

    @PostMapping("add")
    @ResponseBody
    public Map add(DynamicPM dynamicPM) {
        save(dynamicPM);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "/dynamic/addView");
        map.put("msg", "发布成功，去看一看吧");
        return map;
    }

    @GetMapping("detailView")
    public String detailView(String dynamicId) {
        return "jie/detail";
    }

    private String save(DynamicPM dynamicPM) {
        Customer customer = CustomerUtils.getCustomer();
        Dynamic dynamic = dynamicPM.getDynamic();
        dynamic.init();
        dynamic.setCustomerId(customer.getId());
        dynamic.setPopularity(1);
        dynamic.setPraise(0);
        dynamicService.insert(dynamic);
        return dynamic.getId();
    }
}
