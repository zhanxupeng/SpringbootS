package com.mybatis.test.controller.business.dynamic.paramsmodel;

import com.mybatis.test.model.Dynamic;

/**
 * Created by 占大帅 on 2017/12/23.
 */
public class DynamicPM {
    private Dynamic dynamic = new Dynamic();

    public void setFirstTitle(String firstTitle) {
        dynamic.setFirstTitle(firstTitle);
    }

    public void setSecondTitle(String secondTitle) {
        dynamic.setSecondTitle(secondTitle);
    }

    public void setTitle(String title) {
        dynamic.setTitle(title);
    }

    public void setContent(String content) {
        dynamic.setContent(content);
    }

    public Dynamic getDynamic() {

        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }
}
