package com.mybatis.test.service.api.customer;

import com.mybatis.test.domain.Sign;
import com.mybatis.test.domain.SignIn;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.MyAlbum;
import com.mybatis.test.service.common.IBaseDBService;

import java.util.List;

public interface ICustomerService extends IBaseDBService<Customer> {
    /**
     * 根据用户名查找用户
     */
    Customer selectByUserName(String userName);

    /**
     * 获取签到相关信息
     */
    SignIn getSignIn();

    /**
     * 用户签到
     */
    Sign sign();

    /**
     * 保存用户相册图片
     */
    void savePhoto(String photoUrl, String customerId);

    /**
     * 查询某用户的相册
     */
    List<MyAlbum> getCustomerAlbum(String customerId);
}
