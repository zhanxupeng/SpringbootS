package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;
import org.apache.ibatis.type.Alias;

@Alias("Channel")
public class Channel extends BaseModel {
    //渠道名称
    private String name;

    //渠道值
    private String value;

    //IOS短链接
    private String iosUrl;

    //android短链接
    private String androidUrl;

    //描述
    private String description;

    //0-启动,1-禁止
    private String statusType;

    //渠道类型
    private String channelStatisticType;

    //投放成本
    private int deliveryCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIosUrl() {
        return iosUrl;
    }

    public void setIosUrl(String iosUrl) {
        this.iosUrl = iosUrl;
    }

    public String getAndroidUrl() {
        return androidUrl;
    }

    public void setAndroidUrl(String androidUrl) {
        this.androidUrl = androidUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getChannelStatisticType() {
        return channelStatisticType;
    }

    public void setChannelStatisticType(String channelStatisticType) {
        this.channelStatisticType = channelStatisticType;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}