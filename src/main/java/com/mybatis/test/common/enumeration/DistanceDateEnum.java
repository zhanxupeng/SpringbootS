package com.mybatis.test.common.enumeration;

import com.mybatis.test.common.util.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

public enum DistanceDateEnum {
    JUSE(0, 60, "刚刚"),
    ONE_MINUTE(60, 300, "一分钟前"),
    FIVE_MINUTE(300, 3600, "五分钟前"),
    ONE_HOURS(3600, 43200, "一小时前"),
    ONE_DAY(43200, 129600, "一天前");

    private int startValue;
    private int endValue;
    private String description;

    DistanceDateEnum(int startValue, int endValue, String description) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.description = description;
    }

    public int getStartValue() {
        return startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public String getDescription() {
        return description;
    }

    public static String getDistanceDate(Date date) {
        Optional<DistanceDateEnum> distanceDateEnum = Arrays.stream(DistanceDateEnum.values()).filter(x -> (getDistanceSecond(date) >= x.getStartValue() && getDistanceSecond(date) < x.getEndValue()))
                .findFirst();
        return distanceDateEnum.isPresent() ? distanceDateEnum.get().getDescription() : DateUtil.convertDateToString(date, DateUtil.YYYY_MM_DD);
    }

    private static long getDistanceSecond(Date date) {
        return (DateUtil.getCurrentDate().getTime() - date.getTime()) / 1000;
    }
}
