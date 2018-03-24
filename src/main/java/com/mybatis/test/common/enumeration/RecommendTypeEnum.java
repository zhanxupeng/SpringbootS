package com.mybatis.test.common.enumeration;

public enum  RecommendTypeEnum {
    DATE(1,"按时间"),
    POPULARITY(2,"按热度");
    private int value;
    private String description;
    RecommendTypeEnum(int value,String description){
        this.value=value;
        this.description=description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static boolean isPopularity(int value){
        return POPULARITY.value==value;
    }
}
