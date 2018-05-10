package com.mybatis.test.controller.business.admin.viewcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.common.login.AdminCache;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.admin.paramsmodel.AgreeIdentifyPM;
import com.mybatis.test.controller.business.admin.paramsmodel.LoginPM;
import com.mybatis.test.controller.business.admin.paramsmodel.RefuseIdentifyPM;
import com.mybatis.test.controller.business.admin.paramsmodel.UnIdentifyPM;
import com.mybatis.test.service.api.admin.IAdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Resource
    private IAdminService adminService;


    /**
     * 登录
     */
    @PostMapping("/login")
    public Response login(@RequestBody LoginPM loginPM) {
        return result(adminService.login(loginPM.getUserName(), loginPM.getPassword()));
    }

    /**
     * 获取未认证用户信息
     */
    @PostMapping("/unIdentify")
    public Response unIdentify(@RequestBody UnIdentifyPM unIdentifyPM) {
        AdminCache.checkAdmin(unIdentifyPM.getIdentify());
        return result(adminService.getUnIdentifyCustomer());
    }

    /**
     * 拒绝认证
     */
    @PostMapping("refuseIdentify")
    public Response refuseIdentify(@RequestBody RefuseIdentifyPM refuseIdentifyPM) {
        AdminCache.checkAdmin(refuseIdentifyPM.getIdentify());
        adminService.refuseIdentify(refuseIdentifyPM.getCustomerId());
        return success();
    }

    /**
     * 通过认证
     */
    @PostMapping("agreeIdentify")
    public Response agreeIdentify(@RequestBody AgreeIdentifyPM agreeIdentifyPM) {
        AdminCache.checkAdmin(agreeIdentifyPM.getIdentify());
        adminService.agreeIdentify(agreeIdentifyPM.getCustomerId());
        return success();
    }
}
