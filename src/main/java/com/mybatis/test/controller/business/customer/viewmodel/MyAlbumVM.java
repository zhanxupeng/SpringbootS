package com.mybatis.test.controller.business.customer.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.model.MyAlbum;

/**
 * Created by 占大帅 on 2018/1/7.
 */
public class MyAlbumVM {
    private MyAlbum myAlbum;

    public MyAlbumVM(MyAlbum myAlbum) {
        this.myAlbum = myAlbum;
    }

    /**
     * 发布时间
     */
    public String getCreateDate() {
        return DateUtil.convertDateToString(myAlbum.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    /**
     * 图片地址
     */
    public String getImageUrl() {
        return myAlbum.getImageUrl();
    }
}
